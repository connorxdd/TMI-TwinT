package es.ucm.mocks;

public class Perfil {
    String nombre;
    String imagen;

    public Perfil(String nombre, String imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getImagen() {
        return this.imagen;
    }
}
