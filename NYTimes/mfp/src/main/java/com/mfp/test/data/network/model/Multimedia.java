
package com.mfp.test.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Multimedia {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("subtype")
    @Expose
    private String subtype;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("height")
    @Expose
    private Integer height;
    @SerializedName("width")
    @Expose
    private Integer width;
    @SerializedName("rank")
    @Expose
    private Integer rank;
    @SerializedName("legacy")
    @Expose
    private Legacy legacy;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Multimedia() {
    }

    /**
     * 
     * @param rank
     * @param height
     * @param width
     * @param subtype
     * @param type
     * @param url
     * @param legacy
     */
    public Multimedia(String type, String subtype, String url, Integer height, Integer width, Integer rank, Legacy legacy) {
        super();
        this.type = type;
        this.subtype = subtype;
        this.url = url;
        this.height = height;
        this.width = width;
        this.rank = rank;
        this.legacy = legacy;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Legacy getLegacy() {
        return legacy;
    }

    public void setLegacy(Legacy legacy) {
        this.legacy = legacy;
    }

}
