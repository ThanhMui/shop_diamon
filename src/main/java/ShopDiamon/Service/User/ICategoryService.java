package ShopDiamon.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ShopDiamon.Dto.ProductDto;
@Service
public interface ICategoryService {

	public List<ProductDto> getDataProductsPaginates(int id,int start , int totalPage);
	// lay tat ca prodct theo id
	
	public List<ProductDto> getAllProductsById(int id);
	
}
