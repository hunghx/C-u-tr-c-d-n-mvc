package ra.model.services;

import ra.model.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImp implements IServices<User,Integer>{
   List<User> listUsers = new ArrayList<>();

    public UserServiceImp() {
        listUsers.add(new User(1,"Nam Péo","nampeo123","123456","Hà Tĩnh","0129837475",false,2));
    }

    @Override
    public void create(User user) {
        if(listUsers.size() == 0){
            user.setUserId(1);
        }else {
            user.setUserId(listUsers.get(listUsers.size() - 1).getUserId()+1);
        }
        listUsers.add(user);

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public List<User> getAll() {
        return listUsers;
    }

    @Override
    public User findById(Integer integer) {
        return null;
    }
    public User checkLogin(String username, String password){
        for (User user : listUsers) {
            if(user.getUserName().equals(username) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }
}
