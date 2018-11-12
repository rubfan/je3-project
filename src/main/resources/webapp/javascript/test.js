/**
 * Created by ruslangramatic on 9/21/18.
 */
const testEndpoints = {
    testUserAchievementController: {
        getUserAchievementsList: () => endpoints.getUserAchievementsList({userId: 1}, showJsonResult)
    },
    testUserBuildingController: {
        clearUserBuildingList: () => endpoints.clearUserBuildingList({userId: 1}, showStringResult),
        getUserBuildingList: () => endpoints.getUserBuildingList({userId: 1}, showJsonResult)
    },
    testUserCardController: {
        applyCard: () => endpoints.applyCard({userId: 1, cardId: 1}, showJsonResult),
        getAllowUserCardList: () => endpoints.getAllowUserCardList({userId: 1}, showJsonResult)
    },
    testUserController: {
        getUser:  () => endpoints.getUser({userId: 1}, showJsonResult)
    },
    testUserNotificationController: {
        clearUserNotificationList: () => endpoints.clearUserNotificationList({userId: 1}, showJsonResult),
        getUserRecentNotificationList: () => endpoints.getUserRecentNotificationList({userId: 1}, showJsonResult)
    },
    testUserResourceController: {
        clearUserResourceList: () => endpoints.clearUserResourceList({userId: 1}, showJsonResult),
        getUserResourceList: () => endpoints.getUserResourceList({userId: 1}, showJsonResult)
    },
    testUserUpgradeController: {
        clearUserUpgradeList: (params, callback) => endpoints.clearUserUpgradeList({userId: 1}, showJsonResult),
        getUserUpgradeList: (params, callback) => endpoints.getUserUpgradeList({userId: 1}, showJsonResult)
    },
    testAchievementController: {
        getAllAchievementList: (callback) => endpoints.getAllAchievementList(showJsonResult)
    },
    testBuildingController: {
        getAllBuildingList: () => endpoints.getAllBuildingList(showJsonResult)
    },
    testCardController: {
        getAllCardList: () => endpoints.getAllCardList(showJsonResult)
    },
    testMessageController: {
        getRoomMessageList: () => endpoints.getRoomMessageList({roomId: 1}, showJsonResult),
        sendMessage: () => endpoints.sendMessage({user: 1}, showJsonResult)
    },
    testNotificationController: {
        getAllNotificationList: () => endpoints.getAllNotificationList(showJsonResult)
    },
    testResourceController: {
        getAllResourceList: () => endpoints.ResourceController.getAllResourceList(showJsonResult)
    },
    testRoomController: {
        getUserRoomList: () => endpoints.RoomController.getUserRoomList(showJsonResult),
        getAllRoomList: (callback) => endpoints.RoomController.getAllRoomList(showJsonResult),
        joinRoom: (roomId, userId, callback) => endpoints.RoomController.joinRoom(1, 1, showStringResult),
        leaveRoom: (roomId, userId, callback) => endpoints.RoomController.leaveRoom(1, 1, showStringResult)
    },
    testUpgradeController: {
        getAllUpgradeList: (callback) => endpoints.getAllUpgradeList(showJsonResult)
    },
    testUserController: {
        createNewUser: (callback, body) => endpoints.UserController.createNewUser(showStringResult, body),
        loginUser: (callback, body) => endpoints.UserController.loginUser(showStringResult, body),
        logoutUser: (callback) => endpoints.logoutUser(showJsonResult)
    }
};

function showJsonResult(dataObject) {
    console.log(JSON.parse(dataObject));
    setView("result", renderJSON(JSON.parse(dataObject), 1));

}
function showStringResult(res) {
    console.log(res);
    setView("result", res);
}

function renderJSON(obj, numTabs) {
    'use strict';
    var keys = [], retValue = "";
    for (var key in obj) {
        if (typeof obj[key] === 'object') {
            retValue += `<div><i style="color: black">${".".repeat(numTabs * 4)}</i><b style="color: #4b7caf">${key}</b>`;
            retValue += renderJSON(obj[key], ++numTabs);
            numTabs--;
            retValue += "</div>";
        } else {
            retValue += `<div><i style="color: black">${".".repeat(numTabs * 4)}</i><b style="color: #4b7caf">${key}</b>`;
            retValue += `<b style="color: #ffd000"> = </b>${obj[key]}</div>`;
        }
        keys.push(key);
    }
    return retValue;
}
