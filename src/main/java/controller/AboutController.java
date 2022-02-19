package controller;

import ba.sum.fsre.puj.pujjavafx20212022.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import java.io.IOException;

import static ba.sum.fsre.puj.pujjavafx20212022.Main.primaryStage;

public class AboutController {
    @FXML
    protected Label textBox;
    String username;

    public void pass(String user) {
        this.username = user;
        this.textBox.setText("Projekt 'Online čitaonica' je aplikacija napravljena u Java programskom jeziku koja\n" +
                "olakšava život studentima i stvara mogućnost da naprave svoj dnevni raspored učenja na \n" +
                "vrijeme. Aplikacija ce sadržavati opcije kao što su:\nPregled stolova i njihovog statusa: \n" +
                "slobodan ili zauzet.\nProfil: informacije o korisniku aplikakcije koji je registriran u sustav,\n" +
                "O projektu: detaljne informacije o funkcionalnosti aplikacije i glavni ciljevi, te odjava kojim\n" +
                "se korisnik odjavljuje iz aplikacije.\n \n Cilj aplikacije je da studentima i svim ostalim koji žele \n" +
                "učiti stvara mogućnost uštede vremena, energije i mogućnost učenja u miru i tišini. ");
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
