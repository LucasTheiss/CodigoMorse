public class ArvoreBinariaMorse {
    Node raiz = new Node();
    char[] caracteres = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
    };

    String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
            "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-",
            "..-", "...-", ".--", "-..-", "-.--", "--..",
            "-----", ".----", "..---", "...--", "....-", ".....",
            "-....", "--...", "---..", "----."};

    public String getMorseCode(char c){
        int i = 0;
        for (; i < 36; i++){
            if (c == caracteres[i]){ break; }
        }
        return morse[i];
    }

    public void inserir(char c){
        String codigo = getMorseCode(c);
        Node cur = raiz;

        for (int j = 0; j < codigo.length(); j++){
            if (isDot(codigo, j)){
                if (cur.left == null)
                    cur.left = new Node();
                cur = cur.left;
            } else {
                if (cur.right == null)
                    cur.right = new Node();
                cur = cur.right;
            }
        }
        cur.c = c;
    }

    public String search(String codigo){
        String result = "";
        String substring = "";

        for (int i = 0; i < codigo.length(); i++){
            char cur = codigo.charAt(i);
            if (cur == ' '){
                result += search(raiz, substring, 0);
                substring = "";
                continue;
            }
            substring += cur;
        }

        if (substring.length() > 0){
            result += search(raiz, substring, 0);
        }

        return result;
    }

    private char search(Node cur, String c, int depth){
        if (cur == null){ return ' '; }
        else if (depth == c.length()){ return cur.c; }

        Node dir = isDot(c, depth) ? cur.left : cur.right;
        return search(dir, c, depth + 1);
    }

    public void remove(char c){ raiz = remove(raiz, getMorseCode(c), 0); }

    private Node remove(Node cur, String c, int depth){
        if (cur == null ){ return null; }
        else if (depth == c.length()){
            if (isEmpty(cur)){
                return null;
            }
            cur.c = ' ';
            return cur;
        }

        if (isDot(c, depth)){
            cur.left = remove(cur.left, c, depth + 1);
        } else {
            cur.right = remove(cur.right, c, depth + 1);
        }
        return cur;
    }

    public void printTree() { printTree(raiz, "", true); }

    private void printTree(Node node, String prefix, boolean isTail) {
        if (node == null) return;

        printTree(node.right, prefix + (isTail ? "│   " : "    "), false);

        System.out.println(prefix + (isTail ? "└── " : "┌── ") + (node.c == '\0' ? '*' : node.c));

        printTree(node.left, prefix + (isTail ? "    " : "│   "), true);
    }

    public boolean isEmpty(Node n){ return n.left == null && n.right == null; }

    public boolean isDot(String c, int depth){ return c.charAt(depth) == '.'; }
}
