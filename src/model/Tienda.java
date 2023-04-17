package model;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;

public class Tienda {

    final String RUTAPROVEEDOR = "proveedores.json";
    final String RUTAPRODUCTO = "productos.json";

    private ArrayList<Producto> productos;

    public void leer() throws IOException, ParseException {
        LeerArchivo leer = new LeerArchivo();
        leer.leerJSON(RUTAPROVEEDOR, true);
        leer.leerJSON(RUTAPRODUCTO, false);
        productos = leer.obtenerProductos();
    }

    public String buscarProductos(Short edad, Float precioMaximo) {
        ArrayList<Producto> cumplen = new ArrayList<>();
        if (cumplen.size() == 0) {
            return "No hay productos que cumplan con los criterios de búsqueda. Intenta con otro";
        }
        if (edad != null || precioMaximo != null) {
            for (Producto producto : productos) {
                Float total = producto.getPrecioBase() + producto.getProveedor().getPrecioEnvio();
                if (producto.getEdad().equals(edad) && total <= precioMaximo) {
                    cumplen.add(producto);
                }
            }
            return procesarCumplen(cumplen);
        }
        return "Edad o precio máximo no enviados, verifica la información.";
    }

    public String procesarCumplen(ArrayList<Producto> cumplen) {
        String mensaje = "";
        for (Producto producto : cumplen) {
            float precioMax = 0;
            precioMax = producto.getPrecioBase() + producto.getProveedor().getPrecioEnvio();
            mensaje += "Nombre: " + producto.getNombre() + "\n Precio base: " + producto.getPrecioBase()
                    + "\n Precio envío: " + producto.getProveedor().getPrecioEnvio()
                    + "\n Precio total: " + precioMax + "\n \n";
        }
        return mensaje;
    }
}
