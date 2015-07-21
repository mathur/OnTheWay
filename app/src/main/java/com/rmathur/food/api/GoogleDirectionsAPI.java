package com.rmathur.food.api;

import com.rmathur.food.models.Route;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

public interface GoogleDirectionsAPI {
    // Request method and URL specified in the annotation
    // Callback for the parsed response is the last parameter

    @GET("/maps/api/directions/json")
    void getDirections(
            @Query("key") String key,
            @Query("origin") String origin,
            @Query("destination") String destination,
            Callback<Route> route
    );

}