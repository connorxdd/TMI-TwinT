package es.ucm.twint.data;

import org.bson.types.ObjectId;

public class Chat{

    private ObjectId _id;
    private Integer idChat;
    private Integer idUser1;
    private Integer idUser2;
    private String partitionKey;

    public Chat() { }  // RealmObject subclasses must provide an empty constructor

    // Standard getters & setters
    public ObjectId get_id() { return _id; }
    public void set_id(ObjectId _id) { this._id = _id; }

    public Integer getIdChat() { return idChat; }
    public void setIdChat(Integer idChat) { this.idChat = idChat; }

    public Integer getIdUser1() { return idUser1; }
    public void setIdUser1(Integer idUser1) { this.idUser1 = idUser1; }

    public Integer getIdUser2() { return idUser2; }
    public void setIdUser2(Integer idUser2) { this.idUser2 = idUser2; }

    public String getPartitionKey() { return partitionKey; }
    public void setPartitionKey(String partitionKey) { this.partitionKey = partitionKey; }

}
