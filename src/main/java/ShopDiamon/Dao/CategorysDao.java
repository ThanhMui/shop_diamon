package ShopDiamon.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import ShopDiamon.Entity.Categorys;
import ShopDiamon.Entity.MapperCategorys;

@Repository
public class CategorysDao extends BaseDao{

	public List<Categorys> getDataCategorys(){
		List<Categorys> cateList = new ArrayList<Categorys>();
		String sql = "SELECT * FROM categorys";
		cateList = _jdbcJdbcTemplate.query(sql, new MapperCategorys());
		return cateList;
	}
}
