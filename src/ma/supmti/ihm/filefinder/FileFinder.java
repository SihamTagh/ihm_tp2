package ma.supmti.ihm.filefinder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;


public class FileFinder extends JFrame implements ActionListener {
    private JList filesList;

    public FileFinder() {
        super("File Finder");

        filesList = new JList();
        add(new JScrollPane(filesList), BorderLayout.CENTER);

        JPanel buttons = new JPanel();
        JButton findButton = new JButton("Trouver");
        findButton.addActionListener(this);
        buttons.add(findButton);
        add(buttons, BorderLayout.EAST);

        pack();
        setLocationRelativeTo(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                FileFinder finder = new FileFinder();
                finder.setVisible(true);
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        FileFinderWorker worker = new FileFinderWorker(filesList);
        worker.start();
    }
}
