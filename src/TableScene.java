import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;


public class TableScene extends BorderPane {
    TableView tableView;
    TableView tableView2;
    TableView tableView3;
    TableView tableView4;
    List<Nest> combine = new ArrayList<>();
    List<Arc> arcs = new ArrayList<>();

    public TableScene(Scene scene,List<Nest> first,List<Nest> second){
        this.setPrefSize(1000,800);
        tableView = new TableView();
        final ObservableList<Nest> test2 = FXCollections.observableArrayList(first);
        TableColumn one = new TableColumn("S");
        one.setCellValueFactory(new PropertyValueFactory<>("s"));
        TableColumn two = new TableColumn("Ac1(i)");
        two.setCellValueFactory(new PropertyValueFactory<>("ac"));
        TableColumn three = new TableColumn("Ac2(j)");
        three.setCellValueFactory(new PropertyValueFactory<>("acc"));
        TableColumn six = new TableColumn("Ab(j)");
        six.setCellValueFactory(new PropertyValueFactory<>("m"));
        TableColumn four = new TableColumn("Ax(i)");
        four.setCellValueFactory(new PropertyValueFactory<>("a"));
        TableColumn five = new TableColumn("Aa(j,i)");
        five.setCellValueFactory(new PropertyValueFactory<>("aa"));
        tableView.setItems(test2);
        tableView.getColumns().addAll(one,two,three,six,four,five);


        tableView3 = new TableView();
        final ObservableList<Nest> test3 = FXCollections.observableArrayList(second);
        TableColumn oneee = new TableColumn("S");
        oneee.setCellValueFactory(new PropertyValueFactory<>("s"));
        TableColumn twooo = new TableColumn("Ac1(i)");
        twooo.setCellValueFactory(new PropertyValueFactory<>("ac"));
        TableColumn threeee = new TableColumn("Ac2(j)");
        threeee.setCellValueFactory(new PropertyValueFactory<>("acc"));
        TableColumn sixxx = new TableColumn("Ab(j)");
        sixxx.setCellValueFactory(new PropertyValueFactory<>("m"));
        TableColumn fourrr = new TableColumn("Ax(i)");
        fourrr.setCellValueFactory(new PropertyValueFactory<>("a"));
        TableColumn fiveee = new TableColumn("Aa(j,i)");
        fiveee.setCellValueFactory(new PropertyValueFactory<>("aa"));
        tableView3.setItems(test3);
        tableView3.getColumns().addAll(oneee,twooo,threeee,sixxx,fourrr,fiveee);

        /*int s = 0;
        for (int i = 0; i < first.size(); i++) {
            s++;
            combine.add(first.get(i));
            System.out.println("i: "+i);
            for (int j = i; j < first.size()-1; j++) {
                System.out.println("j: "+j);
                s++;
                combine.add(second.get(j));
            }
        }*/
        int s = 0;
        int test = 0;
        for (int i = 0; i < first.size(); i++) {
            Nest testt = first.get(i);
            testt.setS(s);
            combine.add(testt);
            s++;
            for (int j = i; j < first.size()-1; j++) {
                Nest testtt = second.get(test);
                testtt.setS(s);
                combine.add(testtt);
                test++;
                s++;
            }
        }
        tableView4 = new TableView();
        final ObservableList<Nest> test5 = FXCollections.observableArrayList(combine);
        TableColumn o = new TableColumn("S");
        o.setCellValueFactory(new PropertyValueFactory<>("s"));
        TableColumn tw = new TableColumn("Ac1(i)");
        tw.setCellValueFactory(new PropertyValueFactory<>("ac"));
        TableColumn th = new TableColumn("Ac2(j)");
        th.setCellValueFactory(new PropertyValueFactory<>("acc"));
        TableColumn si = new TableColumn("Ab(j)");
        si.setCellValueFactory(new PropertyValueFactory<>("m"));
        TableColumn fo = new TableColumn("Ax(i)");
        fo.setCellValueFactory(new PropertyValueFactory<>("a"));
        TableColumn fi = new TableColumn("Aa(j,i)");
        fi.setCellValueFactory(new PropertyValueFactory<>("aa"));
        tableView4.setItems(test5);
        tableView4.getColumns().addAll(o,tw,th,si,fo,fi);

        checkArcs(combine);

        tableView2 = new TableView();
        final ObservableList<Arc> test4 = FXCollections.observableArrayList(arcs);
        TableColumn onee = new TableColumn("S");
        onee.setCellValueFactory(new PropertyValueFactory<>("s"));
        TableColumn twoo = new TableColumn("Ac1(i)");
        twoo.setCellValueFactory(new PropertyValueFactory<>("ac"));
        TableColumn threee = new TableColumn("Ac2(j)");
        threee.setCellValueFactory(new PropertyValueFactory<>("acc"));
        TableColumn sixx = new TableColumn("from");
        sixx.setCellValueFactory(new PropertyValueFactory<>("from"));
        TableColumn fourr = new TableColumn("to");
        fourr.setCellValueFactory(new PropertyValueFactory<>("to"));
        tableView2.setItems(test4);
        tableView2.getColumns().addAll(onee,twoo,threee,sixx,fourr);
        MenuBar menuBar = new MenuBar();

        //System.out.println(arcs.get(0).getS());

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
        VBox vBox = new VBox();
        Label dzielenie = new Label("Węzły dzielenia");
        Label mnozenie = new Label("Węzły możenia/odejmowania");
        //this.setLeft(tableView3);
        vBox.getChildren().addAll(dzielenie,tableView,mnozenie,tableView3);
        this.setLeft(vBox);
        VBox vBox1 = new VBox();
        vBox1.getChildren().addAll(tableView2,tableView4);
        this.setRight(vBox1);
        scene.setRoot(this);
        //po b - poziom po x pion
    }
    public void checkArcs(List<Nest> a){
        int s = 0;
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.size(); j++) {
                //(jesli nest i.getAc == nest i+1.getAc & nest i.getAcc- nest i+1.getAcc == 1) & nest i.getA == nest i+1.getA
                //System.out.println((((a.get(i).getAcc()==a.get(j).getAcc())&&(Math.abs(a.get(i).getAc()-a.get(j).getAc())==1))&&(a.get(i).getAa().equals(a.get(j).getAa()))));

                //if a.get(i).getA()==a.get(j).getA() || a.get(i).getAa()==a.get(j).getAa();


                //czesc 3: odwzorowanie przestrzenne Fs i czasowe Ft(m - przestrzen wymiarowa (1) ,n - przestrzen grafu (2) Ft(1,n = (2)))
                //obciazenie: liczba wierzcholkow/liczba ep * T
                // macierz zaleznosci informacyjnej d1 : to - from, zawsze [01] albo [10]
                // mnozymy Fs * d1 i Fs * d2, jesli wynik zero to brak przesylu
                //najlepsze : najmniej kanałow
                String b = a.get(i).getAc()+""+a.get(i).getAcc();
                String c = a.get(j).getAc()+""+a.get(j).getAcc();
                if(Integer.parseInt(b)<Integer.parseInt(c)){
                    if((a.get(i).getA().equals(a.get(j).getA()) &&(Math.abs(a.get(i).getAcc()-a.get(j).getAcc())==1))){
                        s++;
                        b = a.get(i).getAc()+""+a.get(i).getAcc();
                        c = a.get(j).getAc()+""+a.get(j).getAcc();
                        Arc arc = new Arc(s,i,j,b,c);
                        arcs.add(arc);
                    }
                    if((a.get(i).getM().equals(a.get(j).getM()))&&(Math.abs(a.get(i).getAc()-a.get(j).getAc())==1)){
                        s++;
                        b = a.get(i).getAc()+""+a.get(i).getAcc();
                        c = a.get(j).getAc()+""+a.get(j).getAcc();
                        Arc arc = new Arc(s,i,j,b,c);
                        arcs.add(arc);
                    }
                    /*if((((a.get(i).getAc()==a.get(j).getAc())&&(Math.abs(a.get(i).getAcc()-a.get(j).getAcc())==1))&&(a.get(i).getA().equals(a.get(j).getA())))||(((a.get(i).getAcc()==a.get(j).getAcc())&&(Math.abs(a.get(i).getAc()-a.get(j).getAc())==1))&&(Math.abs(Integer.parseInt(a.get(i).getA())-Integer.parseInt(a.get(j).getA()))==11))){
                        s++;
                        b = a.get(i).getAc()+""+a.get(i).getAcc();
                        c = a.get(j).getAc()+""+a.get(j).getAcc();
                        Arc arc = new Arc(s,i,j,b,c);
                        arcs.add(arc);
                    }*/
                }
            }
        }
    }

}
