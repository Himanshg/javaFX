package com.example.sececsec;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private TextField username;

    @FXML
    private TextField password;

    private Stage primaryStage;

    @FXML
    public void validateLogin(){

        System.out.println("started");
        String username = this.username.getText();
        String password = this.password.getText();

        System.out.println("User: " + username);
        System.out.println("Pass: " + password);


        boolean loggedIn = new DBOperations().validateUsers(username,password);

        if (loggedIn) {
            // change scene
            shiftScene();
        }
        else {
            //some error
            openPopUp();
        }
    }

    public void shiftScene() {
        try {
            Parent nextScreen = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
            primaryStage.getScene().setRoot(nextScreen);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void openPopUp() {
        Stage popUpStage = new Stage();
        popUpStage.initModality(Modality.APPLICATION_MODAL);
        popUpStage.setTitle("Pop-up Window");

        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> popUpStage.close());

        StackPane layout = new StackPane();
        layout.getChildren().add(closeButton);

        Scene scene = new Scene(layout, 200, 150);
        popUpStage.setScene(scene);
        popUpStage.showAndWait();
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
}
