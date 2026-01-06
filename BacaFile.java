package dika;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
public class BacaFile {
    private static final String FILE_NAME = "riwayat.txt";

    public static void simpanRiwayat(String operasi, double hasil) {
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) {
                file.createNewFile();
            }

            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
            bw.write(operasi + " = " + hasil);
            bw.newLine();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static String bacaRiwayat() {
        StringBuilder sb = new StringBuilder();
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) {
                return "Belum ada riwayat perhitungan.";
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}