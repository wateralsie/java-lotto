package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class ResultFormatter {
    public static String formatLottoInfo(List<Lotto> lottos) {
        return lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }
}
