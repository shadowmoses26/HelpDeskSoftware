package com.example.helpdesksoftware;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MainPageController implements Initializable {

    @FXML
    private Button exitButton;

    @FXML
    private Button exitButtons;

    @FXML
    private TableColumn<TableItems, String> comment;

    @FXML
    private TableColumn<TableItems, Integer> id;

    @FXML
    private TableColumn<TableItems, String> status;

    @FXML
    private TableView<TableItems> table;

    @FXML
    private TableColumn<TableItems, String> theme;

    @FXML
    private Button addButton;
    @FXML
    private TextField txtComment;

    @FXML
    private TextField txtProblem;

    @FXML
    private Button copmleteButton;

    private int idCounter = 0;


    public void exitButtonOnAction(ActionEvent e) {

        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        id.setCellValueFactory(new PropertyValueFactory<TableItems, Integer>("id"));
        theme.setCellValueFactory(new PropertyValueFactory<TableItems, String>("Theme"));
        comment.setCellValueFactory(new PropertyValueFactory<TableItems, String>("Comment"));
        status.setCellValueFactory(new PropertyValueFactory<TableItems, String>("Status"));

    }

    @FXML
    public void addButtonOnAction(ActionEvent actionEvent) {
        idCounter++;

        TableItems selectedItem = table.getSelectionModel().getSelectedItem();
        TableItems tableItems = new TableItems(txtComment.getText(), txtProblem.getText());


        tableItems.setId(idCounter);
        ObservableList<TableItems> listI = table.getItems();
        listI.add(tableItems);
        table.setItems(listI);
        table.refresh();

    }

    @FXML
    public void deleteButtonOnAction(ActionEvent actionEvent) {

        int selectedID = table.getSelectionModel().getSelectedIndex();
        table.getItems().remove(selectedID);
        updateIds();
    }

    @FXML
    public void completeButtonOnAction(ActionEvent actionEvent) {

        TableItems selectedItem = table.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            String newStatus = "Complete";
            selectedItem.setStatus(newStatus);
            table.refresh();
        }


    }

    @FXML
    public void rejectedButtonOnAction(ActionEvent actionEvent) {

        TableItems selectedItem = table.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            String newStatus = "Rejected";
            selectedItem.setStatus(newStatus);
            table.refresh();
        }
    }

    @FXML
    public void queueButtonOnActon(ActionEvent actionEvent) {

        TableItems selectedItem = table.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            String newStatus = "Queue";
            selectedItem.setStatus(newStatus);
            table.refresh();
        }
    }

    private void updateIds() {
        ObservableList<TableItems> listI = table.getItems();
        for (int i = 0; i < listI.size(); i++) {
            listI.get(i).setId(i + 1);
        }
    }

}
