# Atividade 5: oito rainhas (conjuntos independentes)

## Problema:
No jogo de xadrez, a rainha é uma peça cuja movimentação se dá livremente nas linhas colunas e diagonais do tabuleiro.
Um dos problemas mais clássicos da Ciência da Computação é o problema das oito rainhas, que consiste em posicionar, 
simultaneamente, oito rainhas em um tabuleiro de xadrez tradicional (de tamanho 8 x 8), 
de forma que cada uma não fique no caminho das outras.

E a ideia é resolver utilizando grafos com utilizando alguma heurística de conjunto independente.

## Solução:
A heurística que utilizei nesse programa foi a mais simples. Que se trata de uma que estava presente no slide
do professor, no caso:
1. Selecionar um vértice ainda não considerado.
2. Se o vértice não é adjacente a nenhum vértice de S, inclua-o em S.
3. Remova os vértices vizinhos do vértice selecionado.
4. Se há vértices não considerados, volte para 1.

O problema foi que eu não consegui alcançar a solução ótima utilizando esse algoritmo, a abordagem inicial
que utilizei foi a seguinte:
```java
 public void simpleSolutionHeuristic() {
    Graph<Vertex> residualGraph = graph.copy();
    Set<Vertex> solutionSet = new HashSet<>();

    while (!residualGraph.isEmpty()) {
        List<Vertex> vertexes = new ArrayList<>(residualGraph.getAllVertexes());

        // Ordena por quantidade de vizinhos crescente
        vertexes.sort(new VertexComparator(residualGraph));

        Vertex vertexSelected = residualGraph.findVertexById(vertexes.get(0).getId());
        solutionSet.add(vertexSelected);

        markedQueenInOriginaLGraph(vertexSelected.getId());

        residualGraph.removeVertexAndNeighbors(vertexSelected);
    }
}

// Marca que o vertice irá receber uma rainha no grafo original
private void markedQueenInOriginaLGraph(Integer id) {
    Vertex vertexMarked = graph.findVertexById(id);
    vertexMarked.setHasQueen(true);
}
```
O problema que apenas encontrei uma solução maximal de 6 rainhas, após isso com tentativa e erro fiz uma
solução que realmente pode-se considerar gambiarra que alcançou um total de 7 rainhas, no caso essa
é a implementação final do código:
```java
public void simpleSolutionHeuristic() {
    Graph<Vertex> residualGraph = graph.copy();
    Set<Vertex> solutionSet = new HashSet<>();

    for (int i = 5; i < 64 && !residualGraph.isEmpty(); i++) {
        List<Vertex> vertexes = new ArrayList<>(residualGraph.getAllVertexes());

        Vertex vertexSelected = residualGraph.findVertexById(i);
        if (vertexSelected == null) {
            continue;
        }
        solutionSet.add(vertexSelected);

        markedQueenInOriginaLGraph(vertexSelected.getId());

        residualGraph.removeVertexAndNeighbors(vertexSelected);
    }

    System.out.println("Quantidade de rainhas posicionadas = " + solutionSet.size() + "\n");
}

private void markedQueenInOriginaLGraph(Integer id) {
    Vertex vertexMarked = graph.findVertexById(id);
    vertexMarked.setHasQueen(true);
}
```
Após isso cheguei a conclusão que utilizando essa heurística muito simples o resultado não poderia ser
melhor que esse, para alcançar uma solução ótima e necessário um algoritmo mais complexo de conjuntos
independentes, que retorna uma solução máxima não maximal como o método de Maghout.

Copyright (c) <2023> <[Geraldo Arthur Detomi](https://github.com/Arthurdetomi)>