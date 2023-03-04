package B_Object_Orientation;

public class BirthAndDeathOfObjects {

    public static void main(String[] args) {
        /*Student st = new Student();
        st.init("Hossein Alizadeh", 45205068);
        System.out.println(st.getName());
        System.out.println(st.getId());*/

        Country country = new Country();
    }
}

class Country {
    private String name;
    private int population;

    public Country() {
        name = "Iran";
    }

    public Country(int number) {
        this();
        population = number;
    }

    public Country(String n, int number) {
        this(number);
        name = n;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize called....");
    }

    {
        System.out.println("one country created:");
    }
}

class Car {

    private Student student;
    private String[] tyres;
    public Car() {
        student = new Student();
        tyres = new String[4];
        for (int i = 0; i < tyres.length; i++) {
            tyres[i] = new String();
        }
    }


}

