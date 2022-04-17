package es.ucm.mocks;

import java.util.ArrayList;

public class ChatListItem {

    private Integer idChat;
    private Integer idUser;
    private String name;
    private String surname;
    private String profileImage;
    private Integer pendingMessages;

    public ChatListItem() { };

    public ChatListItem(Integer idChat, Integer idUser, String name, String surname, String profileImage, Integer pendingMessages)
    {
        this.idChat=idChat;
        this.idUser=idUser;
        this.name=name;
        this.surname=surname;
        this.profileImage=profileImage;
        this.pendingMessages=pendingMessages;
    };

    public Integer getIdChat() {
        return idChat;
    }

    public void setIdChat(Integer idChat) {
        this.idChat = idChat;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public Integer getPendingMessages() {
        return pendingMessages;
    }

    public void setPendingMessages(Integer pendingMessages) {
        this.pendingMessages = pendingMessages;
    }

    public static ArrayList<ChatListItem> generateTestList()
    {
        ArrayList<ChatListItem> data = new ArrayList<ChatListItem>();
        data.add(new ChatListItem(1,1,"Eva","Porto","https://yt3.ggpht.com/KPU1SySMn9Xff8Ep_o47yss38lY9cdBSaYrgglClUFu8PaGgOTD-xrWa0sAOR4zvg4xp8X4U=s900-c-k-c0x00ffffff-no-rj",0));
        data.add(new ChatListItem(1,2,"Javier","Santaolalla Camino","https://viclit.com/wp-content/uploads/2020/01/Javier_Santaollala_VicLit.jpeg",0));
        data.add(new ChatListItem(2,3,"Brett","J. Gilkey", "https://upload.wikimedia.org/wikipedia/commons/a/a0/Pierre-Person.jpg",1));
        data.add(new ChatListItem(2,4,"Marti","Zanhuesa","https://i.ytimg.com/vi/L_fakhHTVJs/maxresdefault.jpg",2));
        data.add(new ChatListItem(3,5,"Gorka","Santander","https://thumbs.dreamstime.com/b/profesora-en-gafas-sentada-el-escritorio-del-ordenador-y-sosteniendo-manzanas-aula-155810381.jpg",3));
        data.add(new ChatListItem(3,6,"Oliver","Fernández","https://tooxclusive.com/wp-content/uploads/2018/01/Chike-Beautiful-People-mp3-image.jpg",12));
        data.add(new ChatListItem(4,7,"Bernardo","Sáez","https://mdundo.com/media/picture/234940_mRAeiHqBLSjDCciYJdGZXOB6NrHi_b.jpg",102));
        data.add(new ChatListItem(4,8,"Josafat","Román","https://thumbs.dreamstime.com/b/portrait-attractive-cheerful-young-man-smiling-happy-face-human-expressions-emotions-model-beautiful-smile-handsome-145517730.jpg",570));
        data.add(new ChatListItem(5,8,"Cindy","Colton","",31));
        return data;
    }

}
