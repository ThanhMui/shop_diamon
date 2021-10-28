package ShopDiamon.Service.User;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ShopDiamon.Dao.UserDao;
import ShopDiamon.Entity.UserEntity;
@Service
public class AccountService implements IAccountService{
	@Autowired
	UserDao userDao = new UserDao();
	public int addAccount(UserEntity user) {
		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12)) );		
		return userDao.addAccount(user);
	}
	public boolean checkAccount(UserEntity user) {
		String pass = user.getPassword();
		user = userDao.getUserByAccount(user);
		if( user!= null) {
			if( BCrypt.checkpw(pass, user.getPassword())) {
				return true;
			}else {
				return false;
			}			
		}
		return false;
	}

}
