# Documentação
# Trabalho Grafo Ufsj

## Dependências
Programa foi desenvolvido utilizando java 11, não testado com outras versões.

Link da JDK utilizada para desenvolvimento, apesar de necessitar apenas da JRE.

[Java-11-Download](https://docs.aws.amazon.com/corretto/latest/corretto-11-ug/downloads-list.html)
## Como rodar o programa:
A duas formas de executar o programa:

### A primeira forma:

Utilizando uma IDE ou algo que você esteja familiarizado basta abrir a compilar o projeto para gerar a ".class"
o projeto e executar a classe main. O programa já possui uma entrada predefinida Tabuleiro_com_incompatibilidades.gml, por enquanto não
suporta a execução de um arquivo em específico e é claro ao permitir essa possibilidade o arquivo deveria seguir
o padrão do mesmo.

Arquivo de entrada [Tabuleiro](src/main/java/input/Tabuleiro_com_incompatibilidades.gml)

### Segunda forma:

**Levando em consideração que você esteja com o terminal aberto na pasta do projeto:**

Já deixei um Makefile configurado e um *".jar"* pronto para execução basta rodar o programa com:
```bash
make rodar_programa_preparado
```
*Comando 1*

Ou se caso você queira compilar o pacote você mesmo basta rodar o seguinte comando:

```bash
make
```
*Comando 2*

E apos isso rodar o comando:
```bash
make rodar_programa_pos_compilacao
```

### Resposta esperada (versão resumida):
```
Quantidade de rainhas posicionadas = 7

0 0 0 0 0 R 0 0 
R 0 0 0 0 0 0 0 
0 0 R 0 0 0 0 0 
0 0 0 0 R 0 0 0 
0 0 0 0 0 0 R 0 
0 R 0 0 0 0 0 0 
0 0 0 R 0 0 0 0 
0 0 0 0 0 0 0 0 
```

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

