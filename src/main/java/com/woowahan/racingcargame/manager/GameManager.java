package com.woowahan.racingcargame.manager;

import com.woowahan.racingcargame.Referee.Referee;
import com.woowahan.racingcargame.car.Car;
import com.woowahan.racingcargame.car.CarImpl;
import com.woowahan.racingcargame.car.CarList;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private final IoManager ioManager;
    private final Referee referee;
    private CarList carList;
    TurnCount turnCount;

    public GameManager(IoManager ioManager, Referee referee) {
        this.ioManager = ioManager;
        this.referee = referee;
    }

    public void play() {
        createCarList(ioManager.requireCarNames());
        createTurnCount(ioManager.requireTurnCount());
        for(int i=0; i<turnCount.getTurnCount(); i++) {
            carList.race();
            outputResult();
        }

        ioManager.outputResultOfGame(referee.getWinners(carList));
    }

    private void outputResult() {
        ioManager.outputResultMessage();
        for (int i = 0; i < carList.size(); i++) {
            Car car = carList.getCar(i);
            ioManager.outputResultOfTurn(car.getName(), car.getPosition());
        }
        ioManager.outputEnter();
    }

    private void createTurnCount(int requireTurnCount) {
        turnCount = new TurnCount(requireTurnCount);
    }

    private void createCarList(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carNames.length; i++) {
            Car car = new CarImpl(carNames[i]);
            cars.add(car);
        }

        carList = new CarList(cars);
    }

}
