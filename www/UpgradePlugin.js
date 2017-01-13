module.exports = {
    initApp: function (androidKey, successHandler, errorHandler) {
        cordova.exec(successHandler, errorHandler, "UpgradePlugin", "initApp", [androidKey]);
    }
};