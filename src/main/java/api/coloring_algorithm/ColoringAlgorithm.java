package api.coloring_algorithm;

import api.datastructure.graph.Graph;
import api.datastructure.graph.Vertex;
import api.datastructure.graph.VertexComparator;

import java.util.*;

public class ColoringAlgorithm {

    private int totalColorsUsed;

    private Graph<Vertex> graph;

    private Map<Integer, Character> colorsMap = new HashMap<>();

    public ColoringAlgorithm(Graph<Vertex> graph) {
        this.graph = graph;
        initializeColorsMap();
    }

    public void solve() {
        Set<Vertex> vertexesDefinedColorsSet = new HashSet<>();

        List<Vertex> vertexesList = new ArrayList<>(graph.getAllVertexes());
        vertexesList.sort(new VertexComparator(graph));

        Set<Character> markedColorsUsed = new HashSet<>();

        for (Vertex currentVertex : vertexesList) {
            List<Vertex> neighbors = new ArrayList<>(graph.getEdges(currentVertex));

            Set<Character> colorsNeighbors = new HashSet<>();

            for (Vertex currentNeighbor : neighbors) {
                if (currentNeighbor.getColor() != null) {
                    colorsNeighbors.add(currentNeighbor.getColor());
                }
            }

            Character colorAvailable = getFirstColorAvailable(colorsNeighbors);
            markedColorsUsed.add(colorAvailable);

            currentVertex.setColor(colorAvailable);

            for (Vertex currentNeighbor : neighbors) {
                if (!vertexesDefinedColorsSet.contains(currentNeighbor)) {
                    currentNeighbor.setColor(colorAvailable);
                }
            }

            vertexesDefinedColorsSet.add(currentVertex);
        }

        this.totalColorsUsed = markedColorsUsed.size();
    }

    Character getFirstColorAvailable(Set<Character> colorsBlocked) {
        for (char color = 'A'; color <= 'Z'; color++) {
            if (!colorsBlocked.contains(color)) {
                return color;
            }
        }

        return '\0';
    }

    private void initializeColorsMap() {
        int count = 0;
        for (char color = 'A'; color <= 'Z'; color++) {
            colorsMap.put(count, color);
            count++;
        }
    }

    public void getDisplayInformation() {
        System.out.println("Para pintar o tabuleiro.");
        System.out.println("Foi usado um total de " + totalColorsUsed + " cores diferentes\n");

        char primaryColor = colorsMap.get(0);
        char lastColour = colorsMap.get(totalColorsUsed - 1);

        System.out.println("Cores de " + primaryColor + " a " + lastColour + "\n");

        int value = (int) Math.sqrt(graph.getSize());
        int count = 0;
        for (int i = 0; i < value; i++) {
            for (int j = 0; j < value; j++) {
                Vertex currentVertex = graph.findVertexById(count);
                System.out.print(currentVertex.getColor() + " ");
                count++;
            }
            System.out.println();
        }
    }

}
