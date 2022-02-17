package ba.sum.fsre.puj.pujjavafx20212022;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.*;

import java.io.IOException;
import java.sql.Connection;

public class Main extends Application {
    private static Stage primaryStage;

    @Override
    public void start(Stage stage) throws IOException {
        Main.primaryStage = stage;
        Main.showWindow(
                "register.fxml",
                "Registracija na sustav", 600, 450);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("register.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 190);
    }

    public static void showWindow(String viewName, String title, int w, int h) throws IOException {
        FXMLLoader root = new FXMLLoader(Main.class.getResource(viewName));
        primaryStage.setTitle(title);
        primaryStage.setScene(new Scene(root.load(), w, h));
        primaryStage.show();
    }

    public static void main(String[] args) throws Exception {
        database db = new database();
        fakultet f = new fakultet();
        korisnik k = new korisnik();
        djelatnik d = new djelatnik();
        sektor s = new sektor();
        stol st = new stol();
        rezervacija r = new rezervacija();

        f.create(fakultet.class);
        k.create(korisnik.class);
        d.create(djelatnik.class);
        s.create(sektor.class);
        st.create(stol.class);
        r.create(rezervacija.class);

        /*k.setName("Vlado");
        k.setLastName("Santic");
        k.setEmail("vlado@sum.ba");
        k.setPhNumber("063181970");
        k.setAddress("BB19a");*/
        launch();
        }
}