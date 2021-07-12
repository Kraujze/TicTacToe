package app;

import javax.swing.*;

public class game {
    public int counter;
    public String[][] map = new String[][]{
            {"", "", ""},
            {"", "", ""},
            {"", "", ""}
    };
    public JButton[][] buttonArr;
    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        new gameform(400,400);
    }
    public game(JButton[][] btnArr) {
        counter = 0; // First move, 0 - Nought, 1 - Cross
        buttonArr = btnArr;
    }
    public void doMove(String cellCode) {
        String value = (counter % 2 == 0) ? "O" : "X"; // if counter isn't odd, then object is a nought, else - cross
        char[] codeNums = cellCode.toCharArray();
        map[Character.getNumericValue(codeNums[0])][Character.getNumericValue(codeNums[1])] = value;
        counter++;
        render();
    }
    public void render() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!map[i][j].equals("")) {(buttonArr[i][j]).setText(map[i][j]);}
            }
        }
    }
}
