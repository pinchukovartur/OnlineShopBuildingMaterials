package com.pincha.spring.controller;

import com.pincha.spring.dao.photo.PhotoDAOImpl;
import com.pincha.spring.dao.product.ProductDAOImpl;
import com.pincha.spring.model.Photo;
import com.pincha.spring.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


@Controller
public class FileController {

    private final PhotoDAOImpl photoDAO;
    private final ProductDAOImpl productDAO;
    private Path pathApp;

    @Autowired
    public FileController(PhotoDAOImpl photoDAO, ProductDAOImpl productDAO, Path pathApp) {
        this.photoDAO = photoDAO;
        this.productDAO = productDAO;
        this.pathApp = pathApp;
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public String uploadMultiFileHandlerPOST(@RequestParam("file") MultipartFile file,
                                             @RequestParam("productId") int productId, ModelMap model){
        String name = null;
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                name = file.getOriginalFilename();
                File dir = new File(pathApp.toString() + File.separator + "productPhoto");
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                File uploadedFile = new File(pathApp.toString()+ File.separator + "productPhoto" + File.separator + name);
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(uploadedFile));
                stream.write(bytes);
                stream.flush();
                stream.close();

                photoDAO.persist(new Photo(file.getOriginalFilename(),productDAO.getByKey(productId)));

                model.addAttribute("errorImage","You successfully uploaded file=" + name);
                return "admin";
            } catch (Exception e) {
                model.addAttribute("errorImage","You failed to upload " + name + " => " + e.getMessage());
                return "admin";
            }
        } else {
            model.addAttribute("errorImage","You failed to upload " + name + " because the file was empty.");
            return "admin";
        }
    }
}

