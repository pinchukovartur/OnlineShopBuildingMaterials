package ru.pinch.controller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.pinch.entity.products.Product;
import ru.pinch.entity.products.particleboards.ParticleBoard;
import ru.pinch.entity.products.plywoods.Plywood;
import ru.pinch.service.products.ProductsService;
import ru.pinch.service.user.UserService;

import java.security.Principal;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductsService productsService;

    @RequestMapping(value = "/newProduct", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("Plywood") Plywood plywood,
                             @ModelAttribute("ParticleBoard") ParticleBoard particleBoard) {
        if(plywood!=null){productsService.addProduct(plywood);}
        if(particleBoard!=null){productsService.addProduct(particleBoard);}
        return "redirect:/admin";
    }

    @RequestMapping(value = "/dProduct/{id}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable("id") String idProduct) {
        productsService.deleteProduct(idProduct);
        return "redirect:/admin";
    }
}
