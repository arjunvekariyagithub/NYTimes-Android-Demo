
package com.mfp.test.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
    POJO class representing server response.

 */


public class SearchResponse {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("copyright")
    @Expose
    private String copyright;
    @SerializedName("response")
    @Expose
    private Documents documents;

    /**
     * No args constructor for use in serialization
     * 
     */
    public SearchResponse() {
    }

    /**
     * 
     * @param documents
     * @param status
     * @param copyright
     */
    public SearchResponse(String status, String copyright, Documents documents) {
        super();
        this.status = status;
        this.copyright = copyright;
        this.documents = documents;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public Documents getDocuments() {
        return documents;
    }

    public void setDocuments(Documents documents) {
        this.documents = documents;
    }

}
