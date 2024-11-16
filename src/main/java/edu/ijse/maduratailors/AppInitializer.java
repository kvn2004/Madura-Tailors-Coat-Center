package edu.ijse.maduratailors;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class AppInitializer extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent load = FXMLLoader.load(getClass().getResource("/View/AdminLoging.fxml"));
        Scene scene = new Scene(load);
        stage.setScene(scene);
        stage.resizableProperty().setValue(Boolean.FALSE);
        Image image = new Image(getClass().getResourceAsStream("/imgAssets/images/m.png"));
        stage.getIcons().add(image);
        stage.setTitle("Madura Tailors & Coat Center");
        stage.show();

        Task<Scene> task = new Task<>() {
            @Override
            protected Scene call() throws Exception {
                FXMLLoader fxmlLoader = new FXMLLoader(AppInitializer.class.getResource("/View/DashbordPanel.fxml"));
                return new Scene(fxmlLoader.load());
            }
        };
        task.setOnSucceeded(e -> {
            Scene value =  task.getValue();
            stage.setTitle("Madura Tailors & Coat Center");
            stage.getIcons().add(new Image(getClass().getResourceAsStream("/imgAssets/images/m.png")));
            stage.setScene(value);
            stage.show();
        });

    }
}
