package gui.Fxml;

import Project.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Departament;
import model.services.DepartmentService;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class DepartamentLisController implements Initializable {

    private DepartmentService service;

    @FXML
    private TableView<Departament> tableViewDepartment;

    @FXML
    private TableColumn<Departament, Integer> tableColumnId;

    @FXML
    private TableColumn<Departament, String> tableColumnName;

    @FXML
    private Button btNew;

    private ObservableList<Departament> obsList;

    @FXML
    private void onBtNewAction(){
        System.out.println("onBtNewAction");
    }

    public void setDepartmentService(DepartmentService service){
        this.service=service;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initializeNodes();
    }


    private  void initializeNodes(){
        tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));

        Stage stage = (Stage) Main.getMainScene().getWindow();
        tableViewDepartment.prefHeightProperty().bind(stage.heightProperty());

    }
    public void updateTableView(){
        if (service==null){
            throw new IllegalStateException("Service was null");
        }
        List<Departament> list=service.findAll();
        obsList= FXCollections.observableList(list);
        tableViewDepartment.setItems(obsList);
    }
}
