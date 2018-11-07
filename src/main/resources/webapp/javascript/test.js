/**
 * Created by ruslangramatic on 9/21/18.
 */
const testEndpoints = {
    testAccountAchievementController: {
        getAccountAchievementsList: () => endpoints.getAccountAchievementsList({accountId: 1}, showJsonResult)
    },
    testAccountBuildingController: {
        clearAccountBuildingList: () => endpoints.clearAccountBuildingList({accountId: 1}, showStringResult),
        getAccountBuildingList: () => endpoints.getAccountBuildingList({accountId: 1}, showJsonResult)
    },
    testAccountCardController: {
        applyCard: () => endpoints.applyCard({accountId: 1, cardId: 1}, showJsonResult),
        getAllowAccountCardList: () => endpoints.getAllowAccountCardList({accountId: 1}, showJsonResult)
    },
    testAccountController: {
        getAccount:  () => endpoints.getAccount({accountId: 1}, showJsonResult)
    },
    testAccountNotificationController: {
        clearAccountNotificationList: () => endpoints.clearAccountNotificationList({accountId: 1}, showJsonResult),
        getAccountRecentNotificationList: () => endpoints.getAccountRecentNotificationList({accountId: 1}, showJsonResult)
    },
    testAccountResourceController: {
        clearAccountResourceList: () => endpoints.clearAccountResourceList({accountId: 1}, showJsonResult),
        getAccountResourceList: () => endpoints.getAccountResourceList({accountId: 1}, showJsonResult)
    },
    testAccountUpgradeController: {
        clearAccountUpgradeList: (params, callback) => endpoints.clearAccountUpgradeList({accountId: 1}, showJsonResult),
        getAccountUpgradeList: (params, callback) => endpoints.getAccountUpgradeList({accountId: 1}, showJsonResult)
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
        sendMessage: () => endpoints.sendMessage({account: 1}, showJsonResult)
    },
    testNotificationController: {
        getAllNotificationList: () => endpoints.getAllNotificationList(showJsonResult)
    },
    testResourceController: {
        getAllResourceList: () => endpoints.ResourceController.getAllResourceList(showJsonResult)
    },
    testRoomController: {
        getAccountRoomList: () => endpoints.RoomController.getAccountRoomList(showJsonResult),
        getAllRoomList: (callback) => endpoints.RoomController.getAllRoomList(showJsonResult),
        joinRoom: (roomId, accountId, callback) => endpoints.RoomController.joinRoom(1, 1, showStringResult),
        leaveRoom: (roomId, accountId, callback) => endpoints.RoomController.leaveRoom(1, 1, showStringResult)
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
