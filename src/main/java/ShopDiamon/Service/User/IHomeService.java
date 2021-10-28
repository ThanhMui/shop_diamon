package ShopDiamon.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ShopDiamon.Dto.ProductDto;
import ShopDiamon.Entity.Categorys;
import ShopDiamon.Entity.Menus;
import ShopDiamon.Entity.Slides;
@Service
public interface IHomeService {
	@Autowired
	public List<Slides> getDataSlide();
	@Autowired
	public List<Categorys> getDataCategorys();
	@Autowired
	public List<Menus> getDataMenus();
	@Autowired
	public List<ProductDto> getDataProducts();
}
