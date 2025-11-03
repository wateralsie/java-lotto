package lotto.util;

import lotto.constants.ErrorMessage;

public class NumberValidator {
    private final static String ONLY_NUMBER = "\\d+";

    public static void validate(String value) {
        if (!value.matches(ONLY_NUMBER)) {
            throw new IllegalArgumentException(
                    String.format(ErrorMessage.NOT_NUMBER_VALUE_INCLUDED, value)
            );
        }
    }

    public static void validate(String[] values) {
        for (String value : values) {
            validate(value);
        }
    }
}
