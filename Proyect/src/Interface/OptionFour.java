package Interface;

import Logic.Dictionary;
import Model.Word;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OptionFour extends JFrame {
    private JFrame frame;
    private JTextArea resultTextArea;

    private Dictionary dictionary;

    public OptionFour(Dictionary dictionary) {
        this.dictionary = dictionary;

        frame = new JFrame("LISTADO DE PALABRAS");
        frame.setSize(400, 300);
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

        JButton showAllButton = new JButton("Mostrar");
        showAllButton.setBounds(150, 50, 100, 25);
        panel.add(showAllButton);

        resultTextArea = new JTextArea();
        // Utilizamos JScrollPane para agregar una barra de desplazamiento
        JScrollPane scrollPane = new JScrollPane(resultTextArea);
        scrollPane.setBounds(50, 90, 290, 130);
        panel.add(scrollPane);

        showAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAllButtonClicked();
            }
        });
    }

    private void showAllButtonClicked() {
        StringBuilder result = new StringBuilder("Listado de Todas las Palabras:\n");
        result.append(dictionary.displayDictionaryAlphabetically());
        if (result.length() == -1) {
            JOptionPane.showMessageDialog(frame, "No hay palabras en el diccionario.", "Resultados", JOptionPane.INFORMATION_MESSAGE);
        } else {
            resultTextArea.setText(result.toString());
        }
    }

    public void exit() {
        try {
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
