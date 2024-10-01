package problem8;

import utils.DigitNumber;

public class DigitNumberSequence extends DigitNumber {
    public DigitNumberSequence(String number) {
        super(number);
    }

    int index = 0;

    public long next()  {
        long value = digits[index];
        index++;

        return value;
    }

    public boolean hasNext() {
        return index<digits.length;
    }
}
