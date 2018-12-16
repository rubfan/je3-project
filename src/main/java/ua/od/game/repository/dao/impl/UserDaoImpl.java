package ua.od.game.repository.dao.impl;

import ua.od.game.model.UserEntity;
import ua.od.game.repository.dao.UserDao;
import ua.od.game.repository.helper.SqlHelper;
import java.sql.ResultSet;
import java.util.logging.Logger;


public class UserDaoImpl implements UserDao {

    Logger log = Logger.getLogger(UserDaoImpl .class.getName());

    @Override
    public String createNewUser(UserEntity user){
        String token = null;
        Integer create;
        token = user.getToken();
        create = SqlHelper.prepareStatement("INSERT INTO User(name, password, token) values(?,?,?)", pstmt -> {
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getToken());
            return pstmt.executeUpdate();
        });
        if(create == 0) {
            token = null;
            log.warning("This user already exists!!!!");
        }
        return token;
    }

    @Override
    public String loginUser(UserEntity user) {
        String token = null;

        token = SqlHelper.prepareStatement("UPDATE User Set token = ? where name = ? and password = ?",
                pstmt -> {
            pstmt.setString(1, user.getToken());
            pstmt.setString(2, user.getName());
            pstmt.setString(3, user.getPassword());
            return pstmt.executeUpdate() > 0 ? user.getToken() : "";
        });
        if(token.isEmpty()) {
            log.warning("This user does not exists!!!!");
        }
        return token;
    }

    @Override
    public boolean logoutUser(String token) {
        boolean logout;

        logout = SqlHelper.prepareStatement("UPDATE User Set token = '' where token = ?", pstmt -> {
            pstmt.setString(1, token);
            return pstmt.executeUpdate() > 0;
        });
        if(!logout) {
            log.warning("This token is wrong!!!!");
        }
        return logout;
    }

    @Override
    public UserEntity getUserByToken(String token) {
       UserEntity user = null;

       user = SqlHelper.prepareStatement("SELECT * from User where token = ?", pstmt -> {
            pstmt.setString(1, token);
            ResultSet rs = pstmt.executeQuery();
            return rs.next() ? new UserEntity(){{
                setId(rs.getInt("id"));
                setName(rs.getString("name"));
                setPassword(rs.getString("password"));
                setToken(rs.getString("token"));
            }} : null;
            });
        if(user == null) {
            log.warning("Wrong token!!!!!");
        }
       return user;
  }

    @Override
    public UserEntity getUserById(Integer userId) {
        UserEntity user = null;

        user = SqlHelper.prepareStatement("SELECT * from User where id = ?", pstmt -> {
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();
            return rs.next() ? new UserEntity(){{
                setId(rs.getInt("id"));
                setName(rs.getString("name"));
                setPassword(rs.getString("password"));
                setToken(rs.getString("token"));
            }} : null;
        });
        if(user == null) {
            log.warning("Wrong user Id!!!!!");
        }
        return user;
    }
}
