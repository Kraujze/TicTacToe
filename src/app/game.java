package app;

import javax.swing.*;
import java.awt.*;

public class game {
    public Color winButColor = new Color(219, 6, 6);
    public Color winTextColor = new Color(0, 255, 166);
    public Color altTextColor = new Color(255,255,255);
    public int counter;
    public String[][] map = new String[][]{
            {"", "", ""},
            {"", "", ""},
            {"", "", ""}
    };
    public JButton[][] buttonArr;
    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        new gameform(400,400, "TicTacToe v1.8");
    }
    public game(JButton[][] btnArr) {
        counter = 0; // First move, 0 - Nought, 1 - Cross
        buttonArr = btnArr;
    }
    public boolean isExist(String cellCode) {
        char[] codeNums = cellCode.toCharArray();
        return (map[Character.getNumericValue(codeNums[0])][Character.getNumericValue(codeNums[1])] != "");
    }
    public void doMove(String cellCode) {
        String value = (counter % 2 == 0) ? "O" : "X"; // if counter isn't odd, then object is a nought, else - cross
        char[] codeNums = cellCode.toCharArray();
        map[Character.getNumericValue(codeNums[0])][Character.getNumericValue(codeNums[1])] = value;
        render();
        checkWin(codeNums);
        counter++;
    }
    public void render() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!map[i][j].equals("")) {
                    (buttonArr[i][j]).setText(map[i][j]);
                }
            }
        }
    }
    public void checkWin(char[] codeNums) {
        int lastMoveRow = Character.getNumericValue(codeNums[0]);
        int lastMoveCol = Character.getNumericValue(codeNums[1]);
        String lastMoveVal = (counter % 2 == 0) ? "O" : "X";
        String winType = "";
        boolean vWin = false, hWin = false, dWin = false, tieWin = false;
        for (int i = 0; i < 3; i++) {
            vWin = map[i][lastMoveCol].equals(lastMoveVal);
            if (!vWin) break;
        }
        winType = vWin ? "vWin" : winType;

        for(int j = 0; j < 3; j++) {
            hWin = map[lastMoveRow][j].equals(lastMoveVal);
            if (!hWin) break;
        }
        winType = hWin ? "hWin" : winType;

        for (int i = 0, j = 0; i < 3 && j < 3; i++, j++) {
            dWin = map[i][j].equals(lastMoveVal);
            if (!dWin) break;
        }
        winType = dWin ? "dWin" : winType;

        if (counter == 8 && !vWin && !hWin && !dWin) { tieWin = true; winType = "tieWin"; }

        if (vWin || hWin || dWin || tieWin) gameOver(lastMoveVal, winType, lastMoveRow, lastMoveCol);
    }
    public void gameOver(String winner, String winType, int winRow, int winCol) {
        switch (winType) {
            case "vWin":
                for (int i = 0; i < 3; i++) {
                    (buttonArr[i][winCol]).setBackground(winButColor); (buttonArr[i][winCol]).setForeground(winTextColor);
                }
                break;
            case "hWin":
                for (int j = 0; j < 3; j++) {
                    (buttonArr[winRow][j]).setBackground(winButColor); (buttonArr[winRow][j]).setForeground(winTextColor);
                }
                break;
            case "dWin":
                for (int i = 0, j = 0; i < 3 && j < 3; i++, j++) {
                    (buttonArr[i][j]).setBackground(winButColor); (buttonArr[i][j]).setForeground(winTextColor);
                }
                break;
            case "tieWin":
                for (int i = 0; i < 3; i+=2) {
                    for (int j = 0; j < 3; j++) {
                        (buttonArr[i][j]).setBackground(winTextColor); (buttonArr[i][j]).setText("=");
                    }
                }
                buttonArr[1][0].setText("T"); buttonArr[1][1].setText("I"); buttonArr[1][2].setText("E");
                buttonArr[1][0].setBackground(winButColor); buttonArr[1][1].setBackground(winButColor); buttonArr[1][2].setBackground(winButColor);
                buttonArr[1][0].setForeground(altTextColor); buttonArr[1][1].setForeground(altTextColor); buttonArr[1][2].setForeground(altTextColor);
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttonArr[i][j].getText().equals("")) { (buttonArr[i][j]).setEnabled(false); }
            }
        }
    }
}
