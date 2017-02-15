package ru.pinch.controller.product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import ru.pinch.entity.products.Photo;
import ru.pinch.entity.products.plywoods.Plywood;
import ru.pinch.service.products.ProductsService;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

@Controller
public class FileProductController {

    @Autowired
    private ProductsService productsService;

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public ModelAndView uploadPhotoProduct(@RequestParam("file") MultipartFile file,
                                   @RequestParam(value = "productId", defaultValue = "") String productId,
                                           ModelAndView modelAndView) {

        modelAndView.addObject("addProduct", new Plywood());
        modelAndView.addObject("listProduct", productsService.getProducts());
        if (!file.isEmpty() && !productId.equals("")) {
            try {
                /*Date date = new Date();
                String imageName = date.toString().replaceAll(":", ",");*/

                productsService.saveTheImageOnServer(file.getOriginalFilename(), file.getBytes());
                Photo photo = new Photo();
                photo.setProduct(productsService.getProductByID(productId));
                photo.setPhoto(file.getOriginalFilename());

                productsService.savePhoto(photo);

                modelAndView.addObject("errorImage", "file has been successfully downloaded");
                modelAndView.setViewName("WEB-INF/views/admin/" + "product");
                return modelAndView;
            } catch (IOException e) {
                modelAndView.setViewName("WEB-INF/views/admin/" + "product");
                modelAndView.addObject("errorImage", e.getMessage());
                return modelAndView;
            }
        } else {
            modelAndView.addObject("errorImage", "empty file");
            modelAndView.setViewName("WEB-INF/views/admin/" + "product");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/files/{productId}", method = RequestMethod.GET)
    public void getPDFFile(
            @PathVariable("productId") String productId,
            HttpServletResponse response) {
        try {
            FileInputStream is = productsService.getPDF(productsService.getProductByID(productId));
            org.apache.commons.io.IOUtils.copy(is, response.getOutputStream());
            response.flushBuffer();
        } catch (IOException ex) {
            System.err.println("Error writing file to output stream. Filename was-" + productId);
        }
        throw new RuntimeException("IOError writing file to output stream");
    }

    @RequestMapping(value = "/uploadExcel", method = RequestMethod.POST)
    public ModelAndView uploadExcel(@RequestParam("file") MultipartFile file, ModelAndView modelAndView) {

        if (!file.isEmpty()) {
            modelAndView.setViewName("WEB-INF/views/"+"admin");
            modelAndView.addObject("errorExcel", productsService.addProductsFromExcel(file));

        } else {
            modelAndView.addObject("errorExcel", "empty file");
            modelAndView.setViewName("WEB-INF/views/"+"admin");
        }

        modelAndView.addObject("addProduct", new Plywood());
        modelAndView.addObject("listProduct", productsService.getProducts());
        return modelAndView;
    }

    @RequestMapping(value = "/getImage", method = RequestMethod.GET)
    public void getImage(
            @RequestParam("image") String imageName,
            HttpServletResponse response) {
        System.out.println(imageName);
        if(!imageName.equals("")) {
            final String COMPUTER_PATH = "E:\\Projects\\dataServer\\";
            try {
                FileInputStream image = null;
                try {
                    image = new FileInputStream(COMPUTER_PATH + imageName);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                org.apache.commons.io.IOUtils.copy(image, response.getOutputStream());
                response.flushBuffer();
            } catch (IOException ex) {
                System.err.println("Error writing file to output stream. Filename was-" + imageName);
            }
            throw new RuntimeException("IOError writing file to output stream");
        }
    }
}
