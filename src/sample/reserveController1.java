package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class reserveController1 implements Initializable {
    @FXML
    private Label reserveLabel, Label1, Label2, Label3, Label4, Label5, Label6, Label7, Label8, Label9;
    @FXML
    private Button A1, A2, A3, A4, A5, B1, B2, B3, B4, B5;
    public void reserve(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Reservation1.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();

    }

    public void reserve2(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Reservation2.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();

    }

    public void reserve3(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Reservation3.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();

    }
    @Override
    public void initialize(URL location, ResourceBundle resources){

    }
    public void save(String text){
        reserveLabel.setText(text);
    }
    public void save1(String text){
        Label1.setText(text);
    }
    public void save2(String text){
        Label2.setText(text);
    }

}
