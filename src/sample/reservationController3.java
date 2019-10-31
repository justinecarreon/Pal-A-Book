package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

public class reservationController3 {

    public Label priceLbl;
    @FXML
    private Slider slider;


    public void changed() {
        int s = (int) slider.getValue();
        if(slider.getValue() == 3){
            priceLbl.setText("34,000php");
        }
        if(slider.getValue() == 6){
            priceLbl.setText("62,000php");
        }
        if(slider.getValue() == 9){
            priceLbl.setText("92,000php");
        }
        if(slider.getValue() == 12){
            priceLbl.setText("108,000php");
        }
    }
}
