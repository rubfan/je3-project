package ua.od.game.repository.dao.impl;

import ua.od.game.model.UserEntity;
import ua.od.game.repository.dao.UserDao;
import ua.od.game.repository.helper.SqlHelper;
import java.sql.ResultSet;

public class UserDaoImpl implements UserDao {

    @Override
    public String createNewUser(UserEntity user){
        String token = null;
        int countUser = 0;

        countUser = SqlHelper.prepareStatement("SELECT count(*) from User where name = ?", pstmt -> {
            pstmt.setString(1, user.getName());
            ResultSet rs = pstmt.executeQuery();
            return rs.next() ? rs.getInt("count(*)") : 0;
        });
        if(countUser > 0) {
            try {
                throw new Exception("This user already exists!!!!");
            } catch (Exception e) {
                System.out.println(e.toString());
                return "";
            }
        }
        token = user.getToken();
        SqlHelper.prepareStatement("INSERT INTO User(name, password, token) values(?,?,?)", pstmt -> {
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getToken());
            return pstmt.executeUpdate();
        });
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
            try {
                throw new Exception("This user does not exists!!!!");
            } catch (Exception e) {
                System.out.println(e.toString());
                return "";
            }
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
            try {
                throw new Exception("This token is wrong!!!!");
            } catch (Exception e) {
                System.out.println(e.toString());
            }
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
            try {
                throw new Exception("Wrong token!!!!!");
            } catch (Exception e) {
                System.out.println(e.toString());
            }
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
            try {
                throw new Exception("Wrong user Id!!!!!");
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
        return user;
    }
}
