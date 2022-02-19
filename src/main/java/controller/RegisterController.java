package controller;

import ba.sum.fsre.puj.pujjavafx20212022.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;
import model.korisnik;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import static ba.sum.fsre.puj.pujjavafx20212022.Main.primaryStage;

public class RegisterController {
    Parent root;

    @FXML
    private Label errorMsg;
    @FXML
    private TextField nameTxt;
    @FXML
    private TextField lastnameTxt;
    @FXML
    private TextField mailTxt;
    @FXML
    private TextField addressTxt;
    @FXML
    private TextField phNumTxt;
    @FXML
    private TextField usernameTxt;
    @FXML
    private TextField fakultetTxt;

    @FXML
    private PasswordField passwordTxt;

    @FXML
    protected void onRegister() throws Exception {
        String name = this.nameTxt.getText().toString();
        String lastname = this.lastnameTxt.getText().toString();
        String username = this.usernameTxt.getText().toString();
        String password = this.passwordTxt.getText().toString();
        String mail = this.mailTxt.getText().toString();
        String address = this.addressTxt.getText().toString();
        String ph = this.phNumTxt.getText().toString();
        String faks = this.fakultetTxt.getText().toString();

        if (name.equals("") || lastname.equals("") || faks.equals("") || mail.equals("") || address.equals("") || ph.equals("") || password.equals("") || username.equals("")){
            this.errorMsg.setText("Morate unijeti sva polja!");
        } else {
            this.errorMsg.setText("");
            korisnik k = new korisnik();
            k.setName(name);
            k.setLastName(lastname);
            k.setUsername(username);
            k.setPassword(password);
            k.setEmail(mail);
            k.setAddress(address);
            k.setPhNumber(ph);
            if(faks.equals("FSRE"))k.setFakultet_fk(1);
            else if(faks.equals("FPMOZ"))k.setFakultet_fk(2);
            else if(faks.equals("MEFMO"))k.setFakultet_fk(3);
            else if(faks.equals("FFMO"))k.setFakultet_fk(4);
            else k.setFakultet_fk(5);
            k.save();
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("menu.fxml"));
            root = fxmlLoader.load();
            MenuController m = fxmlLoader.getController();
            m.pass(username);
            primaryStage.setScene(new Scene(root, 800, 600));
            primaryStage.setTitle("Izbornik");
            primaryStage.show();
        }
    }
}
