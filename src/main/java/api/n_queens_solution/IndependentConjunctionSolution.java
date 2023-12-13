package api.n_queens_solution;

import api.datastructure.graph.Graph;
import api.datastructure.graph.Vertex;
import api.datastructure.graph.VertexComparator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IndependentConjunctionSolution {

    private Graph<Vertex> graph;
    public IndependentConjunctionSolution(Graph<Vertex> graph) {
        this.graph = graph;
    }

    public void simpleSolutionHeuristic() {
        Graph<Vertex> residualGraph = graph.copy();
        Set<Vertex> solutionSet = new HashSet<>();


        while (!residualGraph.isEmpty()) {
            List<Vertex> vertexes = new ArrayList<>(residualGraph.getAllVertexes());
            vertexes.sort(new VertexComparator(residualGraph));

            Vertex vertexSelected = residualGraph.findVertexById(vertexes.get(0).getId());
            solutionSet.add(vertexSelected);

            markedQueenInOriginaLGraph(vertexSelected.getId());

            residualGraph.removeVertexAndNeighbors(vertexSelected);
        }


        System.out.println(solutionSet.size());
    }

    private void markedQueenInOriginaLGraph(Integer id) {
        Vertex vertexMarked = graph.findVertexById(id);
        vertexMarked.setHasQueen(true);
    }

    public void getDisplayInformation() {

        int value = (int) Math.sqrt(graph.getSize());
        int count  = 0;
        for (int i = 0; i < value; i++) {
            for (int j = 0; j < value; j++) {
                Vertex currentVertex = graph.findVertexById(count);

                if (currentVertex.hasQueen()) {
                    System.out.print("R ");
                } else {
                    System.out.print("0 ");
                }

                count++;
            }
            System.out.println();
        }

    }

}
