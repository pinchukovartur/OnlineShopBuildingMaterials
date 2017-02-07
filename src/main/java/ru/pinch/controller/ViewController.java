package ru.pinch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.pinch.entity.products.Product;
import ru.pinch.entity.products.plywoods.Plywood;
import ru.pinch.entity.users.User;
import ru.pinch.service.products.ProductsService;
import ru.pinch.service.user.UserService;

import java.security.Principal;
import java.util.List;

@Controller
public class ViewController {

    @Autowired
    private UserService userService;
    @Autowired
    private ProductsService productsService;

    private static final String ANONYMOUS_USER = "Is server is connected with anonymous user";
    private static final int AMOUNT_ON_THE_PAGE = 9;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main(ModelAndView modelAndView, Principal user) {
        try {
            modelAndView.addObject("productsInBasket", userService.getAllTheMaterialsOfThisUser(user.getName()).size());
        }
        catch (Exception e){
            System.err.println(ANONYMOUS_USER);
        }
        modelAndView.setViewName("WEB-INF/views/" + "index");
        return modelAndView;
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView admin(ModelAndView modelAndView) {
        modelAndView.setViewName("WEB-INF/views/" + "admin");
        modelAndView.addObject("addProduct", new Plywood());
        modelAndView.addObject("listProduct", productsService.getProducts());
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registration(ModelAndView modelAndView) {
        modelAndView.addObject("user", new User());
        modelAndView.setViewName("WEB-INF/views/" + "registration");
        return modelAndView;
    }

    @RequestMapping(value = "/basket", method = RequestMethod.GET)
    public ModelAndView basket(ModelAndView modelAndView, Principal user) {
        modelAndView.setViewName("WEB-INF/views/" + "basket");
        modelAndView.addObject("basketList", userService.getAllTheMaterialsOfThisUser(user.getName()));
        try {
            modelAndView.addObject("productsInBasket", userService.getAllTheMaterialsOfThisUser(user.getName()).size());
        }
        catch (Exception e){
            System.err.println(ANONYMOUS_USER);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/catalog", method = RequestMethod.GET)
    public ModelAndView select(
            @RequestParam(value = "pageNumber",   defaultValue = "1") int pageNumber,
            @RequestParam(value = "type",   defaultValue = "all") String type,
            @RequestParam(value = "checkbox_particleBoard",   defaultValue = "0") int checkbox_particleBoard,
            @RequestParam(value = "checkbox_plywood",   defaultValue = "0") int checkbox_plywood,
            @RequestParam(value = "input_with", defaultValue = "0") int input_with,
            @RequestParam(value = "input_before",  defaultValue = "0") int input_before,
            @RequestParam(value = "grade",defaultValue = "0") int grade,
            ModelAndView modelAndView, Principal user)
    {
        List<Product> productList = productsService.getProductsByType(type);
        System.out.println(productList);
        productList = productsService.getProductsOnPage(productList,pageNumber,AMOUNT_ON_THE_PAGE);
        System.out.println(productList.get(0).getPhotosList().get(0).getPhoto());
        System.out.println(productsService.getNumberPages(productList,AMOUNT_ON_THE_PAGE));
        modelAndView.addObject("listProduct", productList);
        modelAndView.addObject("numberOfPages", productsService.getNumberPages(productList,AMOUNT_ON_THE_PAGE));
        try {
            modelAndView.addObject("productsInBasket", userService.getAllTheMaterialsOfThisUser(user.getName()).size());
        }
        catch (Exception e){
            System.err.println(ANONYMOUS_USER);
        }
        modelAndView.setViewName("WEB-INF/views/" + "catalog");
        return modelAndView;
    }


    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public ModelAndView oneProduct(@PathVariable("id") String idProduct, ModelAndView modelAndView) {
        modelAndView.addObject("product", productsService.getProductByID(idProduct));
        modelAndView.setViewName("WEB-INF/views/" + "one_product");
        return modelAndView;
    }
}
