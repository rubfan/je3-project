/**
 * @author ruslan.gramatic
 */
var currentAccount = {};

function getView(viewId) {
    return document.getElementById(viewId).innerHTML;
}

function setView(viewId, view) {
    document.getElementById(viewId).innerHTML = view;
}
