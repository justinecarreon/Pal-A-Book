package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

public class reservationController2 {

    public Label priceLbl;
    @FXML
    private Slider slider;


    public void changed() {
        int s = (int) slider.getValue();
        if (slider.getValue() == 3) {
            priceLbl.setText("32,000php");
        }
        if (slider.getValue() == 6) {
            priceLbl.setText("60,000php");
        }
        if (slider.getValue() == 9) {
            priceLbl.setText("90,000php");
        }
        if (slider.getValue() == 12) {
            priceLbl.setText("106,000php");
        }

    }

    public void reserve(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Divisoria1.fxml"));
            Parent root = fxmlLoader.load();
            reserveController1 resController = fxmlLoader.getController();
            resController.save1("Reserved");
            Scene scene = new Scene(root);
            Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
        } catch (Exception e) {
            e.getMessage();
        }


    }


}
