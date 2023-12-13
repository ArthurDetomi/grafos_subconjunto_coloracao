package api;

import api.datastructure.graph.Graph;
import api.datastructure.graph.Vertex;
import api.datastructure.graph.record.FileTextReader;
import api.n_queens_solution.IndependentConjunctionSolution;

public class Main {

    public static void main(String[] args) {
        FileTextReader fileReader =
                new FileTextReader("src/main/java/input/Tabuleiro_com_incompatibilidades.gml");

        Graph<Vertex> graph = fileReader.getReadedGraph();

        IndependentConjunctionSolution ics = new IndependentConjunctionSolution(graph);

        ics.simpleSolutionHeuristic();
        ics.getDisplayInformation();
    }

}
