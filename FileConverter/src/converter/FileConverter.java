package converter;

// Driver class, calls singleton of the factory class
public class FileConverter
{
    public static void main(String[] args)
    {
        // Get instance of abstract factory
        FileConverterFactory factory = FileConverterFactory.getInstance();

        // Create default .csv converter
        CsvConverter csvToTsv = factory.createCsvToTsvConverter();

        // Convert .csv to .tsv
        csvToTsv.chooseFile();
        csvToTsv.convert();

        // Create clone of csv converter that swaps comma for semi-colon
        CsvConverter newCsvToTsv = (CsvConverter) csvToTsv.clone();
        newCsvToTsv.setNewString(";");
        newCsvToTsv.setNewExtension("2.csv");

        newCsvToTsv.chooseFile();
        newCsvToTsv.convert();
    }
}