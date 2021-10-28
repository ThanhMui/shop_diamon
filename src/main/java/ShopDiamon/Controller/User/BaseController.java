package ShopDiamon.Controller.User;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import ShopDiamon.Service.User.HomeServiceImpl;
@Controller
public class BaseController {
	@Autowired
	HomeServiceImpl _homeServiceImpl;
	public ModelAndView mv_shared = new ModelAndView();
	@PostConstruct
	public ModelAndView init() {
		mv_shared.addObject("menus", _homeServiceImpl.getDataMenus());
		return mv_shared;
	}
	
}
