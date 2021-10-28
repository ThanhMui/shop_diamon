package ShopDiamon.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ShopDiamon.Dao.CategorysDao;
import ShopDiamon.Dao.MenusDao;
import ShopDiamon.Dao.ProductsDao;
import ShopDiamon.Dao.SlidesDao;
import ShopDiamon.Dto.ProductDto;
import ShopDiamon.Entity.Categorys;
import ShopDiamon.Entity.Menus;
import ShopDiamon.Entity.Slides;
@Service
public class HomeServiceImpl implements IHomeService{
	@Autowired
	SlidesDao slidesDao;
	@Autowired
	CategorysDao categorysDao;
	@Autowired
	MenusDao menusDao;
	@Autowired
	ProductsDao productsDao;
	public List<Slides> getDataSlide() {		
		return slidesDao.getDataSlide();
	}
	public List<Categorys> getDataCategorys() {		
		return categorysDao.getDataCategorys();
	}
	public List<Menus> getDataMenus() {		
		return menusDao.getDataMenus();
	}
	public List<ProductDto> getDataProducts() {	
		return productsDao.getDataProducts();
	}
}
