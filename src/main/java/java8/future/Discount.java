package java8.future;


/**
 * 商店的折扣
 *
 * @author Jae
 */
public class Discount {

    public enum Code {
        //不同的折扣等级，括号中是属性percentage
        NONE(0), SILVER(5), GOLD(10), PLATINUM(15), DIAMOND(20);

        private final int percentage;

        Code(int percentage) {
            this.percentage = percentage;
        }
    }

    /**
     * 将折扣代码应用于商品最初的原始价格
     * @param quote
     * @return
     */
    public static String applyDiscount(Quote quote) {
        return String.format("%s price is %s",
                    quote.getShopName(),
                    //这一步有计算延时
                    Discount.apply(quote.getPrice(), quote.getDiscountCode()));
    }

    private static double apply(double price, Code code) {
        Utils.delay();
        return (price * (100 - code.percentage) / 100);
    }
}
