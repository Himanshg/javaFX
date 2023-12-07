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
}


