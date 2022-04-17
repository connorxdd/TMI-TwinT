package es.ucm.twint.data;

import io.realm.RealmList;
import io.realm.RealmObject;
import org.bson.types.ObjectId;

public class Hobby extends RealmObject {

    private ObjectId _id;
    private Integer idHobby;
    private String name;
    private RealmList<String> aliasList;
    private String partitionKey;

    public Hobby() { }  // RealmObject subclasses must provide an empty constructor

    // Standard getters & setters
    public ObjectId get_id() { return _id; }
    public void set_id(ObjectId _id) { this._id = _id; }

    public Integer getIdHobby() { return idHobby; }
    public void setIdHobby(Integer idHobby) { this.idHobby = idHobby; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public RealmList<String> getAliasList() { return aliasList; }
    public void setAliasList(RealmList<String> aliasList) { this.aliasList = aliasList; }

    public String getPartitionKey() { return partitionKey; }
    public void setPartitionKey(String partitionKey) { this.partitionKey = partitionKey; }

}
