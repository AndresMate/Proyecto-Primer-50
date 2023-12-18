package Interface;

import Logic.Dictionary;
import Model.Word;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OptionFour {
    private JFrame frame;
    private JTextArea resultTextArea;

    private Dictionary dictionary;

    public OptionFour() {
        dictionary = new Dictionary();

        frame = new JFrame("LISTADO DE PALABRAS");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel titleLabel = new JLabel("LISTADO DE PALABRAS");
        titleLabel.setBounds(150, 10, 200, 25);
        panel.add(titleLabel);

        JButton showAllButton = new JButton("Mostrar");
        showAllButton.setBounds(150, 50, 100, 25);
        panel.add(showAllButton);

        resultTextArea = new JTextArea();
        resultTextArea.setBounds(50, 90, 290, 130);
        resultTextArea.setEditable(false);
        panel.add(resultTextArea);

        showAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAllButtonClicked();
            }
        });
    }

    private void showAllButtonClicked() {
        StringBuilder result = new StringBuilder("Listado de Todas las Palabras:\n");

        for (char letter = 'A'; letter <= 'Z'; letter++) {
            ArrayList<Word> words = dictionary.getWordsByLetter(letter);

            for (Word word : words) {
                result.append("Palabra: ").append(word.getWord()).append(", Significado: ").append(word.getMeaning()).append(", Traducción: ").append(word.getTranslation()).append("\n");
            }
        }

        if (result.length() == 0) {
            JOptionPane.showMessageDialog(frame, "No hay palabras en el diccionario.", "Resultados", JOptionPane.INFORMATION_MESSAGE);
        } else {
            resultTextArea.setText(result.toString());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new OptionFour();
            }
        });
    }
}
