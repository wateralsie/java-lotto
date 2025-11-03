package lotto.domain.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 20, 45})
    void 로또_번호가_1과_45의_사이값이면_객체를_생성한다(int number) {
        assertSimpleTest(() -> {
            new LottoNumber(number);
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46, 101})
    void 로또_번호가_1과_45의_사이값이_아니면_예외가_발생한다(int number) {
        assertThatThrownBy(() -> new LottoNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
