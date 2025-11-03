package lotto.domain.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import lotto.domain.model.PurchaseMoney;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoGeneratorTest {
    @ParameterizedTest
    @CsvSource({
            "1000, 1",
            "5000, 5",
            "8000, 8",
            "14000, 14"
    })
    void 구입_금액에_따라_올바른_개수의_로또를_생성한다(int amount, int expectedCount) {
        PurchaseMoney money = new PurchaseMoney(amount);
        LottoGenerator generator = new LottoGenerator(money);
        assertEquals(expectedCount, generator.getLottoCount());
    }
}
