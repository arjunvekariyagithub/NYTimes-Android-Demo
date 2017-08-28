
package com.mfp.test.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Meta {

    @SerializedName("hits")
    @Expose
    private Integer hits;
    @SerializedName("offset")
    @Expose
    private Integer offset;
    @SerializedName("time")
    @Expose
    private Integer time;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Meta() {
    }

    /**
     * 
     * @param time
     * @param hits
     * @param offset
     */
    public Meta(Integer hits, Integer offset, Integer time) {
        super();
        this.hits = hits;
        this.offset = offset;
        this.time = time;
    }

    public Integer getHits() {
        return hits;
    }

    public void setHits(Integer hits) {
        this.hits = hits;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

}
