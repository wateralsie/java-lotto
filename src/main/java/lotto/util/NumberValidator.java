package lotto.util;

public class NumberValidator {
    private final static String ONLY_NUMBER = "\\d+";

    public static void validate(String value) {
        if (!value.matches(ONLY_NUMBER)) {
            throw new IllegalArgumentException("[ERROR] %s : 숫자가 아닌 값이 포함되어 있습니다.");
        }
    }

    public static void validate(String[] values) {
        for (String value : values) {
            validate(value);
        }
    }
}
