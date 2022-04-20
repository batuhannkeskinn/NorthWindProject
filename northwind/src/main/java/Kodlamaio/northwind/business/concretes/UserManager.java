package Kodlamaio.northwind.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlamaio.northwind.business.abstracts.UserService;
import Kodlamaio.northwind.core.dataAccess.UserDao;
import Kodlamaio.northwind.core.entities.User;
import Kodlamaio.northwind.core.utilities.results.DataResult;
import Kodlamaio.northwind.core.utilities.results.Result;
import Kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import Kodlamaio.northwind.core.utilities.results.SuccessResult;
@Service
public class UserManager implements UserService{
	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
	
		this.userDao = userDao;
	}

	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return  new SuccessResult<User>("Kullanıcı eklendi");
				
	}

	@Override
	public DataResult<User> getByEmail(String email) {
		return new SuccessDataResult<User>(this.userDao.getByEmail(email),"Kullanıcı bulundu");
	}

}
