package Design_Pattern.Singleton;

import org.junit.Test;

import static org.junit.Assert.*;

public class DBConnectionTest {

    @Test
    public void getInstance() {
        DBConnection instance = DBConnection.getInstance();
    }

    @Test
    public void performanceTest() {

        long time = System.currentTimeMillis();
        System.out.println(DBConnection.getInstance());
        System.out.println(System.currentTimeMillis() - time);

        time = System.currentTimeMillis();
        System.out.println(DBConnection.getInstance());
        System.out.println(System.currentTimeMillis() - time);


    }
}