package jmodel.model;

/**
 * Created by IntelliJ IDEA.
 * User: Feifei Hang
 * Date: 24/03/2012
 * Time: 19:09
 */
public class ActorNode extends Node {
    public ActorNode() {
        this.pointX = this.pointY = 0;
    }

    public ActorNode(String title, String id) {
        this();
        this.title = title;
        this.id = id;
    }
}
