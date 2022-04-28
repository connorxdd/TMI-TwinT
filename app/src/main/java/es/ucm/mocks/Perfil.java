package es.ucm.mocks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Perfil {

    String id;
    String nombre;
    String imagen;
    String personalDescription;
    String preferences;
    String biography;
    ArrayList<String> urlFotos;
    String picture;
    Map<String, String> socialNetworks;


    public Perfil() {
        this.socialNetworks = new HashMap<String, String>();
        this.socialNetworks.put("facebook","test");
        this.socialNetworks.put("instagram","");
        this.socialNetworks.put("linkedin","");
        this.socialNetworks.put("spotify","");
        this.socialNetworks.put("tiktok","");
        this.socialNetworks.put("twitch","");
        this.socialNetworks.put("twitter","");
        this.socialNetworks.put("youtube","");
        this.socialNetworks.put("web","");
    }
    public Perfil(String nombre, String imagen, ArrayList<String> urlFotos) {
        this();
        // id never should be null
        this.id = "smth";
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

    public String getPersonalDescription() {
        return personalDescription;
    }

    public void setPersonalDescription(String personalDescription) {
        this.personalDescription = personalDescription;
    }

    public void setSocialNetwork(String key, String value) {
        this.socialNetworks.put(key, value);
    }

    public String getSocialNetwork(String key) {
        return this.socialNetworks.get(key);
    }

    public String getPreferences() {
        return preferences;
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

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<String, String> getSocialNetworks() {
        return socialNetworks;
    }

    public void setSocialNetworks(Map<String, String> socialNetworks) {
        this.socialNetworks = socialNetworks;
    }
}
