
package com.mfp.test.data.network.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Documents {

    @SerializedName("docs")
    @Expose
    private List<Doc> docs = null;
    @SerializedName("meta")
    @Expose
    private Meta meta;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Documents() {
    }

    /**
     * 
     * @param docs
     * @param meta
     */
    public Documents(List<Doc> docs, Meta meta) {
        super();
        this.docs = docs;
        this.meta = meta;
    }

    public List<Doc> getDocs() {
        return docs;
    }

    public void setDocs(List<Doc> docs) {
        this.docs = docs;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

}
