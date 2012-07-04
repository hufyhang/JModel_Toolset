package jmodel.figure;

import java.awt.*;
import java.util.ArrayList;

import jmodel.model.Connect;

/**
 * Created by IntelliJ IDEA.
 * User: Feifei Hang
 * Date: 22/03/2012
 * Time: 16:06
 */
public abstract class Connector {
    private ArrayList<Connect> connects;
    ArrayList<Shape> connectors;
    ArrayList<Shape> ends;
    Connect.TYPE type;
    Point informationPoint;
    String information;

    public Connector() {
        this.connects = new ArrayList<Connect>();
        this.connectors = new ArrayList<Shape>();
        this.ends = new ArrayList<Shape>();
        this.informationPoint = new Point();
        this.information = "";
        this.type = Connect.TYPE.LINEAR;
    }

    public Connector(ArrayList<Connect> connects, String information, Point informationPoint, Connect.TYPE type) {
        this();
        this.setConnects(connects);
        this.setInformation(information);
        this.setInformationPoint(informationPoint);
        this.setType(type);
    }

    public void setType(Connect.TYPE type) {
        this.type = type;
    }

    public Connect.TYPE getType() {
        return this.type;
    }
    
    public void setInformationPoint(Point point) {
        this.informationPoint = new Point(point.x, point.y - 5);
    }

    public Point getInformationPoint() {
        return this.informationPoint;
    }
    
    public void setInformation(String information) {
        this.information = information;
    }

    public void setInformation(String information, Point point) {
        this.information = information;
        this.setInformationPoint(point);
    }

    public String getInformation() {
        return this.information;
    }
    
    public void setConnects(ArrayList<Connect> connects) {
        this.connects = connects;
    }

    public ArrayList<Shape> getConnectors() {
        return this.connectors;
    }

    public ArrayList<Shape> getEnds() {
        return this.ends;
    }
}
