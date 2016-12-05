package ru.pinch.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.pinch.dao.ProductServiceImpl;
import ru.pinch.model.ConstructionmaterialsEntity;

@Controller
public class MainController {

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView admin() {
        ModelAndView modelAndView = new ModelAndView();
        ProductServiceImpl productService = new ProductServiceImpl();
        modelAndView.setViewName("admin");
        modelAndView.addObject("listProduct", productService.listProducts());
        modelAndView.addObject("addProduct", new ConstructionmaterialsEntity());
        String idProduct = "";
        modelAndView.addObject("delProduct", idProduct);
        return modelAndView;
    }

    @RequestMapping(value = "/newProduct", method = RequestMethod.POST)
    public ModelAndView addProduct(@ModelAttribute("addProduct") ConstructionmaterialsEntity product) {
        ProductServiceImpl productService = new ProductServiceImpl();
        productService.addEntity(product);
        return admin();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main() {
        ModelAndView modelAndView = new ModelAndView();
        ProductServiceImpl productService = new ProductServiceImpl();
        modelAndView.addObject("listProduct", productService.listProducts());
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/dProduct", method = RequestMethod.POST)
    public ModelAndView deleteContact(@ModelAttribute("idProduct") String idProduct) {
        ProductServiceImpl productService = new ProductServiceImpl();
        productService.deleteEntity(idProduct);
        return admin();
    }
}