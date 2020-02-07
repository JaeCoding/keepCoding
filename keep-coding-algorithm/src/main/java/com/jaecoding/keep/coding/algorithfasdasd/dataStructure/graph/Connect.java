package com.jaecoding.keep.coding.algorithfasdasd.dataStructure.graph;

/**
 * @author: 彭文杰
 * @create: 2018-09-15 16:26
 * <p>
 * DFS 的应用   查找连通分量 :若A与B相连，则他们的连通分量相同
 * <p>
 * 使用：需要引入Graph
 */
public class Connect {

    public class ConnectCount {
        private boolean[] marked;
        private int[] id;
        private int count;

        public ConnectCount(Graph G) {
            marked = new boolean[G.V()];
            id = new int[G.V()];//id表示每个点的连通分量id
            //s会逐个判断，当s没标记，即为发现了新的连通分量点。
            for (int s = 0; s < G.V(); s++) {
                if (!marked[s]) {
                    dfs(G, s);//！！！这一路下去 会将相连的点都标记完，并设置id为count
                    count++;//下一个连通分量id
                }
            }
        }

        private void dfs(Graph G, int v) {
            marked[v] = true;//标记此点 已遍历
            id[v] = count;//标记此点id为count
            for (int w : G.adj(v)
            ) {
                if (!marked[w]) {
                    dfs(G, w);
                }
            }
        }

        public boolean connected(int v, int w) {
            return id[v] == id[w];
        }

        public int id(int v) {
            return id[v];
        }

        public int getCount() {
            return count;
        }
    }


}
