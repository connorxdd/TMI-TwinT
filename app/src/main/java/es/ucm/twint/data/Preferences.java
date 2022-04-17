package es.ucm.twint.data;

import io.realm.RealmList;
import io.realm.RealmObject;

public class Preferences extends RealmObject {

    private String target;
    private Integer ageGreaterThan;
    private Integer ageLowerThan;
    private RealmList<String> occupationList;
    private Integer radius;

    public Preferences() { }  // RealmObject subclasses must provide an empty constructor

    // Standard getters & setters
    public String getTarget() { return target; }
    public void setTarget(String target) { this.target = target; }

    public Integer getAgeGreaterThan() { return ageGreaterThan; }
    public void setAgeGreaterThan(Integer ageGreaterThan) { this.ageGreaterThan = ageGreaterThan; }

    public Integer getAgeLowerThan() { return ageLowerThan; }
    public void setAgeLowerThan(Integer ageLowerThan) { this.ageLowerThan = ageLowerThan; }

    public RealmList<String> getOccupationList() { return occupationList; }
    public void setOccupationList(RealmList<String> occupationList) { this.occupationList = occupationList; }

    public Integer getRadius() { return radius; }
    public void setRadius(Integer radius) { this.radius = radius; }

}
