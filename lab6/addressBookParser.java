
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.*;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class addressBookParser extends DefaultHandler {

    private ArrayList<BuddyInfo> buddyInfos;
    private StringBuilder elementContent;

    @Override
    public void startDocument() {
        buddyInfos = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equalsIgnoreCase("BuddyInfo")) {
            BuddyInfo currentBuddy = new BuddyInfo(null, null);
            buddyInfos.add(currentBuddy);
        }

        elementContent = new StringBuilder();
    }


    @Override
    public void characters(char[] ch, int start, int length){
        elementContent.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {

        if (qName.equalsIgnoreCase("name")) {
            buddyInfos.getLast().setName(elementContent.toString());
        } else if (qName.equalsIgnoreCase("address")) {
            buddyInfos.getLast().setAddress(elementContent.toString());
        }
    }

    public ArrayList<BuddyInfo> readXMLEmployeeFile(String fileName) throws IOException {
        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser parser = spf.newSAXParser();
            File file = new File(fileName);
            parser.parse(file, this);
            return buddyInfos;
        } catch (IOException | ParserConfigurationException | SAXException e) {
            throw new IOException(e);
        }
    }
}

