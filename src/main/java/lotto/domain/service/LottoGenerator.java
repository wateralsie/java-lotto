package lotto.domain.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.constants.LottoConstant;
import lotto.domain.model.Lotto;
import lotto.domain.model.PurchaseMoney;

public class LottoGenerator {
    private final int lottoCount;

    public LottoGenerator(PurchaseMoney money) {
        this.lottoCount = money.getAmount() / LottoConstant.LOTTO_PRICE;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public List<Lotto> generateLottos() {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = generateLottoNumbers();
            Collections.sort(numbers);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    public List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(LottoConstant.MIN_LOTTO_NUMBER, LottoConstant.MAX_LOTTO_NUMBER, LottoConstant.LOTTO_NUMBERS_COUNT);
    }
}
