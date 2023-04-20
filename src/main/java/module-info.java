module joancies.vsp_calc_2.vsp_calc_2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;


    opens joancies.vsp_calc_2.vsp_calc_2 to javafx.fxml;
    exports joancies.vsp_calc_2.vsp_calc_2;
}