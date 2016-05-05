package madvirus.spring.chap04.homecontrol;

public class InfraredRaySensor {

    private String name;
    private boolean objectFounded;

    public InfraredRaySensor(String name) {
        this.name = name;
    }

    public boolean isObjectFounded() {
        return objectFounded;
    }

    public String getName() {
        return name;
    }

    public void foundObject() {
        objectFounded = true;
    }

    @Override
    public String toString() {
        return "InfraredRaySensor [name=" + name + ", objectFounded="
                + objectFounded + "]";
    }

}
