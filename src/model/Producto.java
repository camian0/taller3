package model;

public class Producto {

    private String nombre;
    private Short edad;
    private Float precioBase;

    public Producto(String unNombre, Short unaEdad, Float unPrecioBase) {
        nombre = unNombre;
        edad = unaEdad;
        precioBase = unPrecioBase;
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
