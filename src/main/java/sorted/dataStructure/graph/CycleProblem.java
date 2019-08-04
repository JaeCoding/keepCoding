package sorted.dataStructure.graph;

/**
 * @author: 彭文杰
 * @create: 2018-09-15 17:09
 * <p>
 * G是无环图吗？ （假设不存在子环或平行边）
 **/
public class CycleProblem {

    public class Cycle {
        private boolean[] marked;
        private boolean hasCycle;

        public Cycle(Graph G) {
            marked = new boolean[G.V()];
            for (int s = 0; s < G.V(); s++) {
                if (!marked[s]) {
                    dfs(G, s, s);
                }
            }
        }

        private void dfs(Graph G, int v, int u) {
            marked[v] = true;
            for (int w : G.adj(v)
            ) {
                if (!marked[w]) {
                    dfs(G, w, v);//如果v的连通点w没有标记，则dfs w v
                } else if (w != u) {//如果v的连通点w，被标记了，并且w 不等于 u
                    hasCycle = true;
                }
            }
        }

        public boolean hasCycle() {
            return hasCycle;
        }
    }

}
