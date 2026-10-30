package airConditioner;

public class AirConditioner {
    private boolean isOn;
    private int temperature;

    public boolean checkState(){
        return isOn;
    }


    public void turnOn() {
        isOn = true;
    }

    public void turnOff() {
        isOn = false;
    }

    public void increaseTemperature() {
        if(temperature < 30)temperature = temperature + 1;
    }

    public int getTemperature() {
        return temperature;
    }

    public void decreaseTemperature() {
        if(temperature > 16)temperature = temperature - 1;
    }
}
