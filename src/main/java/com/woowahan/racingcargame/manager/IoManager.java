package com.woowahan.racingcargame.manager;

import com.woowahan.racingcargame.message.UiMessage;

import java.util.Scanner;

public class IoManager {
    private final Scanner scanner = new Scanner(System.in);

    public String[] requireCarNames() {
        outputRequireCarNames();
        return inputCarNames();
    }

    public int requireTurnCount() {
        outputRequireTurnCount();
        return inputTurnCount();
    }

    public void outputResultOfTurn(String carName, int position) {
        StringBuilder sbPosition = new StringBuilder();
        for (int i = 0; i < position; i++) {
            sbPosition.append("-");
        }

        String output = carName + ":" + sbPosition;

        System.out.println(output);
    }

    public void outputEnter() {
        System.out.println();
    }

    public void outputResultOfGame(String[] winnerNames) {
        StringBuilder sbWinnerNames = new StringBuilder();
        for (int i = 0; i < winnerNames.length; i++) {
            sbWinnerNames.append(winnerNames[i] + ", ");
        }
        sbWinnerNames.delete(sbWinnerNames.length() - 2, sbWinnerNames.length());

        System.out.println(sbWinnerNames + UiMessage.WINNER);
    }

    private String[] inputCarNames() {
        return scanner.nextLine().split(",");
    }

    private int inputTurnCount() {
        return scanner.nextInt();
    }

    private void outputRequireCarNames() {
        System.out.println(UiMessage.REQUIRE_CAR_NAMES);
    }

    private void outputRequireTurnCount() {
        System.out.println(UiMessage.REQUIRE_TURN_COUNT);
    }
}
