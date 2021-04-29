package com.woowahan.racingcargame.car;

import java.util.List;

public class CarList {
    private List<Car> cars;

    public CarList(List<Car> cars) {
        this.cars = cars;
    }

    public void race() {
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).putPedal();
        }
    }

    public int size() {
        return cars.size();
    }

    public Car getCar(int index) {
        return cars.get(index);
    }
}
