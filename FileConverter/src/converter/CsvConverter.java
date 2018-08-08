package converter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

// .csv Converter Prototype. Allows users to convert .csv files to any new version.
public class CsvConverter extends ConverterBuilder implements Cloneable {

    // Base String that will be changed
    String baseString;
    // Replacement string
    String newString;

    // Set base string
    String getBaseString()
    {
        return baseString;
    }

    // Get base string
    void setBaseString(String baseString)
    {
        this.baseString = baseString;
    }

    // Set new string
    String getNewString()
    {
        return newString;
    }

    // Get new string
    void setNewString(String newString)
    {
        this.newString = newString;
    }

    // Get clone of existing converter
    public Object clone() {
        Object clone = null;

        try {
           clone = super.clone();

        } catch (CloneNotSupportedException e) {
           e.printStackTrace();
        }

        return clone;
     }

    // Begin by declaring the extension as *.csv and defaulting to a .tsv conversion
    public CsvConverter()
    {
        extension     = "csv";
        extensionName = "*.csv";
        setBaseString(",");
        setNewString("\t");
        setNewExtension(".tsv");
    }

    // Convert the chosen .csv file
    public void convert()
    {
        try
        {
            // If a valid file was chosen, perform the conversion
            if (file != null)
            {
                File tempFile = new File(file.getAbsolutePath().replace(".csv", newExtension));
                FileWriter fw = new FileWriter(tempFile);

                Reader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);

                // Read through each line and convert any comma to the new string/character
                while(br.ready()) {
                    fw.write(br.readLine().replaceAll(baseString, newString) + "\n");
                }

                fw.close();
                br.close();
                fr.close();
            }

            // If 'Cancel' was chosen in the file chooser, skip conversion.
            else
            {
                System.out.println("File Chooser was cancelled.");
            }
        }

        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
