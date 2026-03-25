import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;


//Ramos Badillo Gustavo Yael
public class CalculadoraGrafica extends JFrame {

    JTextField n1, n2;
    JButton btnSum, btnRes, btnDiv, btnMul;
    JLabel txtRes;
    Font fuente = new Font("Courier", Font.BOLD, 30);

    public CalculadoraGrafica() {
        setTitle("Calculadora tipo Casio");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));

        // Campos de texto
        n1 = new JTextField();
        n1.setFont(fuente);

        n2 = new JTextField();
        n2.setFont(fuente);

        // Panel de botones
        JPanel pOpciones = new JPanel(new GridLayout(1, 4));

        btnSum = new JButton("+");
        btnRes = new JButton("-");
        btnMul = new JButton("*");
        btnDiv = new JButton("/");

        btnSum.setFont(fuente);
        btnRes.setFont(fuente);
        btnMul.setFont(fuente);
        btnDiv.setFont(fuente);

        pOpciones.add(btnSum);
        pOpciones.add(btnRes);
        pOpciones.add(btnMul);
        pOpciones.add(btnDiv);

        // Resultado
        txtRes = new JLabel("Resultado: 0");
        txtRes.setFont(fuente);

        // Eventos con lambdas
        btnSum.addActionListener(e -> calcular("+"));
        btnRes.addActionListener(e -> calcular("-"));
        btnMul.addActionListener(e -> calcular("*"));
        btnDiv.addActionListener(e -> calcular("/"));

        // Agregar componentes
        add(n1);
        add(n2);
        add(pOpciones);
        add(txtRes);
    }

    public class Calculadora {

        public static double sumar(double a, double b) {
            return a + b;
        }

        public static double restar(double a, double b) {
            return a - b;
        }

        public static double multiplicar(double a, double b) {
            return a * b;
        }

        public static double dividir(double a, double b) {
            return a / b;
        }
    }

    public void calcular(String operador) {
        try {
            double num1 = Double.parseDouble(n1.getText());
            double num2 = Double.parseDouble(n2.getText());
            double resultado = 0;

            switch (operador) {
                case "+":
                    resultado = Calculadora.sumar(num1, num2);
                    break;
                case "-":
                    resultado = Calculadora.restar(num1, num2);
                    break;
                case "*":
                    resultado = Calculadora.multiplicar(num1, num2);
                    break;
                case "/":
                    if (num2 == 0) {
                        JOptionPane.showMessageDialog(this, "No se puede dividir entre 0");
                        return;
                    }
                    resultado = Calculadora.dividir(num1, num2);
                    break;
            }

            txtRes.setText("Resultado: " + resultado);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingresa números válidos");
        }
    }

    public static void main(String[] args) {
        new CalculadoraGrafica().setVisible(true);
    }
}