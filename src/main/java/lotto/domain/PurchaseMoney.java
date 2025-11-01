package lotto.domain;

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
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }

    private void validateIsZero(int amount) {
        if (amount == 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액을 지불해주세요.");
        }
    }
}
