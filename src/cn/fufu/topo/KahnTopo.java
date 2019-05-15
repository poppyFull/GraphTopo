package cn.fufu.topo;

import cn.fufu.topo.Graph;
import cn.fufu.topo.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KahnTopo {
    Graph ga;
    Queue<Node> zeroIndegreeV;
    List<Node> res;

    KahnTopo(Graph ga) {
        this.ga = ga;
        this.zeroIndegreeV = new LinkedList<Node>();
        this.res = new ArrayList<Node>();
        for (Node v: this.ga.vSet) {
            if (v.inDegree == 0)
                this.zeroIndegreeV.add(v);
        }
    }

    List<Node> topoSort() {
        while (zeroIndegreeV.isEmpty() == false) {
            Node curV = zeroIndegreeV.poll();
            res.add(curV);
            if (ga.eMap.keySet().isEmpty())
                return res;
            for (Node v: ga.eMap.get(curV)) {
                v.inDegree--;
                if (v.inDegree == 0)
                    zeroIndegreeV.add(v);
            }
            ga.vSet.remove(curV);
            ga.eMap.remove(curV);
        }
        if (ga.vSet.isEmpty() == false)
            throw new IllegalArgumentException("Has Cycle !");
        return res;
    }

}
