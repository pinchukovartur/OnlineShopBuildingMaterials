package ru.pinch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.pinch.entity.products.Product;
import ru.pinch.entity.products.robots.Robot;
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

    private static final int AMOUNT_ON_THE_PAGE = 9;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main(ModelAndView modelAndView, Principal user) {
        if(user!=null){
            modelAndView.addObject("productsInBasket", userService.getAllTheMaterialsOfThisUser(user.getName()).size());
        }
        modelAndView.setViewName("WEB-INF/views/" + "index");
        return modelAndView;
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView admin(
            @RequestParam(value = "window",   defaultValue = "purchases") String window,
            ModelAndView modelAndView) {

        if(window.equals("purchases")) {
            modelAndView.setViewName("WEB-INF/views/admin/" + "purchase");
            modelAndView.addObject("purchasesList", userService.getPurchases());
        }
        if(window.equals("users")) {
            modelAndView.setViewName("WEB-INF/views/admin/" + "user");
            modelAndView.addObject("usersList", userService.getUsers());
        }
        if(window.equals("products")) {
            modelAndView.setViewName("WEB-INF/views/admin/" + "product");
            modelAndView.addObject("plywoodList", productsService.getProductsByType("Plywood"));
            modelAndView.addObject("particleBoardsList", productsService.getProductsByType("ParticleBoard"));
            modelAndView.addObject("robotList", productsService.getProductsByType("Robot"));
        }
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
        return modelAndView;
    }

    @RequestMapping(value = "/catalog={type}&page={pageNumber}", method = RequestMethod.GET)
    public ModelAndView catalog(
            @PathVariable(value = "type") String type,
            @PathVariable(value = "pageNumber") int pageNumber,
            ModelAndView modelAndView, Principal user)
    {
        List<Product> productList = productsService.getProductsByType(type);
                productList = productsService.getProductsOnPage(productList,pageNumber,AMOUNT_ON_THE_PAGE);
        modelAndView.addObject("listProducts", productList);
        modelAndView.addObject("numberOfPages", productsService.getNumberPages(productList,AMOUNT_ON_THE_PAGE));
        if(user!=null) {
            modelAndView.addObject("productsInBasket", userService.getAllTheMaterialsOfThisUser(user.getName()).size());
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

    @RequestMapping(value = "/searchRobots", method = RequestMethod.GET)
    public ModelAndView searchRobots(
            @RequestParam(value = "productionYear", defaultValue = "-1") int productionYear,
            @RequestParam(value = "maxLoad" , defaultValue = "-1") int maxLoad,
            @RequestParam(value = "reach", defaultValue = "-1") int reach,
            @RequestParam(value = "manufacturer", defaultValue = "") String manufacturer,
            @RequestParam(value = "priceWith", defaultValue = "-1") int priceWith,
            @RequestParam(value = "priceBefore", defaultValue = "-1") int priceBefore,
            ModelAndView modelAndView, Principal user)
    {
        List robots = productsService.getProductsByType("Robot");
        robots = productsService.sortProductsByPrice(robots,priceWith,priceBefore);
        robots = productsService.sortRobotsByProductionYear(robots,productionYear);
        robots = productsService.sortRobotsByMaxLoad(robots, maxLoad);
        robots = productsService.sortRobotsByReach(robots, reach);
        robots = productsService.sortRobotsByManufacturer(robots, manufacturer);
        if(user!=null) {
            modelAndView.addObject("productsInBasket", userService.getAllTheMaterialsOfThisUser(user.getName()).size());
        }
        modelAndView.addObject("listProducts", robots);
        modelAndView.addObject("numberOfPages", productsService.getNumberPages(robots,AMOUNT_ON_THE_PAGE));
        modelAndView.setViewName("WEB-INF/views/" + "catalog");
        return modelAndView;
    }

    @RequestMapping(value = "/searchPlywoods", method = RequestMethod.GET)
    public ModelAndView searchPlywoods(
            @RequestParam(value = "grade", defaultValue = "-1") int grade,
            @RequestParam(value = "sanded" , defaultValue = "-1") int sanded,
            @RequestParam(value = "waterResistance", defaultValue = "-1") int waterResistance,
            @RequestParam(value = "priceWith", defaultValue = "-1") int priceWith,
            @RequestParam(value = "priceBefore", defaultValue = "-1") int priceBefore,
            ModelAndView modelAndView, Principal user)
    {
        List plywoods = productsService.getProductsByType("Plywood");
        plywoods = productsService.sortProductsByPrice(plywoods,priceWith,priceBefore);
        plywoods = productsService.sortPlywoodsByGrade(plywoods,grade);
        plywoods = productsService.sortPlywoodsBySanded(plywoods,sanded);
        plywoods = productsService.sortPlywoodsByWaterResistance(plywoods,waterResistance);
        if(user!=null) {
            modelAndView.addObject("productsInBasket", userService.getAllTheMaterialsOfThisUser(user.getName()).size());
        }
        modelAndView.addObject("listProducts", plywoods);
        modelAndView.addObject("numberOfPages", productsService.getNumberPages(plywoods,AMOUNT_ON_THE_PAGE));
        modelAndView.setViewName("WEB-INF/views/" + "catalog");
        return modelAndView;
    }

    @RequestMapping(value = "/searchParticleBoards", method = RequestMethod.GET)
    public ModelAndView searchParticleBoards(
            @RequestParam(value = "color", defaultValue = "") String color,
            @RequestParam(value = "priceWith", defaultValue = "-1") int priceWith,
            @RequestParam(value = "priceBefore", defaultValue = "-1") int priceBefore,
            ModelAndView modelAndView, Principal user)
    {
        List particleBoard = productsService.getProductsByType("ParticleBoard");
        particleBoard = productsService.sortProductsByPrice(particleBoard,priceWith,priceBefore);
        particleBoard = productsService.sortParticleBoardsByColor(particleBoard,color);
        if(user!=null) {
            modelAndView.addObject("productsInBasket", userService.getAllTheMaterialsOfThisUser(user.getName()).size());
        }
        modelAndView.addObject("listProducts", particleBoard);
        modelAndView.addObject("numberOfPages", productsService.getNumberPages(particleBoard,AMOUNT_ON_THE_PAGE));
        modelAndView.setViewName("WEB-INF/views/" + "catalog");
        return modelAndView;
    }
}
