package ShopDiamon.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ShopDiamon.Service.User.ProductServiceImpl;

@Controller
public class ProductController extends BaseController{
	@Autowired
	private ProductServiceImpl _productService;
	
	@RequestMapping(value= {"/chi-tiet-san-pham/{id}" })
	public ModelAndView index(@PathVariable long id) {		 // id tung san pham
		mv_shared.setViewName("user/products/product");
		mv_shared.addObject("product", _productService.getProductsById( id)); // lay 1 product theo id truyen vao
		// lay id san pham
		int idCategory =  _productService.getProductsById( id).getId_category();
		mv_shared.addObject("productByIdCategory", _productService.getProductsByIdCategory(idCategory));
		return mv_shared;
	}

}
