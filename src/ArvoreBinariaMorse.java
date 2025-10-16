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
        Node prev;

        for (int j = 0; j < codigo.length(); j++){
            if (codigo.charAt(j) == '.'){
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

    public String searchInterface(String codigo){
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


    public char search(Node cur, String c, int depth){
        if (cur == null){ return ' '; }
        else if (depth == c.length()){ return cur.c; }

        Node dir = c.charAt(depth) == '.' ? cur.left : cur.right;
        return search(dir, c, ++depth);
    }
}
