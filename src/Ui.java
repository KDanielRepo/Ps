import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Ui extends Application {
    Scene pScene;
    Stage pStage;
    public static int size = 0;
    private Float[][] a;
    private Float[] b;
    private Float[] x;
    private int width;
    List<Arc> test = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) throws Exception {
        pStage = primaryStage;
        BorderPane borderPane = new BorderPane();
        borderPane.setPrefSize(1000, 800);
        Scene scene = new Scene(borderPane);
        MainScene scene1 = new MainScene(scene);
        scene1.getItem1().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TableScene tableScene = new TableScene(scene, test);
            }
        });


        scene1.getCalculate().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                a = new Float[size][size];
                b = new Float[size];
                x = new Float[size];
                setMatrix(scene1);
                fillRandom();
                calculate();
                fillXTable(scene1);
            }
        });

        scene1.getGenerate().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                createTables(size, scene1);
            }
        });

        scene1.getSetSize().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                size = Integer.parseInt(scene1.getSizeArea().getText());
                width = Integer.parseInt(scene1.getWidthArea().getText());
            }
        });
        scene1.getRandom().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                fillRandom();
            }
        });
        pScene = scene;
        primaryStage.setTitle("ZSI");
        primaryStage.setScene(pScene);
        primaryStage.show();
    }

    public void createTables(int size, MainScene mainScene) {
        for (int i = 0; i < size; i++) {
            TextArea area1 = new TextArea();
            TextArea area2 = new TextArea();
            area1.setText("0");
            area2.setText("0");
            area1.setPrefSize(50, 50);
            area2.setPrefSize(100, 50);
            area2.setEditable(false);
            mainScene.getbMatrix().add(area1, 0, i);
            mainScene.getxMatrix().add(area2, 0, i);
            for (int j = 0; j < size; j++) {
                TextArea area = new TextArea();
                area.setPrefSize(50, 50);
                area.setText("0");
                mainScene.getaMatrix().add(area, i, j);
            }
        }
    }

    public void setMatrix(MainScene mainScene) {
        TextArea aa;
        for (int i = 0; i < size; i++) {
            aa = (TextArea) mainScene.getbMatrix().getChildren().get(i);
            b[i] = Float.parseFloat(aa.getText());
            for (int j = 0; j < size; j++) {
                aa = (TextArea) mainScene.getaMatrix().getChildren().get(j + (i * size));
                a[j][i] = Float.parseFloat(aa.getText());
            }
        }
    }

    public void fillXTable(MainScene mainScene) {
        TextArea area;
        for (int i = 0; i < size; i++) {
            area = (TextArea) mainScene.getxMatrix().getChildren().get(i);
            area.setText(Float.toString(x[i]));
        }
    }

    public void calculate() {
        int s = 0;
        for (int i = 0; i < size; i++) {
            x[i] = b[i] / a[i][i];
            for (int j = i + 1; j < width; j++) {
                s++;
                b[j] = b[j] - a[j][i] * x[i];
                String a = j + " " + i;
                String b = i + " " + i;
                Arc arc = new Arc(s, i, j, a, b, a);
                test.add(arc);
            }
        }
    }

    public void fillRandom() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                a[i][j] = ThreadLocalRandom.current().nextFloat() * ThreadLocalRandom.current().nextInt(1, 20);
            }
            b[i] = ThreadLocalRandom.current().nextFloat() * ThreadLocalRandom.current().nextInt(1, 20);
        }
    }

    public static void main(String[] args) {
        launch(Ui.class, args);
    }
}

//ustaw rozmiar x - tworzy siatke x - uzupelnij siatki x - pobierz wartosc z siatki do zmiennych x - calculate x - siatka zwrotna