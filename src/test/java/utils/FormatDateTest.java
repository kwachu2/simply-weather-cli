package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FormatDateTest {


    @Test
    void unixToLocalDateAndTimeString() {

        //given
        long timestamp = 1586880139;
        String expectedDate = "2020.04.14 18.02.19";

        //when
        String actualDate = FormatDate.unixToLocalDateAndTimeString(timestamp);

        //then
        assertEquals(expectedDate, actualDate);
    }

    @Test
    void unixToLocalTimeString() {

        //given
        long timestamp = 1586880139;
        String expectedTime = "18:02:19";

        //when
        String actualTime = FormatDate.unixToLocalTimeString(timestamp);

        //then
        assertEquals(expectedTime, actualTime);
    }
}