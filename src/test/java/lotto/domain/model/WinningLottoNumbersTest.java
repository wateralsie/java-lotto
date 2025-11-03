package lotto.domain.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import lotto.constants.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningLottoNumbersTest {
    private final List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
    private final int bonusNumber = 7;

    @Test
    void 당첨_번호와_보너스_번호가_유효한_경우_객체를_생성한다() {
        new WinningLottoNumbers(winningNumbers, bonusNumber);
    }

    @Test
    void 당첨_번호가_6개가_아니면_예외가_발생한다() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5);

        assertThatThrownBy(() -> new WinningLottoNumbers(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_LOTTO_NUMBERS_COUNT);
    }

    @Test
    @DisplayName("당첨 번호에 중복된 번호가 있으면 예외가 발생한다")
    void 당첨_번호에_중복된_번호가_있으면_예외가_발생한다() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 5);

        assertThatThrownBy(() -> new WinningLottoNumbers(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.DUPLICATE_LOTTO_NUMBERS);
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다")
    void 보너스_번호가_당첨_번호와_중복되면_예외가_발생한다() {
        int bonusNumber = 6;

        assertThatThrownBy(() -> new WinningLottoNumbers(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }

    @ParameterizedTest
    @MethodSource("provideWinningLottoNumbers")
    void 로또_번호_일치_개수와_보너스_번호_일치_여부를_기준으로_올바른_등수를_반환한다(
            List<Integer> lottoNumbers,
            WinningRank expectedRank
    ) {
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(winningNumbers, bonusNumber);
        Lotto lotto = new Lotto(lottoNumbers);

        Optional<WinningRank> result = winningLottoNumbers.compareWith(lotto);

        assertThat(result).isPresent();
        assertThat(result).contains(expectedRank);
    }

    static Stream<Arguments> provideWinningLottoNumbers() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), WinningRank.FIRST),
                Arguments.of(List.of(1, 2, 3, 4, 5, 7), WinningRank.SECOND),
                Arguments.of(List.of(1, 2, 3, 4, 5, 8), WinningRank.THIRD),
                Arguments.of(List.of(1, 2, 3, 4, 8, 9), WinningRank.FOURTH),
                Arguments.of(List.of(1, 2, 3, 8, 9, 10), WinningRank.FIFTH)
        );
    }

    @ParameterizedTest
    @MethodSource("provideNotWinningLottoNumbers")
    void 일치하는_번호가_3개_미만이면_빈_Optional을_반환한다(List<Integer> lottoNumbers) {
        WinningLottoNumbers winning = new WinningLottoNumbers(winningNumbers, bonusNumber);
        Lotto lotto = new Lotto(lottoNumbers);

        Optional<WinningRank> result = winning.compareWith(lotto);

        assertThat(result).isEmpty();
    }

    static Stream<Arguments> provideNotWinningLottoNumbers() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 8, 9, 10, 11)),
                Arguments.of(List.of(1, 8, 9, 10, 11, 12)),
                Arguments.of(List.of(8, 9, 10, 11, 12, 13))
        );
    }
}
