package Interface;

import Logic.Dictionary;
import Model.Word;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Interface.InterfazGrafica;

public class OptionOne extends JFrame {


    private JTextField palabraField, significadoField, traduccionField;
    private JTextArea outputArea;
    private Dictionary dictionary;
    public OptionOne(Dictionary dictionary) {
        super("AGREGAR PALABRA");
        this.dictionary = dictionary;

        // Configurar la interfaz gráfica
        setLayout(new GridLayout(2, 1));

        // Panel de entrada
        JPanel inputPanel = new JPanel(new GridLayout(4, 2));

        palabraField = new JTextField();
        significadoField = new JTextField();
        traduccionField = new JTextField();

        inputPanel.add(new JLabel("Palabra:"));
        inputPanel.add(palabraField);
        inputPanel.add(new JLabel("Significado:"));
        inputPanel.add(significadoField);
        inputPanel.add(new JLabel("Traducción:"));
        inputPanel.add(traduccionField);

        JButton agregarButton = new JButton("Agregar Palabra");
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarPalabra();
            }
        });
        inputPanel.add(agregarButton);

        // Panel de salida
        outputArea = new JTextArea();
        outputArea.setEditable(false);

        // Agregar componentes a la ventana
        add(inputPanel);
        add(new JScrollPane(outputArea));

        // Configuraciones generales de la ventana
        setSize(600, 400);
        setIconImage(new ImageIcon(getClass().getResource("Images/icono.png")).getImage());  // Establecer el icono
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        exit();
    }

    private void agregarPalabra() {
        String palabra = palabraField.getText();
        String significado = significadoField.getText();
        String traduccion = traduccionField.getText();

        Word nuevaWord = new Word(palabra, significado, traduccion);
        String mensaje = dictionary.addWordToDictionary(nuevaWord);

        // Actualizar el área de salida
        outputArea.setText(dictionary.displayDictionary());

        // Mostrar JOptionPane
        JOptionPane.showMessageDialog(this, mensaje, "Resultado", JOptionPane.INFORMATION_MESSAGE);
    }

    public void exit(){
        try {
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
