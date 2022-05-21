package ltd.bongo.talkiesbongo.viewmodels;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;

import ltd.bongo.talkiesbongo.BuildConfig;
import ltd.bongo.talkiesbongo.models.MovieDataModel;
import ltd.bongo.talkiesbongo.models.MovieResult;
import ltd.bongo.talkiesbongo.models.NotificationList;
import ltd.bongo.talkiesbongo.repositories.BongoRepository;


public class SharedViewModel extends AndroidViewModel {
    private static final String TAG = "SharedViewModel";
    Application application;
    BongoRepository bRepository;
    Gson gson= new Gson();
   // public MovieResult movieresult= new MovieResult();
  public   MutableLiveData<MovieResult> movieresult= new MutableLiveData<>();
    MutableLiveData<String> ldErr= new MutableLiveData<>();
    public SharedViewModel(@NonNull Application application) {
        super(application);
        this.application=application;
        bRepository=new BongoRepository(application);
    }


    public MutableLiveData<MovieDataModel> getMoviesResult() {
        String mdata = gson.toJson(bRepository.getMoviesResult().getValue());


        return bRepository.getMoviesResult();
    }
    public MutableLiveData<String> getErr() {
        Log.d(TAG, "getMoviesResult: "+bRepository.getErr().getValue());
        return bRepository.getErr();
    }



    public void getMovies(int iPage) {
        bRepository.setMovies(
               iPage
        );
    }

    public void directionToDetailesFragment(MovieResult mItem) {
        movieresult.postValue(mItem);
    }
    public MutableLiveData<MovieResult> showDetailesFragment() {
//        String pathImg= BuildConfig.IMG_URL+"/"+movieresult.getValue().getPosterPath();
//        movieresult.getValue().setPosterPath(pathImg);
       return movieresult;
    }

}
