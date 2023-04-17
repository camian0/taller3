package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class LeerArchivo {
    private String rutaProveedor;
    private String rutaProducto;

    private ArrayList<Proveedor> proveedores;
    private ArrayList<Producto> productos;


    public LeerArchivo() {
        rutaProducto = "";
        rutaProveedor = "";
        proveedores = new ArrayList<>();
    }

    public LeerArchivo(String unaRutaProveedor, String unaRutaProducto) {
        rutaProveedor = unaRutaProveedor;
        rutaProducto = unaRutaProducto;
        proveedores = new ArrayList<>();
        productos = new ArrayList<>();
    }

    public void setRutaProveedor(String unaRuta) {
        if (unaRuta != null) {
            rutaProveedor = unaRuta;
        }
    }

    public void setRutaProducto(String unaRuta) {
        if (unaRuta != null) {
            rutaProducto = unaRuta;
        }
    }

    /*
        Metodo para leer desde una ruta un archivo json
        recibe como argumento un string con la ruta del archivo
        y una bandera para agregar a proveedor o producto.
        Cada producto o proveedor se envía a un metodo auxiliar para hacer su respectiva agregación
    */
    public void leerJSON(String ruta, Boolean bandera) throws IOException, ParseException {
        File file = new File(ruta);
        FileReader fr = new FileReader(file);
        JSONParser parser = new JSONParser();
        JSONArray objetos = (JSONArray) parser.parse(fr);
        if (bandera) {
            for (int i = 0; i < objetos.size(); i++) {
                JSONObject obj = (JSONObject) objetos.get(i);
                agregarProveedor(obj);
            }
            return;
        }
        for (int i = 0; i < objetos.size(); i++) {
            JSONObject obj = (JSONObject) objetos.get(i);
            agregarProductos(obj);
        }
    }

    /*
        Método apra agregar un proveedor a la lista de proveedores.
        Este, recibe como argumento un objeto jsono bject
    */
    public void agregarProveedor(JSONObject objetoProducto) {
        if (objetoProducto != null) {
            String nombre = (String) objetoProducto.get("nombre");
            Double precio = (Double) objetoProducto.get("precioEnvio");
            Proveedor proveedor = new Proveedor(nombre, precio.floatValue());
            this.proveedores.add(proveedor);
        }
    }

    /*
        Metodo para agregar un producto a la lista de productos.
        Este recibe como argumento un onbjeto de tipo json object.
        Devuelve una lista con los productos obtenidos del json
    */
    public void agregarProductos(JSONObject objetoProducto) {
        if (objetoProducto != null) {
            String nombre = (String) objetoProducto.get("nombre");
            Long edad = (Long) objetoProducto.get("edad");
            Double precioBase = (Double) objetoProducto.get("precio");
            String nombreProveedor = (String) objetoProducto.get("proveedor");
            Proveedor proveedor = buscarProveedor(nombreProveedor);

            Producto producto = new Producto(nombre, edad.shortValue(), precioBase.floatValue(), proveedor);
            this.productos.add(producto);
        }
    }

    /*
        Método para buscar un proveedor por su nombre y devolver el objeto proveeedor.
        Recibe como argumento un string con el nombre del proveedor
    */
    private Proveedor buscarProveedor(String nombreProveedor) {
        nombreProveedor = nombreProveedor.trim();
        if (nombreProveedor != null || nombreProveedor.length() > 0) {
            for (Proveedor proveedor : this.proveedores) {
                nombreProveedor = nombreProveedor.toUpperCase();
                if (proveedor.getNombre().toUpperCase().equals(nombreProveedor)) {
                    return proveedor;
                }
            }
        }
        return null;
    }

    public ArrayList<Producto> obtenerProductos() {
        return productos;
    }
}
