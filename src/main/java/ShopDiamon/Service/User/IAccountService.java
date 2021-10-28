package ShopDiamon.Service.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ShopDiamon.Entity.UserEntity;

@Service
public interface IAccountService {
	@Autowired
	public int addAccount(UserEntity user);
	@Autowired
	public boolean checkAccount(UserEntity user);
}
