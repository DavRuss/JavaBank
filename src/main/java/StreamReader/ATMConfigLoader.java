package StreamReader;// Ejemplo de Checked Exception
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ATMConfigLoader {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("config.txt"));
            String line = reader.readLine();
            System.out.println("Configuración: " + line);
            reader.close();
        } catch (IOException e) {
            System.out.println("Error de I/O: " + e.getMessage());
        }
    }
}

