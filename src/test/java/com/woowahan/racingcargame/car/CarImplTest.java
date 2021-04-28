package com.woowahan.racingcargame.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarImplTest {
    private Car car;

    @BeforeEach
    void init() {
        car = new CarImpl("test");
    }

    @ParameterizedTest
    @CsvSource(value = {"1, 1", "55555, 5"})
    @DisplayName("자동차 이름 길이 1~5 검증")
    void validate_right_length_car_name(String carName, int expected) {
        //given
        //when
        Car car = new CarImpl(carName);

        //then
        assertThat(car.getName().length()).isSameAs(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "666666"})
    @DisplayName("자동차 이름 길이 0 또는 6이상 예외 검증")
    void validate_wrong_length_car_name(String carName) {
        //then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            //given
            //when
            Car car = new CarImpl(carName);
        });
    }

    @Test
    @DisplayName("랜덤 숫자 범위 검증")
    void validate_random_number_range() {
        try {
            //given
            Method method = car.getClass().getDeclaredMethod("createRandomNumber");
            method.setAccessible(true);

            //when
            int randomNumber = (int) method.invoke(car);

            //then
            assertThat(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}).contains(randomNumber);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @ParameterizedTest
    @CsvSource(value = {"0,0", "3,0", "4,1", "9,1"})
    @DisplayName("랜덤 숫자에 따른 자동차 위치 검증")
    void pushGasPedal(int randomNumber, int expected) {
        try {
            //given
            Method method = car.getClass().getDeclaredMethod("pushPedal", int.class);
            method.setAccessible(true);

            //when
            method.invoke(car, randomNumber);

            //then
            assertThat(car.getPosition()).isSameAs(expected);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}