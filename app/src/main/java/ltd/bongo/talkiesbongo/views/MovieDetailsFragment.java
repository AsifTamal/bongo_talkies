package ltd.bongo.talkiesbongo.views;

import static ltd.bongo.talkiesbongo.utils.CommonUtils.makeTextViewResizable;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ltd.bongo.talkiesbongo.R;
import ltd.bongo.talkiesbongo.databinding.FragmentMovieDetailsBinding;
import ltd.bongo.talkiesbongo.databinding.FragmentMovieListBinding;
import ltd.bongo.talkiesbongo.models.MovieResult;
import ltd.bongo.talkiesbongo.viewmodels.SharedViewModel;


public class MovieDetailsFragment extends Fragment {


    private FragmentMovieDetailsBinding binding;
    private SharedViewModel model;
    public MovieDetailsFragment() {
        // Required empty public constructor
    }


    public static MovieDetailsFragment newInstance(String param1, String param2) {
        MovieDetailsFragment fragment = new MovieDetailsFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMovieDetailsBinding.inflate(inflater, container, false);
        model = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        binding.setMovieDetails(model);

        model.movieresult.observe(getViewLifecycleOwner(), new Observer<MovieResult>() {
            @Override
            public void onChanged(MovieResult movieResult) {
                Log.d("pagination", "MovieDetailsFragment: "+movieResult.getOriginalTitle());
                binding.mDecripn.setText(movieResult.getOverview());
                makeTextViewResizable(binding.mDecripn, 3, "See More", true);
            }
        });
        return binding.getRoot();
    }
}