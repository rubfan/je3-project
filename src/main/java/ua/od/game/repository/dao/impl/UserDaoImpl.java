package ua.od.game.repository.dao.impl;

import ua.od.game.model.UserEntity;
import ua.od.game.repository.dao.UserDao;
import ua.od.game.repository.helper.SqlHelper;

import java.sql.ResultSet;
/**
 * @author by ruslan.gramatic
 */
public class UserDaoImpl implements UserDao {

    public String loginUser(UserEntity user) {
        return SqlHelper.prepareStatement("SELECT token FROM User WHERE name = ? and password = ?;", pstmt -> {
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getPassword());
            ResultSet rs = pstmt.executeQuery();
            return rs.next() ? rs.getString("token") : "";
        });
    }

    public boolean logoutUser(String token) {
        return SqlHelper.prepareStatement("UPDATE User SET token = '' WHERE token = ?;", pstmt -> {
            pstmt.setString(1, token);
            return pstmt.executeUpdate() > 0;
        });
    }

    public String createNewUser(UserEntity user) {
        return SqlHelper.prepareStatement("INSERT IGNORE INTO User (name, password, token) VALUES (?,?,?);", pstmt -> {
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getToken());
            return pstmt.executeUpdate() > 0 ? user.getToken() : "";
        });
    }

    public UserEntity getUserByToken(String token) {
        return SqlHelper.prepareStatement("SELECT id, name, token FROM User WHERE token = ?;", pstmt -> {
            pstmt.setString(1, token);
            ResultSet rs = pstmt.executeQuery();
            return rs.next() ? new UserEntity() {{
                setId(rs.getInt("id"));
                setName(rs.getString("name"));
                setPassword(null);
                setToken(rs.getString("token"));
            }} : null;
        });
    }
}
