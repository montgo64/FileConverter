package converter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

// Convert .csv file to .tsv
public class ConvertCsvToTsv extends ConverterBuilder {

    // Begin by declaring the extension as *.csv
    public ConvertCsvToTsv()
    {
        extension     = "csv";
        extensionName = "*.csv";
    }

    // Convert the chosen .csv to a new .tsv file
    public void convert()
    {
        try
        {
            // If a valid file was chosen, perform the conversion
            if (file != null)
            {
                File tempFile = new File(file.getAbsolutePath().replace(".csv", ".tsv"));
                FileWriter fw = new FileWriter(tempFile);

                Reader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);

                // Read through each line and convert any comma to a tab
                while(br.ready()) {
                    fw.write(br.readLine().replaceAll(",", "\t") + "\n");
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
