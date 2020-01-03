import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class MainScene extends BorderPane {
    Button calculate;
    Button generate;
    Button setSize;
    Button random;
    GridPane aMatrix;
    GridPane bMatrix;
    GridPane xMatrix;
    TextField sizeArea;
    TextField widthArea;
    MenuItem item1;


    public MainScene(Scene scene){
        this.setPrefSize(1000,800);
        aMatrix = new GridPane();
        bMatrix = new GridPane();
        xMatrix = new GridPane();
        VBox vBox = new VBox();
        sizeArea = new TextField();
        sizeArea.setText("5");
        sizeArea.setPrefSize(100,100);
        widthArea = new TextField();
        widthArea.setText("5");
        sizeArea.setPrefSize(100,100);
        calculate = new Button("calculate");
        generate = new Button("generate tables");
        setSize = new Button("set size");

        Label mA = new Label("Macierz A");
        Label mB = new Label("Macierz B");
        Label mX = new Label("Macierz X");
        random = new Button("random");
        random.setPrefSize(100,100);
        vBox.getChildren().add(calculate);
        vBox.getChildren().add(setSize);
        vBox.getChildren().add(sizeArea);
        vBox.getChildren().add(generate);
        vBox.getChildren().add(widthArea);
        vBox.getChildren().add(random);
        vBox.setPrefSize(200,500);

        VBox vBox1 = new VBox();
        vBox1.getChildren().add(mA);
        vBox1.getChildren().add(aMatrix);
        this.setLeft(vBox1);

        VBox vBox2 = new VBox();
        vBox2.getChildren().add(mB);
        vBox2.getChildren().add(bMatrix);
        BorderPane.setMargin(vBox2,new Insets(0,0,0,100));
        this.setCenter(vBox2);

        VBox vBox3 = new VBox();
        vBox3.getChildren().add(mX);
        vBox3.getChildren().add(xMatrix);

        MenuBar menuBar = new MenuBar();

        Menu menu = new Menu("menu");
        MenuItem item = new MenuItem("tabela");
        item1 = new MenuItem("Węzły/Łuki");
        menu.getItems().addAll(item,item1);
        menuBar.getMenus().addAll(menu);

        this.setTop(menuBar);
        this.setBottom(vBox3);
        this.setRight(vBox);
        scene.setRoot(this);
    }
    public Button getCalculate() {
        return calculate;
    }

    public void setCalculate(Button calculate) {
        this.calculate = calculate;
    }
    public Button getGenerate() {
        return generate;
    }

    public void setGenerate(Button generate) {
        this.generate = generate;
    }

    public Button getSetSize() {
        return setSize;
    }

    public void setSetSize(Button setSize) {
        this.setSize = setSize;
    }

    public GridPane getaMatrix() {
        return aMatrix;
    }

    public void setaMatrix(GridPane aMatrix) {
        this.aMatrix = aMatrix;
    }

    public GridPane getbMatrix() {
        return bMatrix;
    }

    public void setbMatrix(GridPane bMatrix) {
        this.bMatrix = bMatrix;
    }

    public GridPane getxMatrix() {
        return xMatrix;
    }

    public void setxMatrix(GridPane xMatrix) {
        this.xMatrix = xMatrix;
    }
    public TextField getSizeArea() {
        return sizeArea;
    }

    public void setSizeArea(TextField sizeArea) {
        this.sizeArea = sizeArea;
    }

    public TextField getWidthArea() {
        return widthArea;
    }

    public void setWidthArea(TextField widthArea) {
        this.widthArea = widthArea;
    }
    public MenuItem getItem1() {
        return item1;
    }

    public void setItem1(MenuItem item1) {
        this.item1 = item1;
    }

    public Button getRandom() {
        return random;
    }

    public void setRandom(Button random) {
        this.random = random;
    }
}
