package elements;

import main.Main;
import utillity.Point;
import java.lang.*;
import java.util.Random;

/**
 * Created by YUSUF on 1/9/15.
 */
public class Car{
    public int number;
    public Point possition;
    public int direction;

    public Car(int number, Point p, Integer direction) {
        this.possition = p;
        this.direction = direction;
        this.number = number;
    }

    public void run() {
        if(this.direction == 1) {
            this.possition.x++;
        } else if(this.direction == 2) {
            this.possition.y++;
        } else if (this.direction ==3 ) {
            this.possition.x--;
        } else if (this.direction == 4) {
            this.possition.y--;
        }
        System.out.println("car no: " + this.number+ " " +possition.x +" " + possition.y);
        Node temp = Main.isNode(this.possition);
        if(temp != null) {
            Random randomGenerator = new Random();
            this.direction = temp.directions.get(randomGenerator.nextInt(temp.directions.size()));
        }
    }
}
