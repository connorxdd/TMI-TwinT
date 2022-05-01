package es.ucm.twint.data;

public class CurrentPosition{

    private Double latitude;
    private Double longitude;

    public CurrentPosition() { }  // RealmObject subclasses must provide an empty constructor

    // Standard getters & setters
    public Double getLatitude() { return latitude; }
    public void setLatitude(Double latitude) { this.latitude = latitude; }

    public Double getLongitude() { return longitude; }
    public void setLongitude(Double longitude) { this.longitude = longitude; }

}

