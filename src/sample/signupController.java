package sample;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Model.User;
import sample.Services.UserServices;

import java.io.IOException;

public class signupController {
    @FXML
    private JFXTextField nameReg;
    @FXML
    private JFXPasswordField passReg;
    @FXML
    private JFXTextField bussReg;
    @FXML
    private JFXTextField userReg;


    public void register() throws Exception {
        String username = userReg.getText();
        String password = passReg.getText();
        String name = nameReg.getText();
        String businessName = bussReg.getText() ;
        User user = new User(username, password, name, businessName);


        UserServices us = new UserServices();
        us.addUser(user);
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
