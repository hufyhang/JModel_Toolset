package jmodel.figure;

import java.util.ArrayList;
import java.util.Iterator;
import jmodel.model.*;
import java.awt.*;
import java.awt.geom.*;

/**
 * Created by IntelliJ IDEA. User: Feifei Hang Date: 22/03/2012 Time: 16:10
 */
public class LineConnector extends Connector {
	private Connect connect;

	public LineConnector(Connect connect, Connect.TYPE type) {
		this.connect = connect;
		this.setType(type);

		Node nodeA = this.connect.getNodeA();
		Node nodeB = this.connect.getNodeB();
		Point pointA = new Point(nodeA.getPointX() + nodeA.getWidth() / 2,
				nodeA.getPointY() + nodeA.getHeight() / 2);
		Point pointB = new Point(nodeB.getPointX() + nodeB.getWidth() / 2,
				nodeB.getPointY() + nodeB.getHeight() / 2);
		Line2D line = new Line2D.Float(pointA, pointB);
		this.connectors.add(line);
		this.setInformation(connect.getInformation(), new Point(
				(pointA.x + pointB.x) / 2, (pointA.y + pointB.y) / 2));


        // calculate the formular of connecting line.
        double a = (line.getY1() - line.getY2()) / (line.getX1() - line.getX2());
        double b = (line.getX1() * line.getY2() - line.getX2() * line.getY1()) / (line.getX1() - line.getX2());
        System.out.println("y = " + a + "x + " + b);

        double x = 0;
        double y = 0;
        if(line.getX1() < line.getX2()) {
            for(x = line.getX1(); x <= line.getX2(); ++x) {
                y = a * x + b;
                Rectangle2D nodeArea = new Rectangle2D.Double(nodeB.getPointX(), nodeB.getPointY(), nodeB.getWidth(), nodeB.getHeight());
                if(nodeArea.contains(new Point2D.Double(x, y)))
                    break;
            }
        }
        else {
            for(x = line.getX1(); x >= line.getX2(); --x) {
                y = a * x + b;
                Rectangle2D nodeArea = new Rectangle2D.Double(nodeB.getPointX(), nodeB.getPointY(), nodeB.getWidth(), nodeA.getHeight());
                if(nodeArea.contains(new Point2D.Double(x, y)))
                        break;
            }
        }

        Rectangle2D test = new Rectangle2D.Double(x - 5, y - 5, 20, 20);
        this.ends.add(test);


// 
// 
// 		// check Y asixs first
// 		for (int x = nodeB.getPointX(); x <= nodeB.getPointX() + nodeB.getWidth(); x = x + nodeB.getWidth()) {
// 			for (int y = nodeB.getPointY(); y <= nodeB.getPointY() + nodeB.getHeight(); ++y) {
// 				point = new Point2D.Double(x, y);
// 				if (line.getBounds2D().contains(point.getX(), point.getY())) {
//                     foundPoint = true;
//                     break;
//                 }
//             }
//         }
// 
//         if(!foundPoint) {
//             // check x asixs
//             for (int y = nodeB.getPointY(); y <= nodeB.getPointY() + nodeB.getHeight(); y = y + nodeB.getHeight()) {
//                 for (int x = nodeB.getPointX(); x <= nodeB.getPointX() + nodeB.getWidth(); ++x) {
//                     point = new Point2D.Double(x, y);
//                     if (line.getBounds2D().contains(point.getX(), point.getY())) {
//                         break;
//                     }
//                 }
//             }
//         }

        // this.ends.add(new Rectangle2D.Double(point.getX(), point.getY(), 10, 10));

        // double px, py;
        // px = nodeA.getPointX() - nodeB.getPointX();
        // py = nodeA.getPointY() - nodeB.getPointY();

        // px = px < 0 ? px * -1 : px;
        // py = py < 0 ? py * -1 : py;

        // px = nodeA.getPointX() < nodeB.getPointX() ? point.getX() - 10 : point.getX() + 10;
        // py = nodeA.getPointY() < nodeB.getPointY() ? point.getY() - 10 : point.getY() + 10;


        // this.ends.add(new Line2D.Double(point.getX(), point.getY(),
        //             px, py));
        // this.ends.add(new Line2D.Double(point.getX(), point.getY(),
        //             px, py));
    }
}

