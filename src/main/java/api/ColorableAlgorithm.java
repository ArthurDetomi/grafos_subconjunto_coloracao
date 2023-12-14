package api;

import api.coloring_algorithm.ColoringAlgorithm;
import api.datastructure.graph.Graph;
import api.datastructure.graph.Vertex;
import api.datastructure.graph.record.FileTextReader;

public class ColorableAlgorithm {
    public static void main(String[] args) {
        FileTextReader fileReader =
                new FileTextReader("src/main/java/input/Tabuleiro_com_incompatibilidades.gml");

        Graph<Vertex> graph = fileReader.getReadedGraph();

        ColoringAlgorithm coloringAlgorithm = new ColoringAlgorithm(graph);
        coloringAlgorithm.solve();
        coloringAlgorithm.getDisplayInformation();
    }
}
