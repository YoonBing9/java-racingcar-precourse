package com.woowahan.racingcargame.Referee;

import com.woowahan.racingcargame.car.Car;
import com.woowahan.racingcargame.car.CarList;

import java.util.ArrayList;
import java.util.List;

public class RefereeImpl implements Referee {
    @Override
    public String[] getWinners(CarList carList) {
        int maxPosition = Integer.MIN_VALUE;
        List<String> winners = new ArrayList<>();

        judge(carList, maxPosition, winners);

        return winners.toArray(new String[winners.size()]);
    }

    private void judge(CarList carList, int maxPosition, List<String> winners) {
        for (int i = 0; i < carList.size(); i++) {
            Car car = carList.getCar(i);
            maxPosition = getMaxPosition(maxPosition, winners, car);
        }
    }

    private int getMaxPosition(int maxPosition, List<String> winners, Car car) {
        if (car.getPosition() > maxPosition) {
            maxPosition = car.getPosition();
            winners.clear();
            winners.add(car.getName());
        } else if (car.getPosition() == maxPosition) {
            winners.add(car.getName());
        }

        return maxPosition;
    }
}
