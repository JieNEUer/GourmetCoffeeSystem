
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.io.*;

public class FileCatalogLoader implements CatalogLoader {
    @Override
    public Catalog loadCatalog(String filename) throws FileNotFoundException, IOException, DataFormatException {
        Catalog catalog = new Catalog();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Product")) {
                    Product product = readProduct(line);
                    catalog.addProduct(product);
                } else if (line.startsWith("Coffee")) {
                    Coffee coffee = readCoffee(line);
                    catalog.addProduct(coffee);
                } else if (line.startsWith("Brewer")) {
                    CoffeeBrewer brewer = readCoffeeBrewer(line);
                    catalog.addProduct(brewer);
                }
            }
        }
        return catalog;
    }

    private Product readProduct(String line) throws DataFormatException {
        StringTokenizer tokenizer = new StringTokenizer(line, "_");
        if (tokenizer.countTokens() != 4) {
            throw new DataFormatException(line);
        }
        tokenizer.nextToken();
        String code = tokenizer.nextToken();
        String description = tokenizer.nextToken();
        try {
            double price = Double.parseDouble(tokenizer.nextToken());
            return new Product(code, description, price);
        } catch (NumberFormatException e) {
            throw new DataFormatException(line);
        }
    }

    private Coffee readCoffee(String line) throws DataFormatException {
        StringTokenizer tokenizer = new StringTokenizer(line, "_");
        if (tokenizer.countTokens() != 10) {
            throw new DataFormatException(line);
        }
        tokenizer.nextToken();
        String code = tokenizer.nextToken();
        String description = tokenizer.nextToken();
        try {
            double price = Double.parseDouble(tokenizer.nextToken());
            String origin = tokenizer.nextToken();
            String roast = tokenizer.nextToken();
            String flavor = tokenizer.nextToken();
            String aroma = tokenizer.nextToken();
            String acidity = tokenizer.nextToken();
            String body = tokenizer.nextToken();
            return new Coffee(code, description, price, origin, roast, flavor, aroma, acidity, body);
        } catch (NumberFormatException e) {
            throw new DataFormatException(line);
        }
    }

    private CoffeeBrewer readCoffeeBrewer(String line) throws DataFormatException {
        StringTokenizer tokenizer = new StringTokenizer(line, "_");
        if (tokenizer.countTokens() != 7) {
            throw new DataFormatException(line);
        }
        tokenizer.nextToken();
        String code = tokenizer.nextToken();
        String description = tokenizer.nextToken();
        try {
            double price = Double.parseDouble(tokenizer.nextToken());
            String model = tokenizer.nextToken();
            String waterSupply = tokenizer.nextToken();
            int numberOfCups = Integer.parseInt(tokenizer.nextToken());
            return new CoffeeBrewer(code, description, price, model, waterSupply, numberOfCups);
        } catch (NumberFormatException e) {
            throw new DataFormatException(line);
        }
    }
}