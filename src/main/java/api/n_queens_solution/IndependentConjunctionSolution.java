package api.n_queens_solution;

import api.datastructure.graph.Graph;
import api.datastructure.graph.Vertex;

import java.util.HashSet;
import java.util.Set;

public class IndependentConjunctionSolution {

    private Graph<Vertex> graph;
    public IndependentConjunctionSolution(Graph<Vertex> graph) {
        this.graph = graph;
    }

    public void simpleSolutionHeuristic() {
        Graph<Vertex> residualGraph = graph.copy();
        Set<Vertex> solutionSet = new HashSet<>();




    }


}
