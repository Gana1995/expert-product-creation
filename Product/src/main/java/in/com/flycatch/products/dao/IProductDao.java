package in.com.flycatch.products.dao;

import java.sql.SQLException;
import java.util.List;

import in.com.flycatch.products.dto.ProductDTO;

public interface IProductDao {

	String buildProduct(ProductDTO product) throws SQLException;

	List<ProductDTO> loadProducts() throws SQLException;

}
