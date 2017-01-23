package ru.pinch.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.pinch.entity.Material;
import ru.pinch.entity.User;
import ru.pinch.service.material.MaterialService;
import ru.pinch.service.user.UserService;

import java.io.File;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    private static final int AMOUNT_ON_THE_PAGE = 9;

    @Autowired
    private MaterialService materialService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView admin(ModelAndView modelAndView) {
        modelAndView.setViewName("WEB-INF/views/" + "admin");
        modelAndView.addObject("addProduct", new Material());
        modelAndView.addObject("listProduct", materialService.getAllMaterialsOfTheDataBase());
        modelAndView.addObject("listUsers", userService.getUsers());
        return modelAndView;
    }

    @RequestMapping(value = "/page_{pageNumber}", method = RequestMethod.GET)
    public ModelAndView main(@PathVariable("pageNumber") int pageNumber, ModelAndView modelAndView) {

        modelAndView.addObject("listProduct", materialService.getListMaterialsOnPage(pageNumber,AMOUNT_ON_THE_PAGE));
        modelAndView.addObject("numberOfPages", materialService.getNumberPages(AMOUNT_ON_THE_PAGE));
        materialService.getPDFWithMaterialsData(materialService.getAllMaterialsOfTheDataBase());
        modelAndView.setViewName("WEB-INF/views/" + "catalog");
        return modelAndView;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main(ModelAndView modelAndView,Principal user) {
        try {
            modelAndView.addObject("productsInBasket", userService.getAllTheMaterialsOfThisUser(user.getName()).size());
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
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
        return modelAndView;
    }

    @RequestMapping(value = "/product_select", method = RequestMethod.GET)
    public ModelAndView select(
            @RequestParam(value = "checkbox_particleBoard",   defaultValue = "0") int checkbox_particleBoard,
            @RequestParam(value = "checkbox_plywood",   defaultValue = "0") int checkbox_plywood,
            @RequestParam(value = "input_with", defaultValue = "0") int input_with,
            @RequestParam(value = "input_before",  defaultValue = "0") int input_before,
            @RequestParam(value = "grade",defaultValue = "0") int grade,
            ModelAndView modelAndView)
    {
        modelAndView.addObject("listProduct", materialService.getSortListMaterials(checkbox_particleBoard,
                checkbox_plywood, input_with,input_before,grade));
        modelAndView.addObject("numberOfPages", materialService.getNumberPages(AMOUNT_ON_THE_PAGE));
        modelAndView.setViewName("WEB-INF/views/" + "catalog");
        return modelAndView;
    }

}
