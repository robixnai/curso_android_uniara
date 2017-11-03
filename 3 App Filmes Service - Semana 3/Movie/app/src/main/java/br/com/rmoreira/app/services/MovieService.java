package br.com.rmoreira.app.services;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;

import br.com.rmoreira.app.models.Movie;
import br.com.rmoreira.app.models.Results;
import br.com.rmoreira.app.models.Trailer;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by robsonmoreira on 25/10/17.
 */

public class MovieService {

    private static String BASE_URL = "https://api.themoviedb.org/3/";
    private static String API_KEY = "71e643f4466eb4e93765694f617e6aea";
    private static String LANGUAGE = "pt-BR";

    private static OkHttpClient client = new OkHttpClient();

    private static String query() {
        return "?api_key=".concat(API_KEY).concat("&language=").concat(LANGUAGE);
    }

    private static String getUrl(String endPoint) {
        return BASE_URL.concat(endPoint).concat(query());
    }

    public static Results<Movie> getPopularMovies(int page) throws IOException {
        Request request = new Request.Builder()
                .url(getUrl("movie/popular").concat("&page=").concat(String.valueOf(page)))
                .build();

        Response response = client.newCall(request).execute();
        String string = response.body().string();

        Results<Movie> movieList = null;
        if (response.isSuccessful()) {
            Type listType = new TypeToken<Results<Movie>>(){}.getType();
            movieList = new Gson().fromJson(string, listType);
        }
        return movieList;
    }

    public static Results<Trailer> getMovieTrailers(Integer id) throws IOException {
        String endPoint = "movie/".concat(id.toString()).concat("/videos");
        Request request = new Request.Builder()
                .url(getUrl(endPoint))
                .build();

        Response response = client.newCall(request).execute();
        String string = response.body().string();

        Results<Trailer> traileList = null;
        if (response.isSuccessful()) {
            Type listType = new TypeToken<Results<Trailer>>(){}.getType();
            traileList = new Gson().fromJson(string, listType);
        }
        return traileList;
    }

}
