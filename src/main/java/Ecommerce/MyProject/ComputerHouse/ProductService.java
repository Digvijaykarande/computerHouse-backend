package Ecommerce.MyProject.ComputerHouse;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;
    @Autowired
    private Cloudinary cloudinary;

    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public Product getProductById(String id) {
        return repo.findById(id).orElse(null);
    }

    public Product addProduct(Product product, MultipartFile imagefile) throws IOException {
        if (imagefile != null && !imagefile.isEmpty()) {
        	Map<String, Object> uploadResult = cloudinary.uploader().upload(
                imagefile.getBytes(),ObjectUtils.asMap("folder", "computerhouse"));

        	String publicId = (String) uploadResult.get("public_id"); 
        	product.setImageName(publicId); 
        }
		return repo.save(product); 
    }
    
    public boolean deleteProduct(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }



}