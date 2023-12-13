package api.datastructure.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph<K extends Vertex> {

    private final Map<K, Set<K>> elements = new HashMap<>();

    public Graph() {

    }

    public void addVertex(K vertex) {
        if (vertex == null) {
            throw new IllegalArgumentException("Vértice inserido não pode ser nulo");
        }
        Set<K> edges = new HashSet<>();
        setVertexAndEdges(vertex, edges);
    }

    public void addEdge(K origin, K destination) {
        if (elements.get(origin) == null || elements.get(destination) == null) {
            throw new IllegalArgumentException("Tentativa de inserção de aresta inválida");
        }

        Set<K> edges = getEdges(origin);
        edges.add(destination);

        Set<K> neighborEdges = getEdges(destination);
        neighborEdges.add(origin);
    }

    public long getNeighborsCount(K vertex) {
        Set<K> vertexEdges = getEdges(vertex);

        if (vertexEdges == null) {
            return 0;
        }

        return vertexEdges.size();
    }

    public Set<K> getEdges(K vertex) {
        return elements.get(vertex);
    }

    public void setVertexAndEdges(K vertex, Set<K> edges) {
        this.elements.put(vertex, edges);
    }
    public K findVertexById(int sourceVertexId) {
        for (K currentVertex : elements.keySet()) {
            if (currentVertex.getId().equals(sourceVertexId)) {
                return currentVertex;
            }
        }
        return null;
    }

    public Graph<K> copy() {
        Graph<K> copyGraph = new Graph<>();

        for (K currentVertex : elements.keySet()) {
            Set<K> edges = getEdges(currentVertex);
            copyGraph.setVertexAndEdges(currentVertex, edges);
        }

        return copyGraph;
    }
}
