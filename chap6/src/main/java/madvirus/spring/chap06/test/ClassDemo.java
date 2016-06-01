package madvirus.spring.chap06.test;

public class ClassDemo {

    /*
    public boolean isAssignableFrom(Class<?> cls)
    isAssignFrom 메서드는 cls type이 this class에 assign가능한지 판단하는 메서드임
     */
    public static void main(String[] args) {

        try {
            ClassDemo clazzDemo = new ClassDemo();
            Class clsDemo = clazzDemo.getClass();

            // class object associated with BaseClass
            Class baseClass = BaseClass.class;

            // checks whether BaseClass is assignable from ClassDemo
            boolean retval = baseClass.isAssignableFrom(clsDemo);
            System.out.println("baseClass isAssignableFrom clsDemo : Return Value = " + retval);

            // checks whether ClassDemo is assignable from BaseClass
            retval = clsDemo.isAssignableFrom(baseClass);
            System.out.println("clsDemo isAssignableFrom baseClass Return Value  = " + retval);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}

// base class
class BaseClass extends ClassDemo {

    public BaseClass() {
        // no argument constructor
    }
}