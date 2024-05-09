import java.util.ArrayList;

class Graphs {
    public static void main(String[] args) {
        int n = 4;

        System.out.println("Adjacency List of Lists:");

        GraphList graphList = new GraphList(n);

        graphList.addEdge(1, 2);
        graphList.addEdge(1, 3);
        graphList.addEdge(2, 4);
        graphList.addEdge(3, 4);
        graphList.printGraph();

        System.out.println();

        System.out.println("Adjacency Matrix:");

        GraphMatrix graphMatrix = new GraphMatrix(n);

        graphMatrix.addEdge(1, 2);
        graphMatrix.addEdge(1, 3);
        graphMatrix.addEdge(2, 4);
        graphMatrix.addEdge(3, 4);
        graphMatrix.printGraph();

        System.out.println();
    }
}

class GraphList {

    // Space -> O(2E)

    private ArrayList<ArrayList<Integer>> adjacencyList;

    public GraphList(int totalVertexes) {
        this.adjacencyList = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i <= totalVertexes; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int vertex1, int vertex2) {
        adjacencyList.get(vertex1).add(vertex2);
        adjacencyList.get(vertex2).add(vertex1);
    }

    public void printGraph() {
        for (int i = 0; i < adjacencyList.size(); i++) {
            ArrayList<Integer> neighbors = adjacencyList.get(i);

            System.out.print("Vertex " + i + ": " + neighbors);
            System.out.println();
        }
    }

    public ArrayList<ArrayList<Integer>> adjList() {
        return adjacencyList;
    }
}

class GraphMatrix {
    
    // Space -> O(N x M)

    private int[][] adjacencyMatrix;
    private int totalVertexes;

    public GraphMatrix(int totalVertexes) {
        this.totalVertexes = totalVertexes;
        this.adjacencyMatrix = new int[totalVertexes + 1][totalVertexes + 1];
    }

    public void addEdge(int vertex1, int vertex2) {
        adjacencyMatrix[vertex1][vertex2] = 1;
        adjacencyMatrix[vertex2][vertex1] = 1;
    }

    public void printGraph() {
        for (int i = 1; i <= totalVertexes; i++) {
            System.out.print("Vertex " + i + ": ");
            for (int j = 1; j <= totalVertexes; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}