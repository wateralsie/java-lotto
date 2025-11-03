package lotto.controller;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.PurchaseMoney;
import lotto.domain.ResultFormatter;
import lotto.view.InputView;

public class LottoSessionController {
    private final InputView inputView;

    public LottoSessionController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        PurchaseMoney money = getPurchaseMoneyFromUser();

        LottoGenerator lottoGenerator = new LottoGenerator(money);
        List<Lotto> lottos = lottoGenerator.generateLottos();
        System.out.println();
        System.out.printf("%d개를 구매했습니다.\n", lottos.size());
        System.out.println(ResultFormatter.formatLottoInfo(lottos));
        System.out.println();

        List<Integer> winningNumbers = getWinningNumbersFromUser();
        BonusNumber bonusNumber = getBonusNumberFromUser(winningNumbers);
    }

    private PurchaseMoney getPurchaseMoneyFromUser() {
        try {
            int amount = inputView.readPurchaseMoneyAmount();
            return new PurchaseMoney(amount);
        } catch (IllegalArgumentException e) {
            return getPurchaseMoneyFromUser();
        }
    }

    private List<Integer> getWinningNumbersFromUser() {
        try {
            return inputView.readWinningNumbers();
        } catch (IllegalArgumentException e) {
            return getWinningNumbersFromUser();
        }
    }

    private BonusNumber getBonusNumberFromUser(List<Integer> winningNumbers) {
        try {
            int bonusNumber = inputView.readBonusNumber();
            return new BonusNumber(bonusNumber, winningNumbers);
        } catch (IllegalArgumentException e) {
            return getBonusNumberFromUser(winningNumbers);
        }
    }
}
