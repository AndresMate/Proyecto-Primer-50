package Interface;

import Logic.Dictionary;
import Model.Word;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OptionTree extends JFrame {
    private JFrame frame;
    private JTextField letterTextField;

    private Dictionary dictionary;

    public OptionTree(Dictionary dictionary) {
        this.dictionary= dictionary;

        frame = new JFrame("LISTADO");
        frame.setSize(400, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
        exit();
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel titleLabel = new JLabel("LISTADO DE PALABRAS");
        titleLabel.setBounds(150, 10, 200, 25);
        panel.add(titleLabel);

        JLabel enterLetterLabel = new JLabel("Ingrese una letra:");
        enterLetterLabel.setBounds(50, 50, 150, 25);
        panel.add(enterLetterLabel);

        letterTextField = new JTextField();
        letterTextField.setBounds(200, 50, 50, 25);
        panel.add(letterTextField);

        JButton searchButton = new JButton("Buscar");
        searchButton.setBounds(260, 50, 80, 25);
        panel.add(searchButton);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchButtonClicked();
            }
        });
    }

    private void searchButtonClicked() {
        String letter = letterTextField.getText().trim();
        if (letter.length() == 1 && Character.isLetter(letter.charAt(0))) {
            char searchLetter = Character.toUpperCase(letter.charAt(0));
            displayWordsForLetter(searchLetter);
        } else {
            JOptionPane.showMessageDialog(frame, "Entrada no válida. Ingrese una sola letra.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void displayWordsForLetter(char letter) {
        ArrayList<Word> words = dictionary.getWordsByLetter(letter);

        if (words.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "No hay palabras que comiencen con la letra " + letter, "Resultados", JOptionPane.INFORMATION_MESSAGE);
        } else {
            StringBuilder result = new StringBuilder("Palabras que comienzan con la letra " + letter + ":\n");

            for (Word word : words) {
                result.append("Palabra: ").append(word.getWord()).append(", Significado: ").append(word.getMeaning()).append(", Traducción: ").append(word.getTranslation()).append("\n");
            }

            JOptionPane.showMessageDialog(frame, result.toString(), "Resultados", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void exit(){
        try {
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
