package lotto.domain;

import java.util.List;
import java.util.Optional;

public class WinningLottoNumbers {
    private final List<LottoNumber> winningNumbers;
    private final LottoNumber bonusNumber;

    public WinningLottoNumbers(List<Integer> winningNumbers, int bonusNumber) {
        validate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers.stream()
                .map(LottoNumber::new)
                .toList();
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public Optional<WinningRank> compareWith(Lotto lotto) {
        int matchCount = matchNumbers(lotto);
        boolean hasBonusNumber = lotto.hasNumber(bonusNumber);
        if (matchCount < WinningRank.FIFTH.getNumbersMatchCount()) {
            return Optional.empty();
        }
        return Optional.ofNullable(WinningRank.decideBy(matchCount, hasBonusNumber));
    }

    private int matchNumbers(Lotto lotto) {
        int matchCount = 0;
        for (LottoNumber winningNumber: winningNumbers) {
            if (lotto.hasNumber(winningNumber)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private void validate(List<Integer> winningNumbers, int bonusNumber) {
        validateNotDuplicatedWith(winningNumbers, bonusNumber);
    }

    private void validateNotDuplicatedWith(List<Integer> winningNumbers, int number) {
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}
