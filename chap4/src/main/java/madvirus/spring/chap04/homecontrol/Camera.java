package madvirus.spring.chap04.homecontrol;

import org.springframework.beans.factory.annotation.Required;

public class Camera {

    private int number;

    public Camera() {
    }

    @Required
    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Camera [number=" + number + "]";
    }

}
