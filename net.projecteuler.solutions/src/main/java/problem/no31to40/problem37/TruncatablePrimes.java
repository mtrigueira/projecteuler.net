package problem.no31to40.problem37;

import utils.sequence.arithmetic.PrimeSequence;

import java.math.BigInteger;

import static utils.prime.Prime.isPrime;

public class TruncatablePrimes {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=37
        System.out.println(sumOfPrimesTruncatableInBothDirections());
    }

    private static long sumOfPrimesTruncatableInBothDirections() {
        long sum = 0;
        PrimeSequence primes = PrimeSequence.from(11);
        BigInteger prime = primes.next();

        for (int count = 0; count < 11; prime = primes.next())
            if (isTruncatablePrimeBothDirections(prime)) {
                sum += prime.longValueExact();
                count++;
            }

        return sum;
    }

    private static boolean isTruncatablePrime(long i, boolean leftToRight) {
        if (i < 10) return isPrime(i);

        if (!isPrime(i)) return false;
        long truncated = leftToRight ? truncate(i) : truncateR(i);

        return isTruncatablePrime(truncated, leftToRight);
    }

    private static long truncate(long i) {
        int length = String.valueOf(i).length();
        return i % (long) Math.pow(10, length - 1);
    }

    private static long truncateR(long i) {
        return i / 10;
    }

    public static boolean isTruncatablePrime(long i) {
        return isTruncatablePrime(i, true);
    }

    public static boolean isTruncatablePrimeBothDirections(BigInteger big) {
        long i = big.longValueExact();
        return isTruncatablePrime(i, true) && isTruncatablePrime(i, false);
    }
}
