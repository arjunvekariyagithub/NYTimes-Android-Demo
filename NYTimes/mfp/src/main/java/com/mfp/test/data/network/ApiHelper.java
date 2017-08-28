package com.mfp.test.data.network;

import com.mfp.test.data.network.model.SearchResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 *  Interface, holding signatures for network APIs
 *
 */

public interface ApiHelper {

    /**
     * retrofit callback signature for fetching new articles from NYTimes server.
     *
     * @param apiKey api key for accessing data from api.zappos.com
     * @param term   search term
     * @param fields fields to be retrieved
     * @param fq     filter queries for sub fields
     * @param page   page number
     * @return data in {@link SearchResponse} form
     */

    @GET("articlesearch.json")
    Observable<SearchResponse> searchArticles(@Query("api-key") String apiKey,
                                              @Query("q") String term,
                                              @Query("sort") String sort,
                                              @Query("fl") String[] fields,
                                              @Query("fq") String fq,
                                              @Query("page") int page);
}
