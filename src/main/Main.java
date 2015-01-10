package main;

import elements.Car;
import elements.Node;
import utillity.Point;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by YUSUF on 1/9/15.
 */
public class Main {
    public static ArrayList<Car> cars;
    public static ArrayList<Node> nodes;

    public static void main(String[] argv) {
        cars = new ArrayList<Car>();
        nodes = new ArrayList<Node>();
        generateNode();
        generateCars();
        runCars();
        Scanner scanIn = new Scanner(System.in);
        while(true) {
            int count = 0;
            int x1 = scanIn.nextInt();
            int y1 = scanIn.nextInt();
            int x2 = scanIn.nextInt();
            int y2 = scanIn.nextInt();
            if(x1 == x2) {
                if(y1 < y2) {
                    for(int j = y1; j <=y2; j++) {
                        for(int i = 0 ; i < 10 ; i++ ){
                            Point temp = cars.get(i).possition;
                            if(temp.x == x1 && temp.y == j) {
                                count++;
                            }
                        }
                    }
                } else {
                    for(int j = y2; j <=y1; j++) {
                        for(int i = 0 ; i < 10 ; i++ ){
                            Point temp = cars.get(i).possition;
                            if(temp.x == x1 && temp.y == j) {
                                count++;
                            }
                        }
                    }
                }
                System.out.println(count);
            } else if(y1 == y2) {
                if(x1 < x2) {
                    for(int j = x1; j <=x2; j++) {
                        for(int i = 0 ; i < 10 ; i++ ){
                            Point temp = cars.get(i).possition;
                            if(temp.x == j && temp.y == y1) {
                                count++;
                            }
                        }
                    }
                } else {
                    for(int j = x2; j <=x1; j++) {
                        for(int i = 0 ; i < 10 ; i++ ){
                            Point temp = cars.get(i).possition;
                            if(temp.x == j && temp.y == y1) {
                                count++;
                            }
                        }
                    }
                }
                System.out.println(count);
            } else {
                System.out.println("Wrong Input");
            }
        }
    }

    public static Node isNode(Point p) {
        for(int i=0; i<9; i++) {
            Node temp = nodes.get(i);
            if(temp.p.x == p.x && temp.p.y == p.y) {
                return temp;
            }
        }
        return null;
    }

    public static void generateNode() {
        Node n1 = new Node(new Point(0, 0), new ArrayList<Integer>(){{add(1); add(2);}});
        Node n2 = new Node(new Point(5, 0), new ArrayList<Integer>(){{add(1); add(2); add(3);}});
        Node n3 = new Node(new Point(10, 0), new ArrayList<Integer>(){{add(2); add(3);}});
        Node n4 = new Node(new Point(0, 5), new ArrayList<Integer>(){{add(1); add(2); add(4);}});
        Node n5 = new Node(new Point(5, 5), new ArrayList<Integer>(){{add(1); add(2); add(3); add(4);}});
        Node n6 = new Node(new Point(10, 5), new ArrayList<Integer>(){{add(2); add(3); add(4);}});
        Node n7 = new Node(new Point(0, 10), new ArrayList<Integer>(){{add(1); add(4);}});
        Node n8 = new Node(new Point(5, 10), new ArrayList<Integer>(){{add(1); add(3); add(4);}});
        Node n9 = new Node(new Point(10, 10), new ArrayList<Integer>(){{add(3); add(4);}});
        nodes.add(n1);
        nodes.add(n2);
        nodes.add(n3);
        nodes.add(n4);
        nodes.add(n5);
        nodes.add(n6);
        nodes.add(n7);
        nodes.add(n8);
        nodes.add(n9);
    }

    public static void generateCars() {
        Random randomGenerator = new Random();
        for(int i=0; i<10; i++) {
            Integer nodeNumber = randomGenerator.nextInt(9);
            Node temp = nodes.get(nodeNumber);
            Point p = temp.p;
            Integer direction = temp.directions.get(randomGenerator.nextInt(temp.directions.size()));
            Car c = new Car(i, new Point(p.x, p.y), direction);
            cars.add(c);
        }
    }

    public static void runCars() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    for(int i=0 ; i<10; i++) {
                        cars.get(i).run();
                    }
                    try{
                        Thread.sleep(500);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
