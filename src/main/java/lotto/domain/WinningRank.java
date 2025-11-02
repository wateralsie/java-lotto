package lotto.domain;

public enum WinningRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000);

    private final int numbersMatchCount;
    private final int prizeMoney;

    WinningRank(int numbersMatchCount, int prizeMoney) {
        this.numbersMatchCount = numbersMatchCount;
        this.prizeMoney = prizeMoney;
    }

    public int getNumbersMatchCount() {
        return numbersMatchCount;
    }

    public static WinningRank decideBy(int numbersMatchCount, boolean hasBonusNumber) {
        if (numbersMatchCount == FIRST.numbersMatchCount) {
            return WinningRank.FIRST;
        }
        if (numbersMatchCount == SECOND.numbersMatchCount && hasBonusNumber) {
            return WinningRank.SECOND;
        }
        if (numbersMatchCount == THIRD.numbersMatchCount) {
            return WinningRank.THIRD;
        }
        if (numbersMatchCount == FOURTH.numbersMatchCount) {
            return WinningRank.FOURTH;
        }
        return WinningRank.FIFTH;
    }
}
