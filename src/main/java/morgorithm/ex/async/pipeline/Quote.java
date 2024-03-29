package morgorithm.ex.async.pipeline;

public class Quote {
    private final String shopName;
    private final double price;
    private final Code discountCode;

    public Quote(String shopName, double price, Code discountCode) {
        this.shopName = shopName;
        this.price = price;
        this.discountCode = discountCode;
    }

    public static Quote parse(String s){
        final String[] split = s.split(":");
        final String shopName = split[0];
        final double price = Double.parseDouble(split[1]);
        final Code discountCode = Code.valueOf(split[2]);
        return new Quote(shopName, price, discountCode);
    }

    public String getShopName() {
        return shopName;
    }

    public double getPrice() {
        return price;
    }

    public Code getDiscountCode() {
        return discountCode;
    }
}
