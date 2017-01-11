package ru.pinch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import ru.pinch.entity.Material;
import ru.pinch.service.material.MaterialService;
import ru.pinch.service.user.UserService;

import java.io.IOException;
import java.security.Principal;

@Controller
public class MaterialsController {
    @Autowired
    private MaterialService materialService;

    @RequestMapping(value = "/newProduct", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("addProduct") Material product) {
        materialService.addMaterialInDataBase(product);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/dProduct", method = RequestMethod.POST)
    public String deleteContact(@ModelAttribute("idProduct") String idProduct) {
        materialService.deleteMaterialByIDOfTheDataBase(idProduct);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public
    @ResponseBody
    String uploadFileHandler(@RequestParam("fileName") String filename,
                             @RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                materialService.saveTheImageOnServer(filename, bytes);
                return "Successful";
            } catch (IOException e) {
                e.printStackTrace();
                return "Exception";
            }
        }
        else return "failed";
    }

}
