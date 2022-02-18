package controller;

import ba.sum.fsre.puj.pujjavafx20212022.Main;
import static ba.sum.fsre.puj.pujjavafx20212022.Main.primaryStage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.database;
import model.korisnik;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginController {
    Parent root;
    @FXML
    private Label errorMsg;

    @FXML
    private TextField emailTxt;

    @FXML
    private PasswordField passwordTxt;

    @FXML
    protected void onLogin() throws IOException {
        String email = this.emailTxt.getText().toString();
        String password = this.passwordTxt.getText().toString();
        if (email.equals("") || password.equals("")) {
            this.errorMsg.setText("Morate unijeti sva polja!");
        } else {
            try {
                String SQL = "SELECT * FROM korisnik WHERE email = '" + email + "' and lozinka = '" + password + "'";
                Statement stmt = database.CONNECTION.createStatement();
                ResultSet rs = stmt.executeQuery(SQL);
                if (rs.next()) {
                    this.errorMsg.setText("");
                    FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("menu.fxml"));
                    root = fxmlLoader.load();
                    MenuController m = fxmlLoader.getController();
                    m.pass(email);
                    primaryStage.setScene(new Scene(root, 800, 600));
                    primaryStage.setTitle("Izbornik");
                    primaryStage.show();
                }else { this.errorMsg.setText("Pogrešni podaci. Pokušajte ponovno!");}
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
            @FXML
            protected void registracija () throws IOException {
                Main.showWindow("register.fxml", "Registracija", 600, 500);
            }
        }