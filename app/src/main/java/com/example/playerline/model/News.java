package com.example.playerline.model;

import java.io.Serializable;
import com.google.gson.annotations.SerializedName;

public class News implements Serializable
{

    @SerializedName("id")
    private String id;
    @SerializedName("pid")
    private String pid;
    @SerializedName("time")
    private String time;
    @SerializedName("time_pst")
    private String timePst;
    @SerializedName("pname")
    private String pname;
    @SerializedName("is_favorite")
    private boolean isFavorite;
    @SerializedName("position")
    private String position;
    @SerializedName("title")
    private String title;
    @SerializedName("details")
    private String details;
    @SerializedName("source")
    private String source;
    @SerializedName("source_name")
    private String sourceName;
    @SerializedName("source_url")
    private String sourceUrl;
    @SerializedName("source_logo")
    private String sourceLogo;
    @SerializedName("hash_url")
    private String hashUrl;
    @SerializedName("type")
    private String type;
    @SerializedName("player_image_url")
    private String playerImageUrl;
    private final static long serialVersionUID = 8777716101472550678L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTimePst() {
        return timePst;
    }

    public void setTimePst(String timePst) {
        this.timePst = timePst;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public boolean isIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(boolean isFavorite) {
        this.isFavorite = isFavorite;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public String getSourceLogo() {
        return sourceLogo;
    }

    public void setSourceLogo(String sourceLogo) {
        this.sourceLogo = sourceLogo;
    }

    public String getHashUrl() {
        return hashUrl;
    }

    public void setHashUrl(String hashUrl) {
        this.hashUrl = hashUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlayerImageUrl() {
        return playerImageUrl;
    }

    public void setPlayerImageUrl(String playerImageUrl) {
        this.playerImageUrl = playerImageUrl;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(News.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("pid");
        sb.append('=');
        sb.append(((this.pid == null)?"<null>":this.pid));
        sb.append(',');
        sb.append("time");
        sb.append('=');
        sb.append(((this.time == null)?"<null>":this.time));
        sb.append(',');
        sb.append("timePst");
        sb.append('=');
        sb.append(((this.timePst == null)?"<null>":this.timePst));
        sb.append(',');
        sb.append("pname");
        sb.append('=');
        sb.append(((this.pname == null)?"<null>":this.pname));
        sb.append(',');
        sb.append("isFavorite");
        sb.append('=');
        sb.append(this.isFavorite);
        sb.append(',');
        sb.append("position");
        sb.append('=');
        sb.append(((this.position == null)?"<null>":this.position));
        sb.append(',');
        sb.append("title");
        sb.append('=');
        sb.append(((this.title == null)?"<null>":this.title));
        sb.append(',');
        sb.append("details");
        sb.append('=');
        sb.append(((this.details == null)?"<null>":this.details));
        sb.append(',');
        sb.append("source");
        sb.append('=');
        sb.append(((this.source == null)?"<null>":this.source));
        sb.append(',');
        sb.append("sourceName");
        sb.append('=');
        sb.append(((this.sourceName == null)?"<null>":this.sourceName));
        sb.append(',');
        sb.append("sourceUrl");
        sb.append('=');
        sb.append(((this.sourceUrl == null)?"<null>":this.sourceUrl));
        sb.append(',');
        sb.append("sourceLogo");
        sb.append('=');
        sb.append(((this.sourceLogo == null)?"<null>":this.sourceLogo));
        sb.append(',');
        sb.append("hashUrl");
        sb.append('=');
        sb.append(((this.hashUrl == null)?"<null>":this.hashUrl));
        sb.append(',');
        sb.append("type");
        sb.append('=');
        sb.append(((this.type == null)?"<null>":this.type));
        sb.append(',');
        sb.append("playerImageUrl");
        sb.append('=');
        sb.append(((this.playerImageUrl == null)?"<null>":this.playerImageUrl));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.pname == null)? 0 :this.pname.hashCode()));
        result = ((result* 31)+((this.pid == null)? 0 :this.pid.hashCode()));
        result = ((result* 31)+((this.timePst == null)? 0 :this.timePst.hashCode()));
        result = ((result* 31)+((this.source == null)? 0 :this.source.hashCode()));
        result = ((result* 31)+((this.title == null)? 0 :this.title.hashCode()));
        result = ((result* 31)+((this.type == null)? 0 :this.type.hashCode()));
        result = ((result* 31)+((this.sourceUrl == null)? 0 :this.sourceUrl.hashCode()));
        result = ((result* 31)+((this.hashUrl == null)? 0 :this.hashUrl.hashCode()));
        result = ((result* 31)+((this.playerImageUrl == null)? 0 :this.playerImageUrl.hashCode()));
        result = ((result* 31)+((this.details == null)? 0 :this.details.hashCode()));
        result = ((result* 31)+((this.id == null)? 0 :this.id.hashCode()));
        result = ((result* 31)+((this.time == null)? 0 :this.time.hashCode()));
        result = ((result* 31)+((this.position == null)? 0 :this.position.hashCode()));
        result = ((result* 31)+((this.sourceName == null)? 0 :this.sourceName.hashCode()));
        result = ((result* 31)+((this.sourceLogo == null)? 0 :this.sourceLogo.hashCode()));
        result = ((result* 31)+(this.isFavorite? 1 : 0));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof News) == false) {
            return false;
        }
        News rhs = ((News) other);
        return (((((((((((((((((this.pname == rhs.pname)||((this.pname!= null)&&this.pname.equals(rhs.pname)))&&((this.pid == rhs.pid)||((this.pid!= null)&&this.pid.equals(rhs.pid))))&&((this.timePst == rhs.timePst)||((this.timePst!= null)&&this.timePst.equals(rhs.timePst))))&&((this.source == rhs.source)||((this.source!= null)&&this.source.equals(rhs.source))))&&((this.title == rhs.title)||((this.title!= null)&&this.title.equals(rhs.title))))&&((this.type == rhs.type)||((this.type!= null)&&this.type.equals(rhs.type))))&&((this.sourceUrl == rhs.sourceUrl)||((this.sourceUrl!= null)&&this.sourceUrl.equals(rhs.sourceUrl))))&&((this.hashUrl == rhs.hashUrl)||((this.hashUrl!= null)&&this.hashUrl.equals(rhs.hashUrl))))&&((this.playerImageUrl == rhs.playerImageUrl)||((this.playerImageUrl!= null)&&this.playerImageUrl.equals(rhs.playerImageUrl))))&&((this.details == rhs.details)||((this.details!= null)&&this.details.equals(rhs.details))))&&((this.id == rhs.id)||((this.id!= null)&&this.id.equals(rhs.id))))&&((this.time == rhs.time)||((this.time!= null)&&this.time.equals(rhs.time))))&&((this.position == rhs.position)||((this.position!= null)&&this.position.equals(rhs.position))))&&((this.sourceName == rhs.sourceName)||((this.sourceName!= null)&&this.sourceName.equals(rhs.sourceName))))&&((this.sourceLogo == rhs.sourceLogo)||((this.sourceLogo!= null)&&this.sourceLogo.equals(rhs.sourceLogo))))&&(this.isFavorite == rhs.isFavorite));
    }

}