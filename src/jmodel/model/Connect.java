package jmodel.model;

/**
 * Created by IntelliJ IDEA. User: Feifei Hang Date: 22/03/2012 Time: 15:52
 */
public class Connect {
    public static enum TYPE {
        LINEAR, DOTTED_LINEAR
    };

    private Node nodeA, nodeB;
    private String information;
    private TYPE type;

    // TODO: connect type

    public Connect(Node nodeA, Node nodeB) {
        this.nodeA = nodeA;
        this.nodeB = nodeB;
        this.information = "";
        this.type = TYPE.LINEAR;
    }

    public Connect(Node nodeA, Node nodeB, String information) {
        this(nodeA, nodeB);
        this.information = information;
    }

    public Connect(Node nodeA, Node nodeB, String information, TYPE type) {
        this(nodeA, nodeB, information);
        this.setType(type);
    }

    public void setType(TYPE type) {
        this.type = type;
    }

    public TYPE getType() {
        return this.type;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getInformation() {
        return this.information;
    }

    public void setNodeA(Node node) {
        this.nodeA = node;
    }

    public void setNodeB(Node node) {
        this.nodeB = node;
    }

    public Node[] getNodes() {
        Node[] nodes = { nodeA, nodeB };
        return nodes;
    }

    public Node getNodeA() {
        return this.nodeA;
    }

    public Node getNodeB() {
        return this.nodeB;
    }
}
