package br.com.rmoreira.app.adapters;

/**
 * Created by robsonmoreira on 10/08/17.
 */

public enum GenericType {

    LOADING("L"),
    MOVIES("M");

    private String abbreviation;

    GenericType(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

}