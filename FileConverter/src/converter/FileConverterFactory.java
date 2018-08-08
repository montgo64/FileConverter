package converter;

// Abstract Factory
public class FileConverterFactory {
    // Declare class instance and builders
    private static FileConverterFactory fileConverterFactory = null;

    // Class instantiator
    public static FileConverterFactory getInstance()
    {
        if (fileConverterFactory == null)
            fileConverterFactory = new FileConverterFactory();
        return fileConverterFactory;
    }

    // Create csv converter
    public CsvConverter createCsvToTsvConverter()
    {
        return new CsvConverter();
    }
}
