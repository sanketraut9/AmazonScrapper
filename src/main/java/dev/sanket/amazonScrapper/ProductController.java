package dev.sanket.amazonScrapper;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/scrape")
    public void scrapeAndSaveLaptops() {
        String amazonUrl = "https://www.amazon.in/s?k=laptop&ref=nb_sb_noss";
        List<Product> products = productService.scrapeAmazonLaptops(amazonUrl);
        productService.processAndSaveData(products);
    }
}
