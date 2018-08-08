package converter;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

// Abstract Builder Prototype. Super class that concrete builds inherit from.
public class ConverterBuilder {
    // Selected file from chooseFile
    File file;
    // How extension appears in File Chooser window
    String extensionName;
    // Filtered extension for File Chooser
    String extension;
    // New Extension
    String newExtension;

    // Set new extension
    public void setNewExtension(String newExtension)
    {
        this.newExtension = newExtension;
    }

    // Constructor
    public ConverterBuilder()
    {}

    // Open a File Chooser and select the file you wish to convert. Which file that's
    // Converted depends on what's defined in the concrete builder.
    public void chooseFile()
    {
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        FileNameExtensionFilter filter = new FileNameExtensionFilter(extensionName, extension);
        jfc.setFileFilter(filter);

        int returnValue = jfc.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            file = jfc.getSelectedFile();
        }
    }
}
