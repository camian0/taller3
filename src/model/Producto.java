package model;

public class Producto {

    private String nombre;
    private Short edad;
    private Float precioBase;

    private Proveedor proveedor;

    public Producto(String unNombre, Short unaEdad, Float unPrecioBase, Proveedor unProveedor) {
        nombre = unNombre;
        edad = unaEdad;
        precioBase = unPrecioBase;
        proveedor = unProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public Short getEdad() {
        return edad;
    }

    public Float getPrecioBase() {
        return precioBase;
    }

    public  Proveedor getProveedor(){
        return proveedor;
    }

    public void setNombre(String unNombre) {
        if (unNombre != null) {
            nombre = unNombre;
        }
    }

    public void setEdad(Short unaEdad) {
        if (unaEdad != null) {
            edad = unaEdad;
        }
    }

    public void setPrecioBase(Float unPrecio) {
        if (unPrecio != null) {
            precioBase = unPrecio;
        }
    }
}
