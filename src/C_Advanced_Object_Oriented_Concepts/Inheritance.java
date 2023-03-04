package C_Advanced_Object_Oriented_Concepts;

public class Inheritance {
}


class Shape {
    int color;
    int positionX, positionY;
}

class Rectangle extends Shape {
    private int width, length;

    public double getArea() {
        return width * length;
    }
}

class Person {
    private String name;
    private String nationalID;

    public Person(String name, String nationalID) {
        this.name = name;
        this.nationalID = nationalID;
    }
}

class Student extends Person {
    private long studentID;

    public Student(String name, String id, long studentID) {
        super(name, id);
        this.studentID = studentID;
    }
}
