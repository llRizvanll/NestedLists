package com.nitghowl.test;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * App Api Interface , methods
 */
public interface ApiMethodGen {
    /**
     * Return restaurant data on page wise api call
     * @param page
     * @return restaurant data as response
     */
    //https://api.myjson.com/bins/ngcc?page=0
    @GET(HttpRequestMaker.domain+"/bins/ngcc?")
    Call<RestaurantDataModel> getRestaurantData(@Query("page") int page);

}
