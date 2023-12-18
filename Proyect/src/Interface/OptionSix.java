package Interface;

import Logic.Dictionary;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OptionSix {
    private JFrame frame;
    private JTextField wordTextField;

    private Dictionary dictionary;

    public OptionSix() {
        dictionary = new Dictionary();

        frame = new JFrame("ELIMINAR PALABRA");
        frame.setSize(400, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel titleLabel = new JLabel("Eliminar Palabra");
        titleLabel.setBounds(150, 10, 200, 25);
        panel.add(titleLabel);

        JLabel wordLabel = new JLabel("Palabra a Eliminar:");
        wordLabel.setBounds(50, 50, 150, 25);
        panel.add(wordLabel);

        wordTextField = new JTextField();
        wordTextField.setBounds(200, 50, 150, 25);
        panel.add(wordTextField);

        JButton deleteButton = new JButton("Eliminar");
        deleteButton.setBounds(150, 90, 100, 25);
        panel.add(deleteButton);

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteButtonClicked();
            }
        });
    }

    private void deleteButtonClicked() {
        String wordToDelete = wordTextField.getText().trim();

        if (!wordToDelete.isEmpty()) {
            String result = dictionary.deleteWord(wordToDelete);
            JOptionPane.showMessageDialog(frame, result, "Resultado", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(frame, "Por favor, ingrese la palabra a eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new OptionSix();
            }
        });
    }
}
