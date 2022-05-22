package ltd.bongo.talkiesbongo.networks.Remote;


import ltd.bongo.talkiesbongo.models.MovieDataModel;
import ltd.bongo.talkiesbongo.models.MovieDetailsData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIService {

    @Headers({"Content-Type: application/json;charset=UTF-8"})
    @GET("movie/{id}")
    Call<MovieDetailsData> getMoviesDetails(@Path("id") String mvID, @Query("api_key") String apikey, @Query("language") String language );

    @GET("movie/top_rated") //i.e https://api.test.com/Search?
    Call<MovieDataModel> getMovies(@Query("api_key") String apikey, @Query("language") String language,
                                     @Query("page") String page);

}
