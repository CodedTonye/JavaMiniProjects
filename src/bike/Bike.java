package bike;

public class Bike {
    private boolean isOn;
    private int speed;
    public void turnOn() {
        isOn = true;
    }

    public boolean checkBikeState() {
        return isOn;
    }

    public void turnOff() {
        isOn = false;
    }

    public void accelerate() {
        if(speed >= 0 && speed <= 20) {
            speed += 1;
        }
        else if(speed >= 21 && speed <= 30){
            speed += 2;
        }
        else if(speed >= 31 && speed <= 40) {
            speed += 3;
        }
        else {
            speed += 4;
        }

    }

    public int getAcceleration() {
        return speed;
    }


    public void decelerate() {

        if(speed >= 0 && speed <= 20) {
            speed -= 1;
        }
        else if(speed >= 21 && speed <= 30){
            speed -= 2;
        }
        else if(speed >= 31 && speed <= 40) {
            speed -= 3;
        }
        else {
            speed -= 4;
        }
    }
}
