package sg.edu.rp.c346.id19032110.mymovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

public class MovieDetails extends AppCompatActivity {

    TextView tvTitle;
    TextView tvYear;
    TextView tvGenre;
    TextView tvDescription;
    TextView tvWatchOn;
    TextView tvInTheatre;
    RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        tvTitle = findViewById(R.id.textViewTitle);
        tvYear = findViewById(R.id.textViewYear);
        tvGenre = findViewById(R.id.textViewGenre);
        tvDescription = findViewById(R.id.textViewDescription);
        tvWatchOn = findViewById(R.id.textViewWatchedOn);
        tvInTheatre = findViewById(R.id.textViewTheatre);
        ratingBar = findViewById(R.id.ratingBar);

        Intent intentReceived = getIntent();
        String movieTitle = intentReceived.getStringExtra("movieTitle");
        String movieYear = intentReceived.getStringExtra("movieYear");
        String movieGenre = intentReceived.getStringExtra("movieGenre");
        String movieWatchon = intentReceived.getStringExtra("movieWatchOn");
        String movieTheatre = intentReceived.getStringExtra("movieTheatre");
        String movieDescription = intentReceived.getStringExtra("movieDescription");
        int movieRating = intentReceived.getIntExtra("rating", 0);
        tvTitle.setText(movieTitle);
        tvYear.setText(movieYear);
        tvGenre.setText(movieGenre);
        tvWatchOn.setText(movieWatchon);
        tvInTheatre.setText(movieTheatre);
        tvDescription.setText(movieDescription);
        ratingBar.setRating(movieRating);
    }

}
