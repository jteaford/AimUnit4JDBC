package com.aim.movie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{

    private static final String URL = "jdbc:mysql://localhost:3306/movie?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "10011994";

    public static void main( String[] args )
    {
        try {
        
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a movie title: ");
        String movieTitle = input.nextLine();

       input.close();

       String sql = "select movie_name, first_name, last_name from movies m " +
                    "join directors d on d.director_id = m.director_id where m.movie_name = '" + movieTitle + " ';";

        StringBuilder sql2 = new StringBuilder();
        sql2.append("select m.movie_name, d.first_name, d.last_name, r.rating ");
        sql2.append("from movies m ");
        sql2.append("join directors d on d.director_id = m.director_id ");
        sql2.append("join ratings r on r.rating_id = m.rating_id ");
        sql2.append("where m.movie_name = '" + movieTitle + "';");
        
        Connection connection = DriverManager.getConnection(URL, USER, PASS);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement
            .executeQuery(sql2.toString());

        while (resultSet.next()){
            String movieName = resultSet.getString("m.movie_name");
            System.out.println("Movie Title: " + movieName);

            String directorsFirstName = resultSet.getString("d.first_name");
            String directorsLastName = resultSet.getString("d.last_name");
            System.out.println("Director's Name: " + directorsFirstName + " " + directorsLastName);

            System.out.println("Rating: " + resultSet.getString("r.rating"));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    }
}
