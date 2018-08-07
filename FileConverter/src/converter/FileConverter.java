package converter;

// Driver class, calls singleton of the factory class
public class FileConverter
{
    public static void main(String[] args)
    {
        // Get instance of abstract factory
        FileConverterFactory factory = FileConverterFactory.getInstance();

        // Call .csv to .tsv converter
        factory.csvToTsv();
    }
}