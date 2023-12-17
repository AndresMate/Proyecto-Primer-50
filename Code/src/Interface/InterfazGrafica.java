/**
 * La clase BienvenidaPapeleria representa la ventana de inicio de la Papeleria La Esmeralda.
 * Proporciona opciones para iniciar sesión o registrarse como usuario.
 */
package Interface;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InterfazGrafica {

    JFrame ventana = new JFrame("DICTIONARY");
    ImageIcon icon = new ImageIcon(getClass().getResource("Images/icono.png"));


    JLabel textoBienvenida;
    JButton botonAgregar, botonConsultar,botonObtenerListado,botonListar ,botonModificar;
    /**
     * Constructor de la clase BienvenidaPapeleria.
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
                ImageIcon fondo = new ImageIcon(getClass().getResource("Images/fondo.jpeg"));
                float opacity = 0.8f; // Puedes ajustar este valor según sea necesario
                ((Graphics2D) g).setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));
                g.drawImage(fondo.getImage(), 0, 30, getWidth(), getHeight(), this);
            }
        };

        // Configurar el JPanel personalizado
        panelFondo.setLayout(new GridLayout(7, 1));

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


        botonConsultar = new JButton("Consultar palabra");
        botonConsultar.setForeground(Color.BLACK);
        botonConsultar.setBackground(new Color(245, 180, 145, 255));
        botonConsultar.setFont(new Font("Monospaced", Font.BOLD, 20));
        botonConsultar.setOpaque(false);

        botonObtenerListado = new JButton("Obtener Listado");
        botonObtenerListado.setForeground(Color.BLACK);
        botonObtenerListado.setBackground(new Color(245, 180, 145, 255));
        botonObtenerListado.setFont(new Font("Monospaced", Font.BOLD, 20));
        botonObtenerListado.setOpaque(false);

        botonListar = new JButton("Listar palabras");
        botonListar.setForeground(Color.BLACK);
        botonListar.setBackground(new Color(245, 180, 145, 255));
        botonListar.setFont(new Font("Monospaced", Font.BOLD, 20));
        botonListar.setOpaque(false);

        botonModificar = new JButton("Modificar palabras");
        botonModificar.setForeground(Color.BLACK);
        botonModificar.setBackground(new Color(245, 180, 145, 255));
        botonModificar.setFont(new Font("Monospaced", Font.BOLD, 20));
        botonModificar.setOpaque(false);


        panelFondo.add(textoBienvenida);
        panelFondo.add(botonAgregar);
        panelFondo.add(botonConsultar);
        panelFondo.add(botonObtenerListado);
        panelFondo.add(botonListar);
        panelFondo.add(botonModificar);

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