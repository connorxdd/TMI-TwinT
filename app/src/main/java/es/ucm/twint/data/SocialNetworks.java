package es.ucm.twint.data;

import io.realm.RealmObject;

public class SocialNetworks extends RealmObject {

    private String facebook;
    private String instagam;
    private String linkedin;
    private String spotify;
    private String tiktok;
    private String twitch;
    private String twitter;
    private String youtube;
    private String web;

    public SocialNetworks() { }  // RealmObject subclasses must provide an empty constructor

    // Standard getters & setters
    public String getFacebook() { return facebook; }
    public void setFacebook(String facebook) { this.facebook = facebook; }

    public String getInstagam() { return instagam; }
    public void setInstagam(String instagam) { this.instagam = instagam; }

    public String getLinkedin() { return linkedin; }
    public void setLinkedin(String linkedin) { this.linkedin = linkedin; }

    public String getSpotify() { return spotify; }
    public void setSpotify(String spotify) { this.spotify = spotify; }

    public String getTiktok() { return tiktok; }
    public void setTiktok(String tiktok) { this.tiktok = tiktok; }

    public String getTwitch() { return twitch; }
    public void setTwitch(String twitch) { this.twitch = twitch; }

    public String getTwitter() { return twitter; }
    public void setTwitter(String twitter) { this.twitter = twitter; }

    public String getYoutube() { return youtube; }
    public void setYoutube(String youtube) { this.youtube = youtube; }

    public String getWeb() { return web; }
    public void setWeb(String web) { this.web = web; }

}
