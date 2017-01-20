package ru.pinch.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    public static final int AMOUNT_ON_THE_PAGE = 9;
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

    @RequestMapping(value = "/{pageNumber}", method = RequestMethod.GET)
    public ModelAndView main(@PathVariable("pageNumber") int pageNumber, ModelAndView modelAndView) {

        modelAndView.addObject("listProduct", materialService.getListMaterialsOnPage(pageNumber,AMOUNT_ON_THE_PAGE));
        modelAndView.addObject("numberOfPages", materialService.getNumberPages(AMOUNT_ON_THE_PAGE));
        materialService.getPDFWithMaterialsData(materialService.getAllMaterialsOfTheDataBase());
        modelAndView.setViewName("WEB-INF/views/" + "ru_all_iphone");
        return modelAndView;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main(ModelAndView modelAndView) {
        /*modelAndView.addObject("listProduct",  materialService.getListMaterialsOnPage(1,9));
        modelAndView.addObject("numberOfPages", materialService.getNumberPages(9));*/
        materialService.getPDFWithMaterialsData(materialService.getAllMaterialsOfTheDataBase()); /////////////
        modelAndView.setViewName("WEB-INF/views/" + "index");
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView regist(ModelAndView modelAndView) {
        modelAndView.addObject("user", new User());
        modelAndView.setViewName("WEB-INF/views/" + "regist");
        return modelAndView;
    }


    @RequestMapping(value = "/cabinet", method = RequestMethod.GET)
    public ModelAndView cabinet(ModelAndView modelAndView) {
        modelAndView.setViewName("WEB-INF/views/" + "cabinet");
        return modelAndView;
    }

    @RequestMapping(value = "/basket", method = RequestMethod.GET)
    public ModelAndView basket(ModelAndView modelAndView, Principal user) {
        modelAndView.setViewName("WEB-INF/views/" + "basket");
        modelAndView.addObject("basketList", userService.getAllTheMaterialsOfThisUser(user.getName()));
        return modelAndView;
    }

}
