import java.util.Map;

public interface Tree<T extends Comparable<T>> {

    /* ----------------------------------------------------------------   */
    /* The following methods should be implemented for this assignment.  */
    /* ----------------------------------------------------------------   */


    /** Runs project.  You will create an instance of your project in main
     *      and then have it invoke this method to begin running.
     */
    public void go();

    void find(String name); // find and print Record
    Tree<T> add(Map.Entry<String, Details> data); // add new item
    public int count();  // # of elements



    void traverseInOrder();
    void traversePreOrder();
    void traversePostOrder();

    /* These are useful output methods */
    public void greeting();  // print your name, the class, date and other useful info
    public void help(); // explain how to use this program
    public void exit(); // exit the program in a cleann way

    /** Returns your name **/
    public String getMyName();
}
