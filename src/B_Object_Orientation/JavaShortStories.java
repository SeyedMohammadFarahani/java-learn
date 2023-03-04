package B_Object_Orientation;

public class JavaShortStories {

    /* TODO Primitive Wrapper Classes */
    Double Dob = new Double(12.2);
    double d = Dob.doubleValue();
    int maxInt = Integer.MIN_VALUE;

    // syntax error
    //  Long l = 2;

    //TODO constant
    final int i = 3;

    // TODO enum
    enum Color {
        BLACK, BLUE, GREEN, RED
    }

    Color color = Color.BLACK;


    public static void main(String[] args) {
        //print("1", "2", "3", "4", "5");

        Circle circle = new Circle(5, "circle");
        //System.out.println(circle.toString());

        /*String s = new String("Ali");
        String t = new String("Ali");
        if (s.equals(t))
            System.out.println("s equals t");*/

        Circle circle2 = new Circle(5, "circle");

        if (circle.equals(circle2)) {
            System.out.println(circle.toString() + " is equals with " + circle2.toString());
        }

    }

    /* TODO varargs*/
    static void print(String... params) {
        for (String p : params) {
            System.out.println(p);
        }
    }

    /* TODO Method Overloading */
    void overLoad() {
    }

    void overLoad(String s) {
    }

}

/*TODO toString*/
class Circle {
    private double radius;
    private final String name;

    public Circle(double radius, String name) {
        this.radius = radius;
        this.name = name;
    }

    public String toString() {
        return "Circle [radius=" + radius + "]";
    }

    public boolean equals(Circle circle) {
        return this.radius == circle.radius;
    }
}
