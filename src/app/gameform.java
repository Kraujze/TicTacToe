package app;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class gameform extends JFrame {
    private int vanya = 0;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JPanel panel1;

    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        new gameform();
    }

    public gameform() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        setContentPane(panel1);
        setVisible(true);
        setSize(400,400);
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int odd = vanya % 2;
                String buttonCode = e.getActionCommand();
                String value = (odd == 0) ? "O" : "X";
                switch (buttonCode) {
                    case "11":
                        button1.setText(value);
                        break;
                    case "12":
                        button2.setText(value);
                        break;
                    case "13":
                        button3.setText(value);
                        break;
                    case "21":
                        button4.setText(value);
                        break;
                    case "22":
                        button5.setText(value);
                        break;
                    case "23":
                        button6.setText(value);
                        break;
                    case "31":
                        button7.setText(value);
                        break;
                    case "32":
                        button8.setText(value);
                        break;
                    case "33":
                        button9.setText(value);
                        break;
                }
                vanya++;
            }
        };

        button3.addActionListener(listener);
        button6.addActionListener(listener);
        button7.addActionListener(listener);
        button1.addActionListener(listener);
        button8.addActionListener(listener);
        button2.addActionListener(listener);
        button4.addActionListener(listener);
        button9.addActionListener(listener);
        button5.addActionListener(listener);

    }

}