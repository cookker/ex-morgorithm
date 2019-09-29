package morgorithm.leet.easy.mergetwolist;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RoundEven {

    public static void main(String[] args) {
//        for(double i = 0 ; i < 10 ; i = i + .1){
//            System.out.println("i=" + i + ", " + new BigDecimal(String.valueOf(i)).setScale(0, RoundingMode.HALF_EVEN));
//        }

        System.out.println(new BigDecimal(5.5).setScale(0, RoundingMode.HALF_EVEN));
        System.out.println(new BigDecimal(2.5).setScale(0, RoundingMode.HALF_EVEN));
        System.out.println(new BigDecimal(-5.5).setScale(0, RoundingMode.HALF_EVEN));
        System.out.println(new BigDecimal(1.1).setScale(0, RoundingMode.HALF_EVEN));
        System.out.println(new BigDecimal(-1.1).setScale(0, RoundingMode.HALF_EVEN));
        System.out.println(new BigDecimal(-2.7).setScale(0, RoundingMode.HALF_EVEN));
        System.out.println(new BigDecimal(1239.09).setScale(0, RoundingMode.HALF_EVEN));
    }
}
