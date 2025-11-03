package lotto.domain;

import java.util.List;
import java.util.Optional;

public class LottoSession {
    private final PurchaseMoney purchaseMoney;
    private final WinningLottoNumbers winningLottoNumbers;
    private final List<Lotto> lottos;

    public LottoSession(PurchaseMoney money, WinningLottoNumbers winningLottoNumbers, List<Lotto> lottos) {
        this.purchaseMoney = money;
        this.winningLottoNumbers = winningLottoNumbers;
        this.lottos = lottos;
    }

    public String getResult() {
        LottoSessionResult result = calculateResult();
        double profitRate = result.calculateProfitRate(purchaseMoney);
        return "";
    }

    public LottoSessionResult calculateResult() {
        LottoSessionResult result = LottoSessionResult.initiallyCreate();
        for (Lotto lotto : lottos) {
            Optional<WinningRank> rank = winningLottoNumbers.compareWith(lotto);
            rank.ifPresent(result::add);
        }
        return result;
    }
}
