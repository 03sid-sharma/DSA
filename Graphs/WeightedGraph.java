import java.util.*;

class WG {
    public static void main(String[] args) {
        WeightedGraph wg = new WeightedGraph();
        wg.addNode("A");
        wg.addNode("B");
        wg.addNode("C");
        wg.addEdge("A", "B", 1);
        wg.addEdge("B", "C", 2);
        wg.addEdge("A", "C", 10);
        // wg.print();
        System.out.println(wg.getShortestPath("A", "C"));
    }
}

class WeightedGraph {
    private class Node {
        private String label;
        private List<Edge> edges = new ArrayList<>();

        public Node(String label) {
            this.label = label;
        }

        public void addEdge(Node to, int weight) {
            edges.add(new Edge(this, to, weight));
        }

        public List<Edge> getEdges() {
            return edges;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    private class Edge {
        private Node from;
        private Node to;
        private int weight;

        public Edge(Node from, Node to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return from + "->" + to;
        }
    }

    private Map<String, Node> nodes = new HashMap<>();

    public void addNode(String label) {
        Node node = new Node(label);
        nodes.putIfAbsent(label, node);
    }

    public void addEdge(String from, String to, int weight) {
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);
        if (fromNode == null || toNode == null)
            throw new IllegalArgumentException();

        fromNode.addEdge(toNode, weight);
        toNode.addEdge(fromNode, weight);
    }

    public void print() {
        for (Node node : nodes.values()) {
            List<Edge> edges = node.getEdges();
            if (!edges.isEmpty())
                System.out.println(node + " is connected to " + edges);
        }
    }

    private class NodeEntry {
        private Node node;
        private int priority;

        public NodeEntry(Node node, int priority) {
            this.node = node;
            this.priority = priority;
        }
    }

    class Path {
        private List<String> nodes = new ArrayList<>();
        
        
        public void add(String node) {
            nodes.add(node);
        }

        @Override
        public String toString() {
            return nodes.toString();
        }
    }

    public Path getShortestPath(String from, String to) {
        Node fromNode = nodes.get(from);
        Node toNode=nodes.get(to);

        if (fromNode == null || toNode == null)
            throw new IllegalArgumentException();

        Map<Node, Integer> distances = new HashMap<>();
        
        for (Node node : nodes.values())
            distances.put(node, Integer.MAX_VALUE);
        distances.replace(fromNode, 0);

        Map<Node, Node> previousNodes=new HashMap<>();
        Set<Node> visited = new HashSet<>();
        PriorityQueue<NodeEntry> queue = new PriorityQueue<>(Comparator.comparingInt(ne -> ne.priority));
        
        queue.add(new NodeEntry(fromNode, 0));

        while (!queue.isEmpty()) {
            Node current = queue.remove().node;
            visited.add(current);

            for (var edge : current.getEdges()) {
                if (visited.contains(edge.to))
                    continue;

                int newDistance = distances.get(current) + edge.weight;
                if (newDistance < distances.get(edge.to)) {
                    distances.replace(edge.to, newDistance);
                    previousNodes.put(edge.to,current);
                    queue.add(new NodeEntry(edge.to, newDistance));
                }
            }
        }

        return buildPath(toNode, previousNodes);
    }

    private Path buildPath(Node toNode, Map<Node, Node> previousNodes) {
        Stack<Node> stack = new Stack<>();
        stack.push(toNode);
        Node previous=previousNodes.get(toNode);
        while(previous!=null){
            stack.push(previous);
            previous=previousNodes.get(previous);
        }

        Path path=new Path();

        while(!stack.isEmpty())
            path.add(stack.pop().label);
        return path;
    }
}
