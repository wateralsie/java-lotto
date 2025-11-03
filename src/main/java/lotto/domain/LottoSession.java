package lotto.domain;

import java.util.List;

public class LottoSession {
    private final PurchaseMoney purchaseMoney;
    private final LottoChecker lottoChecker;
    private final BonusNumber bonusNumber;

    public LottoSession(int amount, List<Integer> winningNumbers, int bonusNumber) {
        this.purchaseMoney = new PurchaseMoney(amount);
        this.lottoChecker = new LottoChecker(winningNumbers);
        this.bonusNumber = new BonusNumber(bonusNumber);
    }
}
