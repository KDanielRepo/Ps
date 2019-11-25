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

import java.util.concurrent.ThreadLocalRandom;

public class Ui extends Application {
    Main main = new Main();
    GridPane aMatrix;
    GridPane bMatrix;
    GridPane xMatrix;
    private int size = 0;
    private Float[][] a;
    private Float[] b;
    private Float[] x;
    private int width;

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane borderPane = new BorderPane();
        borderPane.setPrefSize(1000, 800);
        aMatrix = new GridPane();
        bMatrix = new GridPane();
        xMatrix = new GridPane();

        VBox vBox = new VBox();
        TextArea sizeArea = new TextArea();
        sizeArea.setPrefSize(100,100);
        TextArea widthArea = new TextArea();
        sizeArea.setPrefSize(100,100);
        Button calculate = new Button("calculate");
        calculate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                a = new Float[size][size];
                b = new Float[size];
                x = new Float[size];
                setMatrix();
                calculate();
                fillXTable();
            }
        });
        Button generate = new Button("generate tables");
        generate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                createTables(size);
            }
        });
        Button setSize = new Button("set size");
        setSize.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                size = Integer.parseInt(sizeArea.getText());
                width = Integer.parseInt(widthArea.getText());
            }
        });
        Label mA = new Label("Macierz A");
        Label mB = new Label("Macierz B");
        Label mX = new Label("Macierz X");
        vBox.getChildren().add(calculate);
        vBox.getChildren().add(setSize);
        vBox.getChildren().add(sizeArea);
        vBox.getChildren().add(generate);
        vBox.getChildren().add(widthArea);
        vBox.setPrefSize(200,500);

        VBox vBox1 = new VBox();
        vBox1.getChildren().add(mA);
        vBox1.getChildren().add(aMatrix);
        borderPane.setLeft(vBox1);

        VBox vBox2 = new VBox();
        vBox2.getChildren().add(mB);
        vBox2.getChildren().add(bMatrix);
        BorderPane.setMargin(vBox2,new Insets(0,0,0,100));
        borderPane.setCenter(vBox2);

        VBox vBox3 = new VBox();
        vBox3.getChildren().add(mX);
        vBox3.getChildren().add(xMatrix);
        borderPane.setBottom(vBox3);
        borderPane.setRight(vBox);
        Scene scene = new Scene(borderPane);
        primaryStage.setTitle("ZSI");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void createTables(int size){
        for (int i = 0; i < size; i++) {
            TextArea area1 = new TextArea();
            TextArea area2 = new TextArea();
            area1.setText("0");
            area2.setText("0");
            area1.setPrefSize(50,50);
            area2.setPrefSize(100,50);
            area2.setEditable(false);
            bMatrix.add(area1,0,i);
            xMatrix.add(area2,0,i);
            for (int j = 0; j < size; j++) {
                TextArea area = new TextArea();
                area.setPrefSize(50,50);
                area.setText("0");
                aMatrix.add(area,i,j);
            }
        }
    }
    public void setMatrix(){
        System.out.println("latafak");
        TextArea aa;
        for (int i = 0; i < size; i++) {
            aa = (TextArea) bMatrix.getChildren().get(i);
            b[i]=Float.parseFloat(aa.getText());
            for (int j = 0; j < size; j++) {
                aa = (TextArea) aMatrix.getChildren().get(j+(i*size));
                a[j][i]=Float.parseFloat(aa.getText());
            }
        }
    }
    public void fillXTable(){
        TextArea area;
        for (int i = 0; i < size; i++) {
            area = (TextArea) xMatrix.getChildren().get(i);
            area.setText(Float.toString(x[i]));
        }
    }

    public void calculate() {
        for (int i = 0; i < size; i++) {
            x[i] = b[i] / a[i][i];
            for (int j = i + 1; j < width; j++) {
                b[j] = b[j] - a[j][i] * x[i];
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
        launch(Ui.class,args);
    }
}

//ustaw rozmiar x - tworzy siatke x - uzupelnij siatki x - pobierz wartosc z siatki do zmiennych x - calculate x - siatka zwrotna