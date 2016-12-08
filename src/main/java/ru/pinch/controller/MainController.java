package ru.pinch.controller;


import com.sun.xml.internal.ws.developer.Serialization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import ru.pinch.entity.Material;
import ru.pinch.entity.Role;
import ru.pinch.entity.User;
import ru.pinch.service.material.MaterialService;
import ru.pinch.service.user.UserService;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.security.Principal;

@Controller
public class MainController {

    public static final int ENABLED = 1;
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);
    public static final String ROLE_USER = "ROLE_USER";
    public static final int USER_ID = 1;

    @Autowired
    private MaterialService materialService;

    @Autowired
    private UserService userservice;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView admin(ModelAndView modelAndView) {
        String idProduct = "";
        modelAndView.setViewName("WEB-INF/views/" + "admin");
        modelAndView.addObject("addProduct", new Material());
        modelAndView.addObject("delProduct", idProduct);
        modelAndView.addObject("listProduct", materialService.getMaterials());
        modelAndView.addObject("listUsers", userservice.getUsers());
        return modelAndView;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main(ModelAndView modelAndView) {
        modelAndView.addObject("listProduct", materialService.getMaterials());
        modelAndView.setViewName("WEB-INF/views/" + "index");
        return modelAndView;
    }

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

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView regist(ModelAndView modelAndView) {
        modelAndView.addObject("user", new User());
        modelAndView.setViewName("WEB-INF/views/" + "regist");
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView registration(@ModelAttribute("user") User user,
                                     @RequestParam(value = "error", required = false) String error,
                                     ModelAndView modelAndView) {

        if (user.getUsername().equals("") || user.getEmail().equals("") || user.getPassword().equals("")) {
            modelAndView.addObject("error", "Заполните все поля");
            modelAndView.setViewName("WEB-INF/views/" + "regist");
            return modelAndView;
        } else {
            user.setEnabled(ENABLED);
            user.setId(USER_ID);
            userservice.addUser(user);
            modelAndView.setViewName("login");
            return modelAndView;
        }
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public
    @ResponseBody
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
                logger.info("нАЗВАНИЕ ФАЙЛА:" + name);
                File serverFile = new File("E:\\Projects\\OnlineShopBuildingMaterials\\web\\resources\\images" + "image.png");
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();

                logger.info("Server File Location="
                        + serverFile.getAbsolutePath());

                return "You successfully uploaded file=" + name;
            } catch (Exception e) {
                logger.error(e.getMessage());
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + name
                    + " because the file was empty.";
        }
    }
}
