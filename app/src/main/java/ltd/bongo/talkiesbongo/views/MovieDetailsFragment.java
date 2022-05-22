package ltd.bongo.talkiesbongo.views;

import static ltd.bongo.talkiesbongo.utils.CommonUtils.makeTextViewResizable;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import ltd.bongo.talkiesbongo.BuildConfig;
import ltd.bongo.talkiesbongo.R;
import ltd.bongo.talkiesbongo.databinding.FragmentMovieDetailsBinding;
import ltd.bongo.talkiesbongo.databinding.FragmentMovieListBinding;
import ltd.bongo.talkiesbongo.models.Genre;
import ltd.bongo.talkiesbongo.models.MovieDetailsData;
import ltd.bongo.talkiesbongo.models.MovieResult;
import ltd.bongo.talkiesbongo.models.ProductionCompany;
import ltd.bongo.talkiesbongo.models.ProductionCountry;
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
               // Log.d("pagination", "MovieDetailsFragment: "+movieResult.getOriginalTitle());
                binding.mDecripn.setText(movieResult.getOverview());
                model.setDetails(movieResult.getId());
                makeTextViewResizable(binding.mDecripn, 3, "See More", true);
            }
        });
        model.getMovieDetailsss().observe(getViewLifecycleOwner(), new Observer<MovieDetailsData>() {
            @Override
            public void onChanged(MovieDetailsData movieDetailResult) {
                Log.d("pagination", "MovieDetailsFragment: "+movieDetailResult.getTagline());

                        //model.showDetailes(movieDetailResult);


            binding.txtmovieTag.setText(movieDetailResult.getTagline());
            String ggenres="Genre: ";
                for (Genre g:
                        movieDetailResult.getGenres()) {

                    ggenres= ggenres+" "+g.getName();

                }
                binding.txtmovieGenres.setText(ggenres);
                binding.txttstatus.setText("Status: "+movieDetailResult.getStatus());
                binding.txtbgtrev.setText("Budget: "+movieDetailResult.getBudget()+" and Revenue: "+movieDetailResult.getRevenue());
                Glide.with(binding.crMvimgPdction)
                        .load(BuildConfig.IMG_URL+"/"+movieDetailResult.getProductionCompanies().get(0).getLogoPath())
                        .fitCenter()
                        .into(binding.crMvimgPdction);

                String prd_com="Company: ";
                for (ProductionCompany p:
                        movieDetailResult.getProductionCompanies()) {

                    prd_com= prd_com+" "+p.getName();

                }
                binding.txtmoviePdction.setText(prd_com);

                String prd_con="Country: ";
                for (ProductionCountry c:
                        movieDetailResult.getProductionCountries()) {

                    prd_con= prd_con+" "+c.getName();

                }
                binding.txtCountry.setText(prd_con);

            }
        });

        model.moviedetailsMutable.observe(getViewLifecycleOwner(), new Observer<MovieDetailsData>() {
            @Override
            public void onChanged(MovieDetailsData movieDetailResult) {

            }
            });
        return binding.getRoot();
    }
}