import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

public class form extends JFrame {
    private JPanel panel;
    private JFormattedTextField formattedTextField1;
    private JLabel lbl1;


    form() {
        add(panel);
        setTitle("ARDA EREN 22410051054");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        try {
            MaskFormatter mf = new MaskFormatter("###########");
            mf.install(formattedTextField1);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }


        formattedTextField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String TcKimlikNo = formattedTextField1.getText();
                if (isValidTcKimlik(TcKimlikNo)) {
                    lbl1.setText("Geçerli");
                    lbl1.setOpaque(true);
                    lbl1.setBackground(Color.green);
                } else {
                    lbl1.setText("Geçersiz");
                    lbl1.setOpaque(true);
                    lbl1.setBackground(Color.red);
                }
            }

            private boolean isValidTcKimlik(String tcKimlikNo) {
                int islem = 0;
                for (int i = 0; i < 10; i++) {
                    islem += Character.getNumericValue(tcKimlikNo.charAt(i));

                }
                int islem2 = islem % 10;
                int sonKarakter = Character.getNumericValue(tcKimlikNo.charAt(10));
                return islem2 == sonKarakter;
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                form f = new form();
                f.setVisible(true);
            }
        });
    }
}
