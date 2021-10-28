package ShopDiamon.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ShopDiamon.Dto.ProductDto;

@Service
public interface IProductService {
	@Autowired
	public ProductDto getProductsById(long id);
	@Autowired
	public List<ProductDto> getProductsByIdCategory(int id);
}
