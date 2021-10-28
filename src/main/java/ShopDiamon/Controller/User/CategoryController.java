package ShopDiamon.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ShopDiamon.Dto.PaginateDTO;
import ShopDiamon.Service.User.CategoryServiceImpl;
import ShopDiamon.Service.User.PaginateServiceImpl;
@Controller
public class CategoryController extends BaseController{
	int totalProductPage = 9;
	@Autowired
	private CategoryServiceImpl categoryService; 
	@Autowired 
	private PaginateServiceImpl paginateService; 
	@RequestMapping(value= "/san-pham/{id}") // khi request 1 url tu trinh duyet nó dan toi list san pham co category la id 
	public ModelAndView Product(@PathVariable String id) { 
		mv_shared.setViewName("user/products/category");			
		int totalData = categoryService.getAllProductsById(Integer.parseInt(id)).size(); 
		PaginateDTO paginateInfo = paginateService.getInfoPaginate(totalData, totalProductPage, 1); 
		mv_shared.addObject("paginateInfo", paginateInfo);	
		mv_shared.addObject("idCategory", id);	
		mv_shared.addObject("ProductsPaginates", categoryService.getDataProductsPaginates(Integer.parseInt(id),paginateInfo.getStart(), totalProductPage));
		return mv_shared; 
	}	
	@RequestMapping(value= "/san-pham/{id}/{curentPage}") // khi request 1 url tu trinh duyet nó dan toi list san pham co category la id 
	public ModelAndView Product(@PathVariable String id,@PathVariable String curentPage) { 
		mv_shared.setViewName("user/products/category"); 		
		int totalData = categoryService.getAllProductsById(Integer.parseInt(id)).size() ; 
		PaginateDTO paginateInfo = paginateService.getInfoPaginate(totalData, totalProductPage, Integer.parseInt(curentPage));
		mv_shared.addObject("paginateInfo", paginateInfo);	
		mv_shared.addObject("idCategory", id);	
		mv_shared.addObject("ProductsPaginates", categoryService.getDataProductsPaginates(Integer.parseInt(id),paginateInfo.getStart(), totalProductPage));
		return mv_shared; 
	}	
} 
