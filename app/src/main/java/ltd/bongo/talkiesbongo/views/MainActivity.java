package ltd.bongo.talkiesbongo.views;

import static androidx.navigation.ui.NavigationUI.setupActionBarWithNavController;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;


import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;

import ltd.bongo.talkiesbongo.R;
import ltd.bongo.talkiesbongo.databinding.ActivityMainBinding;
import ltd.bongo.talkiesbongo.models.MovieResult;
import ltd.bongo.talkiesbongo.viewmodels.SharedViewModel;


public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        SharedViewModel model = new ViewModelProvider(this).get(SharedViewModel.class);
        model.getMovies(1);

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
// Instantiate the navController using the NavHostFragment
        NavController navController = navHostFragment.getNavController();
// Make sure actions in the ActionBar get propagated to the NavController
        //setupActionBarWithNavController(this, navController);
        model.movieresult.observe(this, new Observer<MovieResult>() {
            @Override
            public void onChanged(MovieResult movieResult) {
                navController.navigate(R.id.action_movieListFragment_to_movieDetailsFragment, null);
                binding.backBtn.setVisibility(View.VISIBLE);
            }
        });
        binding.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.popBackStack();
                binding.backBtn.setVisibility(View.GONE);

            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        binding.backBtn.setVisibility(View.GONE);
    }
}