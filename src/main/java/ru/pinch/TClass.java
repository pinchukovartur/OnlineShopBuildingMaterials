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

        Robot robot = new Robot();
        robot.setProductId("1");
        robot.setType("1");
        robot.setModel("1");
        robot.setManufacturer("1");
        robot.setProductionYear(1);
        robot.setCondition("1");
        robot.setAxles("1");
        robot.setMaxLoad(1);
        robot.setReach(1);
        robot.setFootprint("1");
        robot.setRepeatability("1");
        robot.setWeight(1);
        robot.setPrice(1.1);
        robot.setDescription("1");
        productsService.addProduct(robot);

        /*productsService.deleteProduct("test");*/

        System.out.println("Finishing");
    }
}
