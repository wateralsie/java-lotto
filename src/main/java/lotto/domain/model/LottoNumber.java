package lotto.domain.model;

import lotto.constants.ErrorMessage;
import lotto.constants.LottoConstant;

public class LottoNumber {
    private final int number;

    public LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    public int getValue() {
        return number;
    }

    private void validate(int number) {
        validateInRange(number);
    }

    private void validateInRange(int number) {
        if (number < LottoConstant.MIN_LOTTO_NUMBER || number > LottoConstant.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(
                  String.format(ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE, number)
            );
        }
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof LottoNumber that)) {
            return false;
        }
        return number == that.number;
    }
}
