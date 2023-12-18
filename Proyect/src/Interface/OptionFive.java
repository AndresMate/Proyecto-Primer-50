package Interface;

import Logic.Dictionary;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OptionFive {
    private JFrame frame;
    private JTextField wordTextField;
    private JTextField meaningTextField;

    private Dictionary dictionary;

    public OptionFive() {
        dictionary = new Dictionary();

        frame = new JFrame("OptionFive");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel titleLabel = new JLabel("Modificar");
        titleLabel.setBounds(150, 10, 200, 25);
        panel.add(titleLabel);

        JLabel wordLabel = new JLabel("Palabra a Modificar:");
        wordLabel.setBounds(50, 50, 150, 25);
        panel.add(wordLabel);

        wordTextField = new JTextField();
        wordTextField.setBounds(200, 50, 150, 25);
        panel.add(wordTextField);

        JLabel meaningLabel = new JLabel("Nuevo Significado:");
        meaningLabel.setBounds(50, 80, 150, 25);
        panel.add(meaningLabel);

        meaningTextField = new JTextField();
        meaningTextField.setBounds(200, 80, 150, 25);
        panel.add(meaningTextField);

        JButton modifyButton = new JButton("Modificar Significado");
        modifyButton.setBounds(150, 110, 150, 25);
        panel.add(modifyButton);

        modifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modifyButtonClicked();
            }
        });
    }

    private void modifyButtonClicked() {
        String wordToModify = wordTextField.getText().trim();
        String newMeaning = meaningTextField.getText().trim();

        if (!wordToModify.isEmpty() && !newMeaning.isEmpty()) {
            String result = dictionary.updateMeaning(wordToModify, newMeaning);
            JOptionPane.showMessageDialog(frame, result, "Resultado", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(frame, "Por favor, ingrese la palabra y el nuevo significado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new OptionFive();
            }
        });
    }
}
