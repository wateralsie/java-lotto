package lotto.constants;

public final class ErrorMessage {
    public static final String INVALID_LOTTO_NUMBERS_COUNT = "[ERROR] 로또 번호는 6개여야 합니다.";
    public static final String DUPLICATE_LOTTO_NUMBERS = "[ERROR] 로또 번호는 중복될 수 없습니다.";
    public static final String LOTTO_NUMBER_OUT_OF_RANGE = "[ERROR] %d : 해당 번호는 로또 번호의 범위에서 벗어납니다.";
    public static final String INVALID_PURCHASE_UNIT = "[ERROR] 로또 구입 금액은 1,000원 단위로 입력해야 합니다.";
    public static final String PURCHASE_MONEY_IS_ZERO = "[ERROR] 로또 구입 금액을 지불해주세요.";
    public static final String INVALID_BONUS_NUMBER = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.";
    public static final String NOT_NUMBER_VALUE_INCLUDED = "[ERROR] %s : 숫자가 아닌 값이 포함되어 있습니다.";

    private ErrorMessage() {}
}
