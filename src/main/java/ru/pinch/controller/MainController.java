package ru.pinch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.pinch.model.User;
import ru.pinch.model.database.ConstructionmaterialsEntity;
import ru.pinch.model.database.dao.ShopDataBaseImpl;

import java.util.List;

@Controller
public class MainController {

    /*First method on start application*/
    /*Попадаем сюда на старте приложения (см. параметры аннотации и настройки пути после деплоя) */
    /*@RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main() {
        ModelAndView modelAndView = new ModelAndView();
        ShopDataBaseImpl shopDataBase = new ShopDataBaseImpl();

        List<ConstructionmaterialsEntity> constructionmaterialsEntities = shopDataBase.listProducts();

        modelAndView.setViewName("index");
        modelAndView.addObject("listProduct", constructionmaterialsEntities);

        return modelAndView;
    }*/

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView admin() {
        ModelAndView modelAndView = new ModelAndView();
        ShopDataBaseImpl shopDataBase = new ShopDataBaseImpl();

        modelAndView.setViewName("admin");
        modelAndView.addObject("listProduct", shopDataBase.listProducts());

        modelAndView.addObject("addProduct", new ConstructionmaterialsEntity());

        return modelAndView;
    }

    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    public ModelAndView addProduct(@ModelAttribute("addProduct") ConstructionmaterialsEntity user) {


        //имя представления, куда нужно будет перейти
        ModelAndView modelAndView = new ModelAndView();
        ShopDataBaseImpl shopDataBase = new ShopDataBaseImpl();

        shopDataBase.addEntity(user);
        //записываем в атрибут userJSP (используется на странице *.jsp объект user

        /*modelAndView.setViewName("admin");
        modelAndView.addObject("listProduct", shopDataBase.listProducts());
        modelAndView.addObject("addProduct", new ConstructionmaterialsEntity());
        return modelAndView;*/

        return admin();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userJSP", new ConstructionmaterialsEntity());
        modelAndView.setViewName("index");
        return modelAndView;
    }
}