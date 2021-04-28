package com.woowahan.racingcargame.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarImplTest {

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

}