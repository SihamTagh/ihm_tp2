package ma.supmti.ihm.filefinder;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.SwingUtilities;


public class FileFinderWorker extends SwingWorker {
    private JList filesList;
    private DefaultListModel filesListModel;
    final int[] counter = new int[1];
    
    public FileFinderWorker(JList filesList) {
        this.filesList = filesList;
        this.filesListModel = new DefaultListModel();
        this.filesList.setModel(this.filesListModel);
    }

    public void start() {
    	counter[0] = 0;
        filesListModel.removeAllElements();
        filesListModel.addElement("Recherche des fichiers *.java...");
        super.start();
    }

    public void finished() {
        filesListModel.removeAllElements();
        String[] files = (String[]) get();
        for (String file: files) {
            filesListModel.addElement(file);
        }
    }

    private void addFoundedJavaFilesToList(final List<String> list, File[] filesList)
    {
        // for-each loop for main directory files
    	if(filesList != null) {
    		for (File file : filesList) {
                if (file.isFile() && file.getName().endsWith(".java")) {
                	list.add(file.getName());
                	counter[0]++;
                	filesListModel.setElementAt("Recherche en cours de fichiers *.java...["+counter[0]+"]", 0);
                }
                
                else if (file.isDirectory()) {
                    // recursion for sub-directories
                    addFoundedJavaFilesToList(list, file.listFiles());
                }
            }
    	}
    }
    
    public Object construct() {
        final List<String> list = new ArrayList<String>();
        addFoundedJavaFilesToList(list, new File(".").listFiles());
        return list.toArray(new String[list.size()]);
    }
}
