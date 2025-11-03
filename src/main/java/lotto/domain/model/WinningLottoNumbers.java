package lotto.domain.model;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import lotto.constants.ErrorMessage;
import lotto.constants.LottoConstant;

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
        validateNumbersCount(winningNumbers);
        validateDuplicateNumbers(winningNumbers);
        validateNotDuplicatedWith(winningNumbers, bonusNumber);
    }

    private void validateNumbersCount(List<Integer> winningNumbers) {
        if (winningNumbers.size() != LottoConstant.LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBERS_COUNT);
        }
    }

    private void validateDuplicateNumbers(List<Integer> winningNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (Integer number : winningNumbers) {
            if (!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBERS);
            }
        }
    }

    private void validateNotDuplicatedWith(List<Integer> winningNumbers, int number) {
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER);
        }
    }
}
