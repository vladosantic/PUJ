module ba.sum.fsre.puj.pujjavafx20212022 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.sql;

    opens ba.sum.fsre.puj.pujjavafx20212022 to javafx.fxml;
    opens model;
    exports ba.sum.fsre.puj.pujjavafx20212022;
    exports controller;
    opens controller to javafx.fxml;
}