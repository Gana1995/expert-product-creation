package in.com.flycatch.products.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import in.com.flycatch.common.BaseDao;
import in.com.flycatch.products.dto.ProductDTO;
import in.com.flycatch.products.model.ProductDtl;
import in.com.flycatch.products.model.ProductHdr;

@Repository
public class ProductDaoImp implements IProductDao{

	BaseDao baseDao=null;
	ProductHdr productHdr=null;
	Connection connection=null;
	
	public ProductDaoImp() {
		baseDao=new BaseDao();
		connection=baseDao.getConnection();
	}

	@Override
	public String buildProduct(ProductDTO product) throws SQLException {
	    
		List<ProductDTO> productDTO=new ArrayList<>();
		productDTO=product.getProductDtl();
		String status="success";	
		PreparedStatement prsInsertHdrStatement=null;
		PreparedStatement prsInsertDtlStatement=null;
		
		try {
			connection.setAutoCommit(false);
			//getting current date
			long millis=System.currentTimeMillis();  
			java.sql.Date createdDate=new java.sql.Date(millis);  
			String insertHdrSql="insert into product_hdr(created_date) values(?)";
			String insertDtlSql="insert into product_dtl(product_hdr_id,product_category,product_name,product_color,cost_price) values(?,?,?,?,?)";
			prsInsertHdrStatement=connection.prepareStatement(insertHdrSql,Statement.RETURN_GENERATED_KEYS);
			prsInsertDtlStatement=connection.prepareStatement(insertDtlSql,Statement.RETURN_GENERATED_KEYS);
					
			for(int i=0;i<productDTO.size();i++) {	
			//insert hdr table
			prsInsertHdrStatement.setDate(1,createdDate);
			prsInsertHdrStatement.executeUpdate();
					
			ResultSet resultSet=prsInsertHdrStatement.getGeneratedKeys();
			if(resultSet.next()) {
			
			 long productId=resultSet.getLong(1);	
			//insert dtl table
			prsInsertDtlStatement.setLong(1,productId);
			prsInsertDtlStatement.setString(2, productDTO.get(i).getProductCategory());
			prsInsertDtlStatement.setString(3,productDTO.get(i).getProductName());
			prsInsertDtlStatement.setString(4,productDTO.get(i).getProductColor());
			prsInsertDtlStatement.setDouble(5,productDTO.get(i).getCostPrice());
			}
			//execute dtl query
			prsInsertDtlStatement.executeUpdate();
			}
			
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
			connection.rollback();
		}
		return status;
	}

	@Override
	public List<ProductDTO> loadProducts() throws SQLException {
	
		List<ProductDTO> productList=new ArrayList<>();
		ProductDTO productDTO=new ProductDTO();
		Statement statement=connection.createStatement();
		String selectSql="SELECT * FROM product_hdr hdr INNER JOIN product_dtl dtl ON hdr.id=dtl.product_hdr_id";
		ResultSet resultSet=statement.executeQuery(selectSql);
		while(resultSet.next()) {
			productDTO=new ProductDTO();
			productDTO.setProductName(resultSet.getString("product_name"));
			productDTO.setProductCategory(resultSet.getString("product_category"));
			productDTO.setProductColor(resultSet.getString("product_color"));
			productDTO.setCreatedDate(Date.valueOf(resultSet.getString("created_date")));
			productDTO.setCostPrice(Double.valueOf(resultSet.getString("cost_price")));
			productList.add(productDTO);
		}
		return productList;
	}

}
