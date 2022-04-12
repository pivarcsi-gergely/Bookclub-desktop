module hu.petrik.bookclubdesktop {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;


    opens hu.petrik.bookclubdesktop to javafx.fxml, java.sql;
    exports hu.petrik.bookclubdesktop;
}