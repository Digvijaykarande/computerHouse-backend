package Ecommerce.MyProject.ComputerHouse;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
@CrossOrigin
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
	public Product addProduct(
	        @RequestPart("product") Product product,
	        @RequestPart("imagefile") MultipartFile imagefile) {

	    try {
	        return service.addProduct(product, imagefile);

	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	
//	@DeleteMapping("/products/{id}")
//	public void deleteProduct(@PathVariable String id) {
//		
//	}
	
}

