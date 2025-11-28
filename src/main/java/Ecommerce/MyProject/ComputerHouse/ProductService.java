package Ecommerce.MyProject.ComputerHouse;


import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;

    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public Product getProductById(String id) {
        return repo.findById(id).orElse(null);
    }

    public Product addProduct(Product product, MultipartFile imagefile) throws IOException {

        if (imagefile != null && !imagefile.isEmpty()) {
            product.setImageName(imagefile.getOriginalFilename());
            product.setImageType(imagefile.getContentType());
            product.setImageDate(imagefile.getBytes());
        }

        return repo.save(product);
    }


}