package ShopDiamon.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperUsers  implements RowMapper<UserEntity> {

	public UserEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserEntity user = new UserEntity();
		user.setId(rs.getLong("id"));
		user.setUser(rs.getString("user"));
		user.setPassword(rs.getString("password"));
		user.setDisplay_name(rs.getString("display_name"));
		user.setAddress(rs.getString("address"));
		return user;
	}


}
