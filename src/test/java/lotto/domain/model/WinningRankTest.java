package lotto.domain.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class WinningRankTest {
    @ParameterizedTest
    @MethodSource("provideRankTestCases")
    void 당첨_기준을_기반으로_올바른_등수를_반환한다(int matchCount, boolean hasBonusNumber, WinningRank expectedRank) {
        WinningRank actualRank = WinningRank.decideBy(matchCount, hasBonusNumber);
        assertEquals(expectedRank, actualRank);
    }

    static Stream<Arguments> provideRankTestCases() {
        return Stream.of(
                Arguments.of(3, false, WinningRank.FIFTH),
                Arguments.of(4, false, WinningRank.FOURTH),
                Arguments.of(5, false, WinningRank.THIRD),
                Arguments.of(5, true, WinningRank.SECOND),
                Arguments.of(6, false, WinningRank.FIRST)
        );
    }
}