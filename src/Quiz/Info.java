package Quiz;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class Info extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField vards;
    private JTextField uzvards;
    private JButton btnNewButton;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Info frame = new Info();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Info() {
        setTitle("");
        setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 499, 379);
        setLocationRelativeTo(null);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Vārds:");
        lblNewLabel.setBounds(54, 118, 158, 14);
        contentPane.add(lblNewLabel);

        vards = new JTextField();
        vards.setBounds(54, 143, 158, 20);
        contentPane.add(vards);
        vards.setColumns(10);

        uzvards = new JTextField();
        uzvards.setBounds(260, 143, 158, 20);
        contentPane.add(uzvards);
        uzvards.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Uzvārds:");
        lblNewLabel_1.setBounds(260, 118, 158, 14);
        contentPane.add(lblNewLabel_1);

        btnNewButton = new JButton("Turpināt");
        btnNewButton.setIcon(null);
        btnNewButton.setForeground(Color.BLACK);
        btnNewButton.setBackground(new Color(255, 255, 255));
        btnNewButton.setBounds(191, 180, 89, 23);
        contentPane.add(btnNewButton);
        btnNewButton.setEnabled(false);

        JLabel lblNewLabel_3 = new JLabel("Tests");
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3.setForeground(new Color(255, 0, 0));
        lblNewLabel_3.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 24));
        lblNewLabel_3.setBounds(70, 11, 348, 96);
        contentPane.add(lblNewLabel_3);
        
        JTextArea txtrMaziTestsPar = new JTextArea();
        txtrMaziTestsPar.setEditable(false);
        txtrMaziTestsPar.setToolTipText("");
        txtrMaziTestsPar.setLineWrap(true);
        txtrMaziTestsPar.setText("Maziņš Tests par 2D masīviem.\r\nTiks uzdoti 10 jautājumi kur ir 2 pareizās atbildes.\r\nVēlu Veiksmi!");
        txtrMaziTestsPar.setBounds(10, 214, 463, 96);
        contentPane.add(txtrMaziTestsPar);
        
        JLabel lblNewLabel_3_1 = new JLabel("Maziņš Tests par 2D masīviem.");
        lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3_1.setForeground(Color.RED);
        lblNewLabel_3_1.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 24));
        lblNewLabel_3_1.setBounds(70, 190, 348, 96);
        contentPane.add(lblNewLabel_3_1);

      
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = vards.getText().trim();
                String surname = uzvards.getText().trim();

                
                if (!name.isEmpty() && !surname.isEmpty()) {
                 
                    Tests screen = new Tests();
                    screen.setVisible(true);
                    dispose(); 
                } else {
                    JOptionPane.showMessageDialog(Info.this, "Lūdzu, aizpildi visus lodziņus.");
                }
            }
        });

        // Pārbauda vai visas ailes ir aizpildītas
        vards.getDocument().addDocumentListener(new CustomDocumentListener());
        uzvards.getDocument().addDocumentListener(new CustomDocumentListener());
    }

   
    private class CustomDocumentListener implements DocumentListener {
        @Override
        public void insertUpdate(DocumentEvent e) {
            checkFields();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            checkFields();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
          
        }

        private void checkFields() {
            String name = vards.getText().trim();
            String surname = uzvards.getText().trim();

            //Poga darboas tikai tad ja ir izdarīti specifiski prasījumi
            btnNewButton.setEnabled(!name.isEmpty() && !surname.isEmpty() && name.length() > 3 && surname.length() > 3);
        }
    }
}
