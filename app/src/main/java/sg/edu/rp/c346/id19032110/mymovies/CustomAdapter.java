package sg.edu.rp.c346.id19032110.mymovies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<Movie> movieList;

    public CustomAdapter(Context context, int resource, ArrayList<Movie> objects){
        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        movieList = objects;
    }

    public View getView (int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(layout_id, parent, false);

        TextView tvTitle = rowView.findViewById(R.id.textViewTitle);
        TextView tvYear = rowView.findViewById(R.id.textViewYear);
        TextView tvGenre = rowView.findViewById(R.id.textViewGenre);
        ImageView ivRated = rowView.findViewById(R.id.imageViewRated);

        Movie currentMovie = movieList.get(position);
        tvTitle.setText(currentMovie.getTitle());
        tvYear.setText(currentMovie.getYear() + " ~ ");
        tvGenre.setText(currentMovie.getGenre());

        if (currentMovie.getRated() == "g"){
            ivRated.setImageResource(R.drawable.rating_g);
        }
        else if (currentMovie.getRated() == "pg"){
            ivRated.setImageResource(R.drawable.rating_pg);
        }
        else if (currentMovie.getRated() == "pg13"){
            ivRated.setImageResource(R.drawable.rating_pg13);
        }
        else if (currentMovie.getRated() == "nc16") {
            ivRated.setImageResource(R.drawable.rating_nc16);
        }
        else if (currentMovie.getRated() == "m18") {
            ivRated.setImageResource(R.drawable.rating_m18);
        }
        else if (currentMovie.getRated() == "r21") {
            ivRated.setImageResource(R.drawable.rating_r21);
        }

        if (currentMovie.getYear() == 2020) {
            tvTitle.setTextColor(android.R.color.holo_red_dark);
        }
        return rowView;
    }
}
