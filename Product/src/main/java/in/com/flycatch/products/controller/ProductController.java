package in.com.flycatch.products.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import in.com.flycatch.products.dto.ProductDTO;
import in.com.flycatch.products.model.ProductDtl;
import in.com.flycatch.products.service.ProductServiceImp;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductServiceImp productService;

	public ProductController() {
		productService=new ProductServiceImp();
	}

	/*
	 * to insert
	 */
	@RequestMapping("/createProduct")
	public  ResponseEntity<ProductDtl> createProduct(@RequestBody ProductDTO product,HttpServletRequest request,HttpServletResponse response) throws SQLException {
		try {
			productService.buildProduct(product);
			product.setStatus("Product created successfully");
		}catch(Exception e) {
			product.setStatus("Creation failed!!!");
		}
		return new ResponseEntity<ProductDtl>(HttpStatus.OK);
	}

	/*
	 * to load
	 */
	@RequestMapping(value="/loadProduct")
	public  ResponseEntity<ProductDTO> loadProducts(HttpServletRequest request,HttpServletResponse response) throws JsonParseException, JsonMappingException, IOException {
		
		ProductDTO productDTO=new ProductDTO();
		List<ProductDTO> productData=null;
		try {
			productData=productService.loadProducts();
			if(productData.size()>0) {
				productDTO.setProductDtl(productData);
				productDTO.setStatus("success");
			}
		} catch (SQLException e) {
			productDTO.setStatus("Insufficient Data");
			e.printStackTrace();			
		}
		return new ResponseEntity<ProductDTO>(productDTO, HttpStatus.OK);
	}
}
