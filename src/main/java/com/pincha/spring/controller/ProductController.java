package com.pincha.spring.controller;

import com.pincha.spring.dao.catalog.CatalogDAOImpl;
import com.pincha.spring.dao.category.CategoryDAOImpl;
import com.pincha.spring.dao.product.ProductDAOImpl;
import com.pincha.spring.model.Attribute;
import com.pincha.spring.model.Product;
import com.pincha.spring.model.Value;
import com.pincha.spring.service.product.ProductServiceImpl;
import com.pincha.spring.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Controller
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(ModelMap model) {
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("catalogs", productService.getAllCatalogs());
        return "admin";
    }

    @RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
    public String homePage(ModelMap model) {
        model.addAttribute("productsInBasket", getProductInBasket());
        model.addAttribute("Catalogs", productService.getAllCatalogs());
        return "welcome";
    }

    @RequestMapping(value = "/catalog", method = RequestMethod.GET)
    public String catalog(
            @RequestParam(value = "id" ,defaultValue = "1") int id,
            @RequestParam(value = "pageNumber", defaultValue = "1") int pageNumber, ModelMap model)
    {
        Set<Product> products = productService.getCategoryByKey(id).getProductSet();
        model.addAttribute("productsInBasket", getProductInBasket());
        model.addAttribute("products", products);
        return "catalog";
    }

    @RequestMapping(value = "/dProduct", method = RequestMethod.GET)
    public String deleteProduct(@RequestParam("productId") int idProduct) {
        productService.deleteProductByKey(idProduct);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public String oneProduct(@RequestParam("id") int idProduct, ModelMap model) {
        Product product = productService.getProductByKey(idProduct);
        model.addAttribute("product", product);
        model.addAttribute("productsInBasket", getProductInBasket());
        return "product";
    }

    @RequestMapping(value = "/addNewProduct", method = RequestMethod.GET)
    public String addProductView(@RequestParam("categoryId") int categoryId, ModelMap model) {
        List<String> attributes = new ArrayList<>();
        for (Attribute attribute: productService.getCategoryByKey(categoryId).getAttributes()){
            attributes.add(attribute.getAttributeName());
            System.err.println(attributes);
        }

        model.addAttribute("attributes", attributes);
        model.addAttribute("valueList", new ArrayList<String>());
        model.addAttribute("attributeSize", attributes.size());
        return "addProduct";
    }

    @RequestMapping(value = "/addNewProduct", method = RequestMethod.POST)
    public String addProduct(List<String> values, ModelMap model) {
        System.out.println(values.size());
        return "admin";
    }

    @RequestMapping(value = "/getPDF", method = RequestMethod.GET)
    public ModelAndView getPDFFile(
            @RequestParam("id") int productId) {
        return new ModelAndView("pdfView",
                                "product",
                                productService.getProductByKey(productId));
    }

    private Integer getProductInBasket(){
        if(!getPrincipal().equals("anonymousUser")) {
            System.err.println(getPrincipal());
            return userService.findByUserName(getPrincipal()).getProducts().size();
        }
        else return 0;
    }

    private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
}
