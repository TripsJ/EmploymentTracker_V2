package works.trips.hellov2;
import java.util.ArrayList;

public interface UserService {
    ArrayList<Users> findAllUsers();
    Users findUserByID(long id);
    void addUser();
    void deleteAllData();

}
