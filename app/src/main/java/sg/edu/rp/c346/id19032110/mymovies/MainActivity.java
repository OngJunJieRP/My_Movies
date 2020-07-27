package sg.edu.rp.c346.id19032110.mymovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ListView lvMovies;
    ArrayList<Movie> alMovieList;
    CustomAdapter caMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMovies = findViewById(R.id.listViewMovies);
        alMovieList = new ArrayList<>();

        Calendar date1 = Calendar.getInstance();
        date1.set(2014, 11,15);

        Calendar date2 = Calendar.getInstance();
        date2.set(2015, 5, 15);

        final Movie movie1 = new Movie("The Avengers", 2012, "pg13", "Action | Sci-Fi",
                date1, "Golden Village - Bishan" ,
                "Nick Fury of S.H.I.E.L.D. assembles a team of superheroes to save the planet from Loki and his army." , 4);

        Movie movie2 = new Movie("Planes", 2013, "pg", "Animation | Comedy",
                date2, "Cathay - AMK Hub" ,
                "A crop-dusting plane with a fear of heights lives his dream of competing in a famous around-the-world aerial race." , 3);

        alMovieList.add(movie1);
        alMovieList.add(movie2);

        caMovie = new CustomAdapter(this, R.layout.row, alMovieList);
        lvMovies.setAdapter(caMovie);

        lvMovies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Movie movieSelected = alMovieList.get(position);
                String movieTitle = movieSelected.getTitle();
                int movieYear = movieSelected.getYear();
                String movieGenre = movieSelected.getGenre();
                String moviedescription = movieSelected.getDescription();
                String movieTheatre = movieSelected.getIn_theatre();
                Calendar movieWatchOn = movieSelected.getWatched_on();
                int rating = movieSelected.getRating();

                Intent intent = new Intent(MainActivity.this, MovieDetails.class);
                intent.putExtra("movieTitle", movieTitle);
                intent.putExtra("movieYear", movieYear);
                intent.putExtra("movieGenre", movieGenre);
                intent.putExtra("movieDescription" , moviedescription);
                intent.putExtra("movieTheatre" , movieTheatre);
                String createdAsString = movieWatchOn.get(Calendar.YEAR) + "/" + (movieWatchOn.get(Calendar.MONTH)+1) + "/" + movieWatchOn.get(Calendar.DATE);
                intent.putExtra("movieWatchOn", createdAsString);
                intent.putExtra("rating", rating);
                startActivity(intent);
            }
        });
    }
}
