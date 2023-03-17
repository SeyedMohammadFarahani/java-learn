package D_Softwae_Quality;

public class UnitTesting {
}

class MyMath {
    private static final MyMath instance = new MyMath();

    public static MyMath getInstance() {
        return instance;
    }

    public int division(int a, int b) {
        if (b == 0) throw new ArithmeticException("Division by Zero");
        return a / b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

}