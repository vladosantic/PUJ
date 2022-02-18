package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.korisnik;

public class MenuController {
    @FXML
    protected Label emailBox;
    @FXML
    protected Label userTxt;

    public String email;

    public void pass(String email) {
        this.email = email;
        this.emailBox.setText("Dobro došli: " + email);
    }

}
