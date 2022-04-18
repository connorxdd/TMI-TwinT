package es.ucm.mocks;

import java.util.ArrayList;

public class Perfil {
    String nombre;
    String imagen;
    String personalDescription;
    String preferences;
    String email;
    ArrayList<String> urlFotos;
    String picture;
    ArrayList<String> multimedia;

    public Perfil() {
    }
    public Perfil(String nombre, String imagen, ArrayList<String> urlFotos) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.urlFotos = urlFotos;
    }

    public void addMultimedia(String m) {
        this.multimedia.add(m);
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getImagen() {
        return this.imagen;
    }

    public ArrayList<String> getPhotosProfile() { return this.urlFotos; }

    public String getPersonalDescription() {
        return personalDescription;
    }

    public void setPersonalDescription(String personalDescription) {
        this.personalDescription = personalDescription;
    }

    public String getPreferences() {
        return preferences;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPreferences(String preferences) {
        this.preferences = preferences;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public ArrayList<String> getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(ArrayList<String> multimedia) {
        this.multimedia = multimedia;
    }
}
