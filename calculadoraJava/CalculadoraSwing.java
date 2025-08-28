package calculadoraJava;
 
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CalculadoraSwing extends JFrame implements ActionListener {

    private JTextField campoTexto;
    private String operador;
    private double num1, num2, resultado;

    public CalculadoraSwing(){
        super("Calculadora");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        campoTexto = new JTextField();
        campoTexto.setEditable(false);
        campoTexto.setFont(new Font("Arial", Font.BOLD, 24));
        add(campoTexto, BorderLayout.NORTH);

        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(4, 4, 5, 5));

        String[] botoes = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        };

        for (String txt : botoes) {
            JButton botao = new JButton(txt);
            botao.setFont(new Font("Arial", Font.BOLD, 18));
            botao.addActionListener(this);
            painel.add(botao);

        }

        add(painel, BorderLayout.CENTER);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();


        if (comando.charAt(0)>= '0' && comando.charAt(0) <= '9') {
            campoTexto.setText(campoTexto.getText() + comando);

        

        }else if (comando.equals("C")) {
            campoTexto.setText("");

            num1 = num2 = resultado = 0;
            operador = "";



            
        }else if (comando.equals("=")) {
            num2 = Double.parseDouble(campoTexto.getText());

//switch pra exercer a função desejada pelo usuario
            switch (operador) {

                case "+": 
                resultado = num1 + num2; 
                    
                    break;

                    case "-":
                    resultado = num1 - num2;
                    break;

                    case "*":
                    resultado = num1 * num2;
                    break;

                    case "/":
                    if(num2 == 0){
                        JOptionPane.showMessageDialog(this, "Erro: divisão por zero");
                        return;
                 }
                    resultado = num1 / num2; 
                    break;
            }
            campoTexto.setText(String.valueOf(resultado));
        } else { //operadores
            operador = comando;
            num1 = Double.parseDouble(campoTexto.getText());
            campoTexto.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CalculadoraSwing().setVisible(true);
        });
    }
}