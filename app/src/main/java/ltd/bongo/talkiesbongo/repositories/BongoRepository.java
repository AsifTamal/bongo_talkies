package ltd.bongo.talkiesbongo.repositories;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import ltd.bongo.talkiesbongo.BuildConfig;
import ltd.bongo.talkiesbongo.models.MovieDataModel;
import ltd.bongo.talkiesbongo.models.MovieDetailsData;
import ltd.bongo.talkiesbongo.models.NotificationList;
import ltd.bongo.talkiesbongo.networks.ApiUtil.ApiUtils;
import ltd.bongo.talkiesbongo.networks.Remote.APIService;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class BongoRepository {
    Application application;
    MutableLiveData<MovieDataModel> lMovies= new MutableLiveData<>();
    MutableLiveData<MovieDetailsData> lMoviesDetailes= new MutableLiveData<>();
    MutableLiveData<String> ldErr= new MutableLiveData<>();
    MutableLiveData<String> ldSeenMsg= new MutableLiveData<>();
    public BongoRepository(Application application) {
        this.application = application;
    }

    public void setMovies(int iPage){
        APIService apiService = ApiUtils.getApiService();
        apiService.getMovies(BuildConfig.API_KEY,"en-US", String.valueOf(iPage)).enqueue(new Callback<MovieDataModel>() {
            @Override
            public void onResponse(Call<MovieDataModel> call, Response<MovieDataModel> response) {
                if (response.isSuccessful()){
                    MovieDataModel j=response.body();
                   // lMovies= new MutableLiveData<>();
                    lMovies.postValue(j);
                }
                else {
                    try {

                        ldErr.postValue("Error");
                    } catch (Exception e) {

                        ldErr.postValue("Error");
                    }
                }
            }

            @Override
            public void onFailure(Call<MovieDataModel> call, Throwable t) {

                ldErr.postValue("Error");

            }
        });
    }
    public  MutableLiveData<MovieDataModel> getMoviesResult(){
        return lMovies;
    }
    public  MutableLiveData<String> getErr(){
        return ldErr;
    }
    public  MutableLiveData<String> getLdSeenMsg(){
        return ldSeenMsg;
    }
    public  MutableLiveData<MovieDetailsData> getMoviesDetailesResult(){
        return lMoviesDetailes;
    }
    public void setMoviesDetails(int movieId){
        APIService apiService = ApiUtils.getApiService();
        apiService.getMoviesDetails(String.valueOf(movieId), BuildConfig.API_KEY,"en-US").enqueue(new Callback<MovieDetailsData>() {
            @Override
            public void onResponse(Call<MovieDetailsData> call, Response<MovieDetailsData> response) {
                if (response.isSuccessful()){
                    MovieDetailsData j=response.body();

                    lMoviesDetailes.postValue(j);
                }
                else {
                    try {

                        ldErr.postValue("Error");
                    } catch (Exception e) {
                        //  Log.d("check2Error", e.getMessage());

                        ldErr.postValue("Error");
                    }
                }
            }

            @Override
            public void onFailure(Call<MovieDetailsData> call, Throwable t) {
                // Log.d("customerInfoErr",t.getMessage());

                ldErr.postValue("Error");

            }
        });
    }


}
