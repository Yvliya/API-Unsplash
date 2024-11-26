package br.com.estudos.app_unplash;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;



public interface UnsplashApi {
    @GET("/photos")
    Call<List<UnsplashImage>> getPhotos(@Query("client_id") String clientId);
}
