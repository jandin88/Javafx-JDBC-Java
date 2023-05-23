package gui.Fxml;
import gui.util.alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class viewControler implements Initializable {
    @FXML
     private MenuItem menuItemSeller;
    @FXML

     private MenuItem menuItemDepartment;
    @FXML
     private  MenuItem menuItemAbout;

    @FXML
    public  void onMenuItemSellerAction(){
        System.out.println("onMenuItemSellerAction");
    }
    @FXML
    public  void onMenuItemDepartmentAction(){
        System.out.println("onMenuItemDepartmentAction");
    }
    @FXML
    public  void onMenuItemAboutAction(){
        System.out.println("onMenuItemAboutAction");
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {}

    private void loadView(String AbsoluteName){
        try{
            FXMLLoader loader=new FXMLLoader(getClass().getResource(AbsoluteName));
            VBox newVbox = loader.load();
        }catch (IOException e){
            alerts.showAlert("IO Excpetion",e.getMessage(), Alert.AlertType.ERROR);
        }
    }
}
