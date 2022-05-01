package es.ucm.twint.data;

import org.bson.types.ObjectId;

public class File{

    private ObjectId _id;
    private Integer idFile;
    private String fileName;
    private String fileType;
    private String urlFile;
    private String partitionKey;

    public File() { }  // RealmObject subclasses must provide an empty constructor

    // Standard getters & setters
    public ObjectId get_id() { return _id; }
    public void set_id(ObjectId _id) { this._id = _id; }

    public Integer getIdFile() { return idFile; }
    public void setIdFile(Integer idFile) { this.idFile = idFile; }

    public String getFileName() { return fileName; }
    public void setFileName(String fileName) { this.fileName = fileName; }

    public String getFileType() { return fileType; }
    public void setFileType(String fileType) { this.fileType = fileType; }

    public String getUrlFile() { return urlFile; }
    public void setUrlFile(String urlFile) { this.urlFile = urlFile; }

    public String getPartitionKey() { return partitionKey; }
    public void setPartitionKey(String partitionKey) { this.partitionKey = partitionKey; }

}

