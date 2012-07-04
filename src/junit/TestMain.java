package junit;

import jmodel.model.*;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import jmodel.frame.MiniFrame;

/**
 * Created by IntelliJ IDEA.
 * User: Feifei Hang
 * Date: 20/03/2012
 * Time: 21:11
 */
public class TestMain extends JFrame {
    private JPanel mainPanel;
    private JScrollPane scrollPane;
    private MiniFrame miniFrame;

    private Model model;
    ClassNode node;

    {
        System.out.println("Running...");
        miniFrame = new MiniFrame(this.getGraphics());
        this.registerEvents();

        this.scrollPane = new JScrollPane(this.miniFrame);

        this.scrollPane.setAutoscrolls(true);
        this.scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        this.scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        this.scrollPane.getViewport().add(this.miniFrame);

//        mainPanel = miniFrame;
        this.add(this.scrollPane);

        model = new Model();
        miniFrame.setModel(model);
        /*-Test Data-*/
        String title = "Person";
        String id = "test-user0";
        Model.MODEL_TYPE type = Model.MODEL_TYPE.CLASS;
        String[] attributes = {"-name:String", "-dob:Date", "-age:Integer"};
        String[] signals = {"+getName():String", "+getDoB():Date", "+getAge():Integer"};
        String[] attributesRemoved = {};
        String[] attributesAdded = {"name", "dob", "email", "mobile"};
        String[] signalsRemoved = {};
        String[] signalsAdded = {"receive", "accept", "require"};
        ///////////////

        node = new ClassNode(title, id, type, attributes, signals);
        node.setPointY(100);
        node.setPointX(200);

        model.addNode(node);
        
        
        EntityNode n = new EntityNode("GUI", "idididid");
        n.setPointX(300);
        n.setPointY(500);

        EntityNode nn = new EntityNode("Database", "id");
        nn.setPointX(200);
        nn.setPointY(500);

        PointNode pointNode = new PointNode("do something", "p-01");
        pointNode.setPointX(100);
        pointNode.setPointY(500);

        ActorNode actor = new ActorNode("Client", "clt-01");
        actor.setPointX(10);
        actor.setPointY(300);
        
        model.addNode(n);
        model.addNode(nn);
        model.addNode(pointNode);
        model.addNode(actor);
        
        model.addConnect(pointNode, n, "operates");
        model.addConnect(n, node, "contains", Connect.TYPE.DOTTED_LINEAR);
        model.addConnect(n, nn, "connects");
        model.addConnect(actor, pointNode, "invokes");
    }
    
    private void registerEvents() {
        this.miniFrame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
                try{
                    System.out.println(miniFrame.getSelectedNode().getTitle() + 
                            "=" + miniFrame.getSelectedNode().getPointX() + 
                            "," + miniFrame.getSelectedNode().getPointY());
                }
                catch (NullPointerException excpt) {
                }
            }
        });
    }

    public static void main(String args[]) {
        TestMain test = new TestMain();
        test.setDefaultCloseOperation(EXIT_ON_CLOSE);
        test.pack();
        test.setSize(800, 600);
        test.setVisible(true);
    }
}
