package com.woowahan.racingcargame.manager;

import com.woowahan.racingcargame.message.ExceptionMessage;

public class TurnCount {
    private final int turnCount;

    public TurnCount(int turnCount) {
        validate(turnCount);
        this.turnCount = turnCount;
    }

    private void validate(int turnCount) {
        if (turnCount < 0) {
            throw new IllegalArgumentException(ExceptionMessage.TURN_COUNT);
        }
    }

    public int getTurnCount() {
        return turnCount;
    }
}
