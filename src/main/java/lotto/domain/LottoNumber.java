package lotto.domain;

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
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] %d : 해당 번호는 로또 번호의 범위에서 벗어납니다.");
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
