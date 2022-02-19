package controller;

import ba.sum.fsre.puj.pujjavafx20212022.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import model.database;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static ba.sum.fsre.puj.pujjavafx20212022.Main.primaryStage;

public class ProfilController {
    @FXML
    protected Label imeBox;
    @FXML
    protected Label prezimeBox;
    @FXML
    protected Label usernameBox;
    @FXML
    protected Label emailBox;
    @FXML
    protected Label phBox;
    @FXML
    protected Label addressBox;

    String username;

    public void pass(String user) throws SQLException {
        this.username = user;
        this.usernameBox.setText(username);
        String SQL = "SELECT * FROM korisnik WHERE k_ime = '" + username + "'";
        Statement stmt = database.CONNECTION.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);
        while(rs.next()){
        this.imeBox.setText(rs.getString(2));
        this.prezimeBox.setText((rs.getString(3)));
        this.emailBox.setText(rs.getString(5));
        this.phBox.setText(rs.getString(7));
        this.addressBox.setText(rs.getString(8));
        }
    }

    public void povratak() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("menu.fxml"));
        Parent root = fxmlLoader.load();
        MenuController m = fxmlLoader.getController();
        m.pass(username);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.setTitle("Izbornik");
        primaryStage.show();
    }


}
