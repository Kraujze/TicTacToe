package app;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class gameform extends JFrame {
    protected JButton button1;
    protected JButton button2;
    protected JButton button3;
    protected JButton button4;
    protected JButton button5;
    protected JButton button6;
    protected JButton button7;
    protected JButton button8;
    protected JButton button9;
    private JPanel panel1;
    protected final JButton[][] buttonArr = new JButton[][]{
            {button1, button2, button3},
            {button4, button5, button6},
            {button7, button8, button9}
    };
    public JButton[][] getArr() {
        return buttonArr;
    }
    public gameform(int width, int height, String title) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        setContentPane(panel1); setVisible(true); setSize(width,height); setTitle(title); setDefaultCloseOperation(EXIT_ON_CLOSE);
        game game = new game(buttonArr);
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cellCode = e.getActionCommand();
                if (!game.isExist(cellCode)) { game.doMove(cellCode); }
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