
package com.project.cart_api.controller;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.cart_api.entities.CartApi;
import com.project.cart_api.service.CartApiService;


import org.springframework.http.MediaType;



@RestController
public class CartApiController {

	@Autowired
	private CartApiService cartApiService;
	
	public static String uploadDirectory=System.getProperty("user.dir")+"/src/main/webapp/images";
//	File saveFile=new ClassPathResource("static/img").getFile();
//	Path path=Paths.get(saveFile.getAbsolutePath()+File.separator +file.getOriginalFilename());
//	
	
	@GetMapping("/cartAll")
	public List<CartApi> getCarts(){
		
		return this.cartApiService.getAllCarts();
	}
	
//
//	@GetMapping("/carts/{id}")
//	public CartApi getCart(@PathVariable("id") int id) {
//		return cartApiService.getCartById(id);
//	}
	
	
	
	@PostMapping("/cartsAdd")
	public CartApi addCart(@ModelAttribute CartApi cart,@RequestParam("imageFile") MultipartFile file) throws IOException {
		
		String originalFileName=file.getOriginalFilename();
		File imageFolder=new File(uploadDirectory);
		if(!imageFolder.exists()) {
			imageFolder.mkdir(); 
			}
			
		Path fileNameAndPath=Paths.get(uploadDirectory ,originalFileName );
		
		System.out.println(fileNameAndPath);
		Files.write(fileNameAndPath, file.getBytes());
		cart.setImage(file.getBytes());
		cart.setImageName(originalFileName);
		String contentTypeImage=Files.probeContentType(fileNameAndPath);
		cart.setImageContentType(contentTypeImage);
		cart.setImagePath(fileNameAndPath.toString());
		CartApi c=cartApiService.addCart(cart);
		
		return c; 
		
	}
		
//	Fetching the data by id
	@GetMapping("/carts/{id}")
	public ResponseEntity<CartApi> getCartById(@PathVariable("id") int id){
		CartApi cartDetail = cartApiService.getCartById(id);
		System.out.println("cartDetail"+cartDetail);
		return ResponseEntity.ok().body(cartDetail);
	}
		 
	
	
//	Fetching the image of a particular student 
	@GetMapping("/carts/getImage/{id}")
	public ResponseEntity<Resource> getImage(@PathVariable("id") int id) throws IOException{
		CartApi cartDetail = cartApiService.getCartById(id);
//		Get the image path from the cart detail
		Path imagePath=Paths.get(uploadDirectory ,cartDetail.getImageName());
//		we are fetching the image from the particular path
		Resource resource = new FileSystemResource(imagePath.toFile());
//		here getting the content type of image
		String contentType=Files.probeContentType(imagePath);
//		we parse the image to display / return to postman
		return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType)).body(resource);
	}
	
	
		
		
//		CartApi c=null;
//		
//		System.out.println(file.getOriginalFilename());
//		System.out.println(file.getSize());
//		System.out.println(file.getContentType());
//		System.out.println(file.getName());
//		try {
			
//			if(file.isEmpty()) {
////				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("must contain file");
//				System.out.println("must contain file");
//				
//			}
//			if(!file.getContentType().equals("img/jpeg")){
//				System.out.println("must be jpeg file");
//			}
//			
//		boolean b=uploadFile(file);
//		if(b) {
//			System.out.println("must be jpeg file");
//		}
//			 {
			//	cart.setImageName(file.getOriginalFilename());
//				File saveFile=new ClassPathResource("static/img").getFile();
//				Path path=Paths.get(saveFile.getAbsolutePath()+File.separator +file.getOriginalFilename());
//				
//				Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
//				
//				
//			}
		//	c=this.cartApiService.addCart(cart);
			
		
		//	return ResponseEntity.of(Optional.of(c));
//		return ResponseEntity.ok("done");
//			
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//		}
//	}
	
	public final String UPLOAD_DIR="C:\\Users\\mishr\\Documents\\workspace-spring-tool-suite-4-4.19.0.RELEASE\\new5\\Cart2\\src\\main\\resources\\static\\img";
	
//	public boolean uploadFile( MultipartFile multipartFile) {
//		
//		boolean f=false;
//		try {
//			
//			InputStream is=multipartFile.getInputStream();
//			byte data[] =new byte[is.available()];
//			is.read();
//			
//			FileOutputStream fos=new FileOutputStream(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename());
//			fos.write(data);
//			
//			fos.flush();
//			fos.close();
//			
//			f=true;
//			
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		
//		}
//		return f;
//	}
	
//	new cart Adding handler
//	@PostMapping("/cartsAdd")
//	public ResponseEntity<CartApi> addCart(@RequestBody CartApi cart,@RequestParam("imageFile") MultipartFile file){
//		
//		CartApi c=null;
//		try {
//			
//			if(file.isEmpty()) {
//				
//			}else {
//				cart.setImageName(file.getOriginalFilename());
//				File saveFile=new ClassPathResource("static/img").getFile();
//				Path path=Paths.get(saveFile.getAbsolutePath()+File.separator +file.getOriginalFilename());
//				
//				Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
//				
//				
//			}
//			c=this.cartApiService.addCart(cart);
//			
//		
//			return ResponseEntity.of(Optional.of(c));			
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//		}
//	}
	
	
//	for API and image both
//	public ResponseEntity<CartApi> addCart(@RequestPart("cart") CartApi cart , @RequestPart("imageFile")MultipartFile[] file ){
		
	
//	@PostMapping(value = {"/cartsAdd"} , consumes= {MediaType.MULTIPART_FORM_DATA_VALUE})
//	public ResponseEntity<CartApi> addCart(@RequestParam(value="cart", required=false ) CartApi cart , @RequestParam("imageFile") MultipartFile[] file ){
//		
//		CartApi c=null;
//		try {
//			
//			System.out.println("file"+file);
//			Set<ImageModel> images =uploadImage(file);
//			System.out.println("images"+images);
//			cart.setProductImages(images);
//			System.out.println("cart"+cart);
//			c=this.cartApiService.addCart(cart);
//			System.out.println("c"+c);
//			
//		
//			return ResponseEntity.of(Optional.of(c));			
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//		}
//	}
//	
//	
//	
//	public Set<ImageModel> uploadImage(MultipartFile[] multipartFiles) throws IOException {
//		Set<ImageModel> imageModels = new HashSet<>();
//		
//		for(MultipartFile file : multipartFiles) {
//			System.out.println("file"+file);
//			ImageModel imageModel = new ImageModel(file.getOriginalFilename(),file.getContentType(), file.getBytes() );
//					imageModels.add(imageModel);
//					
//		}
//		
//		return imageModels;
//	}
	

//	Delete cart handler
	@DeleteMapping("/carts/{cartId}")
	public ResponseEntity<Void> deleteCart(@PathVariable("cartId") int cartId){
		
		try {
			this.cartApiService.deleteCart(cartId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	

//	update cart handler
	@PutMapping("/carts/{cartId}") 
	public ResponseEntity<CartApi> updateCart(@RequestBody CartApi cart , @PathVariable("cartId") int cartId){
		
		try {
			this.cartApiService.updateCart(cart , cartId);
			return ResponseEntity.ok().body(cart);
		} catch(Exception e) {
			e.printStackTrace(); 
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	
}
