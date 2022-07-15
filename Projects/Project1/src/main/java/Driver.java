import com.revature.daos.UsersDAO;
import com.revature.daos.UsersHibernate;
import com.revature.models.Users;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Users u = new Users();
		UsersDAO ud = new UsersHibernate();
		u = ud.getUserById(1);
		System.out.println(u.toString());

	}

}
