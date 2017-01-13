module.exports = {
    initApp: function (androidKey,ioskey, successHandler, errorHandler) {
        cordova.exec(successHandler, errorHandler, "UpgradePlugin", "initApp", [androidKey,ioskey]);
    }
};
