package C_Advanced_Object_Oriented_Concepts;

public class Interface {

    //Inner Class
    interface Protocol {
        void behavior();
    }

    public static void main(String[] args) {

        /* TODO Anonymous Inner Class*/
        Protocol inner = new Protocol() {
            public void behavior() {
                int value = 5;
            }
        };
        inner.behavior();


    }
}

interface InterfaceShape {
    double getArea();

    double getPerimeter();
}

class Rect implements InterfaceShape {
    public double getArea() {
        return 0;
    }

    public double getPerimeter() {
        return 0;
    }
}

class OuterClass {
    private int value;

    public void f() {
    }


    class Inner {
        public void f() {
        }

    }
}




