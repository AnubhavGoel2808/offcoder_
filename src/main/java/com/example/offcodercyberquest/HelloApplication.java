package com.example.offcodercyberquest;

import com.example.offcodercyberquest.queue.TaskManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private static Stage stg;
    private TaskManager manager;
    @Override
    public void start(Stage stage) {
        try {
            stg = stage;
            Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
            Scene scene = new Scene(root,685,475);
            stage.setScene(scene);
            stage.show();

            // task manager thread
            manager = new TaskManager();
            manager.setName("TASK MANAGER THREAD");
            manager.start();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    //FUNCTION TO CHANGE SCENE
    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(pane);
    }
    public static void main(String[] args) {launch(args);
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        Chrometon.getDriverInstance().quit();
    }
}