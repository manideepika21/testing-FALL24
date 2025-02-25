import java.util.Arrays;
import java.util.Set;

public class Graph {
    // the number of nodes in the graph
    private int nodeCount;

    // edges[i][j] == true iff there is an edge from node i to node j
    // in "this" graph
    private boolean[][] edges;

    // class invariant: "edges" is non-null;
    //                  "edges" is a square matrix;
    //                  "nodeCount" is the number of rows in "edges"

    public Graph(int size) {
        if (size < 0) throw new IllegalArgumentException("Size must be non-negative");
        this.nodeCount = size;
        //this.edges = new boolean[size][size];
    }

    public String toString() {
        return "nodeCount: " + nodeCount + "\n" + "edges: "
            + Arrays.deepToString(edges);
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Graph)) return false;
        Graph other = (Graph) o;
        return this.nodeCount == other.nodeCount && Arrays.deepEquals(this.edges, other.edges);
    }

    public void insertEdge(int from, int to) {
        if (from < 0 || from >= nodeCount || to < 0 || to >= nodeCount) {
            throw new IllegalArgumentException("Node indices out of bounds");
        }
        edges[from][to] = true;
    }

    public boolean isReachable(Set<Integer> sources, Set<Integer> targets) {
        if (sources == null || targets == null)
            throw new IllegalArgumentException("Sources and targets must not be null");

        for (int source : sources) {
            if (source < 0 || source >= nodeCount) {
                return false;
            }
        }

        for (int target : targets) {
            if (target < 0 || target >= nodeCount) {
                return false;
            }
        }

        for (int target : targets) {
            boolean foundPath = false;
            for (int source : sources) {
                if (dfs(source, target, new boolean[nodeCount])) {
                    foundPath = true;
                    break;
                }
            }
            if (!foundPath) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int current, int target, boolean[] visited) {
        if (current == target) return true;
        visited[current] = true;
        for (int i = 0; i < nodeCount; i++) {
            if (edges[current][i] && !visited[i]) {
                if (dfs(i, target, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
}
