package es.ucm.twint.data;

import io.realm.RealmObject;
import org.bson.types.ObjectId;

public class Message extends RealmObject {

    private ObjectId _id;
    private Integer idMessage;
    private String text1;
    private String text2;
    private Integer idGIF;
    private String date;
    private String time;
    private Integer idChat;
    private Integer idUser;
    private String partitionKey;

    public Message() { }  // RealmObject subclasses must provide an empty constructor

    // Standard getters & setters
    public ObjectId get_id() { return _id; }
    public void set_id(ObjectId _id) { this._id = _id; }

    public Integer getIdMessage() { return idMessage; }
    public void setIdMessage(Integer idMessage) { this.idMessage = idMessage; }

    public String getText1() { return text1; }
    public void setText1(String text1) { this.text1 = text1; }

    public String getText2() { return text2; }
    public void setText2(String text2) { this.text2 = text2; }

    public Integer getIdGIF() { return idGIF; }
    public void setIdGIF(Integer idGIF) { this.idGIF = idGIF; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }

    public Integer getIdChat() { return idChat; }
    public void setIdChat(Integer idChat) { this.idChat = idChat; }

    public Integer getIdUser() { return idUser; }
    public void setIdUser(Integer idUser) { this.idUser = idUser; }

    public String getPartitionKey() { return partitionKey; }
    public void setPartitionKey(String partitionKey) { this.partitionKey = partitionKey; }

}