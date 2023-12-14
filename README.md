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

Arquivo de entrada [Tabuleiro](../src/main/java/input/Tabuleiro_com_incompatibilidades.gml)

### Segunda forma:

**Considerando que você esteja com o terminal aberto na pasta do projeto:**

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

### Resposta esperada:
```
Para pintar o tabuleiro.
Foi usado um total de 14 cores diferentes

Cores de A a N

F J G K H C I D 
L C I D E F G B 
D B E F C A J H 
J G D A B E C L 
I A B C D G F M 
G D F H A B E I 
E H A B I J K C 
K F J E G L H N 

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

# Algoritmos:

## Atividade 6: rainhas (coloraçao)

#### [Coloracao Vertices Documentacao](documentations/coloracao_doc.md)

## Atividade 5: oito rainhas (conjuntos independentes)

#### [Subconjunto Oito Rainhas Documentação](documentations/subconjunto_doc.md)

Copyright (c) <2023> <[Geraldo Arthur Detomi](https://github.com/Arthurdetomi)>