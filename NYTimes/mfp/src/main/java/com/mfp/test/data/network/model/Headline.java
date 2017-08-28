
package com.mfp.test.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Headline {

    @SerializedName("main")
    @Expose
    private String main;
    @SerializedName("print_headline")
    @Expose
    private String printHeadline;
    @SerializedName("kicker")
    @Expose
    private String kicker;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Headline() {
    }

    /**
     * 
     * @param printHeadline
     * @param kicker
     * @param main
     */
    public Headline(String main, String printHeadline, String kicker) {
        super();
        this.main = main;
        this.printHeadline = printHeadline;
        this.kicker = kicker;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getPrintHeadline() {
        return printHeadline;
    }

    public void setPrintHeadline(String printHeadline) {
        this.printHeadline = printHeadline;
    }

    public String getKicker() {
        return kicker;
    }

    public void setKicker(String kicker) {
        this.kicker = kicker;
    }

}
