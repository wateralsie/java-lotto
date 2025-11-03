package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class ResultFormatter {
    public static String formatLottoInfo(List<Lotto> lottos) {
        return lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }

    public static String formatWinningStatistics(LottoSessionResult result, double profitRate) {
        StringBuilder winningStatistics = new StringBuilder();
        for (WinningRank rank : WinningRank.values()) {
            String rankResult = String.format(rank.getResultMessage(), result.getCountOfRank(rank));
            winningStatistics.append(rankResult);
        }
        winningStatistics.append(String.format("총 수익률은 %.1f%%입니다.", profitRate));
        return winningStatistics.toString();
    }
}
