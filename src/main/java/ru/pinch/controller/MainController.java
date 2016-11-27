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
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main() {
        ModelAndView modelAndView = new ModelAndView();
        ShopDataBaseImpl shopDataBase = new ShopDataBaseImpl();

        List<ConstructionmaterialsEntity> constructionmaterialsEntities = shopDataBase.listProducts();

        modelAndView.setViewName("index");
        modelAndView.addObject("listProduct", constructionmaterialsEntities);

        return modelAndView;
    }

    @RequestMapping(value = "/authorization", method = RequestMethod.GET)
    public String auth(Model model) {
        return "admin";
    }

    /*как только на index.jsp подтвердится форма
    <spring:form method="post"  modelAttribute="userJSP" action="check-user">,
    то попадем вот сюда
     */
    @RequestMapping(value = "/check-user")
    public ModelAndView checkUser(@ModelAttribute("userJSP") User user) {
        ModelAndView modelAndView = new ModelAndView();

        //имя представления, куда нужно будет перейти
        modelAndView.setViewName("secondPage");

        //записываем в атрибут userJSP (используется на странице *.jsp объект user
        modelAndView.addObject("userJSP", user);

        return modelAndView; //после уйдем на представление, указанное чуть выше, если оно будет найдено.
    }
}