public class Main {
    public static void main(String[] args) {
        ArvoreBinariaMorse a = new ArvoreBinariaMorse();

        // nao pode usar lista, feito manualmente
        a.inserir(".-", 'A');
        a.inserir("-...", 'B');
        a.inserir("-.-.", 'C');
        a.inserir("-..", 'D');
        a.inserir(".", 'E');
        a.inserir("..-.", 'F');
        a.inserir("--.", 'G');
        a.inserir("....", 'H');
        a.inserir("..", 'I');
        a.inserir(".---", 'J');
        a.inserir("-.-", 'K');
        a.inserir(".-..", 'L');
        a.inserir("--", 'M');
        a.inserir("-.", 'N');
        a.inserir("---", 'O');
        a.inserir(".--.", 'P');
        a.inserir("--.-", 'Q');
        a.inserir(".-.", 'R');
        a.inserir("...", 'S');
        a.inserir("-", 'T');
        a.inserir("..-", 'U');
        a.inserir("...-", 'V');
        a.inserir(".--", 'W');
        a.inserir("-..-", 'X');
        a.inserir("-.--", 'Y');
        a.inserir("--..", 'Z');
        a.inserir(".----", '1');
        a.inserir("..---", '2');
        a.inserir("...--", '3');
        a.inserir("....-", '4');
        a.inserir(".....", '5');
        a.inserir("-....", '6');
        a.inserir("--...", '7');
        a.inserir("---..", '8');
        a.inserir("----.", '9');
        a.inserir("-----", '0');

        a.printTree();

        System.out.println(a.search("-.-. ."));

        a.remove(".");

        System.out.println(a.search("-.-. ."));

        a.printTree();
    }
}