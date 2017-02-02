package ru.pinch.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.pinch.entity.products.plywoods.Plywood;
import ru.pinch.entity.users.User;
import ru.pinch.service.products.ProductsService;
import ru.pinch.service.user.UserService;

import java.security.Principal;
import java.util.List;

@Controller
public class MainController {


    private static final String ANONYMOUS_USER = "Is server is connected with anonymous user";

    @Autowired
    private ProductsService productsService;

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView admin(ModelAndView modelAndView) {
        modelAndView.setViewName("WEB-INF/views/" + "admin");
        modelAndView.addObject("addProduct", new Plywood());
        modelAndView.addObject("listProduct", productsService.getAllMaterials());
        return modelAndView;
    }



    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main(ModelAndView modelAndView,Principal user) {
        /*try {
            modelAndView.addObject("productsInBasket", userService.getAllTheMaterialsOfThisUser(user.getName()).size());
        }
        catch (Exception e){
            System.err.println(ANONYMOUS_USER);
        }*/

        System.out.println(userService.getUsers());
        modelAndView.setViewName("WEB-INF/views/" + "index");
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView regist(ModelAndView modelAndView) {
        modelAndView.addObject("user", new User());
        modelAndView.setViewName("WEB-INF/views/" + "regist");
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

    @RequestMapping(value = "/product_select", method = RequestMethod.GET)
    public ModelAndView select(
            @RequestParam(value = "checkbox_particleBoard",   defaultValue = "0") int checkbox_particleBoard,
            @RequestParam(value = "checkbox_plywood",   defaultValue = "0") int checkbox_plywood,
            @RequestParam(value = "input_with", defaultValue = "0") int input_with,
            @RequestParam(value = "input_before",  defaultValue = "0") int input_before,
            @RequestParam(value = "grade",defaultValue = "0") int grade,
            ModelAndView modelAndView, Principal user)
    {
        modelAndView.addObject("listProduct", productsService.getSortListMaterials(checkbox_particleBoard,
                checkbox_plywood, input_with,input_before,grade));

        try {
            modelAndView.addObject("productsInBasket", userService.getAllTheMaterialsOfThisUser(user.getName()).size());
        }
        catch (Exception e){
            System.err.println(ANONYMOUS_USER);
        }
        modelAndView.setViewName("WEB-INF/views/" + "catalog");
        return modelAndView;
    }


}
