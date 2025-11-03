package lotto.domain;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoSessionResult {
    private final Map<WinningRank, Integer> result;

    private LottoSessionResult(Map<WinningRank, Integer> result) {
        this.result = result;
    }

    public static LottoSessionResult initiallyCreate() {
        Map<WinningRank, Integer> result = Arrays.stream(WinningRank.values())
                .collect(Collectors.toMap(rank -> rank, rank -> 0));
        return new LottoSessionResult(result);
    }

    public void add(WinningRank rank) {
        result.put(rank, result.get(rank) + 1);
    }

    public int getCountOfRank(WinningRank rank) {
        return result.get(rank);
    }

    public double calculateProfitRate(PurchaseMoney money) {
        long profit = calculateProfit();
        return (double) profit / money.getAmount() * 100;
    }

    private long calculateProfit() {
        long profit = 0;
        for (WinningRank rank : WinningRank.values()) {
            profit += (long) rank.getPrizeMoney() * result.get(rank);
        }
        return profit;
    }
}
