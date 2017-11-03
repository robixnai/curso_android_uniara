package br.com.rmoreira.app.adapters;

/**
 * Created by robsonmoreira on 10/08/17.
 */

public enum GenericType {

    LOADING("L"),
    NOT_DATA("N"),
    MOVIES("M");

    private String abbreviation;

    GenericType(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

}