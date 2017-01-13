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
             * wifi���Զ�����
             */
            Beta.autoDownloadOnWifi = false;
            /**
             * �Ƿ���ʾ����apk��Ϣ��Ĭ�ϵ�����
             */
            Beta.canShowApkInfo = true;

            String androidAppID = args.optString(0);
            /**
             * �Ѿ�����Bugly�û���������ĳ�ʼ������,��Ӱ��ԭ�е�crash�ϱ�����;.
             * init�������Զ������£�����Ҫ���ֶ�����Beta.checkUpgrade(),���������Զ����ʱ������ʹ��Beta.checkUpgrade(false,false);
             * ����1��applicationContext
             * ����2��appId
             * ����3���Ƿ���debug
             */
            Bugly.init(this.cordova.getActivity(), androidAppID , false);
            callbackContext.success();
            return true;
        }

        return false;
    }
}
