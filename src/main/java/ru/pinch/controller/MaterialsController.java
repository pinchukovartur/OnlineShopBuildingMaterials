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
import ru.pinch.entity.products.plywoods.Plywood;
import ru.pinch.service.products.ProductsService;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

@Controller
public class MaterialsController {

    @Autowired
    private ProductsService productsService;

    @RequestMapping(value = "/newProduct", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("addProduct") Plywood product) {
        productsService.addMaterial(product);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/dProduct/{id}", method = RequestMethod.GET)
    public String deleteContact(@PathVariable("id") String idProduct) {
        productsService.deleteMaterial(idProduct);
        return "redirect:/admin";
    }


    @RequestMapping(value = "/files/{productId}", method = RequestMethod.GET)
    public void getFile(
            @PathVariable("productId") String productId,
            HttpServletResponse response) {
        try {
            FileInputStream is = productsService.getPDFWithMaterialsData(productsService.getMaterial(productId));
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

        modelAndView.addObject("addProduct", new Plywood());
        modelAndView.addObject("listProduct", productsService.getAllMaterials());

        if (!file.isEmpty()) {
            try {
                Date date = new Date();
                /*Photosplywoods plywoodPhotos = new Photosplywoods();*/
                String imageName = date.toString().replaceAll(":", ",");

                productsService.saveTheImageOnServer(imageName, file.getBytes());

                /*plywoodPhotos.setProduct(productsService.getMaterial(material));
                plywoodPhotos.setPhoto(imageName);*/

                /*productsService.saveTheImageOnDataBase(plywoodPhotos);*/

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

        if (!file.isEmpty()) {
            modelAndView.setViewName("WEB-INF/views/"+"admin");
            modelAndView.addObject("errorExcel", productsService.addMaterialsFromExcel(file));

        } else {
            modelAndView.addObject("errorExcel", "empty file");
            modelAndView.setViewName("WEB-INF/views/"+"admin");
        }

        modelAndView.addObject("addProduct", new Plywood());
        modelAndView.addObject("listProduct", productsService.getAllMaterials());
        return modelAndView;
    }
}
