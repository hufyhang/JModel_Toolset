package jmodel.figure;

import jmodel.model.ActorNode;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

/**
 * Created by IntelliJ IDEA.
 * User: Feifei Hang
 * Date: 24/03/2012
 * Time: 19:09
 */
public class ActorNodeFigure extends Figure {
    private ActorNode node;

    public ActorNodeFigure(ActorNode node) {
        this.node = node;
    }

    public void update(Graphics g) {
        this.setX(this.node.getPointX());
        this.setY(this.node.getPointY());

        this.setWidth(0);
        this.setHeight(20);

        Graphics2D g2d = (Graphics2D)g;
        FontMetrics metrics = g2d.getFontMetrics();
        // int fontHeight = metrics.getHeight();
        int fontWidth;

        // check & set width
        String title = this.node.getTitle();
        fontWidth = metrics.stringWidth(title);
        this.checkWidth(fontWidth + 5);

        int x = this.getX();
        int y = this.getY();

        // add actor shape
        this.addShape(new Ellipse2D.Float(this.getX(), this.getY(), this.getWidth(), this.getHeight()));

        y += this.getHeight();
        x += this.getWidth() / 2;
        this.addShape(new Line2D.Float(x, y, x, y + this.getHeight()));
        int legY = y + this.getHeight();
        this.addShape(new Line2D.Float(x, legY, this.getX(), legY + this.getHeight()));
        this.addShape(new Line2D.Float(x, legY, this.getX() + this.getWidth(), legY + this.getHeight()));
        x = this.getX();
        y = this.getY() + this.getHeight() + 5;
        this.addShape(new Line2D.Float(x, y, x + this.getWidth(), y));

        // add title
        x = this.getX() + (this.getWidth() / 2 - fontWidth / 2);
        y = legY + this.getHeight() + 10;
        Point point = new Point(x, y);
        this.addString(title, point);
        
        this.setHeight(y - this.getY());
        this.setWidth(this.getWidth());

        this.node.setGeometry(this.getX(), this.getY(), this.getWidth(), this.getHeight());

        // add boarder
        this.addShape(new Rectangle2D.Float(this.getX(), this.getY() - 5, this.getWidth(), this.getHeight() + 10));
    }
}
