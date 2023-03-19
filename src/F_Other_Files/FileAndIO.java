package F_Other_Files;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileAndIO {

    public static void main(String[] args) {

        /**
         * Read and Write
         */
        /* Todo File Reader */
        FileReader inf = null;
        try {
            inf = new FileReader("readme.txt");
            int chCode;
            while (-1 != (chCode = inf.read()))
                System.out.println("Next:" + (char) chCode);
            inf.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        /* Todo File Writer */
        FileWriter writer = null;
        try {
            writer = new FileWriter("writeme.txt");
            writer.write("This is a line. \n");
            writer.write("This is the second line. \n");
            writer.close();

            // append end of file
            FileWriter wr = new FileWriter("text.txt", true);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        /* Todo FileInputStream */
        List<Byte> list = new ArrayList<>();
        FileInputStream info = null;
        try {
            info = new FileInputStream("file");
            int bCode;
            while (-1 != (bCode = info.read()))
                list.add((byte) bCode);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (info != null) {
                try {
                    info.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        /* Todo FileOutputStream */
        int[] numbers = {1234567890, 1234567891, 1234567892};
        //byte[] array = intToByteArray(numbers);//length=12
        FileOutputStream out = null;
        try {
            out = new FileOutputStream("file");
            //out.write(array);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        /**
         * File
         */
        File f = new File("1.txt");
        long length = f.length();
        boolean isdir = f.isDirectory();
        long lastModified = f.lastModified();

        /**
         * File Methods
         * boolean canRead();
         * boolean canWrite();
         * boolean canExecute();
         * long lastModified();
         * boolean exists();
         * boolean isFile();
         * boolean isDirectory();
         * String getName();
         * String getAbsolutePath();
         * String getParent();
         * long length(); //zero for folders
         * String[] list();
         * */

        /**
         * RandomAccessFile
         * */
        RandomAccessFile raf =
                null;
        try {
            raf = new RandomAccessFile("1.txt", "rw");
            //reads a single byte:
            byte ch = raf.readByte();
            //reads a 32-bit integer (binary read)
            int i = raf.readInt();
            //reads text
            String line = raf.readLine();
            //5 bytes from the beginning of the file
            raf.seek(5);
            //write text
            raf.writeBytes("This will complete the Demo");
            //wriet 8-bytes (binary)
            raf.writeDouble(1.2);
            raf.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        /**
         * Scanner
         */
        Scanner s = null;
        try {
            s = new Scanner("1.txt");
            s = new Scanner(new File("1.txt"));
            s = new Scanner(new FileInputStream("1.txt"));
            s = new Scanner(new FileReader("1.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        /* Todo try-with-resources */
        try (FileReader fr = new FileReader("1.txt")) {
            int read = fr.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
