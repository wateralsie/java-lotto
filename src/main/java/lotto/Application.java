package lotto;

import lotto.controller.LottoSessionController;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoSessionController lottoSessionController = new LottoSessionController(inputView, outputView);
        lottoSessionController.run();
    }
}
