package ra.controller;

import ra.model.entity.User;
import ra.model.services.IServices;
import ra.model.services.UserServiceImp;

import java.util.List;

public class UserController implements IController<User,Integer> {
    UserServiceImp userService = new UserServiceImp();
    @Override
    public void create(User user) {
        userService.create(user);
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User findById(Integer integer) {
        return null;
    }
    public User checkLogin(String username, String password){
        return userService.checkLogin(username, password);
    }

}
