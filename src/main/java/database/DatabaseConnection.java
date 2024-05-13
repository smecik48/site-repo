package database;

import java.sql.*;

public class DatabaseConnection {
    private static Connection connection;
    public static void connect(String path){
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:"+path);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Połączono");

    }

    public static void disconnect() throws SQLException {
        if(connection != null && !connection.isClosed()) {
            connection.close();
            System.out.println("Połączenie zostało poprawnie zamknięte!!!");
        }

    }
    public static void insertTrack(int id, String artist, String name, int duration){
        Statement insertStatement = null;
        try {
            insertStatement = connection.createStatement();
            String sb = "INSERT INTO song VALUES" +
                    String.format("(%d, '%s', '%s', '%d')", id, artist, name, duration);
            insertStatement.executeUpdate(sb);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }
    public static void readTrack(){
        try {
            Statement selectionStatement = connection.createStatement();
            String query = "SELECT title FROM song WHERE id=20;";
            ResultSet rs = selectionStatement.executeQuery(query);
            System.out.println(rs.getString("title"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static Connection getConnection() {
        return connection;
    }


}
