package com.woowahan.racingcargame;

import com.woowahan.racingcargame.Referee.Referee;
import com.woowahan.racingcargame.Referee.RefereeImpl;
import com.woowahan.racingcargame.manager.GameManager;
import com.woowahan.racingcargame.manager.IoManager;

public class AppConfig {
    public IoManager ioManager() {
        return new IoManager();
    }

    public Referee referee() {
        return new RefereeImpl();
    }

    public GameManager gameManager() {
        return new GameManager(ioManager(), referee());
    }
}
