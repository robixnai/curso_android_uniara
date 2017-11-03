package br.com.rmoreira.app.models;

import java.util.ArrayList;
import java.util.List;

import br.com.rmoreira.app.R;

/**
 * Created by robsonmoreira on 20/10/17.
 */

public class MovieRepository {

    public static List<Movie> getMovieList() {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("It: A coisa", 7.4, 2017, "Aventura, Drama, Terror"));
        movies.add(new Movie("Minions", 6.4, 2015, "Família, Animação, Aventura, Co…"));
        movies.add(new Movie("Blade Runner 2049", 7.7, 2017, "Ação, Mistério, Ficção científica, …"));
        movies.add(new Movie("A Bela e a Fera", 6.8, 2017, "Família, Fantasia, Romance"));
        movies.add(new Movie("Homem-Aranha: De Volta ao Lar", 7.3, 2017, "Ação, Aventura, Comédia, Ficção"));
        movies.add(new Movie("Kingsman: O Círculo Dourado", 7.3, 2017, "Ação, Aventura, Comédia"));
        return movies;
    }

}
