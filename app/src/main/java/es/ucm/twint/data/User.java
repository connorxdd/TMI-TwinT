package es.ucm.twint.data;

import io.realm.RealmList;
import io.realm.RealmObject;
import org.bson.types.ObjectId;

public class User extends RealmObject {

    private ObjectId _id;
    private Integer idUser;
    private String account;
    private String password;
    private String name;
    private String surname;
    private String email;
    private String sex;
    private String dateOfBirth;
    private String language;
    private String country;
    private String occupationType;
    private String occupation;
    private String usualZone;
    private CurrentPosition currentPosition;
    private String biography;
    private RealmList<Integer> hobbyList;
    private RealmList<Integer> fileList;
    private Preferences preferences;
    private SocialNetworks socialNetworks;
    private String lastLogin;
    private String partitionKey;

    public User() { }  // RealmObject subclasses must provide an empty constructor

    // Standard getters & setters
    public ObjectId get_id() { return _id; }
    public void set_id(ObjectId _id) { this._id = _id; }

    public Integer getIdUser() { return idUser; }
    public void setIdUser(Integer idUser) { this.idUser = idUser; }

    public String getAccount() { return account; }
    public void setAccount(String account) { this.account = account; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSex() { return sex; }
    public void setSex(String sex) { this.sex = sex; }

    public String getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(String dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public String getOccupationType() { return occupationType; }
    public void setOccupationType(String occupationType) { this.occupationType = occupationType; }

    public String getOccupation() { return occupation; }
    public void setOccupation(String occupation) { this.occupation = occupation; }

    public String getUsualZone() { return usualZone; }
    public void setUsualZone(String usualZone) { this.usualZone = usualZone; }

    public CurrentPosition getCurrentPosition() { return currentPosition; }
    public void setCurrentPosition(CurrentPosition currentPosition) { this.currentPosition = currentPosition; }

    public String getBiography() { return biography; }
    public void setBiography(String biography) { this.biography = biography; }

    public RealmList<Integer> getHobbyList() { return hobbyList; }
    public void setHobbyList(RealmList<Integer> hobbyList) { this.hobbyList = hobbyList; }

    public RealmList<Integer> getFileList() { return fileList; }
    public void setFileList(RealmList<Integer> fileList) { this.fileList = fileList; }

    public Preferences getPreferences() { return preferences; }
    public void setPreferences(Preferences preferences) { this.preferences = preferences; }

    public SocialNetworks getSocialNetworks() { return socialNetworks; }
    public void setSocialNetworks(SocialNetworks socialNetworks) { this.socialNetworks = socialNetworks; }

    public String getLastLogin() { return lastLogin; }
    public void setLastLogin(String lastLogin) { this.lastLogin = lastLogin; }

    public String getPartitionKey() { return partitionKey; }
    public void setPartitionKey(String partitionKey) { this.partitionKey = partitionKey; }

}

