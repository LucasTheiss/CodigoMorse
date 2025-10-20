# Projeto: Árvore Binária de Código Morse

Este projeto implementa uma estrutura de dados de árvore binária para armazenar e decodificar caracteres do Código Morse.

## Estrutura Principal

A aplicação é composta por três classes principais:

1.  **`Node.java`**: Representa um nó individual na árvore. Contém um caractere (`char c`) e referências para dois filhos: `left` (usado para `.`) e `right` (usado para `-`).
2.  **`ArvoreBinariaMorse.java`**: Contém toda a lógica de gestão da árvore. Armazena o nó `raiz` e fornece os métodos para manipulação.
3.  **`Main.java`**: Classe executável utilizada para popular a árvore com o alfabeto e números, e para executar testes de funcionalidade (busca, remoção e exibição).

## Lógica das Funções Principais (em ArvoreBinariaMorse.java)

* **`inserir(String codigo, char c)`**
    * **Lógica**: Esta função insere um caractere na árvore. Ela percorre o `codigo` Morse (ex: ".-"). Para cada `.` na string, avança para o nó da esquerda (`cur.left`); para cada `-`, avança para o nó da direita (`cur.right`). Se um nó no caminho não existir, ele é criado. Ao final do `codigo`, o caractere `c` é armazenado no nó atual.

* **`search(String codigo)`**
    * **Lógica**: Esta função decodifica uma mensagem Morse completa (ex: "-.-. ."). A função principal itera pela string de entrada, acumulando um `substring` para cada código. Quando um espaço é encontrado, ela chama a função auxiliar recursiva `search(Node cur, String c, int depth)` para encontrar o caractere correspondente àquele `substring`. O resultado é concatenado numa string final.
    * **Lógica Auxiliar**: A função `search` recursiva navega pela árvore (esquerda para `.` e direita para `-`) até que a profundidade (`depth`) seja igual ao tamanho do código. Nesse ponto, retorna o caractere (`cur.c`) armazenado naquele nó.

* **`remove(String codigo)`**
    * **Lógica**: Esta função é um invólucro para a função recursiva `remove(Node cur, String c, int depth)`. A função recursiva localiza o nó exato correspondente ao `codigo`.
    * **Regras de Remoção**:
        1.  Se o nó encontrado for uma folha (não tem filhos, verificado por `isEmpty(cur)`), a função retorna `null`, efetivamente removendo o nó da árvore.
        2.  Se o nó *não* for uma folha (ou seja, seu caminho é usado por outros códigos), seu valor de caractere é simplesmente definido como um espaço em branco (`cur.c = ' '`). Isso preserva a estrutura da árvore para os nós descendentes.

* **`printTree()`**
    * **Lógica**: Utiliza um método recursivo para imprimir uma representação visual da árvore no console, mostrando a hierarquia dos nós.