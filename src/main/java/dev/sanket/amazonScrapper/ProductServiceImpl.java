package dev.sanket.amazonScrapper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private static final String OUTPUT_FILE_NAME = "product.csv";

    @Override
    public List<Product> scrapeAmazonLaptops(String url) {
        List<Product> products = new ArrayList<>();
        try {
            Document document = Jsoup.connect(url).userAgent("Mozilla").get();
            extractData(document, products);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public void processAndSaveData(List<Product> products) {
        try (FileWriter writer = new FileWriter(OUTPUT_FILE_NAME)) {
            for (Product product : products) {
                writer.write(product.toNDJSONString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // Extracted fields and specifications

    private void extractData(Document document, List<Product> products) {
        Elements laptopElements = document.select(".laptop-item");
        for (Element laptopElement : laptopElements) {
            Product product = new Product();
            product.setSkuId(laptopElement.attr("data-sku"));
            product.setProductName(laptopElement.select(".product-name").text());
            product.setProductTitle(laptopElement.select(".product-title").text());
            product.setDescription(laptopElement.select(".description").text());
            product.setCategory(laptopElement.select(".category").text());
            product.setMrp(Double.parseDouble(laptopElement.select(".mrp").text()));
            product.setSellingPrice(Double.parseDouble(laptopElement.select(".selling-price").text()));
            product.setDiscount(Integer.parseInt(laptopElement.select(".discount").text()));
            product.setWeight(Double.parseDouble(laptopElement.select(".weight").text()));
            product.setBrandName(laptopElement.select(".brand-name").text());
            product.setImageUrl(laptopElement.select(".image-url").attr("src"));
            product.setLaptopSpecification(laptopElement.select(".specifications").text());

            products.add(product);
        }
    }
}
