package controller;

import ba.sum.fsre.puj.pujjavafx20212022.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Table;
import model.database;
import model.stol;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;

import static ba.sum.fsre.puj.pujjavafx20212022.Main.primaryStage;

public class AdminPanelController implements Initializable {
    @FXML
    private TableView stoloviTbl;
    @FXML
    private TableColumn colID;
    @FXML
    private TableColumn colStatus;
    @FXML
    private TextField stolidTxt;

    String username;


    public void pass(String user) {
        this.username = user;}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.colStatus.setCellValueFactory(new PropertyValueFactory<>("name"));
        this.fillStolovi();
    }

    private void fillStolovi() {
        try {
            List<?> stoloviList = Table.list(stol.class);
            ObservableList<?> stoloviObservableList = FXCollections.observableList(stoloviList);
            this.stoloviTbl.setItems(stoloviObservableList);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @FXML
    private void oslobodi() throws SQLException {
        String id = this.stolidTxt.getText().toString();
        String SQL = "UPDATE stol SET status='Slobodan' WHERE id=" + id;
        Statement stmt = database.CONNECTION.createStatement();
        stmt.executeUpdate(SQL);
        fillStolovi();
    }
    @FXML
    private void zauzmi() throws SQLException {
        String id = this.stolidTxt.getText().toString();
        String SQL = "UPDATE stol SET status='Zauzet' WHERE id=" + id;
        Statement stmt = database.CONNECTION.createStatement();
        stmt.executeUpdate(SQL);
        fillStolovi();
    }
    public void povratak() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("menu.fxml"));
        Parent root = fxmlLoader.load();
        MenuController m = fxmlLoader.getController();
        m.pass(username);
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.setTitle("Izbornik");
        primaryStage.show();
    }
}
