package com.woowahan.racingcargame.manager;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TurnCountTest {
    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    @DisplayName("움직일 횟수는 양수가 되야한다.")
    void turnCount_must_be_positive(int count) {
        //then
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> {
            //given
            //when
            TurnCount turnCount = new TurnCount(count);
        });
    }
}