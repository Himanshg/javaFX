module com.example.sececsec {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.sececsec to javafx.fxml;
    exports com.example.sececsec;
}