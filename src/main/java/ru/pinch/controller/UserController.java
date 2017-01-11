package ru.pinch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.pinch.entity.User;
import ru.pinch.service.material.MaterialService;
import ru.pinch.service.user.UserService;

import java.security.Principal;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MaterialService materialService;

    @RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
    public ModelAndView accessDenied(Principal user, ModelAndView modelAndView) {
        if (user != null) {
            modelAndView.addObject("errorMsg", user.getName() + "У вас нет доступа");
        } else {
            modelAndView.addObject("У вас нет доступа");
        }

        modelAndView.setViewName("WEB-INF/views/" + "accessDenied");
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView checkUser(@RequestParam(value = "error", required = false) String error,
                                  ModelAndView modelAndView) {

        if (error != null) {
            modelAndView.addObject("error", "Invalid username or password!");
        }
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = "/addtobasket/{productID}", method = RequestMethod.GET)
    public String addToBasket(@PathVariable("productID") String productID, Principal user) {
        userService.addToBasket(user.getName(), productID);
        return "redirect:/";
    }

    @RequestMapping(value = "/buymaterial/{productID}", method = RequestMethod.GET)
    public String buyMaterial(@PathVariable("productID") String productID, Principal user) {
        userService.buyMaterialsUser(userService.getUserByID(user.getName()),
                materialService.getMaterialsByIDOfTheDataBase(productID));
        return "redirect:/";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView registration(@ModelAttribute("user") User user,
                                     @RequestParam(value = "error", required = false) String error,
                                     ModelAndView modelAndView) {
        if (user.getUsername().equals("") || user.getEmail().equals("") || user.getPassword().equals("")) {
            modelAndView.addObject("error", "Заполните все поля");
            modelAndView.setViewName("WEB-INF/views/" + "regist");
            return modelAndView;
        }
        System.err.println(userService.getUserByID(user.getUsername()));
        if (userService.getUserByID(user.getUsername())==null){
            userService.saveUser(user.getUsername(), user.getPassword(), user.getEmail());
            modelAndView.setViewName("login");
            return modelAndView;
        }
        modelAndView.addObject("error", "Это имя уже занято");
        modelAndView.setViewName("WEB-INF/views/" + "regist");
        return modelAndView;
    }
}
