package B_Object_Orientation;

public class ObjectOrientedProgramming {

    public static void main(String[] args) {

        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(2);
        rectangle.setLength(7);

        System.out.println(rectangle.calculatePerimeter());
        System.out.println(rectangle.calculateArea());

    }

}

class Rectangle {
    private int width, length;

    /*public Rectangle(int width, int length) {
        this.width = width;
        this.length = length;
    }*/

    public void setWidth(int width) {
        this.width = width;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int calculateArea() {
        return width * length;
    }

    public int calculatePerimeter() {
        return (width + length) * 2;
    }

}
