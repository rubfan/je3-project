/**
 * Created by ruslangramatic on 9/21/18.
 */
const RESOURCE_URL = window.location.protocol + "//" + window.location.host;
const REST_API_URL = RESOURCE_URL + "/rest";
const METHOD_GET = "GET";
const METHOD_POST = "POST";
const METHOD_PUT = "PUT";
const METHOD_DELETE = "DELETE";

const static = {
    loginPage: () => window.location.replace(RESOURCE_URL + '/login.html'),
    logoutPage: () => window.location.replace(RESOURCE_URL + '/login.html'),
    roomsPage: () => window.location.replace(RESOURCE_URL + '/rooms.html'),
    gameplayPage: () => window.location.replace(RESOURCE_URL + '/gameplay.html'),
    achievementsPage: () => window.location.replace(RESOURCE_URL + '/achievements.html'),
    testPage: () => window.location.replace(RESOURCE_URL + '/test.html')
};

const endpoints = {
    UserAchievementController: {
        getUserAchievementsList: (userId, callback) => restRequest(METHOD_GET, `${REST_API_URL}/user/${userId}/achievement/list`, callback)
    },
    UserBuildingController: {
        clearUserBuildingList: (userId, callback) => restRequest(METHOD_GET, `${REST_API_URL}/user/${userId}/building/list/clear`, callback),
        getUserBuildingList: (userId, callback) => restRequest(METHOD_GET, `${REST_API_URL}/user/${userId}/building/list`, callback)
    },
    UserCardController: {
        applyCard: (userId, cardId, callback) => restRequest(METHOD_GET, `${REST_API_URL}/user/${userId}/card/${cardId}/apply`, callback),
        getAllowUserCardList: (userId, callback) => restRequest(METHOD_GET, `${REST_API_URL}/user/${userId}/card/list`, callback)
    },
    UserNotificationController: {
        clearUserNotificationList: (userId, callback) => restRequest(METHOD_GET, `${REST_API_URL}/user/${userId}/notification/list/clear`, callback),
        getUserRecentNotificationList: (userId, callback) => restRequest(METHOD_GET, `${REST_API_URL}/user/${userId}/notification/list`, callback)
    },
    UserResourceController: {
        clearUserResourceList: (userId, callback) => restRequest(METHOD_GET, `${REST_API_URL}/user/${userId}/resource/list/clear`, callback),
        getUserResourceList: (userId, callback) => restRequest(METHOD_GET, `${REST_API_URL}/user/${userId}/resource/list`, callback)
    },
    UserUpgradeController: {
        clearUserUpgradeList: (userId, callback) => restRequest(METHOD_GET, `${REST_API_URL}/user/${userId}/upgrade/list/clear`, callback),
        getUserUpgradeList: (userId, callback) => restRequest(METHOD_GET, `${REST_API_URL}/user/${userId}/upgrade/list`, callback)
    },
    AchievementController: {
        getAllAchievementList: (callback) => restRequest(METHOD_GET, `${REST_API_URL}/achievement/list`, callback)
    },
    BuildingController: {
        getAllBuildingList: (callback) => restRequest(METHOD_GET, `${REST_API_URL}/building/list`, callback)
    },
    CardController: {
        getAllCardList: (callback) => restRequest(METHOD_GET, `${REST_API_URL}/card/list`, callback)
    },
    MessageController: {
        getRoomMessageList: (roomId, callback) => restRequest(METHOD_GET, `${REST_API_URL}/room/${roomId}/message/list`, callback),
        sendMessage: (userId, callback) => restRequest(METHOD_POST, `${REST_API_URL}/user/${userId}/message`, callback)
    },
    NotificationController: {
        getAllNotificationList: (callback) => restRequest(METHOD_GET, `${REST_API_URL}/notification/list`, callback)
    },
    ResourceController: {
        getAllResourceList: (callback) => restRequest(METHOD_GET, `${REST_API_URL}/resource/list`, callback)
    },
    RoomController: {
        getUserRoomList: (callback) => restRequest(METHOD_GET, `${REST_API_URL}/room/user/list`, callback),
        getAllRoomList: (callback) => restRequest(METHOD_GET, `${REST_API_URL}/room/list`, callback),
        joinRoom: (roomId, userId, callback) => restRequest(METHOD_GET, `${REST_API_URL}/room/${roomId}/user/${userId}/join`, callback),
        leaveRoom: (roomId, userId, callback) => restRequest(METHOD_GET, `${REST_API_URL}/room/${roomId}/user/${userId}/leave`, callback)
    },
    UpgradeController: {
        getAllUpgradeList: (callback) => restRequest(METHOD_GET, `${REST_API_URL}/upgrade/list`, callback)
    },
    UserController: {
        createNewUser: (callback, body) => restRequest(METHOD_POST, `${REST_API_URL}/user/new`, callback, body),
        loginUser: (callback, body) => restRequest(METHOD_POST, `${REST_API_URL}/user/login`, callback, body),
        logoutUser: (callback) => restRequest(METHOD_GET, `${REST_API_URL}/user/logout`, callback)
    }
};

function restRequest(method, url, callback, body) {
    console.log("restRequest method: " + method + " url: " + url + (body ? " body:" : ""));
    if (body) console.log(body);
    var httpRequest = new XMLHttpRequest();
    httpRequest.onreadystatechange = function() {
        console.log("status: " + this.status);
        if (this.readyState == 4 && (this.status == 200 || this.status == 201)) {
            if(callback && this.responseText) {
                console.log("executed callback with data object: " + callback.name);
                callback(this.responseText);
                //callback(JSON.parse(this.responseText));
            } else if (callback) {
                console.log("executed callback: " + callback.name);
                callback();
            }
        }
    };
    httpRequest.open(method, url, true);
    httpRequest.setRequestHeader('Accept', 'application/json');
    httpRequest.setRequestHeader("Content-type", "application/json");
    switch(method) {
        case METHOD_GET: httpRequest.send(null); break;
        case METHOD_POST: httpRequest.send(JSON.stringify(body)); break;
        case METHOD_PUT: httpRequest.send(JSON.stringify(body)); break;
        case METHOD_DELETE: httpRequest.send(null); break;
    }
}

function getCookie(key) {
    var match = document.cookie.match(new RegExp(key + '=([^;]+)'));
    if (match) return match[1];
    return null;
}
function removeCookie(key) {
    document.cookie = key + "=";
}
function setCookie(key, value) {
    document.cookie = key + "=" + value;
}
