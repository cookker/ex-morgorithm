package morgorithm.ex.async.pipeline;

import static morgorithm.ex.async.pipeline.Shop.*;

public class Discount {

    public static String applyDiscount(Quote quote){
        return quote.getShopName() + " price is " +
                Discount.apply(quote.getPrice(), quote.getDiscountCode());
    }

    private static double apply(double price, Code code){
        delay();
        return price * (100 - code.getPercentage()) / 100;
    }
}
