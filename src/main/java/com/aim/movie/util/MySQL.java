package com.aim.movie.util;

public enum MySQL {
    URL(jdbc:mysql://localhost:3306/movie?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"),
    USER("root"),
    PASS("10011994");

    public final String value;

    private MySQL(String value) {
        this.value = value;
    }
}