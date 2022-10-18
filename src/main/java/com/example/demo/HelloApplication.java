package com.example.demo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) {
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20));
        Button bt = new Button("Get State");
        bt.setTranslateX(100);

        GridPane pane = new GridPane();
        pane.setHgap(80);
        pane.setVgap(20);
        vbox.getChildren().addAll(pane, bt);

        Label lbl1 = new Label("CheckBox State");
        Label lbl2 = new Label("ComboBox State");
        Label lbl3 = new Label("Radio Button State");

        TextField txt1 = new TextField();
        TextField txt2 = new TextField();
        TextField txt3 = new TextField();

        CheckBox ckb1 = new CheckBox("driver");
        CheckBox ckb2 = new CheckBox("passenger");

        ComboBox cbo = new ComboBox();
        cbo.getItems().addAll("Swimming", "Football", "Volleyball");
        pane.addColumn(0, lbl1, lbl2, lbl3, ckb1, ckb2, cbo);

        RadioButton rdb1 = new RadioButton("Married");
        RadioButton rdb2 = new RadioButton("Single");
        RadioButton rdb3 = new RadioButton("Divorced");
        ToggleGroup tlg = new ToggleGroup();
        rdb1.setToggleGroup(tlg);
        rdb2.setToggleGroup(tlg);
        rdb3.setToggleGroup(tlg);
        pane.addColumn(1, txt1, txt2, txt3, rdb1, rdb2, rdb3);

        bt.setOnAction(e -> {
            if (ckb1.isSelected() && ckb2.isSelected())
                txt1.setText(ckb1.getText() + " " + ckb2.getText());
            else if (ckb1.isSelected())
                txt1.setText(ckb1.getText());
            else if (ckb2.isSelected())
                txt1.setText(ckb2.getText());

            txt2.setText(
                    cbo.getSelectionModel().getSelectedItem().toString()
            );

            if (rdb1.isSelected())
                txt3.setText(rdb1.getText());
            else if (rdb1.isSelected())
                txt3.setText(rdb2.getText());
            else
                txt3.setText(rdb3.getText());
        });

        Scene scene = new Scene(vbox);
        stage.setScene(scene);
        stage.setTitle("Ma420@");
        stage.show();


    }

    public static void main(String[] args) {
        launch();
    }
}