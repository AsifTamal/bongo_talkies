package ltd.bongo.talkiesbongo.viewmodels;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;

import ltd.bongo.talkiesbongo.BuildConfig;
import ltd.bongo.talkiesbongo.models.MovieDataModel;
import ltd.bongo.talkiesbongo.models.MovieDetailsData;
import ltd.bongo.talkiesbongo.models.MovieResult;
import ltd.bongo.talkiesbongo.models.NotificationList;
import ltd.bongo.talkiesbongo.repositories.BongoRepository;


public class SharedViewModel extends AndroidViewModel {
    private static final String TAG = "SharedViewModel";
    Application application;
    BongoRepository bRepository;
    Gson gson= new Gson();
   // public MovieResult movieresult= new MovieResult();
  public MutableLiveData<MovieResult> movieresult= new MutableLiveData<>();
    MutableLiveData<String> ldErr= new MutableLiveData<>();
    public MutableLiveData<MovieDetailsData> moviedetailsMutable= new MutableLiveData<>();


    public SharedViewModel(@NonNull Application application) {
        super(application);
        this.application=application;
        bRepository=new BongoRepository(application);
    }


    public MutableLiveData<MovieDataModel> getMoviesResult() {

        return bRepository.getMoviesResult();
    }
    public MutableLiveData<String> getErr() {

        return bRepository.getErr();
    }


    public MutableLiveData<MovieDetailsData> getMovieDetailsss() {

        return bRepository.getMoviesDetailesResult();
    }
    public void getMovies(int iPage) {
        bRepository.setMovies(
               iPage
        );
    }
    public void setDetails(int idMv) {
        bRepository.setMoviesDetails(
                idMv
        );
    }

    public void directionToDetailesFragment(MovieResult mItem) {
        movieresult.postValue(mItem);
    }

//    public void showDetailes(MovieDetailsData movieDetailsData) {
//
//        final Handler handler = new Handler(Looper.getMainLooper());
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                moviedetailsMutable.postValue(movieDetailsData);
//                Log.d("pagination", "showDetailes: "+movieDetailsData.getTagline());
//            }
//        }, 300);
//
//    }

}
