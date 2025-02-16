package app.controller;

import app.entity.Product;
import app.entity.ProductList;
import app.service.CalcCostDelivery;
import app.service.CalcCostProduct;
import app.util.Constants;
import app.util.Rounder;
import app.view.AppView;
import java.util.ArrayList;
import java.util.List;


public class AppController {
    static List<Product> productList = new ArrayList<>();
    static int choice;
    static String name;
    static int quota;
    static double totalCost;

    public static void getOutput() {

        CalcCostProduct costProduct = new CalcCostProduct();
        CalcCostDelivery delivery = new CalcCostDelivery();
        ProductList diary = new ProductList();
        AppView view = new AppView();
        view.getDisplayInfo(Constants.START_MESSAGE);
        diary.getFruit(productList);
        while (choice != 4) {
            view.getMenu();
//            Menu:
//        1 - show all product
//        2 - calculation cost product with delivery
//        3 - exit
            choice = view.getInputNum("Input operation: ");

            switch (choice) {
                case 1 -> {
                    for (Product product : productList) {
                        view.getDisplayInfo(product);
//                      Product: name: egg, quota: 100pcs., price: USD 0.2
//                      Product: name: Kiwi, quota: 50pcs., price: USD 12.5
//                      Product: name: Pineapple, quota: 35pcs., price: USD 20.0
                    }
                }
                case 2 -> {
                    view.getLine();
                    name = view.getInputName("Input name: ");
                    quota = view.getInputNum("Input quota: ");

                    for (Product product : productList) {
                        if (product == null) {
                            view.getDisplayInfo("Product that you input was not found");
                        } else if (product.getName().equalsIgnoreCase(name.trim())) {
                            if (quota > product.getQuota()) {
                                view.getDisplayInfo("In shop we have only - " + product.getQuota() + Constants.MEASURE_PCS);
                                break;
                            }
                            totalCost = costProduct.calcCostProducts(quota, product.getPrice());
                            double distance = view.getDistanceToClient();
                            double calcDelivery = delivery.calcDelivery(distance);
                            double finalCostDeliveryAndProduct = calcDelivery + totalCost;
                            view.getDisplayInfo("\n-----------------------------------------------------------------------------\n");
                            view.getDisplayInfo("Product: " + name + " - cost of 1 piece is - " + Constants.CURRENCY + " "
                                    + product.getPrice() + " - total cost of " + quota + Constants.MEASURE_PCS + " is " +
                                    Constants.CURRENCY + " " + Rounder.round(totalCost) + ".\n" +
                                    "Delivery to your home (" + Rounder.round(distance) + " "
                                    + Constants.MEASURE_DISTANCE + ") will cost - " + Constants.CURRENCY + " " + Rounder.round(calcDelivery) +
                                    " so the same price(product and delivery) is " + Constants.CURRENCY + " " + Rounder.round(finalCostDeliveryAndProduct));
                            view.getDisplayInfo("\n-------------------------------------------------------------------------------\n");
                        }

                    }

                }
                case 3 -> view.getDisplayInfo(Constants.FINISH_MESSAGE);
            }

        }
    }
}
