public class Main {
    public static void main(String[] args) {
        ArvoreBinariaMorse a = new ArvoreBinariaMorse();

        char[] lista = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};

        for (char item: lista){ a.inserir(item); }

        System.out.println(a.searchInterface("-.-. ..-"));
    }
}