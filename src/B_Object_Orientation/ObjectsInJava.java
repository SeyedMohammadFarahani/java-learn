package B_Object_Orientation;

public class ObjectsInJava {

    public static void main(String[] args) {
        Student[] students;
        students = new Student[10];

        /*students[0] = new Student();
        students[0].setName("Ali");
        students[1] = new Student();
        students[1].setName("Mohammad");*/

        /*System.out.println(students[0].getName());
        System.out.println(students[1].getName());*/

        /* TODO Reference to Null*/
        /*for (int i = 0; i < students.length; i++) {
            students[i].setId(i+10000);
        }*/

        /*System.out.println(students[5].getId());*/


        /* TODO swap names*/
        /*Student a = new Student();
        Student b = new Student();
        a.setName("Ali");
        b.setName("Taghi");
        Student.swapNames(a, b);
        System.out.println(a.getName());
        System.out.println(b.getName());*/

        /* TODO change JVM */
        // Xms : init volume for Heap
        // Xmx : max volume for Heap
        // Xss : max volume for Stack



    }
}

class Student {
    private String name;
    private long id;

    public Student() {
    }

    /* Constructor */
    public Student(String name, long id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public static void swapNames(Student s1, Student s2) {
        String tmp = s1.name;
        s1.name = s2.name;
        s2.name = tmp;
    }

    public void init(String name, long id) {
        setName(name);
        setId(id);
    }
}
