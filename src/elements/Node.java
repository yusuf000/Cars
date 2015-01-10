package elements;

import utillity.Point;

import java.util.ArrayList;

/**
 * Created by YUSUF on 1/9/15.
 */
public class Node {
    public Point p;
    public ArrayList<Integer> directions;

    public Node(Point p, ArrayList<Integer> d) {
        this.p = p;
        this.directions = d;
    }

}
