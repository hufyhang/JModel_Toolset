package junit;

import jmodel.model.ClassNode;
import jmodel.model.Model;

/**
 * Created by IntelliJ IDEA.
 * User: Feifei Hang
 * Date: 20/03/2012
 * Time: 19:51
 */
public class Main {
    public static void main(String[] args) {
        ClassNode node;

        /*-Test Data-*/
        String title = "User";
        String id = "test-user0";
        Model.MODEL_TYPE type = Model.MODEL_TYPE.CLASS;
        String[] attributes = {"name", "dob", "email"};
        String[] signals = {"receive", "accept"};
        String[] attributesRemoved = {"name", "email"};
        String[] attributesAdded = {"name", "dob", "email", "mobile"};
        String[] signalsRemoved = {"receive"};
        String[] signalsAdded = {"receive", "accept", "require"};
        ///////////////
        
        node = new ClassNode(title, id, type, attributes, signals);
        node.addAttribute("mobile");
        for(String str : node.getAttributes()) {
            System.out.println(str);
        }
    }
}
