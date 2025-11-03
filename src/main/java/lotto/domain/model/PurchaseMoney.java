package lotto.domain.model;

import lotto.constants.ErrorMessage;
import lotto.constants.LottoConstant;

public class PurchaseMoney {
    private final int amount;

    public PurchaseMoney(int amount) {
        validate(amount);
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    private void validate(int amount) {
        validateNoChange(amount);
        validateIsZero(amount);
    }

    private void validateNoChange(int amount) {
        if (amount % LottoConstant.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_UNIT);
        }
    }

    private void validateIsZero(int amount) {
        if (amount == 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_MONEY_IS_ZERO);
        }
    }
}
