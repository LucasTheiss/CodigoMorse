public class ArvoreBinariaMorse {
    Node raiz;
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

            if (codigo.charAt(j) == '.'){
                if (cur.left == null)
                    cur.left = new Node();
                cur = cur.left;
            } else {
                if (cur.right == null)
                    cur.left = new Node();
                cur = cur.right;
            }

        }
    }
}
