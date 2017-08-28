
package com.mfp.test.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Legacy {

    @SerializedName("xlargewidth")
    @Expose
    private Integer xlargewidth;
    @SerializedName("xlarge")
    @Expose
    private String xlarge;
    @SerializedName("xlargeheight")
    @Expose
    private Integer xlargeheight;
    @SerializedName("wide")
    @Expose
    private String wide;
    @SerializedName("widewidth")
    @Expose
    private Integer widewidth;
    @SerializedName("wideheight")
    @Expose
    private Integer wideheight;
    @SerializedName("thumbnailheight")
    @Expose
    private Integer thumbnailheight;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("thumbnailwidth")
    @Expose
    private Integer thumbnailwidth;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Legacy() {
    }

    /**
     * 
     * @param thumbnail
     * @param xlargeheight
     * @param wideheight
     * @param widewidth
     * @param wide
     * @param thumbnailwidth
     * @param thumbnailheight
     * @param xlarge
     * @param xlargewidth
     */
    public Legacy(Integer xlargewidth, String xlarge, Integer xlargeheight, String wide, Integer widewidth, Integer wideheight, Integer thumbnailheight, String thumbnail, Integer thumbnailwidth) {
        super();
        this.xlargewidth = xlargewidth;
        this.xlarge = xlarge;
        this.xlargeheight = xlargeheight;
        this.wide = wide;
        this.widewidth = widewidth;
        this.wideheight = wideheight;
        this.thumbnailheight = thumbnailheight;
        this.thumbnail = thumbnail;
        this.thumbnailwidth = thumbnailwidth;
    }

    public Integer getXlargewidth() {
        return xlargewidth;
    }

    public void setXlargewidth(Integer xlargewidth) {
        this.xlargewidth = xlargewidth;
    }

    public String getXlarge() {
        return xlarge;
    }

    public void setXlarge(String xlarge) {
        this.xlarge = xlarge;
    }

    public Integer getXlargeheight() {
        return xlargeheight;
    }

    public void setXlargeheight(Integer xlargeheight) {
        this.xlargeheight = xlargeheight;
    }

    public String getWide() {
        return wide;
    }

    public void setWide(String wide) {
        this.wide = wide;
    }

    public Integer getWidewidth() {
        return widewidth;
    }

    public void setWidewidth(Integer widewidth) {
        this.widewidth = widewidth;
    }

    public Integer getWideheight() {
        return wideheight;
    }

    public void setWideheight(Integer wideheight) {
        this.wideheight = wideheight;
    }

    public Integer getThumbnailheight() {
        return thumbnailheight;
    }

    public void setThumbnailheight(Integer thumbnailheight) {
        this.thumbnailheight = thumbnailheight;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Integer getThumbnailwidth() {
        return thumbnailwidth;
    }

    public void setThumbnailwidth(Integer thumbnailwidth) {
        this.thumbnailwidth = thumbnailwidth;
    }

}
