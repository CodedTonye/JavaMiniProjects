package bike;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BikeTest {

    private Bike myBike;
    @BeforeEach
    public void setUp() {
        myBike = new Bike();
    }

    @Test
    public void bikeIsTurnedOn_bikeIsOnTest() {
        myBike.turnOn();
        assertTrue(myBike.checkBikeState());
    }

    @Test
    public void bikeIsTurnedOffFromOn_BikeIsOffTest() {
        myBike.turnOn();
        assertTrue(myBike.checkBikeState());
        myBike.turnOff();
        assertFalse(myBike.checkBikeState());
    }

    @Test
    public void bikeAtSpeed15InGearOne_acceleratesTo16Test() {
        myBike.turnOn();

        for(int count = 0; count < 15; count++){
            myBike.accelerate();
        }
        myBike.accelerate();

        assertEquals(16, myBike.getAcceleration());
    }

    @Test
    public void bikeIsOnGearTwoSpeed21_accelerationIs23Test() {

        myBike.turnOn();
        for(int count = 0; count <= 21; count++){
            myBike.accelerate();
        }

        assertEquals(23, myBike.getAcceleration());
    }

    @Test
    public void bikeOnGearThreeSpeed31_accelerationIs34Test() {
        for(int count = 0; count <= 21; count++){
            myBike.accelerate();
        }
        for(int count = 0; count < 4; count++) {
            myBike.accelerate();
        }

        myBike.accelerate();
        assertEquals(34, myBike.getAcceleration());

    }

    @Test
    public void bikeOnGearFourSpeed40_accelerationIs44Test() {
        for(int count = 0; count <= 21; count++){
            myBike.accelerate();
        }
        for(int count = 0; count < 4; count++) {
            myBike.accelerate();
        }
        for(int count = 0; count < 5; count++){
            myBike.accelerate();
        }
        assertEquals(47, myBike.getAcceleration());
    }

    @Test
    public void bikeOnGearOneSpeed15_decelerationIs14Test() {
        for(int count = 0; count < 15; count++){
            myBike.accelerate();
        }
        myBike.decelerate();
        assertEquals(14, myBike.getAcceleration());
    }

    @Test
    public void bikeOnGearTwoSpeed23_decelerationIs21Test() {
        for(int count = 0; count < 22; count++){
            myBike.accelerate();
        }
        myBike.decelerate();
        assertEquals(21, myBike.getAcceleration());
    }

    @Test
    public void bikeOnGearThreeSpeed34_accelerationIs31Test() {
        for(int count = 0; count < 21; count++){
            myBike.accelerate();
        }
        for(int count = 0; count < 4; count++){
            myBike.accelerate();

        }

        for(int count = 0; count < 2; count++){
            myBike.accelerate();

        }
//        myBike.accelerate();
//        myBike.decelerate();
        assertEquals(34, myBike.getAcceleration());
    }

    @Test
    public void bikeOnGearFourSpeed51_accelerationIs447Test() {
        for(int count = 0; count <= 21; count++){
            myBike.accelerate();
        }
        for(int count = 0; count < 4; count++) {
            myBike.accelerate();
        }
        for(int count = 0; count < 6; count++){
            myBike.accelerate();
        }

        myBike.decelerate();

        assertEquals(47, myBike.getAcceleration());
    }

    @Test
    public void bikeIsOff_accelerationReturnsZeroTest() {
        for(int count = 0; count < 15; count++){
            myBike.accelerate();
        }
        assertEquals(0, myBike.getAcceleration());
    }



}