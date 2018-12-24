package javafxapp;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class WebTorrent extends Application{
    @Override
    public  void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("WebTorrent v1.0");
        primaryStage.setFullScreen(true);

        Label label=new Label("Hello World");
        Scene scene=new Scene(label,200,300);

        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public static void main(String[] args) {
        Application.launch(args);
    }

}
