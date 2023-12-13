package api.datastructure.graph;

import java.util.Comparator;

public class VertexComparator implements Comparator<Vertex> {

    private Graph<Vertex> graph;

    public VertexComparator(Graph<Vertex> graph) {
        this.graph = graph;
    }

    @Override
    public int compare(Vertex v1, Vertex v2) {
        return Integer.compare(graph.getNeighborsCount(v1), graph.getNeighborsCount(v2));
    }

}
