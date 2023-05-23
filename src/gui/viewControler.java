package gui;
import gui.util.Constraints;
import gui.util.alerts;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class viewControler implements Initializable {
    @FXML
    private TextField txtNumber1;
    @FXML
    private TextField txtNumber2;
    @FXML
    private Label labelResult;
    @FXML
    private Button btSum;


    public void onButtonSumAction(){
        try {
            Double number1 = Double.parseDouble(txtNumber1.getText());
            Double number2 = Double.parseDouble(txtNumber2.getText());

            double sum = number1 + number2;
            labelResult.setText(String.format("%.2f", sum));
        }catch (NumberFormatException e){
            alerts.showAlert("ERROR",e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Constraints.setTextFieldDouble(txtNumber1);
        Constraints.setTextFieldDouble(txtNumber2);
        Constraints.setTextFieldMaxLength(txtNumber1,12);
        Constraints.setTextFieldMaxLength(txtNumber2,12);
    }
}
