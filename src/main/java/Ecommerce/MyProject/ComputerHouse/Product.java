package Ecommerce.MyProject.ComputerHouse;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonFormat;



@Document(collection = "products")
public class Product {
	
@Id
private String id;
private String name,desc,brand,category;
private double price;
@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd-MM-yyyy")
private Date releaseDate;
private boolean available;
private String imageName;
private String imageType;
private byte[] imageDate;

public Product() {
	
}

public Product(String id, String name, String desc, String brand, String category, double price, Date releaseDate,
		boolean available) {
	super();
	this.id = id;
	this.name = name;
	this.desc = desc;
	this.brand = brand;
	this.category = category;
	this.price = price;
	this.releaseDate = releaseDate;
	this.available = available;
}

public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDesc() {
	return desc;
}
public void setDesc(String desc) {
	this.desc = desc;
}
public String getBrand() {
	return brand;
}
public void setBrand(String brand) {
	this.brand = brand;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public Date getReleaseDate() {
	return releaseDate;
}
public void setReleaseDate(Date releaseDate) {
	this.releaseDate = releaseDate;
}
public boolean isAvailable() {
	return available;
}
public void setAvailable(boolean available) {
	this.available = available;
}



public String getImageType() {
	return imageType;
}

public void setImageType(String imageType) {
	this.imageType = imageType;
}

public byte[] getImageDate() {
	return imageDate;
}

public void setImageDate(byte[] imageDate) {
	this.imageDate = imageDate;
}

public String getImageName() {
	return imageName;
}

public void setImageName(String imageName) {
	this.imageName = imageName;
}


@Override
public String toString() {
	return "Product [id=" + id + ", name=" + name + ", desc=" + desc + ", brand=" + brand + ", category=" + category
			+ ", price=" + price + ", releaseDate=" + releaseDate + ", available=" + available + "]";
}

}
