package gui.Fxml;
import Project.Main;
import gui.util.alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import model.services.DepartmentService;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

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
        loadView("/gui/FXml/DepartamentList.fxml",(DepartamentLisController controller)->{
            controller.setDepartmentService(new DepartmentService());
            controller.updateTableView();
        });
    }

    @FXML
    public  void onMenuItemAboutAction(){
       loadView("/gui/FXml/About.fxml",x->{});
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {}

    private synchronized <T> void loadView(String AbsoluteName, Consumer<T> initializingAction){
        try{
            FXMLLoader loader=new FXMLLoader(getClass().getResource(AbsoluteName));
            VBox newVbox = loader.load();

            Scene mainScene= Main.getMainScene();
            VBox mainVbox=(VBox) ((ScrollPane)mainScene.getRoot()).getContent();

            Node mainMenu= mainVbox.getChildren().get(0);
            mainVbox.getChildren().clear();
            mainVbox.getChildren().add(mainMenu);
            mainVbox.getChildren().addAll(newVbox.getChildren());

            T controller=loader.getController();
            initializingAction.accept(controller);
        }catch (IOException e){
            alerts.showAlert("IO Excpetion",e.getMessage(), Alert.AlertType.ERROR);
        }
    }

}
