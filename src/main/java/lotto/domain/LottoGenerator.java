package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    private final int lottoCount;

    public LottoGenerator(PurchaseMoney money) {
        this.lottoCount = money.getAmount() / 1000;
        generateLottos(lottoCount);
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public List<Lotto> generateLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = generateLottoNumbers();
            Collections.sort(numbers);
            lottos.add(new Lotto(generateLottoNumbers()));
        }
        return lottos;
    }

    public List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
