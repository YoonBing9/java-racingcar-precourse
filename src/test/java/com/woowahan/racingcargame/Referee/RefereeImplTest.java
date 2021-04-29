package com.woowahan.racingcargame.Referee;

import com.woowahan.racingcargame.car.Car;
import com.woowahan.racingcargame.car.CarImpl;
import com.woowahan.racingcargame.car.CarList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class RefereeImplTest {

    @ParameterizedTest
    @CsvSource(value = {"0,1,2,1,'C'", "0,2,2,2,'B,C'", "2,2,2,3,'A,B,C'"})
    @DisplayName("자동차 위치에 따른 우승자 판별 검증")
    void getWinners(int car1Position, int car2Position, int car3Position, int expectedLength, String winnerNames) {
        //given
        Referee referee = new RefereeImpl();
        Car car1 = new CarImpl("A", car1Position);
        Car car2 = new CarImpl("B", car2Position);
        Car car3 = new CarImpl("C", car3Position);

        CarList carList = new CarList(Arrays.asList(car1, car2, car3));

        //when
        String[] winners = referee.getWinners(carList);

        //then
        assertThat(winners.length).isSameAs(expectedLength);
        assertThat(winners).containsExactly(winnerNames.split(","));
    }
}