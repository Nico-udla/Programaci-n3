import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel Panel;
    private JTextField txtUrl;
    private JButton btnInsertar;
    private JButton btnEliminar;
    private JButton btnCima;
    private JButton btnMostrar;
    private JTextArea txtListar;
    private JButton btnButton;
    private JButton BtnResetear;
    private Pila pila1= new Pila();

    public Ventana() {
        btnInsertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = txtUrl.getText();
                Post obj=new Post(url);
                pila1.push(obj);
                txtListar.setText(pila1.showAll());

            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Post eliminar=pila1.pop();
                    txtListar.setText(pila1.showAll());
                    JOptionPane.showMessageDialog(null, "se elimino" + eliminar.toString());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });

        btnCima.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Post cima=pila1.peak();
                    txtListar.setText(" La cima es " + cima.toString());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });

        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtListar.setText(pila1.showAll());

            }
        });

        btnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    pila1.peak().aumentarLikes();
                    txtListar.setText(pila1.showAll());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });

        BtnResetear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    pila1.peak().resetearLikes();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                txtListar.setText(pila1.showAll());
            }
        });

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().Panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
