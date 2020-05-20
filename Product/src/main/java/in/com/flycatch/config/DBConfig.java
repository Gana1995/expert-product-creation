package in.com.flycatch.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource({ "classpath:database.properties" })
public class DBConfig {
	
	@Autowired
	Environment env;
    
	public static DBConfig single_instance=null;
	//private String jdbc_url="jdbc:mysql://localhost:3306/sample_application?user=root&password=root";
	//private String driverClassName="com.mysql.jdbc.Driver";
	
     public static DBConfig getInstance() {
		
		if(single_instance==null) {
			
			single_instance=new DBConfig();
			
		}
		
		return single_instance;
	}
	
	/**
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	@Bean
	public JdbcTemplate getJDBCTemplate() throws SQLException, Exception {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
	}
	
	
	/**
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	@Bean
	public DataSource getDataSource() throws SQLException, Exception {
	      BasicDataSource dataSource = new BasicDataSource();
	      dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
          dataSource.setUrl(env.getProperty("jdbc.url"));
	      return dataSource;
	}
	
	/**
	 * @return
	 * @throws Exception
	 *//*
	@Bean(name="dbHelper")
	public DBHelper getDBHelper() throws Exception{
		
		DBHelper dbHelper=null;
		
		switch(env.getProperty("dbType")){

		case "sqlite":
			dbHelper=SQLiteDBHelper.getInstance( env.getProperty("jdbc.url"));
			break;
		case "mysql":
			dbHelper=MySQLDBHelper.getInstance();
			break;

		}		
		return dbHelper;
		
	}
*/
	/*public String getJdbc_url() {
		return jdbc_url;
	}

	public void setJdbc_url(String jdbc_url) {
		this.jdbc_url = jdbc_url;
	}

	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}
		*/
}
