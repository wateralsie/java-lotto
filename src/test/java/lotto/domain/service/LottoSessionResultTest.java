package lotto.domain.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import lotto.domain.model.PurchaseMoney;
import lotto.domain.model.WinningRank;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoSessionResultTest {
    @Test
    void 특정_등수를_추가하면_해당_등수의_개수가_증가한다() {
        LottoSessionResult result = LottoSessionResult.initiallyCreate();

        result.add(WinningRank.THIRD);
        result.add(WinningRank.THIRD);
        result.add(WinningRank.FIFTH);

        assertEquals(2, result.getCountOfRank(WinningRank.THIRD));
        assertEquals(1, result.getCountOfRank(WinningRank.FIFTH));
        assertEquals(0, result.getCountOfRank(WinningRank.FIRST));
    }

    @ParameterizedTest
    @MethodSource("provideProfitRateTestCases")
    void 당첨_결과에_따라_정상적으로_수익률을_계산한다(
            int purchaseAmount,
            WinningRank rank,
            int count,
            double expectedProfitRate
    ) {
        LottoSessionResult result = LottoSessionResult.initiallyCreate();
        PurchaseMoney money = new PurchaseMoney(purchaseAmount);
        for (int i = 0; i < count; i++) {
            result.add(rank);
        }
        double actualProfitRate = result.calculateProfitRate(money);
        assertEquals(expectedProfitRate, actualProfitRate);
    }

    static Stream<Arguments> provideProfitRateTestCases() {
        return Stream.of(
                Arguments.of(8000, WinningRank.FIFTH, 1, 62.5),
                Arguments.of(10000, WinningRank.FOURTH, 1, 500.0),
                Arguments.of(10000, WinningRank.THIRD, 1, 15000.0),
                Arguments.of(10000, WinningRank.FIFTH, 2, 100.0),
                Arguments.of(1000, WinningRank.FIFTH, 0, 0.0)
        );
    }
}
