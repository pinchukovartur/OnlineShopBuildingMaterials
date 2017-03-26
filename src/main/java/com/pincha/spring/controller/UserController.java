package com.pincha.spring.controller;

import com.pincha.spring.model.Product;
import com.pincha.spring.model.User;
import com.pincha.spring.model.UserRole;
import com.pincha.spring.service.MailService;
import com.pincha.spring.service.product.ProductServiceImpl;
import com.pincha.spring.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {

    private UserService userService;
    private MailService mailService;
    private ProductServiceImpl productService;

    @Autowired
    public UserController(UserService userService, MailService mailService, ProductServiceImpl productService) {
        this.userService = userService;
        this.mailService = mailService;
        this.productService = productService;
    }

    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "accessDenied";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView registration(@ModelAttribute("user") User user) {
        ModelAndView modelAndView = new ModelAndView();
        User user1 = new User(user.getUsername(), user.getPassword(), user.getEmail(), 1,
                new UserRole(user.getUsername(), "ROLE_USER"));
        userService.save(user1);
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registration(ModelAndView modelAndView) {
        modelAndView.addObject("user", new User());
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(value = "/addToBasket", method = RequestMethod.GET)
    public String addToBasket(@RequestParam("productID") int productID) {
        Product product = productService.getProductByKey(productID);
        if (!getPrincipal().equals("anonymousUser")) {
            User user = userService.findByUserName(getPrincipal());
            user.getProducts().add(productService.getProductByKey(productID));
            userService.updateUser(user);
        }
        return "redirect:/catalog?id=" + product.getCategoryID() + "&pageNumber=1";
    }

    @RequestMapping(value = "/basket", method = RequestMethod.GET)
    public String basket(ModelMap model) {
        model.addAttribute("productsInBasket", getProductInBasket());
        model.addAttribute("basketList", userService.findByUserName(getPrincipal()).getProducts());
        return "basket";
    }

    @RequestMapping(value = "/deleteBasketProduct", method = RequestMethod.GET)
    public String deleteBasketProduct(@RequestParam("idProduct") int productID) {
        Product product = productService.getProductByKey(productID);
        for (User user : product.getUsers()) {
            user.getProducts().remove(product);
            userService.updateUser(user);
        }
        return "redirect:/basket";
    }

    @RequestMapping(value = "/buy", method = RequestMethod.GET)
    public String buyProduct(@RequestParam("productID") int productID) {
        try {
            Product product = productService.getProductByKey(productID);
            String message = "Вы заказали товар - " + product.getProductName() + "\n" +
                    "Его стоимость - " + product.getPrice();
            mailService.send("Заказ на покупку " + product.getProductName(), message, userService.findByUserName(getPrincipal()).getEmail());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        return "redirect:/basket";
    }

    private String getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

    private Integer getProductInBasket() {
        return userService.findByUserName(getPrincipal()).getProducts().size();
    }
}