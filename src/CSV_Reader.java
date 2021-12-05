import java.io.*;

public class CSV_Reader {

    public static void main(String[] args) {
        String path = "G://sample.csv";
        String line = "";
        int maxLineSize = 0;
        String[] row;
        String[][] matrix;

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));

            while ((line = br.readLine()) != null) {

//                maxLineSize = Math.max(maxLineSize, row.length);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("maxLines "+maxLineSize);

    }
}
