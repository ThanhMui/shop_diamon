package ShopDiamon.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ShopDiamon.Dao.SlidesDao;
import ShopDiamon.Service.User.HomeServiceImpl;

@Controller
public class HomeController extends BaseController{
	
	
	@RequestMapping(value= { "/", "/trang-chu" })
	public ModelAndView index() {
		
		mv_shared.addObject("slides", _homeServiceImpl.getDataSlide());
		mv_shared.addObject("categorys", _homeServiceImpl.getDataCategorys());
		mv_shared.addObject("products", _homeServiceImpl.getDataProducts());
		mv_shared.setViewName("user/index");
		
		return mv_shared;
	}
	@RequestMapping(value= "/product")
	public ModelAndView Product() {
		ModelAndView model = new ModelAndView("user/product");
		return model;
	}
	
}
