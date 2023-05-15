package vue;

public class RouteCipher {
    private int key;

    public RouteCipher(){
        setKey(5);
    }

    public RouteCipher(int key){
        setKey(key);
    }

    public RouteCipher(RouteCipher other){
        setKey(other.getKey());
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    private int countLetters(char[] chars){
        int count = 0;
        for (char c : chars){
            if (Character.isLetter(c)){
                ++count;
            }
        }
        return count;
    }

    //Fills the grid with the letters
    private void fillGrid(char[] cipher, char[][] grid){
        int readIndex = 0;
        for (int i=0; i<grid.length; ++i){
            for (int j=0; j<grid[i].length; ++j){
                if (readIndex < cipher.length && Character.isLetter(cipher[readIndex])){
                    grid[i][j] = cipher[readIndex];
                }
                else if (readIndex < cipher.length){ //The read symbol was not a letter
                    --j;
                }
                else { //We have reached the end of cipher
                    grid[i][j] = '%';
                }
                ++readIndex;
            }
        }
    }

    private void print(char[][] grid){
        for (int i=0; i<grid.length; ++i){
            for (int j=0; j<grid[i].length; ++j){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public String encrypt(String plainText){
        char [] cipherTextChars = plainText.toCharArray(); // to char array
        char[][] grid = new char[(int)Math.ceil((double)countLetters(cipherTextChars) / Math.abs(key))][Math.abs(key)];
        fillGrid(cipherTextChars, grid);
        print(grid); //to be deleted
        return new String(cipherTextChars);
    }

    public String decrypt(String cipherText){
        char [] cipherTextChars = cipherText.toCharArray(); // to char array
        return new String(cipherTextChars); // to string
    }

    @Override
    public String toString() {
        return "RouteCipher{" +
                "key=" + key +
                '}';
    }
}
