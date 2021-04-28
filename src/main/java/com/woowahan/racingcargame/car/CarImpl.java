package com.woowahan.racingcargame.car;

import com.woowahan.racingcargame.message.ExceptionMessage;

import java.util.Random;

public class CarImpl implements Car {
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private static final int RANDOM_NUMBER_RANGE = 9; // 0 ~ 9
    private static final int BREAK_POINT = 3; // 3 이하는 브레이크(멈춤)
    private final String name;
    private int position;

    public CarImpl(String name) {
        validationNameLength(name);
        this.name = name;
    }

    private void validationNameLength(String name) {
        if (isValidLength(name)) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_LENGTH);
        }
    }

    private boolean isValidLength(String name) {
        return MIN_NAME_LENGTH > name.length() || name.length() > MAX_NAME_LENGTH;
    }

    private int createRandomNumber() {
        return new Random().nextInt(RANDOM_NUMBER_RANGE);
    }

    @Override
    public void putPedal() {
        int randomNumber = createRandomNumber();

        pushPedal(randomNumber);
    }

    private void pushPedal(int randomNumber) {
        if(isForward(randomNumber)) {
            accelerate();
        }
    }

    private boolean isForward(int randomNumber) {
        return randomNumber > BREAK_POINT;
    }

    private void accelerate() {
        position++;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPosition() {
        return position;
    }
}

