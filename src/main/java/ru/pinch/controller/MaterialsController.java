package ru.pinch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.pinch.entity.Material;
import ru.pinch.entity.MaterialsPictures;
import ru.pinch.service.material.MaterialService;

import java.io.IOException;
import java.util.Date;

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
    public String uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("material") String material) {
        /*if (!file.isEmpty()) {
            try {
                Date date = new Date();
                MaterialsPictures materialsPictures = new MaterialsPictures();
                String imageName = date.toString().replaceAll(":",",");
                materialService.saveTheImageOnServer(imageName, file.getBytes());
                materialsPictures.setMaterial(materialService.getMaterialsByIDOfTheDataBase(material));
                materialsPictures.setPhoto(imageName);
                materialService.saveTheImageOnDataBase(materialsPictures);
                return "redirect:/admin";
            } catch (IOException e) {
                e.printStackTrace();
                return "redirect:/admin";
            }
        }
        else*/ return "redirect:/admin";
    }
}
