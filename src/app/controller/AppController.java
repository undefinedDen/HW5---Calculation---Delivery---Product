package app.controller;

import app.entity.Product;
import app.list.ProductList;
import app.service.CalcCostDelivery;
import app.service.CalcCostProduct;
import app.util.Constants;
import app.util.Rounder;
import app.view.AppView;


public class AppController {
    static int choice;
    static String name;
    static int quota;
    static double totalCost;

    public static void getOutput() {
        CalcCostProduct costProduct = new CalcCostProduct();
        CalcCostDelivery delivery = new CalcCostDelivery();
        ProductList list = new ProductList();
        AppView view = new AppView();
        view.getDisplayInfo(Constants.START_MESSAGE);
        list.getList();
        while (choice != 3) {
            view.getMenu();
//            Menu:
//        1 - show all product
//        2 - calculation cost product with delivery
//        3 - exit

            choice = view.getInputNum("Input operation: ");

            switch (choice) {
                case 1 -> {
                    for (Product product : list.getList()) {
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
                    //Errors

                    for (Product product : list.getList()) {
                        if (quota > product.getQuota() && product.getName().equalsIgnoreCase(name.trim())) {
                            view.getDisplayInfo("In our shop we are not have - " +
                                    quota + Constants.MEASURE_PCS + " of - " + name);
                            break;
                        }

                        if (product.getName().equalsIgnoreCase(name.trim())) {
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
                            break;
                        } else {
                            view.getDisplayInfo("Product that you input do not find");
                            break;
                        }


                    }

                }
                case 3 -> view.getDisplayInfo(Constants.FINISH_MESSAGE);
            }

        }
    }
}
