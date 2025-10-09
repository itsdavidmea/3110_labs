import java.util.ArrayList;
import java.util.List;

public class XML {

    private String rootName;
    private List<Element> root;

    public XML (String rootName) {
        this.rootName = rootName;
        root = new ArrayList<Element>();

    }


    public void addElementToRoot(Element el) {
        root.add(el);
    }





    public void removeElementToRoot(Element el) {
        root.remove(el);
    }


    public void print() {
            System.out.println("<" + rootName + ">");

            for(Element anElement: root) {
                System.out.println("  " + anElement.toString());
            }

            System.out.println("</" + rootName + ">");
    }
}
