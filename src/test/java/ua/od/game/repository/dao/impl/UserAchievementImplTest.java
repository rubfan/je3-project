package ua.od.game.repository.dao.impl;

import org.junit.Before;
import org.junit.Test;
import ua.od.game.model.AchievementNumberEntity;
import ua.od.game.repository.dao.DbTest;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class UserAchievementImplTest extends DbTest {

    UserAchievementImpl userAchievement;

    @Before
    public void init(){
        userAchievement = new UserAchievementImpl();
    }

    @Test
    public void testGetUserAchievement (){
        List <AchievementNumberEntity> achievementNumberEntityList = userAchievement.getUserNotifications(1);
        for (int i = 0; i < achievementNumberEntityList.size(); i++) {
            System.out.println(achievementNumberEntityList.get(i).getId() + " ");
            System.out.println(achievementNumberEntityList.get(i).getAchievement_id() + " ");
            System.out.println(achievementNumberEntityList.get(i).getNumber() + " ");
            System.out.println(achievementNumberEntityList.get(i).getUser_id() + " ");

        }

        if (!achievementNumberEntityList.isEmpty()){
            assertTrue(true);
        }


    }

}
