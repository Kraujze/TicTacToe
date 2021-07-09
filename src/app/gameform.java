package app;

import javax.swing.*;

public class gameform extends JFrame {
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton Button1;
    private JButton button7;
    private JButton Button;
    private JButton button8;
    private JButton button9;
    private JButton button6;
    private JPanel panel1;

    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        new gameform();
    }

    public gameform() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        setContentPane(panel1);
        setVisible(true);
        setSize(400,400);
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    }

}
