package sample;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class LabelWithGraphics extends Application {
    public LabelWithGraphics() {
    }

    public void start(Stage primaryStage) {
        ImageView us = new ImageView(new Image("https://www.google.be/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png"));
        Label lb1 = new Label("US\n50 States", us);
        lb1.setStyle("-fx-border-color: green; -fx-border-width: 2");
        lb1.setContentDisplay(ContentDisplay.BOTTOM);
        lb1.setTextFill(Color.RED);
        Label lb2 = new Label("Circle", new Circle(50.0D, 50.0D, 25.0D));
        lb2.setContentDisplay(ContentDisplay.TOP);
        lb2.setTextFill(Color.ORANGE);
        Label lb3 = new Label("Retangle", new Rectangle(10.0D, 10.0D, 50.0D, 25.0D));
        lb3.setContentDisplay(ContentDisplay.RIGHT);
        Label lb4 = new Label("Ellipse", new Ellipse(50.0D, 50.0D, 50.0D, 25.0D));
        lb4.setContentDisplay(ContentDisplay.LEFT);
        Ellipse ellipse = new Ellipse(50.0D, 50.0D, 50.0D, 25.0D);
        ellipse.setStroke(Color.GREEN);
        ellipse.setFill(Color.WHITE);
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(new Node[]{ellipse, new Label("JavaFX")});
        Label lb5 = new Label("A pane inside a label", stackPane);
        lb5.setContentDisplay(ContentDisplay.BOTTOM);
        HBox pane = new HBox(20.0D);
        pane.getChildren().addAll(new Node[]{lb1, lb2, lb3, lb4, lb5});
        Scene scene = new Scene(pane, 450.0D, 150.0D);
        primaryStage.setTitle("LabelWithGraphic");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
