import java.awt.Color;
import java.awt.GridLayout;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;


//Ramos Badillo Gustavo Yael
public class Fred20 extends JFrame {

    JButton casillas[] = new JButton[4];
    int[] secuencia = new int[6];
    Random r = new Random();

    // Colores de cada botón
    Color[] colores = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW};

    public Fred20() {
        setTitle("Fred20");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 2));

        for (int i = 0; i < casillas.length; i++) {
            casillas[i] = new JButton();
            casillas[i].setBackground(Color.LIGHT_GRAY);

            int index = i; // importante para lambda

            // 🔥 Evento con lambda
            casillas[i].addActionListener(e -> encenderBoton(index));

            add(casillas[i]);
        }

        crearSecuencia();
        mostrarSecuencia();
    }

    public void crearSecuencia() {
        for (int i = 0; i < secuencia.length; i++) {
            secuencia[i] = r.nextInt(4);
        }

        for (int x : secuencia) {
            System.out.print(x + " ");
        }
    }

    public void mostrarSecuencia() {

        Thread hilo = new Thread(() -> {

            for (int i = 0; i < secuencia.length; i++) {
                int indice = secuencia[i];

                try {
                    // 🔥 Enciende con color correspondiente
                    casillas[indice].setBackground(colores[indice]);
                    Thread.sleep(800);

                    // 🔁 Apaga (gris)
                    casillas[indice].setBackground(Color.LIGHT_GRAY);
                    Thread.sleep(300);

                } catch (Exception e) {
                }
            }

        });

        hilo.start();
    }

    // 🔥 Método para cuando el usuario presiona
    public void encenderBoton(int index) {

        new Thread(() -> {
            try {
                casillas[index].setBackground(colores[index]);
                Thread.sleep(500);
                casillas[index].setBackground(Color.LIGHT_GRAY);
            } catch (Exception e) {
            }
        }).start();
    }

    public static void main(String[] args) {
        new Fred20().setVisible(true);
    }
}