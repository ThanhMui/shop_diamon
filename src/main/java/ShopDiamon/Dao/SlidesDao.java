package ShopDiamon.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ShopDiamon.Entity.MapperSlides;
import ShopDiamon.Entity.Slides;

@Repository
public class SlidesDao extends BaseDao{
	
	public List<Slides> getDataSlide(){
		List<Slides> slides = new ArrayList<Slides>();
		String sql = "SELECT * FROM slides";
		slides = _jdbcJdbcTemplate.query(sql, new MapperSlides());
		return slides;
	}
	/*
	 * public static void main(String[] args) { SlidesDao dao = new SlidesDao();
	 * List<Slides> list = dao.getDataSlide(); }
	 */
}
