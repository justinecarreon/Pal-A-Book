package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class adminController {
    @FXML
    private BorderPane borderpane;
    public void mall1(ActionEvent actionEvent) {
        loadUI("Divisoria1");
    }

    public void mall2(ActionEvent actionEvent) {
        loadUI("Divisoria2");
    }

    public void loadUI(String ui){
        Parent root = null;
        try{
            root = FXMLLoader.load(getClass().getResource(ui + ".fxml"));
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        borderpane.setCenter(root);
    }
    public void cancelButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Hackathon.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}
