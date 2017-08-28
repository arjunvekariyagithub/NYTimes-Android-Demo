
package com.mfp.test.data.network.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Doc {

    @SerializedName("web_url")
    @Expose
    private String webUrl;
    @SerializedName("snippet")
    @Expose
    private String snippet;
    @SerializedName("multimedia")
    @Expose
    private List<Multimedia> multimedia = null;
    @SerializedName("headline")
    @Expose
    private Headline headline;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("score")
    @Expose
    private Float score;

    /**
     * No args constructor for use in serialization
     *
     */
    public Doc() {
    }

    /**
     *
     * @param id
     * @param headline
     * @param webUrl
     * @param multimedia
     * @param score
     * @param snippet
     */
    public Doc(String webUrl, String snippet, List<Multimedia> multimedia, Headline headline, String id, Float score) {
        super();
        this.webUrl = webUrl;
        this.snippet = snippet;
        this.multimedia = multimedia;
        this.headline = headline;
        this.id = id;
        this.score = score;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    public List<Multimedia> getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(List<Multimedia> multimedia) {
        this.multimedia = multimedia;
    }

    public Headline getHeadline() {
        return headline;
    }

    public void setHeadline(Headline headline) {
        this.headline = headline;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

}
