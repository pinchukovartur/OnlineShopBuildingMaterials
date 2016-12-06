package ru.pinch.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.servlet.ModelAndView;
import ru.pinch.dao.constmaterials.BuildingOnlineShopDataBaseImpl;
import ru.pinch.dao.userbase.UserDataBaseImpl;
import ru.pinch.dto.ProductService;
import ru.pinch.dto.ProductServiceImpl;
import ru.pinch.model.ConstructionmaterialsEntity;
import ru.pinch.model.UsersEntity;

import javax.print.attribute.standard.MediaSize;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.security.Principal;

@Controller
public class MainController {

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView admin() {
        ModelAndView modelAndView = new ModelAndView();
        String idProduct = "";
        ProductService productService = new ProductServiceImpl();
        modelAndView.setViewName("WEB-INF/views/" + "admin");
        modelAndView.addObject("addProduct", new ConstructionmaterialsEntity());
        modelAndView.addObject("delProduct", idProduct);
        modelAndView.addObject("listProduct", productService.listProducts());
        modelAndView.addObject("listUsers", productService.listUsers());
        /*modelAndView.addObject("dto", productService);*/
        return modelAndView;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main() {
        ModelAndView modelAndView = new ModelAndView();
        BuildingOnlineShopDataBaseImpl productService = new BuildingOnlineShopDataBaseImpl();
        modelAndView.addObject("listProduct", productService.listProducts());
        modelAndView.setViewName("WEB-INF/views/" + "index");
        return modelAndView;
    }

    @RequestMapping(value = "/newProduct", method = RequestMethod.POST)
    public ModelAndView addProduct(@ModelAttribute("addProduct") ConstructionmaterialsEntity product) {
        BuildingOnlineShopDataBaseImpl productService = new BuildingOnlineShopDataBaseImpl();
        productService.addEntity(product);
        return admin();
    }

    @RequestMapping(value = "/dProduct", method = RequestMethod.POST)
    public ModelAndView deleteContact(@ModelAttribute("idProduct") String idProduct) {
        BuildingOnlineShopDataBaseImpl productService = new BuildingOnlineShopDataBaseImpl();
        productService.deleteEntity(idProduct);
        return admin();
    }

    @RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
    public ModelAndView accessDenied(Principal user) {
        ModelAndView modelAndView = new ModelAndView();
        if (user != null) {
            modelAndView.addObject("errorMsg", user.getName() + "У вас нет доступа");
        } else {
            modelAndView.addObject("У вас нет доступа");
        }

        modelAndView.setViewName("WEB-INF/views/" + "accessDenied");
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView checkUser(@RequestParam(value = "error", required = false) String error) {

        ModelAndView modelAndView = new ModelAndView();

        if (error != null) {
            modelAndView.addObject("error", "Invalid username or password!");
        }
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView regist() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", new UsersEntity());
        modelAndView.setViewName("WEB-INF/views/" + "regist");
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView registration(@ModelAttribute("user") UsersEntity user,
                                     @RequestParam(value = "error", required = false) String error) {

        ModelAndView modelAndView = new ModelAndView();

        if (user.getUsername().equals("") || user.getEmail().equals("") || user.getPassword().equals("")) {
            modelAndView.addObject("error", "Заполните все поля");
            modelAndView.setViewName("WEB-INF/views/" + "regist");
            return modelAndView;
        }
        else {
            user.setRole("ROLE_USER");
            user.setEnabled(1);
            UserDataBaseImpl userDataBase = new UserDataBaseImpl();
            userDataBase.addUser(user);

            modelAndView.setViewName("login");
            return modelAndView;
        }
    }

    private static  final Logger logger = LoggerFactory.getLogger(MainController.class);

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public @ResponseBody
    String uploadFileHandler(@RequestParam("fileName") String name,
                             @RequestParam("file") MultipartFile file) {

        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();

                // Creating the directory to store file
                String rootPath = System.getProperty("catalina.properties");
                File dir = new File(rootPath + File.separator + "tmpFiles");
                if (!dir.exists())
                    dir.mkdirs();

                // Create the file on server
                System.err.println("нАЗВАНИЕ ФАЙЛА:" + name);
                File serverFile = new File("E:\\Programs\\apache-tomcat-8.5.8\\images\\" + name);
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();

                logger.info("Server File Location="
                        + serverFile.getAbsolutePath());

                return "You successfully uploaded file=" + name;
            } catch (Exception e) {
                System.err.println(e.getMessage());
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + name
                    + " because the file was empty.";
        }
    }
}
