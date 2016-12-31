package ru.pinch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.pinch.entity.Material;
import ru.pinch.service.material.MaterialService;
import ru.pinch.service.user.UserService;

import java.security.Principal;

@Controller
public class ProductController {
    @Autowired
    private MaterialService materialService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/newProduct", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("addProduct") Material product) {
        materialService.addMaterial(product);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/dProduct", method = RequestMethod.POST)
    public String deleteContact(@ModelAttribute("idProduct") String idProduct) {
        materialService.deleteMaterial(idProduct);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/addtobasket/{productID}", method = RequestMethod.GET)
    public String addToBasket(@PathVariable("productID") String productID, Principal user) {
        userService.addToBasket(user.getName(), productID);
        return "redirect:/";
    }
}
