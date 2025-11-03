package lotto.domain.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constants.ErrorMessage;
import lotto.constants.LottoConstant;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                .map(LottoNumber::new)
                .toList();
    }

    public boolean hasNumber(LottoNumber number) {
        return numbers.contains(number);
    }

    private void validate(List<Integer> numbers) {
        validateNumbersCount(numbers);
        validateDuplicateNumbers(numbers);
    }

    private void validateNumbersCount(List<Integer> numbers) {
        if (numbers.size() != LottoConstant.LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBERS_COUNT);
        }
    }

    private void validateDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (Integer number : numbers) {
            if (!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBERS);
            }
        }
    }

    @Override
    public String toString() {
        return numbers.stream()
                .map(LottoNumber::getValue)
                .toList()
                .toString();
    }
}
