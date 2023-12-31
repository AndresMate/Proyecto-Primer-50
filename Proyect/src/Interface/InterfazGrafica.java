/**
 * La clase BienvenidaPapeleria representa la ventana de inicio de la Papeleria La Esmeralda.
 * Proporciona opciones para iniciar sesión o registrarse como usuario.
 */
package Interface;

import Logic.Dictionary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.util.Objects.requireNonNull;

public class InterfazGrafica {

    JFrame ventana = new JFrame("DICTIONARY");
    ImageIcon icon = new ImageIcon(requireNonNull(getClass().getResource("Images/icono.png")));
    private Dictionary dictionary;///

    JLabel textoBienvenida;
    JButton botonAgregar, botonConsultar,botonObtenerListado,botonListadoPorLetra,botonListar ,botonModificar, botonEliminar;
    OptionOne optionOne; // Nueva instancia de la interfaz de agregar palabra
    OptionTwo optionTwo;

    /**
     * Constructor de la clase InterfazGrafica.
     * Configura la ventana de bienvenida y los componentes, como el texto de bienvenida y los botones.
     */
    public InterfazGrafica() {
        // Configurar ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(new BorderLayout());
        ventana.setIconImage(icon.getImage());

        // Crear un JPanel personalizado con la imagen de fondo
        JPanel panelFondo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Carga y dibuja la imagen de fondo
                ImageIcon fondo = new ImageIcon(requireNonNull(getClass().getResource("Images/fondo.jpeg")));
                float opacity = 0.8f; // Puedes ajustar este valor según sea necesario
                ((Graphics2D) g).setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));
                g.drawImage(fondo.getImage(), 0, 30, getWidth(), getHeight(), this);
            }
        };

        // Configurar el JPanel personalizado
        panelFondo.setLayout(new GridLayout(8, 1));

        // Texto de bienvenida
        textoBienvenida = new JLabel("SELECCIONE UNA OPCION");
        textoBienvenida.setForeground(Color.BLACK);
        textoBienvenida.setFont(new Font("Monospaced", Font.BOLD, 20));
        textoBienvenida.setBackground(new Color(213, 133, 89, 255));
        textoBienvenida.setVerticalTextPosition(JLabel.CENTER);
        textoBienvenida.setHorizontalAlignment(JLabel.CENTER);

        // Botones
        botonAgregar = new JButton("Agregar palabra");
        botonAgregar.setForeground(Color.BLACK);
        botonAgregar.setBackground(new Color(245, 180, 145, 255));
        botonAgregar.setFont(new Font("Monospaced", Font.BOLD, 20));
        botonAgregar.setOpaque(false);


        dictionary = new Dictionary();
        // Agregar ActionListener para mostrar la interfaz de agregar palabra
        botonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Pasa el diccionario a OptionOne
                optionOne = new OptionOne(dictionary);
                optionOne.setVisible(true);
            }
        });


        botonConsultar = new JButton("Consultar palabra");
        botonConsultar.setForeground(Color.BLACK);
        botonConsultar.setBackground(new Color(245, 180, 145, 255));
        botonConsultar.setFont(new Font("Monospaced", Font.BOLD, 20));
        botonConsultar.setOpaque(false);

        botonConsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear la instancia de OptionTwo al hacer clic en el botón
                OptionTwo optionTwo = new OptionTwo(dictionary);
                // Hacer visible la instancia existente de OptionTwo
                optionTwo.setVisible(true);
            }
        });

        botonListadoPorLetra = new JButton("Consultar listado por letra");
        botonListadoPorLetra.setForeground(Color.BLACK);
        botonListadoPorLetra.setBackground(new Color(245, 180, 145, 255));
        botonListadoPorLetra.setFont(new Font("Monospaced", Font.BOLD, 20));
        botonListadoPorLetra.setOpaque(false);
        botonListadoPorLetra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear la instancia de OptionTree al hacer clic en el botón
                OptionTree optionTree = new OptionTree(dictionary);
                // Hacer visible la instancia existente de OptionTree
                optionTree.setVisible(true);
            }
        });


        botonObtenerListado = new JButton("Obtener Listado");
        botonObtenerListado.setForeground(Color.BLACK);
        botonObtenerListado.setBackground(new Color(245, 180, 145, 255));
        botonObtenerListado.setFont(new Font("Monospaced", Font.BOLD, 20));
        botonObtenerListado.setOpaque(false);

        botonObtenerListado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear la instancia de OptionFour al hacer clic en el botón
                OptionFour optionFour = new OptionFour(dictionary);
                // Hacer visible la instancia existente de OptionFour
                optionFour.setVisible(true);
            }
        });

        botonModificar = new JButton("Modificar Significado");
        botonModificar.setForeground(Color.BLACK);
        botonModificar.setBackground(new Color(245, 180, 145, 255));
        botonModificar.setFont(new Font("Monospaced", Font.BOLD, 20));
        botonModificar.setOpaque(false);

        botonModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear la instancia de OptionFive al hacer clic en el botón
                OptionFive optionFive = new OptionFive(dictionary);
                // Hacer visible la instancia existente de OptionFive
                optionFive.setVisible(true);
            }
        });

        botonEliminar = new JButton("Eliminar Palabra");
        botonEliminar.setForeground(Color.BLACK);
        botonEliminar.setBackground(new Color(245, 180, 145, 255));
        botonEliminar.setFont(new Font("Monospaced", Font.BOLD, 20));
        botonEliminar.setOpaque(false);

        botonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear la instancia de OptionSix al hacer clic en el botón
                OptionSix optionSix = new OptionSix(dictionary);
                // Hacer visible la instancia existente de OptionSix
                optionSix.setVisible(true);
            }
        });


        panelFondo.add(textoBienvenida);
        panelFondo.add(botonAgregar);
        panelFondo.add(botonConsultar);
        panelFondo.add(botonListadoPorLetra);
        panelFondo.add(botonObtenerListado);
        panelFondo.add(botonModificar);
        panelFondo.add(botonEliminar);


        // Agregar el panel de fondo a la ventana
        ventana.add(panelFondo);

        // Mostrar ventana
        ventana.setSize(400, 300);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);




    }

    public static void main(String[] args) {
        new InterfazGrafica();
    }
}