package cn.fufu.topo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph {
    Set<Node> vSet = new HashSet<Node>();
    Map<Node, Set<Node>> eMap = new HashMap<Node, Set<Node>>();

    boolean addNode(Node beg, Node end) {
        if (vSet.contains(beg)==false) {
            vSet.add(beg);
        }
        if (vSet.contains(end)==false) {
            vSet.add(end);
        }
        if (eMap.containsKey(beg) && eMap.get(beg).contains(end)) {
            return false;
        }
        else if (eMap.containsKey(beg)) {
            eMap.get(beg).add(end);
        }
        else {
            Set tmp = new HashSet<Node>();
            tmp.add(end);
            eMap.put(beg, tmp);
        }
        end.inDegree++;
        return true;
    }

}

class Node {
    Object val;
    int inDegree=0;
    Node(Object a) {
        this.val = a;
    }
}
