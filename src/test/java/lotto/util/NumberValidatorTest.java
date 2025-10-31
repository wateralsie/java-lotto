package lotto.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = {"\n", " ", "aaa", "1aa", "f2dg"})
    void 숫자가_아닌_경우_예외가_발생한다(String value) {
        assertThatThrownBy(() -> NumberValidator.validate(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
