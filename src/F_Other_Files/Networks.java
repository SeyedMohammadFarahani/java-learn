package F_Other_Files;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.Scanner;

public class Networks {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("google.com", 80);
            OutputStream out = socket.getOutputStream();
            InputStream inp = socket.getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        /* Todo Write in Socket */
        Socket socket = null;
        try {
            socket = new Socket("192.168.10.21", 8888);
            OutputStream outputStream = socket.getOutputStream();
            Formatter formatter = new Formatter(outputStream);
            formatter.format("Salam!\n");
            formatter.flush();
            socket.close();
            System.out.println("finished");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        /* Todo Read from Socket */

        InputStream inputStream = null;
        try {
            inputStream = socket.getInputStream();
            Scanner scanner = new Scanner(inputStream);
            while (true) {
                String next = scanner.next();
                if (next.contains("exit"))
                    break;
                System.out.println("Server : " + next);
                System.out.flush();
            }
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        /* Todo ServerSide Class */
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8888);
            Socket socket2 = serverSocket.accept();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        /* Todo Serializable */
        FileOutputStream f1 = null;
        try {
            f1 = new FileOutputStream("user.txt");
            ObjectOutputStream out = new ObjectOutputStream(f1);
            Student st = new Student("Ali", new double[]{17.0, 18.0});
            System.out.println(st.name);
            System.out.println(st.average);
            out.writeObject(st);
            out.close();

            FileInputStream f2 = new FileInputStream("user.txt");
            ObjectInputStream in = new ObjectInputStream(f2);
            Student s2 = (Student) in.readObject();
            System.out.println(s2.name);
            System.out.println(s2.average);
            in.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        /* Todo Decorator Design Pattern */
        FileOutputStream file = null;
        try {
            file = new FileOutputStream("c:/f.txt");
            BufferedOutputStream buffer = new BufferedOutputStream(file);
            PrintStream print = new PrintStream(buffer);
            print.println("salam");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        /**
         * Paths class and Path Interface
         */
        Path path = Paths.get("f.txt");
        Path parent = path.getParent();
        File f = path.toFile();


    }
}

class Server {

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8765);
             Socket socket = server.accept();
             Scanner in = new Scanner(socket.getInputStream());
             Formatter out = new Formatter(socket.getOutputStream());) {
            String next;
            do {
                next = in.next();
                String translate = translate(next);
                out.format(translate + "\n");
                out.flush();
            } while (!next.equals("exit"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String translate(String string) {
        return string;
    }
}

class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8765);
             Scanner socketIn = new Scanner(socket.getInputStream());
             Formatter socketOut =
                     new Formatter(socket.getOutputStream());
             Scanner systemIn = new Scanner(System.in);) {
            String next;
            do {
                next = systemIn.next();
                socketOut.format(next + "\n");
                socketOut.flush();
                String received = socketIn.next();
                System.out.println("received: " + received);
            } while (!next.equals("exit"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

class Student implements Serializable {
    String name;
    double[] grades;
    transient double average;

    public Student(String name, double[] grades) {
        this.name = name;
        this.grades = grades;
        double tempAVG = 0;
        for (Double grade : grades) {
            tempAVG += grade;
        }
        this.average = tempAVG / grades.length;
    }


}


