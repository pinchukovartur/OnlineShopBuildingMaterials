package ru.pinch;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.pinch.dao.products.ProductsDAOImpl;
import ru.pinch.entity.products.robots.Robot;

public class TClass {


    public static void main(String[] args) {
        System.out.println("Starting configuration...");

        ApplicationContext context = new AnnotationConfigApplicationContext(ProductsDAOImpl.class);
        ProductsDAOImpl productsService = context.getBean(ProductsDAOImpl.class);

        /*Robot robot = new Robot();
        robot.setProductId("Robot34567");
        robot.setType("Robot2");
        robot.setManufacturer("M");
        robot.setModel("Mo");
        productsService.addProduct(robot);*/

        productsService.deleteProduct("test");

        System.out.println("Finishing");
    }
}
