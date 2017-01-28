package ru.pinch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
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
import java.util.Locale;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MaterialService materialService;

    @Autowired
    private MessageSource messageSource;


    @RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
    public ModelAndView accessDenied(Locale locale, Principal user, ModelAndView modelAndView) {
        if (user != null) {
            modelAndView.addObject("errorMsg",user.getName() + " - " + messageSource.getMessage("label.accessDenied",
                                                                    new String[]{locale.getDisplayName(locale)}, locale));
        } else {
            modelAndView.addObject("errorMsg", messageSource.getMessage("label.accessDenied",
                                                                    new String[]{locale.getDisplayName(locale)}, locale));
        }
        modelAndView.setViewName("WEB-INF/views/" + "accessDenied");
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView checkUser(@RequestParam(value = "error", required = false) String error,
                                  ModelAndView modelAndView, Locale locale) {
        if (error != null) {
            modelAndView.addObject("error", messageSource.getMessage("InvalidUsernameOrPassword",
                                                                     new String[]{locale.getDisplayName(locale)}, locale));
        }
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = "/addtobasket/{productID}", method = RequestMethod.GET)
    public String addToBasket(@PathVariable("productID") String productID, Principal user) {
        userService.addToBasket(user.getName(), productID);
        return "redirect:/page_1";
    }

    @RequestMapping(value = "/buymaterial/{productID}", method = RequestMethod.GET)
    public String buyMaterial(@PathVariable("productID") String productID, Principal user) {
        userService.buyMaterialsUser(userService.getUserByID(user.getName()),
                materialService.getMaterial(productID));
        return "redirect:/basket";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView registration(@ModelAttribute("user") User user,
                                     ModelAndView modelAndView, Locale locale) {

        if (user.getUsername().equals("") || user.getEmail().equals("") || user.getPassword().equals("")) {
            modelAndView.addObject("error", messageSource.getMessage("FillInAllTheFields",
                                                                    new String[]{locale.getDisplayName(locale)}, locale));
            modelAndView.setViewName("WEB-INF/views/" + "regist");
            return modelAndView;
        }
        if (userService.getUserByID(user.getUsername())==null){
            userService.saveUser(user.getUsername(), user.getPassword(), user.getEmail());
            modelAndView.setViewName("login");
            return modelAndView;
        }
        else {
            modelAndView.addObject("error", messageSource.getMessage("ThisNameIsAlreadyTaken",
                                                                    new String[]{locale.getDisplayName(locale)}, locale));
            modelAndView.setViewName("WEB-INF/views/" + "regist");
            return modelAndView;
        }
    }
}
