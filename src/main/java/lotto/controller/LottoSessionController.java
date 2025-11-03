package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoSession;
import lotto.domain.PurchaseMoney;
import lotto.domain.ResultFormatter;
import lotto.domain.WinningLottoNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoSessionController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoSessionController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        PurchaseMoney money = getPurchaseMoneyFromUser();

        LottoGenerator lottoGenerator = new LottoGenerator(money);
        List<Lotto> lottos = lottoGenerator.generateLottos();
        outputView.printLottoInfo(lottoGenerator.getLottoCount(), ResultFormatter.formatLottoInfo(lottos));

        List<Integer> winningNumbers = getWinningNumbersFromUser();
        int bonusNumber = getBonusNumberFromUser();
        WinningLottoNumbers winningLottoNumbers = createWinningLottoNumbers(winningNumbers, bonusNumber);

        LottoSession lottoSession = new LottoSession(money, winningLottoNumbers, lottos);
        outputView.printWinningStatistics(lottoSession.getResult());
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

    private int getBonusNumberFromUser() {
        return inputView.readBonusNumber();
    }

    private WinningLottoNumbers createWinningLottoNumbers(List<Integer> winningNumbers, int bonusNumber) {
        try {
            return new WinningLottoNumbers(winningNumbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            return createWinningLottoNumbers(winningNumbers, getBonusNumberFromUser());
        }
    }

}
