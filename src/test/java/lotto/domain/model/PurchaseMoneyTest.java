package lotto.domain.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseMoneyTest {
    @ParameterizedTest
    @ValueSource(ints = {500, 2400, 9999})
    void 구입금액이_1000으로_나누어떨어지지_않는다면_예외가_발생한다(int amount) {
        assertThatThrownBy(() -> new PurchaseMoney(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 구입 금액은 1,000원 단위로 입력해야 합니다.");
    }

    @Test
    void 구입금액이_0원이면_예외가_발생한다() {
        int amount = 0;
        assertThatThrownBy(() -> new PurchaseMoney(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 구입 금액을 지불해주세요.");
    }
}
