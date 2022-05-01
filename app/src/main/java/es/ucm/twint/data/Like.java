package es.ucm.twint.data;

import org.bson.types.ObjectId;

public class Like{

    private ObjectId _id;
    private Integer idLike;
    private Integer idGiver;
    private Integer idReceiver;
    private String date;
    private String time;
    private String partitionKey;

    public Like() { }  // RealmObject subclasses must provide an empty constructor

    // Standard getters & setters
    public ObjectId get_id() { return _id; }
    public void set_id(ObjectId _id) { this._id = _id; }

    public Integer getIdLike() { return idLike; }
    public void setIdLike(Integer idLike) { this.idLike = idLike; }

    public Integer getIdGiver() { return idGiver; }
    public void setIdGiver(Integer idGiver) { this.idGiver = idGiver; }

    public Integer getIdReceiver() { return idReceiver; }
    public void setIdReceiver(Integer idReceiver) { this.idReceiver = idReceiver; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }

    public String getPartitionKey() { return partitionKey; }
    public void setPartitionKey(String partitionKey) { this.partitionKey = partitionKey; }

}
