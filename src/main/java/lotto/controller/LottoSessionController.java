package lotto.controller;

import java.util.List;
import lotto.domain.LottoSession;
import lotto.domain.PurchaseMoney;
import lotto.view.InputView;

public class LottoSessionController {
    private final InputView inputView;

    public LottoSessionController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        int amount = getPurchaseMoneyAmountFromUser();
        List<Integer> winningNumbers = getWinningNumbersFromUser();
        int bonusNumber = getBonusNumberFromUser();

        LottoSession lottoSession = new LottoSession(amount, winningNumbers, bonusNumber);
    }

    private int getPurchaseMoneyAmountFromUser() {
        try {
            return inputView.readPurchaseMoneyAmount();
        } catch (IllegalArgumentException e) {
            return getPurchaseMoneyAmountFromUser();
        }
    }

    private List<Integer> getWinningNumbersFromUser() {
        try {
            return inputView.readWinningNumbers();
        } catch (IllegalArgumentException e) {
            return getWinningNumbersFromUser();
        }
    }

    private int getBonusNumberFromUser() {
        try {
            return inputView.readBonusNumber();
        } catch (IllegalArgumentException e) {
            return getBonusNumberFromUser();
        }
    }
}
