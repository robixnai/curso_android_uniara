package br.com.rmoreira.app.storages.preferences;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Objects;

import br.com.rmoreira.app.models.Genre;

/**
 * Created by robsonmoreira on 01/11/17.
 */

public final class GenresSharedPreferences {

    public static void putGenres(Context context, List<Genre> genreList) {
        Gson gson = new Gson();
        String stringGenres = gson.toJson(genreList);

        SharedPreferences sharedPref = context.getSharedPreferences("GENRES", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("GENRE_LIST", stringGenres);
        editor.commit();
    }

    public static List<Genre> getGenres(Context context) {
        SharedPreferences sharedPref = context.getSharedPreferences("GENRES", Context.MODE_PRIVATE);
        String genreList = sharedPref.getString("GENRE_LIST", null);

        if (genreList != null) {
            Gson gson = new Gson();
            Type listType = new TypeToken<List<Genre>>(){}.getType();
            return gson.fromJson(genreList, listType);
        }
        return null;
    }

    public static Genre getGenre(Context context, Integer id) {
        List<Genre> genreList = getGenres(context);
        if (genreList != null && !genreList.isEmpty()) {
            for (Genre genre : genreList) {
                if (id.equals(genre.getId()))
                    return genre;
            }
        }
        return null;
    }

}
