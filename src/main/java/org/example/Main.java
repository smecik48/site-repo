package org.example;

import database.DatabaseConnection;
import database.song;

import java.sql.SQLException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args){
        DatabaseConnection.connect("songs.db");
        song x = new song(49, "Krawczyk", "Parostatek", 1000);

    }
}