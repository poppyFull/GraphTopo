package cn.fufu.topo;

import cn.fufu.topo.Graph;
import cn.fufu.topo.KahnTopo;
import cn.fufu.topo.Node;

import java.util.List;


public class test {

    public static void main(String[] args) {
        Node n1 = new Node("n1");
        Node n2 = new Node("n2");
        Node n3 = new Node("n3");
        Node n4 = new Node("n4");
        Node n5 = new Node("n5");

        Graph ga1 = new Graph();
        ga1.addNode(n1, n2);
        ga1.addNode(n1, n4);
        ga1.addNode(n2, n3);
        ga1.addNode(n2, n4);
        ga1.addNode(n3, n5);
        ga1.addNode(n4, n3);
        ga1.addNode(n4, n5);

        Node na = new Node("a");
        Node nb = new Node("b");
        Node nc = new Node("c");
        Node nd = new Node("d");
        Node ne = new Node("e");
        Node nf = new Node("f");

        Graph ga2  = new Graph();
        ga2.addNode(na, nb);
        ga2.addNode(nb, nc);
        ga2.addNode(nb, nd);
        ga2.addNode(nc, nf);
        ga2.addNode(nd, nc);
        ga2.addNode(ne, nc);


        KahnTopo kt = new KahnTopo(ga2);
        List<Node> res = kt.topoSort();
        for (Node i: res) {
            System.out.print(i.val.toString()+" ");
        }
    }

}
