# Bugly Upgrade Cordova Plugin

##使用方式
- 添加plugin 
corodva plugin add https://github.com/tommychen1228/cordova-plugin-bugly-upgrade.git
- 在应用启动的地方执行初始化
BuglyUpgrade.initApp(androidKey,iosKey,successCallback,errorCallback);
androidKey和iosKey为bugly官网申请的APP_ID
