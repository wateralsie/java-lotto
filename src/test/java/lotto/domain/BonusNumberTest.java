package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 46, 101})
    void 보너스_번호가_1과_45의_사이값이_아니면_예외가_발생한다(int number) {
        assertThatThrownBy(() -> new BonusNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
