package com.woowahan.racingcargame;

import com.woowahan.racingcargame.manager.GameManager;

public class Player {
    public static void main(String[] args) {
        AppConfig config = new AppConfig();
        GameManager gameManager = config.gameManager();
        gameManager.play();
    }
}
