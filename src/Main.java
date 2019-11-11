import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    private int size = 0;
    private Float[][] a = new Float[size][size];
    private Float[] b = new Float[size];
    private Float[] x = new Float[size];
    public void fill(){
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.println("podaj wartosc "+i+" "+j+": ");
                a[i][j] = scanner.nextFloat();
            }
            System.out.println("podaj wartosc b "+i+": ");
            b[i]=scanner.nextFloat();
        }
    }
    public void fillRandom(){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                a[i][j] = ThreadLocalRandom.current().nextFloat()*ThreadLocalRandom.current().nextInt(1,20);
            }
            b[i]= ThreadLocalRandom.current().nextFloat()*ThreadLocalRandom.current().nextInt(1,20);
        }
    }
    public void zeroes(){
        for (int i = 0; i < size; i++) {
            for (int j = i+1; j < size; j++) {
                a[i][j]=0f;
            }
        }
    }
     public void calculate(){
         for (int i = 0; i < size; i++) {
             x[i] = b[i]/a[i][i];
             for (int j = i+1; j < size; j++) {
                 b[j] = b[j] - a[j][i] * x[i];
             }
         }
     }
     public void getA(){
         for (int i = 0; i < size; i++) {
             for (int j = 0; j < size; j++) {
                 System.out.print(a[i][j]+" ");
             }
             System.out.println("\n");
         }
     }
     public void getB(){
         for (int i = 0; i < size; i++) {
             System.out.print(b[i]+" ");
         }
         System.out.println("\n");
     }
     public void getX(){
         for (int i = 0; i < size; i++) {
             System.out.print(x[i]+" ");
         }
     }
     public void setSize(int size){
        this.size = size;
     }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println("podaj rozmiar macierzy: ");
        Scanner scanner = new Scanner(System.in);
        main.setSize(scanner.nextInt());
        main.fill();
        main.zeroes();
        main.getA();
        main.getB();
        long start = System.nanoTime();
        main.calculate();
        long end = System.nanoTime();
        long duration = (end-start);
        System.out.println(duration);
        main.getX();
    }
}
