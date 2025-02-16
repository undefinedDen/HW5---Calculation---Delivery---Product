package app.service;

import app.util.Constants;

public class CalcCostDelivery {
    public double calcDelivery(double getDistanceToClient) {
        if (getDistanceToClient > 0 && getDistanceToClient <= 1) {
            return Constants.RATE_DELIVERY + (Constants.ONE_KILOMETER_DELIVERY_PRICE * getDistanceToClient);
        } else if (getDistanceToClient > 1 && getDistanceToClient <= 5) {
            return Constants.RATE_DELIVERY + (Constants.ONE_KILOMETER_DELIVERY_PRICE * getDistanceToClient);
        } else {
            return Constants.RATE_DELIVERY + (Constants.ONE_KILOMETER_DELIVERY_PRICE * getDistanceToClient);
        }
    }
}
