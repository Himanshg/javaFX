package com.example.sececsec;

import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextArea chatWindow;

    @FXML
    private TextField message;

    @FXML
    private Button sendBtn;

    @FXML
    protected void onSendButtonClick() {
        var msg = this.message.getText();
        this.chatWindow.appendText("YOU: " + msg + "\n");

        this.message.clear();

        this.messageFromFriend();

        new DBOperations().AddMessage(0, msg);
    }

    protected void messageFromFriend() {
        var msg = "Message from friend";
        this.chatWindow.appendText("FRIEND: " + msg + "\n");
    }
}