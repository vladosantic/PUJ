package controller;

import ba.sum.fsre.puj.pujjavafx20212022.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.korisnik;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static ba.sum.fsre.puj.pujjavafx20212022.Main.primaryStage;

public class MenuController {
    Parent root;

    @FXML
    protected Label usernameBox;
    @FXML
    protected Label datetimeTxt;

    public String username;

    public void pass(String user) {
        this.username = user;
        this.usernameBox.setText("Dobro došli: " + user);
        this.showDate();
    }

    @FXML
    protected void odjava() throws IOException {
        Main.showWindow("login.fxml", "Prijavi se", 400, 300);
    }

    @FXML protected void profil() throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("profil.fxml"));
        root = fxmlLoader.load();
        ProfilController p = fxmlLoader.getController();
        p.pass(username);
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.setTitle("Profil");
        primaryStage.show();
    }
    @FXML protected void stolovi() throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("stolovi.fxml"));
        Parent root = fxmlLoader.load();
        StoloviController s = fxmlLoader.getController();
        s.pass(username);
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.setTitle("Pregled stolova");
        primaryStage.show();
    }
    @FXML protected void about() throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("about.fxml"));
        Parent root = fxmlLoader.load();
        AboutController a = fxmlLoader.getController();
        a.pass(username);
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.setTitle("O projektu");
        primaryStage.show();
    }
    @FXML
    void showDate () {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter datef = DateTimeFormatter.ofPattern("dd.MM.yyyy. HH:mm");
        String dt = datef.format(date);
        this.datetimeTxt.setText(dt);
    }
}
