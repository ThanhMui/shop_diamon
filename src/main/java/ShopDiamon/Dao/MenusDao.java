package ShopDiamon.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import ShopDiamon.Entity.Categorys;
import ShopDiamon.Entity.MapperCategorys;
import ShopDiamon.Entity.MapperMenus;
import ShopDiamon.Entity.Menus;
@Repository
public class MenusDao extends BaseDao{
	public List<Menus> getDataMenus(){
		List<Menus> cateList = new ArrayList<Menus>();
		String sql = "SELECT * FROM menus";
		cateList = _jdbcJdbcTemplate.query(sql, new MapperMenus());
		return cateList;
	}
}
