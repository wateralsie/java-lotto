package lotto.domain;

public enum WinningRank {
    FIFTH(3, 5_000, "3개 일치 (5,000원) - %d개\n"),
    FOURTH(4, 50_000, "4개 일치 (50,000원) - %d개\n"),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원) - %d개\n"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"),
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - %d개\n");

    private final int numbersMatchCount;
    private final int prizeMoney;
    private final String resultMessage;

    WinningRank(int numbersMatchCount, int prizeMoney, String resultMessage) {
        this.numbersMatchCount = numbersMatchCount;
        this.prizeMoney = prizeMoney;
        this.resultMessage = resultMessage;
    }

    public int getNumbersMatchCount() {
        return numbersMatchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getResultMessage() {
        return resultMessage;
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
