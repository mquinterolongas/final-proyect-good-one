import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MarcoDeDatos {

    public ArrayList leerCSV(String direcciónCSV) {

        ArrayList<ArrayList<String>> a = new ArrayList<ArrayList<String>>();
        Path dirección = Paths.get(direcciónCSV);
        //Try-catch generado automaticamente por el IDE para prevenir errores
        try {
            BufferedReader reader = Files.newBufferedReader(dirección);
            String fileLine;
            while ((fileLine = reader.readLine()) != null) {
                String[] infoInLine = fileLine.replace(", ", "-").split(",", -1);
                ArrayList<String> infoArray = new ArrayList<String>();
                for (String info : infoInLine) {
                    infoArray.add(info.replaceAll("\"", ""));
                }
                a.add(infoArray);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        a.remove(0);
        return (a);
    }
}