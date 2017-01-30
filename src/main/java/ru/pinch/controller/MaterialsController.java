package ru.pinch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import ru.pinch.entity.Material;
import ru.pinch.entity.MaterialsPictures;
import ru.pinch.service.material.MaterialService;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

@Controller
public class MaterialsController {

    @Autowired
    private MaterialService materialService;

    @RequestMapping(value = "/newProduct", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("addProduct") Material product) {
        materialService.addMaterial(product);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/dProduct/{id}", method = RequestMethod.GET)
    public String deleteContact(@PathVariable("id") String idProduct) {
        materialService.deleteMaterial(idProduct);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public ModelAndView oneProduct(@PathVariable("id") String idProduct, ModelAndView modelAndView) {
        modelAndView.addObject("product", materialService.getMaterial(idProduct));
        modelAndView.addObject("numberOfPhoto", materialService.getAllPhotoMaterials(materialService.getMaterial(idProduct)).size());
        modelAndView.setViewName("WEB-INF/views/" + "one_product");
        return modelAndView;
    }


    @RequestMapping(value = "/files/{productId}", method = RequestMethod.GET)
    public void getFile(
            @PathVariable("productId") String productId,
            HttpServletResponse response) {
        try {
            FileInputStream is = materialService.getPDFWithMaterialsData(materialService.getMaterial(productId));
            org.apache.commons.io.IOUtils.copy(is, response.getOutputStream());
            response.flushBuffer();
        } catch (IOException ex) {
            System.err.println("Error writing file to output stream. Filename was-" + productId);
        }
        throw new RuntimeException("IOError writing file to output stream");
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public ModelAndView uploadFile(@RequestParam("file") MultipartFile file,
                                   @RequestParam("material") String material, ModelAndView modelAndView) {

        modelAndView.addObject("addProduct", new Material());
        modelAndView.addObject("listProduct", materialService.getAllMaterials());

        if (!file.isEmpty()) {
            try {
                Date date = new Date();
                MaterialsPictures materialsPictures = new MaterialsPictures();
                String imageName = date.toString().replaceAll(":", ",");

                materialService.saveTheImageOnServer(imageName, file.getBytes());

                materialsPictures.setMaterial(materialService.getMaterial(material));
                materialsPictures.setPhoto(imageName);

                materialService.saveTheImageOnDataBase(materialsPictures);

                modelAndView.addObject("errorImage", "file has been successfully downloaded");
                modelAndView.setViewName("WEB-INF/views/"+"admin");
                return modelAndView;
            } catch (IOException e) {
                modelAndView.setViewName("WEB-INF/views/"+"admin");
                modelAndView.addObject("errorImage", e.getMessage());
                return modelAndView;
            }
        } else {
            modelAndView.addObject("errorImage", "empty file");
            modelAndView.setViewName("WEB-INF/views/"+"admin");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/uploadExcel", method = RequestMethod.POST)
    public ModelAndView uploadExcel(@RequestParam("file") MultipartFile file, ModelAndView modelAndView) {

        modelAndView.addObject("addProduct", new Material());
        modelAndView.addObject("listProduct", materialService.getAllMaterials());

        if (!file.isEmpty()) {
            modelAndView.setViewName("WEB-INF/views/"+"admin");
            modelAndView.addObject("errorExcel", "not empty file");

            materialService.addMaterialsFromExcel(file);

        } else {
            modelAndView.addObject("errorExcel", "empty file");
            modelAndView.setViewName("WEB-INF/views/"+"admin");
        }
        return modelAndView;
    }
}
