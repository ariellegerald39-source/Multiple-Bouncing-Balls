
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage appStage) {

        MainPane mainPane = new MainPane();

        Scene scene = new Scene(mainPane, 500, 500);

        appStage.setScene(scene);
        appStage.setTitle("Multiple Bouncing Balls");
        appStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
