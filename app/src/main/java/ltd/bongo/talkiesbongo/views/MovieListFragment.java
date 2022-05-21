package ltd.bongo.talkiesbongo.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import ltd.bongo.talkiesbongo.R;
import ltd.bongo.talkiesbongo.databinding.FragmentMovieListBinding;
import ltd.bongo.talkiesbongo.models.MovieResult;
import ltd.bongo.talkiesbongo.viewmodels.SharedViewModel;


public class MovieListFragment extends Fragment {


    private FragmentMovieListBinding binding;
    private SharedViewModel model;
    ArrayList<MovieResult> movieResults= new ArrayList<>();
    int visibleItemCount,totalItemCount,pastVisibleItemCount,page=1,previoustotal=0,view_thhold=20;

    boolean isLoading=true;

    public MovieListFragment() {
        // Required empty public constructor
    }


    public static MovieListFragment newInstance(String param1, String param2) {
        MovieListFragment fragment = new MovieListFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentMovieListBinding.inflate(inflater, container, false);
        model = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        RecyclerView.LayoutManager layoutManager= new GridLayoutManager(requireContext(),2);
        binding.rvMovieList.setLayoutManager(layoutManager);
        MovieListAdapter movieListAdapter= new MovieListAdapter(requireContext(),model);
        movieListAdapter.setListAgain(movieResults);
        binding.rvMovieList.setAdapter(movieListAdapter);

        model.getMoviesResult().observe(getViewLifecycleOwner(), item -> {
            // Update the UI.

            movieResults.addAll(item.getResults());
            Log.d("pagination", "movieResults: "+movieResults.size()+" page"+page+"api data "+item.getResults().size());
           movieListAdapter.setListAgain(movieResults);
            binding.idPBLoading.setVisibility(View.GONE);

        });

//        binding.rvMovieList.addOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
//                super.onScrollStateChanged(recyclerView, newState);
//            }
//
//            @Override
//            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
//                super.onScrolled(recyclerView, dx, dy);
//                visibleItemCount=layoutManager.getChildCount();
//                        totalItemCount=layoutManager.getItemCount();
//
//                pastVisibleItemCount = ((GridLayoutManager)recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
//
//                Log.d("pagination", "onScrolled: "+totalItemCount);
//                if(dy>0){
//                    if(isLoading){
//
//                        if(totalItemCount>previoustotal){
//                            isLoading=false;
//
//
//
//                        }
//                    }
//
//                    if (!isLoading&&(totalItemCount-visibleItemCount)<= (pastVisibleItemCount+view_thhold)) {
//                       page++;
//                       model.getMovies(page);
//                       binding.idPBLoading.setVisibility(View.VISIBLE);
//                    }
//                }
//            }
//        });

        binding.idNestedSV.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                // on scroll change we are checking when users scroll as bottom.
                if (scrollY == v.getChildAt(0).getMeasuredHeight() - v.getMeasuredHeight()) {
                    // in this method we are incrementing page number,
                    // making progress bar visible and calling get data method.
                    page++;
                    binding.idPBLoading.setVisibility(View.VISIBLE);
                    model.getMovies(page);
                }
            }
        });
        return binding.getRoot();
      
    }
}