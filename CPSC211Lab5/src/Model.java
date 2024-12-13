
import java.util.ArrayList;
import java.util.List;

public class Model {
    private int numberOfNodes;
    private List<List<Integer>> adjacencyList;

    public Model(int numberOfNodes) {
        this.numberOfNodes = numberOfNodes;
        this.adjacencyList = new ArrayList<>();
        for (int i = 0; i < numberOfNodes; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int from, int to) {
        adjacencyList.get(from).add(to);
    }

    public boolean isSolvable() {
        boolean[] visited = new boolean[numberOfNodes];
        dfs(0, visited);
        
        for (boolean nodeVisited : visited) {
            if (!nodeVisited) {
                return false;
            }
        }
        return true;
    }

    private void dfs(int node, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : adjacencyList.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited);
            }
        }
    }

    public static Model fromInputData(List<String> inputData) {
        int numberOfNodes = Integer.parseInt(inputData.get(0));
        Model graph = new Model(numberOfNodes);

        for (int i = 1; i <= numberOfNodes; i++) {
            String[] connections = inputData.get(i).split("\\s+");
            for (String connection : connections) {
                graph.addEdge(i - 1, Integer.parseInt(connection));
            }
        }

        return graph;
    }
}

