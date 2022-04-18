package es.ucm.mocks;

import java.util.ArrayList;

public class Perfiles {

    public static ArrayList<Perfil> getPerfiles() {
        ArrayList<Perfil> data = new ArrayList<Perfil>();
        ArrayList<String> fotos = new ArrayList<>();
        data.add(new Perfil("Brett J. Gilkey", "https://upload.wikimedia.org/wikipedia/commons/a/a0/Pierre-Person.jpg", fotos));
        data.add(new Perfil("Marti Zanhuesa", "https://i.ytimg.com/vi/L_fakhHTVJs/maxresdefault.jpg", fotos));
        data.add(new Perfil("Gorka Santander", "https://thumbs.dreamstime.com/b/profesora-en-gafas-sentada-el-escritorio-del-ordenador-y-sosteniendo-manzanas-aula-155810381.jpg", fotos));
        data.add(new Perfil("Oliver Fernández", "https://tooxclusive.com/wp-content/uploads/2018/01/Chike-Beautiful-People-mp3-image.jpg", fotos));
        data.add(new Perfil("Bernardo Sáez", "https://mdundo.com/media/picture/234940_mRAeiHqBLSjDCciYJdGZXOB6NrHi_b.jpg", fotos));
        data.add(new Perfil("Josafat Román", "https://thumbs.dreamstime.com/b/portrait-attractive-cheerful-young-man-smiling-happy-face-human-expressions-emotions-model-beautiful-smile-handsome-145517730.jpg", fotos));
        return data;
    }
}
