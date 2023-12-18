package Interface;

import Logic.Dictionary;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OptionTwo {
    private JFrame frame;
    private JTextField wordTextField;
    private JTextArea resultTextArea;

    private Dictionary dictionary;

    public OptionTwo() {
        dictionary = new Dictionary();

        frame = new JFrame("SIGNIFICADO");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);


    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel titleLabel = new JLabel("Buscar Significado");
        titleLabel.setBounds(150, 10, 200, 25);
        panel.add(titleLabel);

        wordTextField = new JTextField();
        wordTextField.setBounds(50, 50, 200, 25);
        panel.add(wordTextField);

        JButton searchButton = new JButton("Buscar");
        searchButton.setBounds(260, 50, 80, 25);
        panel.add(searchButton);

        resultTextArea = new JTextArea();
        resultTextArea.setBounds(50, 90, 290, 130);
        resultTextArea.setEditable(false);
        panel.add(resultTextArea);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchButtonClicked();
            }
        });
    }

    private void searchButtonClicked() {
        String wordToFind = wordTextField.getText().trim();
        String[] meaningAndTranslation = dictionary.getMeaningAndTranslation(wordToFind);

        String result = "Significado: " + meaningAndTranslation[0] + "\nTraduccion: " + meaningAndTranslation[1];
        resultTextArea.setText(result);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new OptionTwo();
            }
        });
    }
}
