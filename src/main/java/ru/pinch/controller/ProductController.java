package ru.pinch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.pinch.entity.Material;
import ru.pinch.service.material.MaterialService;

@Controller
public class ProductController {
    @Autowired
    private MaterialService materialService;

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
}
