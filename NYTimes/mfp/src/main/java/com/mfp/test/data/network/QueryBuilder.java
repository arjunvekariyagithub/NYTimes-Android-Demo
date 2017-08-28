package com.mfp.test.data.network;

public class QueryBuilder {

    public static final String[] PARAM_RESPONSE_FIELDS = {"_id", "web_url", "snippet", "headline", "multimedia"};

    static final String[] MATERIAL_TYPES = {"News", "Review"};

    public static final String PARAM_SORT = "newest";

    static String sFiledFQ;

    static {
        StringBuilder fqParams = new StringBuilder();
        if (MATERIAL_TYPES.length > 0) {
            fqParams.append("type_of_material:(");
            if (MATERIAL_TYPES.length > 1) {
                for (int i = 0; i < MATERIAL_TYPES.length - 1; i++) {
                    fqParams.append(MATERIAL_TYPES[i]);
                    fqParams.append(" ");
                }
                fqParams.append(MATERIAL_TYPES[MATERIAL_TYPES.length - 1]);
            } else {
                fqParams.append(MATERIAL_TYPES[0]);
            }
            fqParams.append(")");
            sFiledFQ =  fqParams.toString();
        }
    }

    public static String getParamFQ() {
        return sFiledFQ;
    }

    public static String[] getParamFL() {
        return PARAM_RESPONSE_FIELDS;
    }
}
