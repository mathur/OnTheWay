package com.rmathur.food.api;

import com.rmathur.food.models.Foursquare;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by rohan on 21/07/15.
 */
public interface FoursquareAPI {

    @GET("/v2/venues/search")
    void getVenues (
            @Query("client_id") String client_id,
            @Query("client_secret") String client_secret,
            @Query("v") String v,
            @Query("ll") String ll,
            @Query("query") String query,
            @Query("radius") double radius,
            Callback<Foursquare> Foursquare
    );
}