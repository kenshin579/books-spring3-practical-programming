package madvirus.spring.chap04.homecontrol;

import org.springframework.beans.factory.annotation.Required;

public class Camera {

    private int number;

    public Camera() {
    }

    /*
    필수 프로퍼티를 지정하려면 아래 오노테이션을 붙여준다.
    todo: 이 의미는 꼭 필요하다는 건가?
    스프링에서 무엇을 해준다는 것인가?
     */
    @Required
    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Camera [number=" + number + "]";
    }

}
