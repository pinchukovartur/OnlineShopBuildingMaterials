package myproject.controller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import myproject.entity.products.particleboards.ParticleBoard;
import myproject.entity.products.plywoods.Plywood;
import myproject.entity.products.robots.Robot;
import myproject.service.products.ProductsService;

@Controller
public class ProductController {

    @Autowired
    private ProductsService productsService;

    @RequestMapping(value = "/addParticleBoard", method = RequestMethod.GET)
    public String addParticleBoard(@RequestParam(value = "productId", defaultValue = "") String productId,
                             @RequestParam(value = "price", defaultValue = "0.0") double price,
                             @RequestParam(value = "weight", defaultValue = "0") Integer weight,
                             @RequestParam(value = "length", defaultValue = "0") Integer length,
                             @RequestParam(value = "thickness", defaultValue = "0") Integer thickness,
                             @RequestParam(value = "numberOfSheets", defaultValue = "0") Integer numberOfSheets,
                             @RequestParam(value = "numberOfPackages", defaultValue = "0") Integer numberOfPackages,
                             @RequestParam(value = "color", defaultValue = "") String color,
                             @RequestParam(value = "description", defaultValue = "0") String description) {
        ParticleBoard particleBoard = new ParticleBoard();
        particleBoard.setProductId(productId);
        particleBoard.setType("ParticleBoard");
        particleBoard.setPrice(price);
        particleBoard.setWeight(weight);
        particleBoard.setLength(length);
        particleBoard.setThickness(thickness);
        particleBoard.setNumberOfSheets(numberOfSheets);
        particleBoard.setNumberOfPackages(numberOfPackages);
        particleBoard.setColor(color);
        particleBoard.setDescription(description);
        productsService.addProduct(particleBoard);
        return "redirect:/admin?window=products";
    }

    @RequestMapping(value = "/addPlywood", method = RequestMethod.GET)
    public String addPlywood(@RequestParam(value = "productId", defaultValue = "") String productId,
                                   @RequestParam(value = "price", defaultValue = "0") double price,
                                   @RequestParam(value = "weight", defaultValue = "0") Integer weight,
                                   @RequestParam(value = "length", defaultValue = "0") Integer length,
                                   @RequestParam(value = "thickness", defaultValue = "0") Integer thickness,
                                   @RequestParam(value = "grade", defaultValue = "") String grade,
                                   @RequestParam(value = "sanded", defaultValue = "0") Integer sanded,
                                   @RequestParam(value = "waterResistance", defaultValue = "0") Integer waterResistance,
                                   @RequestParam(value = "numberOfSheets", defaultValue = "0") Integer numberOfSheets,
                                   @RequestParam(value = "numberOfPackages", defaultValue = "0") Integer numberOfPackages,
                                   @RequestParam(value = "description", defaultValue = "") String description) {
        Plywood plywood = new Plywood();
        plywood.setProductId(productId);
        plywood.setType("Plywood");
        plywood.setPrice(price);
        plywood.setWeight(weight);
        plywood.setLength(length);
        plywood.setThickness(thickness);
        plywood.setGrade(grade);
        plywood.setSanded(sanded);
        plywood.setWaterResistance(waterResistance);
        plywood.setNumberOfPackages(numberOfPackages);
        plywood.setNumberOfSheets(numberOfSheets);
        plywood.setDescription(description);
        productsService.addProduct(plywood);
        return "redirect:/admin?window=products";
    }

    @RequestMapping(value = "/addRobot", method = RequestMethod.GET)
    public String addRobot (@RequestParam(value = "productId", defaultValue = "") String productId,
                             @RequestParam(value = "price", defaultValue = "0.0") double price,
                             @RequestParam(value = "weight", defaultValue = "0") Integer weight,
                             @RequestParam(value = "model", defaultValue = "") String model,
                             @RequestParam(value = "manufacturer", defaultValue = "") String manufacturer,
                             @RequestParam(value = "productionYear", defaultValue = "0") Integer productionYear,
                             @RequestParam(value = "condition", defaultValue = "") String condition,
                             @RequestParam(value = "axles", defaultValue = "") String axles,
                             @RequestParam(value = "maxLoad", defaultValue = "0") Integer maxLoad,
                             @RequestParam(value = "reach", defaultValue = "0") Integer reach,
                             @RequestParam(value = "footprint", defaultValue = "") String footprint,
                             @RequestParam(value = "repeatability", defaultValue = "") String repeatability,
                             @RequestParam(value = "description", defaultValue = "0") String description) {
        Robot robot = new Robot();
        robot.setProductId(productId);
        robot.setType("Robot");
        robot.setPrice(price);
        robot.setWeight(weight);
        robot.setModel(model);
        robot.setManufacturer(manufacturer);
        robot.setProductionYear(productionYear);
        robot.setCondition(condition);
        robot.setAxles(axles);
        robot.setMaxLoad(maxLoad);
        robot.setReach(reach);
        robot.setFootprint(footprint);
        robot.setRepeatability(repeatability);
        robot.setDescription(description);
        productsService.addProduct(robot);
        return "redirect:/admin?window=products";
    }

    @RequestMapping(value = "/dProduct/{id}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable("id") String idProduct) {
        productsService.deleteProduct(idProduct);
        return "redirect:/admin?window=products";
    }
}
