package cn.fufu.xml;


import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DomDemo implements XmlDocument {
//    private Document document;

    public void parserXml(String filePath) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(filePath);
            NodeList users = document.getChildNodes();

            for (int i = 0; i < users.getLength(); i++) {
                System.out.println("document.firstChild_i == users: " + i);
                Node user = users.item(i);
                NodeList userInfo = user.getChildNodes();

                for (int j = 0; j < userInfo.getLength(); j++) {
                    System.out.println("j " + j);
                    System.out.println("NodeName-> " + userInfo.item(j).getNodeName()
                            + "\t NodeType-> " + userInfo.item(j).getNodeType()
                            + "\t NodeValue-> " + userInfo.item(j).getNodeValue()
                            + "\t TextContent-> " + userInfo.item(j).getTextContent());

                    Node n = userInfo.item(j);
                    NodeList userMeta = n.getChildNodes();

                    for (int k = 0; k < userMeta.getLength(); k++) {
                        if (userMeta.item(k).getNodeName() != "#text") {
                            System.out.println(userMeta.item(k).getNodeName()
                                    + ": " + userMeta.item(k).getTextContent());
                        }
                    }

                    System.out.println("---------");
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
