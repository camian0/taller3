package model;

public class Proveedor {

    private String nombre;
    private Float precioEnvío;

    public Proveedor(String unNombre, float unPrecioEnvio) {
        nombre = unNombre;
        precioEnvío = unPrecioEnvio = unPrecioEnvio;
    }

    public String getNombre() {
        return nombre;
    }

    public Float getPrecioEnvio() {
        return precioEnvío;
    }

    public void setNombre(String unNombre) {
        nombre = unNombre;
    }

    public void setPrecioEnvío(float unPrecio) {
        precioEnvío = unPrecio;
    }
}
