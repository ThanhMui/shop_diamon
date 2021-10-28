package ShopDiamon.Dao;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import ShopDiamon.Dto.ProductDto;
import ShopDiamon.Dto.ProductDtoMapper;
@Repository
public class ProductsDao extends BaseDao{
	private final boolean YES= true;
	private final boolean NO= false;
	private StringBuilder sqlString() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT p.id AS id_product, ");
		sql.append(" p.id_category, ");
		sql.append(" p.sizes, ");
		sql.append(" p.name, ");
		sql.append(" p.price, ");
		sql.append(" p.sale, ");
		sql.append(" p.title, ");
		sql.append(" p.highlight, ");
		sql.append(" p.new_product, ");
		sql.append(" p.details, ");
		sql.append(" c.id AS id_color, ");
		sql.append(" c.name AS name_color, ");
		sql.append(" c.code AS code_color, ");
		sql.append(" c.img, ");
		sql.append(" p.created_at, ");
		sql.append(" p.updated_at ");
		sql.append(" FROM ");
		sql.append(" products AS p ");
		sql.append(" INNER JOIN ");
		sql.append(" colors AS c ");
		sql.append(" ON p.id = c.id_product ");
		
		return sql;
	}
	private String sqlProducts(boolean newProduct, boolean highlight) {
		StringBuilder sql = sqlString();
		sql.append(" WHERE 1=1 ");
		if( highlight) {
			sql.append(" AND p.highlight= true ");
		}
		if( newProduct ) {
			sql.append(" AND p.new_product= false ");
		}	
		sql.append(" GROUP BY p.id, c.id_product");
		sql.append(" ORDER BY RAND()");
		if( highlight) {
			sql.append(" LIMIT 9");
		}
		if( newProduct) {
			sql.append(" LIMIT 12");
		}				
		return sql.toString();
	}
	private StringBuilder sqlProductsById(int id) {
		StringBuilder sql = sqlString();
		sql.append(" WHERE 1=1 ");
		sql.append(" AND p.id_category = "+ id + " ");			
		return sql;
	}
	//lay  phan trang
	private String sqlProductsPaginates(int id, int start, int totalPage) {
		StringBuilder sql = sqlProductsById( id);	
		sql.append("LIMIT "+ start + ", "+ totalPage);			
		return sql.toString();
	}
	private String sqlProductById(long id) {
		StringBuilder sql = sqlString();
		sql.append(" WHERE 1=1 ");
		sql.append(" AND p.id = "+ id + " ");		
		sql.append(" LIMIT 1 ");		
		return sql.toString();
	}
	public List<ProductDto> getDataProducts(){
		List<ProductDto> listProduct = new ArrayList<ProductDto>();
		String sql = sqlProducts(YES, NO);
		listProduct = _jdbcJdbcTemplate.query(sql, new ProductDtoMapper());
		return listProduct;
	}
	public List<ProductDto> getAllProductsById(int id){
		String sql = sqlProductsById(id).toString();
		List<ProductDto> listProduct= _jdbcJdbcTemplate.query(sql, new ProductDtoMapper());
		return listProduct;
	}
	// lay data paginate 
	public List<ProductDto> getDataProductsPaginates(int id, int start, int totalPage){		
		StringBuilder sqlGetDataById = sqlProductsById(id);
		List<ProductDto> listProductsById = _jdbcJdbcTemplate.query(sqlGetDataById.toString(), new ProductDtoMapper());
		List<ProductDto> listProduct= new ArrayList<ProductDto>();
		if( listProductsById.size() >0) {
			String sql = sqlProductsPaginates(id, start, totalPage).toString();
			listProduct=	_jdbcJdbcTemplate.query(sql, new ProductDtoMapper());
		}			
		return listProduct;
	}
	public List<ProductDto> getProductsById(long id) {
		String sql = sqlProductById(id);
	 List<ProductDto> listProduct =	_jdbcJdbcTemplate.query(sql, new ProductDtoMapper());
		return listProduct;
	}	
	public ProductDto findProductsById(long id) {
		String sql = sqlProductById(id);
	 ProductDto product = _jdbcJdbcTemplate.queryForObject(sql, new ProductDtoMapper());
		return product;
	}	
}
