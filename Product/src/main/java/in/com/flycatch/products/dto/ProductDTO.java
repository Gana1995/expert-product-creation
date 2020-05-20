package in.com.flycatch.products.dto;

import java.sql.Date;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import in.com.flycatch.products.model.ProductDtl;

public class ProductDTO {

	private String productName;
	private String productCategory;
	private String productColor;
	private Double costPrice;
	private Date createdDate;
	private String status;
	private List<ProductDTO> productDtl;
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public String getProductColor() {
		return productColor;
	}
	public void setProductColor(String productColor) {
		this.productColor = productColor;
	}
	public Double getCostPrice() {
		return costPrice;
	}
	public void setCostPrice(Double costPrice) {
		this.costPrice = costPrice;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<ProductDTO> getProductDtl() {
		return productDtl;
	}
	public void setProductDtl(List<ProductDTO> productDtl) {
		this.productDtl = productDtl;
	}
	
	
	
}
