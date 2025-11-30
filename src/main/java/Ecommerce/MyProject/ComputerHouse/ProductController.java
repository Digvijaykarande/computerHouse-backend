package Ecommerce.MyProject.ComputerHouse;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(origins = "*")
public class ProductController {
	@Autowired
	private ProductService service;

	@RequestMapping("/")
	public String home() {
		return "homePage...";
	}
	
	@GetMapping("/products")
	public List<Product> getAllProducts(){
		return service.getAllProducts();
	}
	
	@GetMapping("/products/{id}")
	public Product getProduct(@PathVariable String id) {
		return service.getProductById(id);
	}	
	
	@PostMapping(value = "/products", consumes = "multipart/form-data")
	public ResponseEntity<?> addProduct( 
	        @RequestPart("product") Product product,
	        @RequestPart("imagefile") MultipartFile imagefile) {
	    try {
	        Product savedProduct = service.addProduct(product, imagefile);
	        return ResponseEntity.ok(savedProduct); 
	    } catch (Exception e) {
	        e.printStackTrace();
	        return ResponseEntity.status(500).body("Error processing product or uploading image: " + e.getMessage());
	    }
	}
	
	@DeleteMapping("/products/{id}")
	public ResponseEntity<?> delete(@PathVariable String id) {
	    if (service.deleteProduct(id)) {
	        return ResponseEntity.ok("Deleted");
	    } else {
	        return ResponseEntity.status(404).body("Not found");
	    }
	}

	
}

