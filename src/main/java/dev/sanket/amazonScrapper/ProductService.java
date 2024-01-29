package dev.sanket.amazonScrapper;
import java.util.List;

public interface ProductService {
    List<Product> scrapeAmazonLaptops(String url);
    void processAndSaveData(List<Product> products);
}
