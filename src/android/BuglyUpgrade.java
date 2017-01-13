package tech.bigbug.cordova.plugin;

import com.tencent.bugly.Bugly;
import com.tencent.bugly.beta.Beta;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

/**
 * Created by evan on 2017/1/12.
 */

public class BuglyUpgrade extends CordovaPlugin {
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("initApp")) {
            /**
             * wifi下自动下载
             */
            Beta.autoDownloadOnWifi = false;
            /**
             * 是否显示弹窗apk信息（默认弹窗）
             */
            Beta.canShowApkInfo = true;

            String androidAppID = args.optString(0);
            /**
             * 已经接入Bugly用户改用上面的初始化方法,不影响原有的crash上报功能;.
             * init方法会自动检测更新，不需要再手动调用Beta.checkUpgrade(),如需增加自动检查时机可以使用Beta.checkUpgrade(false,false);
             * 参数1：applicationContext
             * 参数2：appId
             * 参数3：是否开启debug
             */
            Bugly.init(this.cordova.getActivity(), androidAppID , false);
            callbackContext.success();
            return true;
        }

        return false;
    }
}
