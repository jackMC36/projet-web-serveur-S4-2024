package src.com.uca.core;

import src.com.uca.dao.UserDAO;
import src.com.uca.entity.UserEntity;

import java.util.ArrayList;

public class UserCore {

    public static ArrayList<UserEntity> getAllUsers() {
        return new UserDAO().getAllUsers();
    }

}
