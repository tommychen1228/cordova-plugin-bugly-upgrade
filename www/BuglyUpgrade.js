module.exports = {
    initApp: function (androidKey,ioskey, successHandler, errorHandler) {
        cordova.exec(successHandler, errorHandler, "BuglyUpgrade", "initApp", [androidKey,ioskey]);
    }
};
