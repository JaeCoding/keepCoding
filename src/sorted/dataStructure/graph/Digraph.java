package sorted.dataStructure.graph;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: 彭文杰
 * @create: 2018-09-16 11:33
 **/
public class Digraph {
    private final int V; //定点的个数
    private int E;//边的个数
    private Set<Integer>[] adj;//bag数组，表示每个点的邻接表

    public int V(){return V;}//定点的个数
    public int E(){return E;}//边的个数
    public Digraph(int v) {
        this.V = v;
        this.E = 0;
        for (int i = 0; i < v; i++) {
            adj[i] = new HashSet<Integer>();//初始化邻接表
        }
    }

    private void addEdge(int v, int w) {
        adj[v].add(w);
        E++;
    }
    //点v的邻接表
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public Digraph reverse() {
        Digraph R = new Digraph(V);
        for (int v = 0; v < V; v++) {
            for (int w : adj(v)
                    ) {
                R.addEdge(w, v);
            }
        }
        return R;
    }

}

class DirectedDFS {
    private boolean[] markded;

    public DirectedDFS(Digraph G, int s) {
        markded = new boolean[G.V()];
        dfs(G, s);
    }

    /**
     * 从 G 中找到 source中 所有顶点可达的 所有顶点
     * @param G
     * @param sources
     */
    public DirectedDFS(Digraph G, Iterable<Integer> sources) {
        markded = new boolean[G.V()];
        for (int s : sources
             ) {
            if (!markded[s]) {
                dfs(G, s);
            }
        }
    }

    private void dfs(Digraph G, int v) {
        markded[v] = true;
        for (int w : G.adj(v)
                ) {
            if (!markded[w]){
                dfs(G, w);}
        }
    }

    /**
     * v 是可达的吗
     */
    public boolean marked(int v) {
        return markded[v];
    }


}
