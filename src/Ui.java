import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ui extends Application {
    Main main = new Main();

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane borderPane = new BorderPane();
        borderPane.setPrefSize(1000, 800);
        GridPane gridPane = new GridPane();

        VBox vBox = new VBox();
        TextArea size = new TextArea();
        Button random = new Button("random");
        random.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                main.fillRandom();
            }
        });
        vBox.getChildren().add(random);
        Button calculate = new Button("calculate");
        calculate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                main.setSize(Integer.parseInt(size.getText()));
                main.calculate();
            }
        });
        Button fill = new Button("fill");
        fill.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                main.fill();
            }
        });
        vBox.getChildren().add(fill);
        vBox.getChildren().add(calculate);
        borderPane.setCenter(gridPane);
        borderPane.setRight(vBox);
        Scene scene = new Scene(borderPane);
        primaryStage.setTitle("ZSI");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(Ui.class,args);
    }
}
