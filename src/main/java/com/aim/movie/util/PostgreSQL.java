package com.aim.movie.util;

public enum PostgreSQL {
    URL("jdbc:postgresql://localhost:5432/movie"), USER("postgres"), PASS("10011994");

    public final String value;

    private PostgreSQL(String value) {
        this.value = value;
    }
}