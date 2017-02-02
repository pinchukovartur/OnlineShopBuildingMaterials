package ru.pinch.controller.plywood;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.pinch.entity.products.Product;
import ru.pinch.entity.products.plywoods.Plywood;
import ru.pinch.service.products.ProductsService;
import ru.pinch.service.user.UserService;

import java.security.Principal;
import java.util.List;

@Controller
public class ProductController {

    private static final String ANONYMOUS_USER = "Is server is connected with anonymous user";
    private static final int AMOUNT_ON_THE_PAGE = 9;

    @Autowired
    private ProductsService productsService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/page_{pageNumber}", method = RequestMethod.GET)
    public ModelAndView main(@PathVariable("pageNumber") int pageNumber, ModelAndView modelAndView, Principal user) {
        List<Product> plywoodList = productsService.getAllMaterials();
        modelAndView.addObject("listProduct", productsService.getListMaterialsOnPage(plywoodList,pageNumber,AMOUNT_ON_THE_PAGE));
        modelAndView.addObject("numberOfPages", productsService.getNumberPages(plywoodList,AMOUNT_ON_THE_PAGE));
        modelAndView.setViewName("WEB-INF/views/" + "catalog");

        try {
            modelAndView.addObject("productsInBasket", userService.getAllTheMaterialsOfThisUser(user.getName()).size());
        }
        catch (Exception e){
            System.err.println(ANONYMOUS_USER);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public ModelAndView oneProduct(@PathVariable("id") String idProduct, ModelAndView modelAndView) {
        modelAndView.addObject("product", productsService.getMaterial(idProduct));
        modelAndView.setViewName("WEB-INF/views/" + "one_product");
        return modelAndView;
    }
}
