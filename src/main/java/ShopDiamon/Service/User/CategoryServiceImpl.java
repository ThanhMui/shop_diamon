package ShopDiamon.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ShopDiamon.Dao.ProductsDao;
import ShopDiamon.Dto.ProductDto;
@Service
public class CategoryServiceImpl implements ICategoryService{
	@Autowired
	private ProductsDao productDao;
	public List<ProductDto> getAllProductsById(int id) {
		return productDao.getAllProductsById(id);
	}
	public List<ProductDto> getDataProductsPaginates(int id ,int start, int totalPage) {				
		return productDao.getDataProductsPaginates(id , start, totalPage);
	}
	
	

}
