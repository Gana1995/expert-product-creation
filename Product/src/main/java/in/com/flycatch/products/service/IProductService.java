package in.com.flycatch.products.service;

import java.sql.SQLException;
import java.util.List;

import com.google.gson.JsonArray;

import in.com.flycatch.products.dto.ProductDTO;
import in.com.flycatch.products.model.ProductDtl;

public interface IProductService {

	String buildProduct(ProductDTO product) throws SQLException;
	List<ProductDTO> loadProducts() throws SQLException;
}
