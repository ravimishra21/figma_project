
package com.project.cart_api.entities;


import java.util.Set;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;



@Entity
@Table(name="cartApi")
public class CartApi {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="cartApi_id")
	private int id;
	private String imageName;
	private String name;
	private String detail;
	private String price;
	private String previous_price;
	private String location;
	private String views;
	
	@Lob
	@Column(length = 500000000)
	private byte[] image;
	private String imagePath;
	private String imageContentType;
	
//	@ManyToMany(fetch = FetchType.EAGER , cascade= CascadeType.ALL)
//	@JoinTable(name ="product_images" ,
//			joinColumns = {
//					@JoinColumn(name="cartApi_id")
//			},
//			inverseJoinColumns = {
//					@JoinColumn(name="image_id")
//			}
//			)
//	private Set<ImageModel> productImages;
//	
//	public Set<ImageModel> getProductImages() {
//		return productImages;
//	}
//
//
//	public void setProductImages(Set<ImageModel> productImages) {
//		this.productImages = productImages;
//	}


	public CartApi(int id, String imageName, String name, String detail, String price, String previous_price,
			String location, String views, byte[] image, String imagePath, String imageContentType) {
		super();
		this.id = id;
		this.imageName = imageName;
		this.name = name;
		this.detail = detail;
		this.price = price;
		this.previous_price = previous_price;
		this.location = location;
		this.views = views;
		this.image = image;
		this.imagePath = imagePath;
		this.imageContentType = imageContentType;
	}


	public CartApi() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getImageName() {
		return imageName;
	}


	public void setImageName(String imageName) {
		this.imageName = imageName;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDetail() {
		return detail;
	}


	public void setDetail(String detail) {
		this.detail = detail;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	public String getPrevious_price() {
		return previous_price;
	}


	public void setPrevious_price(String previous_price) {
		this.previous_price = previous_price;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getViews() {
		return views;
	}


	public void setViews(String views) {
		this.views = views;
	}
	

	public byte[] getImage() {
		return image;
	}


	public void setImage(byte[] image) {
		this.image = image;
	}
	


	public String getImagePath() {
		return imagePath;
	}



	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}



	public String getImageContentType() {
		return imageContentType;
	}



	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}


	@Override
	public String toString() {
		return "CartApi [id=" + id + ", imageName=" + imageName + ", name=" + name + ", detail=" + detail + ", price="
				+ price + ", previous_price=" + previous_price + ", location=" + location + ", views=" + views + "]";
	}
	
	
	
	
	
	
	
}
