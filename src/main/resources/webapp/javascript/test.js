/**
 * Created by ruslangramatic on 9/21/18.
 */
const testStatic = {
    loginPage: () => static.loginPage(),
    logoutPage: () => static.logoutPage(),
    roomsPage: () => static.roomsPage(),
    gameplayPage: () => static.gameplayPage(),
    achievementsPage: () => static.achievementsPage()
};

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
        getAllResourceList: () => endpoints.getAllResourceList(showJsonResult)
    },
    testRoomController: {
        getAccountRoomList: () => endpoints.getAccountRoomList(showJsonResult),
        getAllRoomList: (callback) => endpoints.getAllRoomList(showJsonResult),
        joinRoom: (params, callback) => restRequest('GET', REST_API_URL + format('/room/{roomId}/account/{accountId}/join', params), callback),
        leaveRoom: (params, callback) => restRequest('GET', REST_API_URL + format('/room/{roomId}/account/{accountId}/leave', params), callback)
    },
    testUpgradeController: {
        getAllUpgradeList: (callback) => endpoints.getAllUpgradeList(showJsonResult)
    },
    testUserController: {
        createNewUser: (callback, body) => restRequest('POST', REST_API_URL + '/user/new', callback, body),
        loginUser: (сallback, body) => restRequest('POST', REST_API_URL + '/user/login', callback, body),
        logoutUser: (callback) => endpoints.logoutUser(showJsonResult)
    }
};

function showJsonResult(dataObject) {
    console.log(JSON.parse(dataObject));
}
function showStringResult(res) {
    console.log(res);
}
