package F_Other_Files;


import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Reflection {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException, ClassNotFoundException {

        /* Todo getClass() */
        List arrayList = new ArrayList<String>();
        String simpleName = arrayList.getClass().getSimpleName();
        String name = arrayList.getClass().getName();

        /* Todo ways to reach Object Class */
        // 1) .class:     Class c = Person.class;
        // 2) forName():  Class c = Class.forName("ir.javacup.Person");
        // 3) getClass(): Object o = new Person();
        //                Class c = o.getClass();

        /* Todo instanceof vs. getClass() */
        // instanceof = .class.isInstance
        // if(c instanceof Person)...
        // if(Person.class.isInstance(c))...

        Circle circle = new Circle();
        Class circleClass = circle.getClass();
        Class circleClass2 = Class.forName("F_Other_Files.Circle");
        Class circleClass3 = Circle.class;
        /* Todo Field Class */
        Field[] fields = Circle.class.getFields();
        Field field = fields[0];
        field = Circle.class.getField("radius");
        field.set(circle, 2.0);
        /* Todo Method Class */
        Method setter = circleClass.getMethod("setRadius", Double.class);
        setter.invoke(circle, new Double(2.5));
        Method getter = circleClass.getMethod("getRadius");
        System.out.println(getter.invoke(circle));
        /* Todo Constructor Class */
        Constructor cons = circleClass.getConstructor(Double.class);
        Object o = cons.newInstance(new Double(1.0));
        Circle c = (Circle) o;
        System.out.println(c.area());
        Circle c2 = (Circle) circleClass.newInstance();
        /* Todo Annotation Class */
        Annotation[] annotations = Circle.class.getAnnotations();
        for (Annotation annotation : annotations)
            System.out.println(annotation.annotationType());
        annotations = Circle.class.getMethod("f").getAnnotations();
        for (Annotation a : annotations)
            System.out.println(a.annotationType().getSimpleName());


        /* Todo getMethod Vs. getDeclaredMethod*/
        /**
         * getMethods, getMethod, getField, getFields
         * اعضای به ارث‌رسیده را هم برمی‌گردانند
         * فقط اعضای پابلیک کلاس را برمی‌گردانند
         * getDeclaredMethods, getDeclaredMethod, getDeclaredField, getDeclaredFields
         * فقط اعضایی که در همان کلاس تعریف شده‌اند را برمی‌گردانند
         * اعضای غیرعمومی کلاس را هم برمی‌گردانند
         * */

        // To use static methods and fields, it is not necessary to mention the object
        X x = new X();
        X.class.getMethod("f").invoke(x);
        X.class.getMethod("g").invoke(null);
        X.class.getField("a").set(x, 1);
        X.class.getField("b").set(null, 2);

        // It is also possible to call .class on primitive data types
        Method method = String.class.getMethod("substring", int.class);

        /* Todo Change access level */
        MyClass instance = new MyClass();
        Method myMethod =
                MyClass.class.getDeclaredMethod("privateMethod");
        myMethod.setAccessible(true);
        myMethod.invoke(instance);


    }
}


class Circle {
    public Double radius;

    public Circle() {
    }

    public Circle(Double radius) {
        this.radius = radius;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    public double perimeter() {
        return Math.PI * 2 * radius;
    }
}

class X {
    public void f() {
    }

    public static void g() {
    }

    public int a;
    public static int b;
}

class MyClass {
    private void privateMethod() {
        System.out.println("");
    }
}


