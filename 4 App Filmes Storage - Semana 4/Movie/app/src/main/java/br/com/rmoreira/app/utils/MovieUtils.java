package br.com.rmoreira.app.utils;

import java.util.ArrayList;
import java.util.List;

import br.com.rmoreira.app.MovieApplication;
import br.com.rmoreira.app.models.Genre;
import br.com.rmoreira.app.storages.preferences.GenresSharedPreferences;

/**
 * Created by robsonmoreira on 01/11/17.
 */

public final class MovieUtils {

    public static String getCategory(List<Integer> genresId) {
        String categoryString = "";
        List<String> categoryList = MovieUtils.getCategoryList(genresId);
        if (categoryList.size() > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < categoryList.size() - 1; i++) {
                if (!categoryList.get(i).matches(" *")) {
                    sb.append(categoryList.get(i));
                    sb.append(", ");
                }
            }
            sb.append(categoryList.get(categoryList.size() - 1).trim());
            categoryString = sb.toString();
        }
        return categoryString;
    }

    public static List<Integer> getGenres(String category) {
        List<Integer> genres = new ArrayList<>();
        String[] arrayCategory = category.split(", ");
        for (String anArrayCategory : arrayCategory) {
            Genre genre = MovieUtils.getGenre(anArrayCategory);
            if (genre != null)
                genres.add(genre.getId());
        }
        return genres;
    }

    private static List<String> getCategoryList(List<Integer> genresId) {
        List<String> categoryList = new ArrayList<>();
        if (genresId != null && !genresId.isEmpty()) {
            for (Integer id : genresId) {
                Genre genre = GenresSharedPreferences.getGenre(MovieApplication.getContext(), id);
                if (genre != null)
                    categoryList.add(genre.getName());
            }
        }
        return categoryList;
    }

    private static Genre getGenre(String genreName) {
        List<Genre> genreList = GenresSharedPreferences.getGenres(MovieApplication.getContext());
        if (genreList != null) {
            for (Genre genre : genreList) {
                if (genreName.equals(genre.getName()))
                    return genre;
            }
        }
        return null;
    }

}
