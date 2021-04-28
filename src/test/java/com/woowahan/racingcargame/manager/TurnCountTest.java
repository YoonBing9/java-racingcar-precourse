package com.woowahan.racingcargame.manager;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TurnCountTest {
    @Test
    @DisplayName("움직일 횟수는 음수가 될 수 없다.")
    void turnCount_not_be_negative() {
        //then
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> {
            //given
            //when
            TurnCount turnCount = new TurnCount(-1);
        });
    }
}