package ua.od.game.repository.dao.impl;

import org.junit.Before;
import org.junit.Test;
import ua.od.game.model.UserEntity;
import ua.od.game.repository.dao.DbTest;
import ua.od.game.repository.dao.UserDao;

import static org.junit.Assert.assertEquals;

/**
 * @author ruslan.gramatic
 */
public class UserDaoImplTest extends DbTest {
    UserDao userDao;

    @Before
    public void init() {
        userDao = new UserDaoImpl();
    }

    @Test
    public void loginUserTest() {
        UserEntity user = new UserEntity() {{
            setName("u1");
            setPassword("u1");
        }};
        String token = userDao.loginUser(user);
        assertEquals("11111", token);
    }

    @Test
    public void logoutUserTest() {
    }

    public void createNewUserTest() {
    }

    public void getUserByTokenTest() {
    }
}
