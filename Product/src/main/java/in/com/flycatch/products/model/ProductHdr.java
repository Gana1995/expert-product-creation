package in.com.flycatch.products.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product_hdr")
public class ProductHdr {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name="created_date")
	private Date createdDate;
	
	@Column(name="product_hdr_id")
	private Integer productHdrId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getProductHdrId() {
		return productHdrId;
	}

	public void setProductHdrId(Integer productHdrId) {
		this.productHdrId = productHdrId;
	}
	
	
}
