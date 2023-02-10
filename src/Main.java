import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Нажмите на пробел");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int width = 500, height = 500;
        frame.setBounds(dim.width / 2 - width / 2, dim.height / 2 - height / 2, width, height);
        JPanel panel = new JPanel ();
        panel.setFocusable(true);
        frame.add(panel);
        panel.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) // Если нажат пробел
                {
                    JOptionPane pane = new JOptionPane(); // Создаем диалог
                    int result1 = pane.showConfirmDialog(panel, "Хочешь машину?", "Вопрос 1", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); // Выводим 1 вопрос
                    int result2 = pane.showConfirmDialog(panel, "Хочешь дом?", "Вопрос 2", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); // Выводим 2 вопрос
                    String result;
                    if (result1 == 0 && result2 == 0) result = "Придётся очень много работать :)";
                    else if (result1 == 0 && result2 != 0) result = "Можно взять каршеринг -_-";
                    else if (result1 != 0 && result2 == 0) result = "Придётся много работать!";
                    else result = "Печально :(";
                    pane.showMessageDialog(panel, result, "Ответ", JOptionPane.INFORMATION_MESSAGE); // Выводим ответ
                }
            }
        });
        frame.setVisible(true);
    }
}