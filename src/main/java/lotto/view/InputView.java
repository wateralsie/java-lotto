package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.util.NumberValidator;

public class InputView {
    public int readPurchaseMoneyAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String money = Console.readLine();
        NumberValidator.validate(money);

        return Integer.parseInt(money);
    }

    public List<Integer> readWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] numbers = Console.readLine().split(",");
        NumberValidator.validate(numbers);

        return Arrays.stream(numbers)
                .map(Integer::parseInt)
                .toList();
    }

    public int readBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String number = Console.readLine();
        NumberValidator.validate(number);

        return Integer.parseInt(number);
    }
}
