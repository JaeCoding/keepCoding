package com.jaecoding.keep.coding.algorithfasdasd.dataStructure.graph;

/**
 * @author: 彭文杰
 * @create: 2018-09-15 17:19
 * <p>
 * G是二分图吗？  双色问题：任意一条边的两个端点都不同。  例如电影与演员关系图。电影之间和演员之间不会相连。
 **/
public class TwoColorProblem {

    public class TowColor {
        private boolean[] marked;
        private boolean[] color;
        private boolean isTwoColorable = true;

        public TowColor(Graph G) {
            marked = new boolean[G.V()];
            color = new boolean[G.V()];//表示每个点的属性
            for (int s = 0; s < G.V(); s++) {
                if (!marked[s]) {
                    dfs(G, s);
                }
            }
        }

        private void dfs(Graph G, int v) {
            marked[v] = true;//标记此点 已遍历
            for (int w : G.adj(v)
            ) {
                if (!marked[w]) {
                    color[w] = !color[v];
                    dfs(G, w);
                } else if (color[w] == color[v]) {//如果v的连通点w，被标记了，并且w颜色和v不同
                    isTwoColorable = false;
                }
            }
        }

        public boolean isTwoColor() {
            return isTwoColorable;
        }
    }
}
