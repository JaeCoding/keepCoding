package com.jaecoding.keep.coding.algorithm.dataStructure.graph;

import java.util.*;

/**
 * @author: 彭文杰
 * @create: 2018-09-15 16:50
 * <p>
 * 需要使用 直接将Graph类粘贴即可
 **/
public class GraphForCopy {

    public class Graph {

        private final int V; //定点的个数
        private int E;//边的个数
        private Set<Integer>[] adj;//bag数组，表示每个点的邻接表

        public int V() {
            return V;
        }//定点的个数

        public int E() {
            return E;
        }//边的个数

        public Graph(int v) {
            this.V = v;
            this.E = 0;
            for (int i = 0; i < v; i++) {
                adj[i] = new HashSet<Integer>();//初始化邻接表
            }
        }

        //图的构造
        public Graph(Scanner sc) {
            this(sc.nextInt());
            int Edge = sc.nextInt();
            for (int i = 0; i < Edge; i++) {
                int v = sc.nextInt();
                int w = sc.nextInt();
                addEdge(v, w);
            }
        }

        //图 加边
        private void addEdge(int v, int w) {
            adj[v].add(w);
            adj[w].add(v);
            E++;
        }

        //点v的邻接表
        public Iterable<Integer> adj(int v) {
            return adj[v];
        }


        /**
         * DFS 遍历搜索 图中路径
         * 用于解决 ：  寻找路径问题
         * 结果： 一个edgeTo数组，可表示s-v之间的路径
         */
        private boolean[] marked;//这个顶点上调用过dfs()了吗？
        private int[] edgeTo; //绳子的作用，表示从 起点 到i上顶点 的已知路径。
        //例如 edgeTo = {null,2,0,2,3,3}表示0从0来，1从2来，2从0来，3从2来，4从3来，5从3来。
        private int s;//起点

        public void DfsPaths(com.jaecoding.keep.coding.algorithm.dataStructure.graph.Graph G, int s) {
            marked = new boolean[G.V()];
            edgeTo = new int[G.V()];
            this.s = s;
            dfs(G, s);
        }

        private void dfs(com.jaecoding.keep.coding.algorithm.dataStructure.graph.Graph G, int v) {
            marked[v] = true;//标记遍历的起点
            for (int w : G.adj(v)
            ) {
                if (!marked[w]) {//若w点没有标记（没经历过）
                    edgeTo[w] = v;//表示 w是从v走过来的。也就是边v-w
                    dfs(G, w);
                }
            }
        }

        public boolean hasPathTo(int v) {
            return marked[v];//判断 s 能否达到 v
        }

        /**
         * 广度优先搜索
         * 用于解决：  单点最短路径问题
         * 用队列 来保存所有已经被标记过 但是其邻接表 还未被检查的顶点。
         */
        public void bfs(com.jaecoding.keep.coding.algorithm.dataStructure.graph.Graph G, int s) {
            Queue<Integer> queue = new LinkedList<>();
            marked[s] = true;//起点
            queue.offer(s);
            while (!queue.isEmpty()) {
                int v = queue.poll();//选出队列头部
                for (int w : G.adj(v)
                ) {
                    if (!marked[w]) {
                        edgeTo[w] = v;//保存 最短路径的最后 一条边，用于回溯路径
                        marked[w] = true;
                        queue.offer(w);
                    }
                }
            }
        }

        /**
         * 用于 查找 s-v的路径。 使用dfs和bfs出来的效果 会不相同
         */
        public Iterable<Integer> pathTo(int v) {
            if (!hasPathTo(v)) return null;
            Stack<Integer> path = new Stack<>();
            //从终点倒退到起点，把路径压入栈中。edgeTo[x]就表示x的上一步
            for (int x = v; x != s; x = edgeTo[x]) {
                path.push(x);
            }
            path.push(s);
            return path;
        }
    }
}
