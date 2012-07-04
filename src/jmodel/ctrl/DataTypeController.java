package jmodel.ctrl;

/**
 * Created by IntelliJ IDEA.
 * User: Feifei Hang
 * Date: 20/03/2012
 * Time: 18:09
 */
public class DataTypeController {
    public static void addItemIntoArray(Object[] array, Object item) {
        int currentLength = array.length;
        Object[] newArray = new Object[currentLength + 1];
        int index = 0;
        for(Object obj : array) {
            newArray[index++] = obj;
        }
        newArray[index] = item;
        array = newArray;
    }
    
    public static boolean removeItemFromArray(Object[] array, int index) {
        boolean result = true;
        if(index > array.length - 1) {
            result = false;
        }
        // if the original array contains only one item
        else if(array.length == 1) {
            array = new Object[0];
        }
        else {
            Object[] newArray = new Object[array.length - 1];
            
            // when removing the first item
            if(index == 0) {
                for(int i = 1; i != array.length; ++i) {
                    newArray[i] = array[i];
                }
            }
            // when removing the last item
            else if(index == array.length - 1) {
                for(int i = 0; i != array.length - 1; ++i) {
                    newArray[i] = array[i];
                }
            }
            // when removing the item that is neither the first nor the last one
            else {
                for(int i = 0; i != index; ++i) {
                    newArray[i] = array[i];
                }
                for(int i = index + 1; i != newArray.length; ++i) {
                    newArray[i] = array[i];
                }
            }
            array = newArray;
        }
        return result;
    }
}
