package api.datastructure.graph.record;

import api.datastructure.graph.Graph;
import api.datastructure.graph.Vertex;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileTextReader {

    private Scanner input;

    public FileTextReader(String filePath) {
        try {
            input = new Scanner(new File(filePath));
        } catch (FileNotFoundException fex) {
            System.out.println("Arquivo enviado não existe");
            System.exit(1);
        }
    }

    public Graph<Vertex> getReadedGraph() {
        Graph<Vertex> graph = new Graph<>();

        Pattern patternVertex = Pattern.compile("id (\\d+)\\s+label \"(\\d+)\"");
        Pattern patternEdge = Pattern.compile("source (\\d+)\\s+target (\\d+)");

        try {
            while (input.hasNext()) {
                String currentLine = input.nextLine();

                if (currentLine.contains("node")) {
                    String nextLine = input.nextLine() + input.nextLine();

                    Matcher matcher = patternVertex.matcher(nextLine);

                    if (matcher.find()) {
                        int id = Integer.parseInt(matcher.group(1));
                        String label = matcher.group(2);

                        Vertex currentVertex = new Vertex(id, label);
                        graph.addVertex(currentVertex);
                    }
                } else if (currentLine.contains("edge")) {
                    String nextLine = input.nextLine() + input.nextLine();

                    Matcher matcher = patternEdge.matcher(nextLine);

                    if (matcher.find()) {
                        int sourceVertexId = Integer.parseInt(matcher.group(1));
                        int targetVertexId = Integer.parseInt(matcher.group(2));

                        Vertex sourceVertex = graph.findVertexById(sourceVertexId);
                        Vertex targetVertex = graph.findVertexById(targetVertexId);

                        if (sourceVertex == null || targetVertex == null) {
                            System.out.println("Aresta informada invalida:");
                            System.out.println("Linha:");
                            System.out.println(nextLine);
                            System.exit(1);
                        }

                        graph.addEdge(sourceVertex, targetVertex);
                    }
                }
            }
        } catch (NoSuchElementException nex) {
            System.out.println("Arquivo em formato impróprio");
            System.exit(1);
        } catch (IllegalArgumentException iex) {
            System.out.println("Erro durante leitura do arquivo");
            System.exit(1);
        }

        return graph;

    }



}
