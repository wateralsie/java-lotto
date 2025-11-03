package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.constants.LottoConstant;
import lotto.constants.LottoMessage;
import lotto.util.NumberValidator;

public class InputView {
    public int readPurchaseMoneyAmount() {
        System.out.println(LottoMessage.PURCHASE_MONEY_ENTER_PROMPT);
        String money = Console.readLine();
        NumberValidator.validate(money);

        return Integer.parseInt(money);
    }

    public List<Integer> readWinningNumbers() {
        System.out.println(LottoMessage.WINNING_NUMBERS_ENTER_PROMPT);
        String[] numbers = Console.readLine().split(LottoConstant.LOTTO_NUMBER_SEPARATOR);
        NumberValidator.validate(numbers);

        return Arrays.stream(numbers)
                .map(Integer::parseInt)
                .toList();
    }

    public int readBonusNumber() {
        System.out.println(LottoMessage.BONUS_NUMBER_ENTER_PROMPT);
        String number = Console.readLine();
        NumberValidator.validate(number);

        return Integer.parseInt(number);
    }
}
