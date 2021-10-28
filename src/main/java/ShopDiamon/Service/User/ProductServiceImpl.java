package ShopDiamon.Service.User;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ShopDiamon.Dao.ProductsDao;
import ShopDiamon.Dto.ProductDto;
@Service
public class ProductServiceImpl implements IProductService{
	@Autowired
	ProductsDao productsDao;
	public ProductDto getProductsById(long id) {
		// TODO Auto-generated method stub
		List<ProductDto> listProducts = productsDao.getProductsById( id);
		return listProducts.get(0);
	}
	public List<ProductDto> getProductsByIdCategory(int id) {
		
		return productsDao.getAllProductsById(id);
	}
	
	
	

}
