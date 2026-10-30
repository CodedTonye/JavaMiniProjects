package airConditioner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AirConditionerTest {

    private AirConditioner myAirConditioner;
    @BeforeEach
     void setUp() {
        myAirConditioner = new AirConditioner();
    }
    @Test
    public void airConditionerTurnOn_checkStateIsTrueTest() {

        assertFalse(myAirConditioner.checkState());

        myAirConditioner.turnOn();
        assertTrue(myAirConditioner.checkState());
    }

    @Test
    public void airConditionerTurnOff_checkStateTest() {
        myAirConditioner.turnOn();
        assertTrue(myAirConditioner.checkState());

        myAirConditioner.turnOff();
        assertFalse((myAirConditioner.checkState()));
    }

    @Test
    public void airConditionerTemperatureIsIncreased_temperatureIsIncreasedTest() {
        myAirConditioner.turnOn();
        myAirConditioner.increaseTemperature();
        assertEquals(1, myAirConditioner.getTemperature());

    }

    @Test
    public void airConditionerTemperatureIncreasedThrice_temperatureIsIncreasedThreeTimesTest() {
        myAirConditioner.turnOn();
        myAirConditioner.increaseTemperature();
        myAirConditioner.increaseTemperature();
        myAirConditioner.increaseTemperature();
        assertEquals(3, myAirConditioner.getTemperature());
    }

    @Test
    public void airConditionerTemperatureIsIDecreased_temperatureIsDecreasedTest() {
        myAirConditioner.turnOn();
        int iterator = 1;
        while(iterator <= 36) {
            myAirConditioner.increaseTemperature();
            iterator++;
        }
        assertEquals(30, myAirConditioner.getTemperature());

        for(int count = 0; count < 3; count++){
            myAirConditioner.decreaseTemperature();
        }
        assertEquals(27, myAirConditioner.getTemperature());

    }

    @Test
    public void airConditionerTemperatureIsIncreasedBeyond30_temperatureIsStill30Test() {
        myAirConditioner.turnOn();
        int iterator = 1;
        while(iterator <= 30) {
            myAirConditioner.increaseTemperature();
            iterator++;
        }
        assertEquals(30, myAirConditioner.getTemperature());

        myAirConditioner.increaseTemperature();
        myAirConditioner.increaseTemperature();
        assertEquals(30, myAirConditioner.getTemperature());
    }

    @Test
    public void airConditionerIsIncreasedBelow16_temperatureIsStill16Test() {
        myAirConditioner.turnOn();
        int iterator = 1;
        while(iterator < 17) {
            myAirConditioner.increaseTemperature();
            iterator++;
        }
        assertEquals(16, myAirConditioner.getTemperature());

        myAirConditioner.decreaseTemperature();
        myAirConditioner.decreaseTemperature();
        myAirConditioner.decreaseTemperature();
        assertEquals(16, myAirConditioner.getTemperature());
    }





}
