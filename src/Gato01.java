import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


//Ramos Badillo Gustavo Yael
public class Gato01 extends JFrame implements ActionListener {

    JButton botones[] = new JButton[9];
    JButton btnReiniciar;
    boolean turnoX = true;
    Font fuente = new Font("Arial", Font.BOLD, 60);
    JPanel pJuego, pOpciones;
    String letra;

    public Gato01() {
        setTitle("Gato");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pJuego = new JPanel();
        pJuego.setLayout(new GridLayout(3, 3));

        for (int i = 0; i < botones.length; i++) {
            botones[i] = new JButton("");
            botones[i].setFont(fuente);
            botones[i].addActionListener(this);
            pJuego.add(botones[i]);
        }

        add(pJuego, BorderLayout.CENTER);

        btnReiniciar = new JButton("Reiniciar Juego");
        pOpciones = new JPanel();

        btnReiniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reiniciarJuego();
            }
        });

        pOpciones.add(btnReiniciar);
        add(pOpciones, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        Gato01 g = new Gato01();
        g.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (turnoX) {
            letra = "X";
            turnoX = false;
        } else {
            letra = "O";
            turnoX = true;
        }

        for (int i = 0; i < botones.length; i++) {
            if (e.getSource() == botones[i]) {
                botones[i].setText(letra);
                botones[i].setEnabled(false);
            }
        }

        verificarGanador();
        verificarEmpate();
    }


    public void verificarGanador() {

        String[][] t = new String[3][3];
        int k = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                t[i][j] = botones[k].getText();
                k++;
            }
        }

        // Filas y columnas
        for (int i = 0; i < 3; i++) {
            // Filas
            if (!t[i][0].equals("") &&
                    t[i][0].equals(t[i][1]) &&
                    t[i][1].equals(t[i][2])) {

                mostrarGanador(t[i][0]);
                return;
            }

            // Columnas
            if (!t[0][i].equals("") &&
                    t[0][i].equals(t[1][i]) &&
                    t[1][i].equals(t[2][i])) {

                mostrarGanador(t[0][i]);
                return;
            }
        }

        // Diagonal principal
        if (!t[0][0].equals("") &&
                t[0][0].equals(t[1][1]) &&
                t[1][1].equals(t[2][2])) {

            mostrarGanador(t[0][0]);
            return;
        }

        // Diagonal secundaria
        if (!t[0][2].equals("") &&
                t[0][2].equals(t[1][1]) &&
                t[1][1].equals(t[2][0])) {

            mostrarGanador(t[0][2]);
        }
    }


    public void mostrarGanador(String ganador) {
        JOptionPane.showMessageDialog(this, "Ganó: " + ganador);

        for (int i = 0; i < botones.length; i++) {
            botones[i].setEnabled(false);
        }
    }


    public void verificarEmpate() {
        boolean lleno = true;

        for (int i = 0; i < botones.length; i++) {
            if (botones[i].getText().equals("")) {
                lleno = false;
                break;
            }
        }

        if (lleno) {
            JOptionPane.showMessageDialog(this, "Empate");
            reiniciarJuego();
        }
    }

    //REINICIAR
    public void reiniciarJuego() {
        for (int i = 0; i < botones.length; i++) {
            botones[i].setText("");
            botones[i].setEnabled(true);
        }
        turnoX = true;
    }
}