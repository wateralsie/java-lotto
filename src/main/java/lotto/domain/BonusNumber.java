package lotto.domain;

public class BonusNumber {
    private final int number;

    public BonusNumber(int number) {
        validate(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private void validate(int number) {
        validateInRange(number);
    }

    private void validateInRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 로또 번호의 범위에서 벗어납니다. (1~45)");
        }
    }
}
