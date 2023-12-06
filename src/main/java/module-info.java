module com.example.sececsec {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.sececsec to javafx.fxml;
    exports com.example.sececsec;
}