package com.mfp.test.data.network;


import com.mfp.test.data.network.model.SearchResponse;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import retrofit2.http.Query;

@Singleton
public class AppApiHelper implements ApiHelper {

    @Inject
    public AppApiHelper() {
    }

    @Override
    public Observable<SearchResponse> searchArticles(@Query("api-key") String apiKey,
                                                     @Query("q") String term,
                                                     @Query("sort") String sort,
                                                     @Query("fl") String[] fields,
                                                     @Query("fq") String fq,
                                                     @Query("page") int page) {
        return null;
    }
}

