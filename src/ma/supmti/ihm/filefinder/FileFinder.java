package ma.supmti.ihm.filefinder;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

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
        setVisible(Boolean.TRUE);
	}
	
	public static void main(String[] args) {
		new FileFinder();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Bouton Trouver cliqué !");
		
	}
}
