package controller;

import ba.sum.fsre.puj.pujjavafx20212022.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.korisnik;

import java.io.IOException;

public class RegisterController {
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
    private TextField faksTxt;

    @FXML
    private PasswordField passwordTxt;

    @FXML
    protected void onRegister() throws Exception {
        String name = this.nameTxt.getText().toString();
        String lastname = this.lastnameTxt.getText().toString();
        String password = this.passwordTxt.getText().toString();
        String mail = this.mailTxt.getText().toString();
        String address = this.addressTxt.getText().toString();
        String ph = this.phNumTxt.getText().toString();
        String faks = this.faksTxt.getText().toString();

        if (name.equals("") || lastname.equals("") || mail.equals("") || address.equals("") || ph.equals("") || password.equals("") || faks.equals("")){
            this.errorMsg.setText("Morate unijeti sva polja!");
        } else {
            this.errorMsg.setText("");
            korisnik k = new korisnik();
            k.setName(name);
            k.setLastName(lastname);
            k.setPassword(password);
            k.setEmail(mail);
            k.setAddress(address);
            k.setPhNumber(ph);
            k.setFakultet_fk(1);
            k.save();
            Main.showWindow(
                    "menu.fxml",
                    "Menu", 800, 600);
        }
    }
}
