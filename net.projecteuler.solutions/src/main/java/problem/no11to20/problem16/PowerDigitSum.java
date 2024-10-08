package problem.no11to20.problem16;

import utils.data.DigitNumber;

import static java.math.BigInteger.TWO;

public class PowerDigitSum {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=16
        System.out.println(of2ToThe(1000));
    }

    public static int of2ToThe(int i) {
        return DigitNumber.of(TWO.pow(i)).sumOfDigits();
    }
}
