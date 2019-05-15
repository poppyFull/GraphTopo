package cn.fufu.xml;

public class testDom {
    public static void main(String[] args) {
        String file = "/Users/fu/Documents/code/data/usersInfo.xml";
        DomDemo dd = new DomDemo();
        dd.parserXml(file);
    }
}
