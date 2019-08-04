package java8.fp;

import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleUnaryOperator;

    public class FunctionTest {

        static DoubleUnaryOperator curriedConverter(double f, double b){
            return (double x) -> x * f + b;
        }

        static DoubleBinaryOperator func1(double a, double b, double c){
            return (double x, double y) -> (x*x) * a + y * b + c;
        }



        public static void main(String[] args) {
            DoubleUnaryOperator convertUSDtoGBP = curriedConverter(0.6, 0);

            double gbp = convertUSDtoGBP.applyAsDouble(1000);

            DoubleBinaryOperator dbo = func1(1, 2, 3);
    }
}
