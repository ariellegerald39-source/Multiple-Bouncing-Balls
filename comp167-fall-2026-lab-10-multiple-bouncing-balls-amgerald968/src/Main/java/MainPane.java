
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class MainPane extends BorderPane {

    private BouncePane bouncePane = new BouncePane();

    public MainPane() {

        setCenter(bouncePane);

        Button addBall = new Button("Add Ball");
        Button scramble = new Button("Scramble");
        Button exit = new Button("Exit");

        HBox hbox = new HBox(10);

        hbox.getChildren().add(addBall);
        hbox.getChildren().add(scramble);
        hbox.getChildren().add(exit);

        setBottom(hbox);

        addBall.setOnAction(e -> {
            bouncePane.addNewBall();
        });

        scramble.setOnAction(e -> {
            bouncePane.scramble();
        });

        exit.setOnAction(e -> {
            Platform.exit();
        });
    }
}
