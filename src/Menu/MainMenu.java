package Menu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame
{
    private JButton dertButton; // = new JButton("Derdini sikeyim butonu");
    private JPanel panel1; // = new JPanel();
    private JLabel dertText;

    public MainMenu(String appTitle)
    {
        super(appTitle);

        dertButton.setText("Derdini sikeyim butonu");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel1);
        this.pack();
        dertButton.addActionListener(e -> {
            dertText.setText("DERDİNİ SİKEYİM!!!");

            JOptionPane.showMessageDialog(null, "Derdiniz sikilmiştir. Bilginize.", "Bilgilendirme Mesajı", JOptionPane.INFORMATION_MESSAGE);
        });
    }
}