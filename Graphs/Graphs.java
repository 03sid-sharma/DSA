import java.util.*;

public class Graphs {
    public static void main(String[] args) {
        GraphsImplement graph = new GraphsImplement();
        graph.addNode("X");
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("P");
        // graph.addEdge("A", "B");
        // graph.addEdge("B", "D");
        // graph.addEdge("D", "C");
        // graph.addEdge("A", "C");
        graph.addEdge("X", "B");
        graph.addEdge("X", "A");
        graph.addEdge("A", "P");
        graph.addEdge("B", "P");

        System.out.println(graph.topologicalSort());
        // graph.traverseBreadthFirst("A");
        // graph.traverseDepthFirst("A");

        // graph.removeEdge("A","C");
        // graph.removeNode("B");
        // graph.print();
    }
}

class GraphsImplement {
    private class Node {
        private String label;

        public Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    private Map<String, Node> nodes = new HashMap<>();
    private Map<Node, List<Node>> adjacencyList = new HashMap<>();

    public void addNode(String label) {
        Node node = new Node(label);
        nodes.putIfAbsent(label, node);
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(String from, String to) {
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);
        if (fromNode == null || toNode == null)
            throw new IllegalArgumentException();

        adjacencyList.get(fromNode).add(toNode);
    }

    public void print() {
        for (Node source : adjacencyList.keySet()) {
            List<Node> targets = adjacencyList.get(source);
            if (!targets.isEmpty())
                System.out.println(source + " is connected to " + targets);
        }
    }

    public void removeNode(String label) {
        Node node = nodes.get(label);
        if (node == null)
            return;
        for (Node n : adjacencyList.keySet())
            adjacencyList.get(n).remove(node);

        adjacencyList.remove(node);
        nodes.remove(node);
    }

    public void removeEdge(String from, String to) {
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);
        if (fromNode == null || toNode == null)
            return;
        adjacencyList.get(fromNode).remove(toNode);
    }

    public void traverseDepthFirstRec(String root) {
        Node node = nodes.get(root);
        if (node == null)
            return;
        traverseDepthFirstRec(node, new HashSet<>());
    }

    private void traverseDepthFirstRec(Node root, Set<Node> visited) {
        System.out.println(root);
        visited.add(root);

        for (Node node : adjacencyList.get(root)) {
            if (!visited.contains(node))
                traverseDepthFirstRec(node, visited);
        }
    }

    public void traverseDepthFirst(String root) {
        Node node = nodes.get(root);
        if (node == null)
            return;

        Stack<Node> stack = new Stack<>();
        Set<Node> visited = new HashSet<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            if (visited.contains(current))
                continue;
            System.out.println(current);
            visited.add(current);

            for (Node neighbour : adjacencyList.get(current)) {
                if (!visited.contains(neighbour))
                    stack.push(neighbour);
            }
        }
    }

    public void traverseBreadthFirst(String root) {
        Node node = nodes.get(root);
        if (node == null)
            return;

        Queue<Node> queue = new ArrayDeque<>();
        Set<Node> visited = new HashSet<>();

        queue.add(node);
        while (!queue.isEmpty()) {
            Node current = queue.remove();
            if (visited.contains(current))
                continue;
            System.out.println(current);
            visited.add(current);

            for (Node neighbour : adjacencyList.get(current)) {
                if (!visited.contains(neighbour))
                    queue.add(neighbour);
            }
        }
    }

    public List<String> topologicalSort() {
        Set<Node> visited = new HashSet<>();
        Stack<Node> stack = new Stack<>();

        for (Node node : nodes.values())
            topologicalSort(node, visited, stack);

        List<String> sorted = new ArrayList<>();
        while (!stack.isEmpty()) {
            sorted.add(stack.pop().label);
        }

        return sorted;
    }

    private void topologicalSort(Node node, Set<Node> visited, Stack<Node> stack) {
        if (visited.contains(node))
            return;

        visited.add(node);

        for (Node neighbour : adjacencyList.get(node))
            topologicalSort(neighbour, visited, stack);

        stack.push(node);
    }
}