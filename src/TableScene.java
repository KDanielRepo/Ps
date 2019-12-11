import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

import java.util.ArrayList;
import java.util.List;


public class TableScene extends BorderPane {
    TableView tableView;

    public TableScene(Scene scene,List<Arc> arcs){
        this.setPrefSize(1000,800);
        tableView = new TableView();
        final ObservableList<Arc> test2 = FXCollections.observableArrayList(arcs);
        TableColumn one = new TableColumn("S");
        one.setCellValueFactory(new PropertyValueFactory<>("s"));
        TableColumn two = new TableColumn("Ac1(i)");
        two.setCellValueFactory(new PropertyValueFactory<>("ac"));
        TableColumn three = new TableColumn("Ac2(j)");
        three.setCellValueFactory(new PropertyValueFactory<>("acc"));
        TableColumn six = new TableColumn("m(j,i)");
        six.setCellValueFactory(new PropertyValueFactory<>("m"));
        TableColumn four = new TableColumn("a(i,i)");
        four.setCellValueFactory(new PropertyValueFactory<>("a"));
        TableColumn five = new TableColumn("a(j,i)");
        five.setCellValueFactory(new PropertyValueFactory<>("aa"));
        tableView.setItems(test2);
        tableView.getColumns().addAll(one,two,three,six,four,five);

        MenuBar menuBar = new MenuBar();

        Menu menu = new Menu("menu");
        MenuItem item = new MenuItem("tabela");
        item.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MainScene mainScene = new MainScene(scene);
            }
        });
        MenuItem item1 = new MenuItem("Węzły/Łuki");
        menu.getItems().addAll(item,item1);
        menuBar.getMenus().addAll(menu);

        this.setTop(menuBar);
        this.setCenter(tableView);
        scene.setRoot(this);
    }

}
