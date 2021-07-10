package app;

import javax.swing.*;

public class game {
    public int counter;
    public String[][] map = new String[][]{
            {"", "", ""},
            {"", "", ""},
            {"", "", ""}
    };
    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        new gameform();
    }
    public void game() {
        counter = 0; // First move, 0 - Nought, 1 - Cross

    }
    public void doMove(String cellCode) {
        String value = (counter % 2 == 0) ? "O" : "X"; // if counter is not odd, then object is a nought, else - cross
        char[] codeNums = cellCode.toCharArray();
        map[codeNums[0]][codeNums[1]] = value;
        // render();
    }
    public void render() {
        // функция для заполнения поля в окне крестиками и ноликами
    }
}
