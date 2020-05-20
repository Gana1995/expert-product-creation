package in.com.flycatch.products.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonArray;

import in.com.flycatch.products.dao.ProductDaoImp;
import in.com.flycatch.products.dto.ProductDTO;
import in.com.flycatch.products.model.ProductDtl;

@Service
public class ProductServiceImp implements IProductService{

	@Autowired
	 ProductDaoImp productDaoImp;
	
	public ProductServiceImp() {
         productDaoImp = new ProductDaoImp();
	}

	@Override
	public String buildProduct(ProductDTO product) throws SQLException {	
		return productDaoImp.buildProduct(product);
	}

	@Override
	public List<ProductDTO> loadProducts() throws SQLException {
		return productDaoImp.loadProducts();
	}

}
