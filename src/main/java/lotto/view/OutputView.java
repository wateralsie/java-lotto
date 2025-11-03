package lotto.view;

import lotto.constants.LottoMessage;

public class OutputView {
    public void printLottoInfo(int count, String info) {
        printEnter();
        System.out.printf(LottoMessage.LOTTO_COUNT, count);
        System.out.println(info);
        printEnter();
    }

    public void printWinningStatistics(String result) {
        printEnter();
        System.out.println(LottoMessage.WINNING_STATISTICS_TITLE);
        System.out.println(result);
    }

    public void printErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    public void printEnter() {
        System.out.println();
    }
}
