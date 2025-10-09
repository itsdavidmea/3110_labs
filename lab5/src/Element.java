
import java.util.ArrayList;
import java.util.List;

public class Element {


    private String tag;


    private List<Element> elementContent;

    public Element(String tag) {
        this.tag = tag;
        elementContent = new ArrayList<>();


    }

    public Element(String tag, String attributes) {
        this.tag = tag;
        elementContent = new ArrayList<>();



    }

    public void addElement(Element el) {
        elementContent.add(el);


    }



    public String getTag() {
        return this.tag;
    }


    public void removeElement(Element el) {
        elementContent.remove(el);
    }

    @Override
    public String toString() {
        String subElements = "";
        if (elementContent.size() == 0) {
            return "<" + tag + ">"  + "<" + tag + "/>";
        } else {
            for (Element anElement: elementContent) {
                subElements += " \n     " + anElement.toString();
            }
        }






        return  "<" + tag + ">"  + subElements + "  " + "\n  <" + tag + "/>";



    }
}
