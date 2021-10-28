package ShopDiamon.Controller.User;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ShopDiamon.Dto.CartDto;
import ShopDiamon.Service.User.CartServiceImpl;

@Controller
public class CartController extends BaseController {
	@Autowired
	private CartServiceImpl cartService;
	@RequestMapping(value="gio-hang")
	public ModelAndView index() {		
		mv_shared.addObject("slides", _homeServiceImpl.getDataSlide());
		mv_shared.addObject("categorys", _homeServiceImpl.getDataCategorys());
		mv_shared.addObject("products", _homeServiceImpl.getDataProducts());
		mv_shared.setViewName("user/cart/list_cart");		
		return mv_shared;
	}
	@RequestMapping(value="AddCart/{id}")
	public String addCart( HttpServletRequest httpRequest ,HttpSession session, @PathVariable long id) {
		HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>) session.getAttribute("Cart");
		if( cart == null) {
			cart = new HashMap<Long, CartDto>();
		}
		cart = cartService.addCart(id, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantyCart", cartService.totalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartService.totalPrice(cart));
		/* return "redirect:/chi-tiet-san-pham/{id}"; */
		return "redirect:" + httpRequest.getHeader("Referer");
	}
	@RequestMapping(value="EditCart/{id}/{quanty}")
	public String editCart( HttpServletRequest httpRequest ,HttpSession session, @PathVariable long id, @PathVariable int quanty) {
		HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>) session.getAttribute("Cart");
		if( cart == null) {
			cart = new HashMap<Long, CartDto>();
		}
		cart =	cartService.editCart(id, quanty, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantyCart", cartService.totalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartService.totalPrice(cart));
		/* return "redirect:/chi-tiet-san-pham/{id}"; */
		return "redirect:" + httpRequest.getHeader("Referer");
	}
	@RequestMapping(value="DeleteCart/{id}")
	public String deleteCart( HttpServletRequest httpRequest ,HttpSession session, @PathVariable long id) {
		HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>) session.getAttribute("Cart");
		if( cart == null) {
			cart = new HashMap<Long, CartDto>();
		}
		cart = cartService.deleteCart(id, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantyCart", cartService.totalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartService.totalPrice(cart));
		/* return "redirect:/chi-tiet-san-pham/{id}"; */
		return "redirect:" + httpRequest.getHeader("Referer");
	}

}
