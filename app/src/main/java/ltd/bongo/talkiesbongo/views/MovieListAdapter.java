package ltd.bongo.talkiesbongo.views;



import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import ltd.bongo.talkiesbongo.BuildConfig;
import ltd.bongo.talkiesbongo.R;
import ltd.bongo.talkiesbongo.databinding.ItemListRowBinding;
import ltd.bongo.talkiesbongo.models.MovieResult;
import ltd.bongo.talkiesbongo.viewmodels.SharedViewModel;


public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieListAdapterVH>{
    Context context;
    ArrayList<MovieResult> movieResults= new ArrayList<>();

    SharedViewModel model;

    public MovieListAdapter(Context context, SharedViewModel model) {
        this.context = context;
        this.model = model;

    }

    @NonNull
    @Override
    public MovieListAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListRowBinding view = ItemListRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MovieListAdapter.MovieListAdapterVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieListAdapterVH holder, int position) {
        MovieResult mItem = movieResults.get(position);
            holder.itemListRowBinding.setMovie(mItem);
//        Glide.with(holder.itemView)
//                .load(BuildConfig.IMG_URL+"/"+ movieResults.get(position).getBackdropPath())
//                .fitCenter()
//                .placeholder(context.getResources().getDrawable(R.drawable.placeholder_img))
//                .into(holder.imgItemMovieResult);
//       // holder.MovieResultName.setText(mItem.getTitle());
//        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
//        try {
//            Date yourDate = parser.parse(mItem.getReleaseDate());
//            Calendar calendar = Calendar.getInstance();
//            calendar.setTime(yourDate);
//         int ggg=   calendar.get(Calendar.YEAR);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        holder.MovieResultPrice.setText(deviceItem.getPrice()+"");
//        holder.MovieResultQuantity.setText(String.valueOf(deviceItem.getRemaining()+""));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.directionToDetailesFragment(mItem);
            }
        });

    }

    @Override
    public int getItemCount() {
        return movieResults.size();
    }

    public void setListAgain(ArrayList<MovieResult> movieResultss) {
        this.movieResults.clear();
        this.movieResults.addAll(movieResultss);
        Log.d("pagination", "movieResults: "+movieResults.size()+"api data "+movieResultss.size());
        notifyDataSetChanged();
    }

    public class MovieListAdapterVH extends RecyclerView.ViewHolder {
        ImageView imgItemMovieResult;
        TextView MovieResultName,MovieResultPrice,MovieResultQuantity,textViewQuantity;
        ItemListRowBinding itemListRowBinding;

        public MovieListAdapterVH(ItemListRowBinding itemListRowBinding) {
            super(itemListRowBinding.getRoot());
//            imgItemMovieResult= itemView.findViewById(R.id.imgItemMovieResult);
//            MovieResultName=itemView.findViewById(R.id.txt_MovieResult_name);
//            MovieResultPrice=itemView.findViewById(R.id.txt_price);
//            MovieResultQuantity=itemView.findViewById(R.id.txt_quantity);
//            textViewQuantity=itemView.findViewById(R.id.textViewQuantity);
//
//            textViewQuantity.setText("Stock");
            this.itemListRowBinding=itemListRowBinding;

        }
    }
}
