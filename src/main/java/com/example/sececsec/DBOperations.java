package com.example.sececsec;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBOperations {

    public boolean AddMessage(int chat_id, String message) {
        try (Connection connection = MySQLConnector.connect()) {
            String query = "INSERT INTO messages (chat_id, message) VALUES (?, ?);";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, chat_id);
                preparedStatement.setString(2, message);
                int rowsInserted = preparedStatement.executeUpdate();
                if (rowsInserted > 0) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean validateUsers(String Username, String Password) {
        try (Connection connection = MySQLConnector.connect()) {
            String query = "SELECT * From user where username = ? and password = ?;";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, Username);
                preparedStatement.setString(2, Password);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    int count = 0;

                    while (resultSet.next()){
                        count++;
                    }

                    if (count == 1){
                        return true;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}


