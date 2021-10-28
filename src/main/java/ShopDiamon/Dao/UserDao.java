package ShopDiamon.Dao;

import org.springframework.stereotype.Repository;

import ShopDiamon.Dto.ProductDto;
import ShopDiamon.Dto.ProductDtoMapper;
import ShopDiamon.Entity.MapperUsers;
import ShopDiamon.Entity.UserEntity;

@Repository
public class UserDao extends BaseDao{
	
	public int addAccount(UserEntity user) {
		
		StringBuffer  sql = new StringBuffer();
		sql.append("INSERT INTO ");
		sql.append("users ");
		sql.append("( ");
		sql.append("user, ");
		sql.append("password, ");
		sql.append("display_name, ");
		sql.append("address ");
		sql.append(") ");
		sql.append("VALUES ");
		sql.append("( ");
		sql.append("  '"+ user.getUser()+ "', ");
		sql.append("  '"+ user.getPassword()+ "', ");
		sql.append("  '"+ user.getDisplay_name()+ "', ");
		sql.append("  '"+ user.getAddress()+ "' ");
		sql.append(") ");
		int insert = _jdbcJdbcTemplate.update(sql.toString());
		return insert;
		
	}
	public UserEntity getUserByAccount(UserEntity user) {
	String sql = "SELECT * FROM users WHERE user = '"+ user.getUser()+ "'";
	UserEntity result = _jdbcJdbcTemplate.queryForObject(sql, new MapperUsers());		
		return result;		
	}
}
