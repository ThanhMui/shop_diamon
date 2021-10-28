package ShopDiamon.Controller.User;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ShopDiamon.Entity.UserEntity;
import ShopDiamon.Service.User.AccountService;

@Controller
public class UserController extends BaseController{
	@Autowired
	AccountService accountService = new AccountService();
	@RequestMapping(value="/dang-ky" , method = RequestMethod.GET)
	public ModelAndView Register() {		
		mv_shared.setViewName("user/account/register");		
		mv_shared.addObject("user", new UserEntity());
		return mv_shared;
	}
	@RequestMapping(value="/dang-ky" , method = RequestMethod.POST)
	public ModelAndView createAccount(@ModelAttribute("user") UserEntity user) {
		int account = accountService.addAccount(user);
		if( account > 0) {
			mv_shared.addObject("status", "Đăng ký tài khoản thành công!");
		}else {
			mv_shared.addObject("status", "Đăng ký tài khoản thất bại!");
		}
		mv_shared.setViewName("user/account/register");
		return mv_shared;
	}
	@RequestMapping(value="/dang-nhap" , method = RequestMethod.POST)
	public ModelAndView loginAccount( HttpSession sesion,@ModelAttribute("user") UserEntity user) {		
		boolean check= accountService.checkAccount(user);
		if( check) {			
			mv_shared.setViewName("redirect:trang-chu");
			sesion.setAttribute("loginInfo", user);
		}else {
			mv_shared.addObject("statusLogin", "Đăng nhập tài khoản thất bại!");
		}		
		return mv_shared;
	}
}
