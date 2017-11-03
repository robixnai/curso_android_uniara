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
        movies.add(new Movie(R.drawable.a_coisa, "It: A coisa", 7.4, 2017, "Aventura, Drama, Terror", "Quando as crianças começam a desaparecer na cidade de Derry, no Maine, as crianças do bairro se unem para atacar Pennywise, um palhaço malvado, cuja história de…"));
        movies.add(new Movie(R.drawable.minions, "Minions", 6.4, 2015, "Família, Animação, Aventura, Co…", "Seres amarelos milenares, os minions têm uma missão: servir os maiores vilões. Em depressão desde a morte de seu antigo mestre, eles tentam encontrar um novo chefe.…"));
        movies.add(new Movie(R.drawable.blade_runner, "Blade Runner 2049", 7.7, 2017, "Ação, Mistério, Ficção científica, …", "Trinta anos após os acontecimentos do primeiro filme, a humanidade está novamente ameaçada, e dessa vez o perigo pode ser ainda maior. Isso porque o novato oficial…"));
        movies.add(new Movie(R.drawable.a_bela_e_a_fera, "A Bela e a Fera", 6.8, 2017, "Família, Fantasia, Romance", "Moradora de uma pequena aldeia francesa, Bela (Emma Watson) tem o pai capturado pela Fera e decide entregar sua vida ao estranho ser em troca da liberdade do progenitor.…"));
        movies.add(new Movie(R.drawable.homem_aranha, "Homem-Aranha: De Volta ao Lar", 7.3, 2017, "Ação, Aventura, Comédia, Ficção", "Depois de atuar ao lado dos Vingadores, chegou a hora do pequeno Peter Parker (Tom Holland) voltar para casa e para a sua vida, já não mais tão normal. Lutando diariamente…"));
        movies.add(new Movie(R.drawable.kingsmans, "Kingsman: O Círculo Dourado", 7.3, 2017, "Ação, Aventura, Comédia", "Um grandioso ataque destrói o quartel-general Kingsman, obrigando Eggsy (Taron Egerton), Merlin (Mark Strong) e cia a unirem forças com o equivalente estadunidense…"));
        return movies;
    }

}
