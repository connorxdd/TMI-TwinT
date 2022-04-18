package es.ucm.mocks;

import java.util.ArrayList;

public class Perfil {
    String nombre;
    String imagen;
    ArrayList<String> urlFotos;

    public Perfil(String nombre, String imagen, ArrayList<String> urlFotos) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.urlFotos = urlFotos;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getImagen() {
        return this.imagen;
    }

    public ArrayList<String> getPhotosProfile() { return this.urlFotos; }
}
