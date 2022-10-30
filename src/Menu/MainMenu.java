package Menu;

import javax.swing.*;

public class MainMenu extends JFrame
{
    private JButton dertButton; // = new JButton("Derdini sikeyim butonu");
    private JPanel panel1; // = new JPanel();

    public MainMenu(String appTitle)
    {
        super(appTitle);

        dertButton.setText("Derdini sikeyim butonu");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel1);
        this.pack();
    }
}