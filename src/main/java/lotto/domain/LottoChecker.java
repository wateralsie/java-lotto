package lotto.domain;

import java.util.List;
import java.util.Optional;

public class LottoChecker {
    private final List<Integer> winningNumbers;

    public LottoChecker(List<Integer> numbers) {
        this.winningNumbers = numbers;
    }

    public Optional<WinningRank> compareNumbers(Lotto lotto, BonusNumber bonusNumber) {
        int matchCount = 0;
        for (Integer winningNumber: winningNumbers) {
            if (lotto.hasNumber(winningNumber)) {
                matchCount++;
            }
        }
        boolean hasBonusNumber = lotto.hasNumber(bonusNumber.getNumber());
        return Optional.ofNullable(WinningRank.decideBy(matchCount, hasBonusNumber));
    }
}
