# Atividade 6: rainhas (coloraçao)

## Problema:
Esta tarefa consiste em pegar o mesmo tabuleiro de incompatibilidade de rainhas e resolver um problema de coloração. 
Nesse problema, todas as rainhas devem estar associadas a uma classe de cor. O objetivo é criar uma solução em 
que uma rainha só possa estar no caminho de outra se suas cores forem distintas. Duas rainhas da mesma cor 
não pode estar no caminho uma da outra.

## Solução:
A heurística que utilizei nesse programa é a seguinte:
1. Ordena todos os vértices conforme o seu grau de forma decrescente.
2. Inicia um HashSet para marcar vértices que já tiveram sua cor definida.
3. Percorre cada vértice e para cada um faça:
- Defina sua cor como a primeira disponível
- Se a cor dos seus vizinhos ainda não foram definidas pinta da mesma cor 
- Marque o vértice atual como definido
4. Ao percorrer todos os vértices significa que já definiu uma cor para todos os vértices, portanto é o fim do programa.

O programa alcança uma solução ótima, algoritmo:
```java
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
```

Copyright (c) <2023> <[Geraldo Arthur Detomi](https://github.com/Arthurdetomi)>