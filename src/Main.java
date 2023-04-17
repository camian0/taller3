import model.Tienda;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        try (Scanner scanner = new Scanner(System.in)) {
            Tienda tienda = new Tienda();
            tienda.leer();

            System.out.println("Ingresa la edad de la persona: ");
            String recibido = scanner.nextLine();
            recibido = recibido.trim();
            Short edad = Short.parseShort(recibido);
            recibido = "";
            System.out.println("Precio maximo del regalo: ");
            recibido = scanner.nextLine();
            recibido = recibido.trim();
            Float precio = Float.parseFloat(recibido);
            String mensaje = tienda.buscarProductos(edad, precio);
            System.out.println(mensaje);
        } catch (IOException e) {
            System.out.println("Verifica la ruta seleccionada.  \n" + e.getMessage() + "\n");
        } catch (ParseException e) {
            System.out.println("Objeto no soportado para para agregar. \n" + e.getMessage() + "\n");
        }
    }
}