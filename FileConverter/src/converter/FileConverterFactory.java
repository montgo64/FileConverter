package converter;

// Abstract Factory
public class FileConverterFactory {
    // Declare class instance and builders
    private static FileConverterFactory fileConverterFactory = null;
    private ConvertCsvToTsv csvToTsv = new ConvertCsvToTsv();

    // Class instantiator
    public static FileConverterFactory getInstance()
    {
        if (fileConverterFactory == null)
            fileConverterFactory = new FileConverterFactory();
        return fileConverterFactory;
    }

    // Call conversion from .csv to .tsv
    public void csvToTsv()
    {
        csvToTsv.chooseFile();
        csvToTsv.convert();
    }
}
