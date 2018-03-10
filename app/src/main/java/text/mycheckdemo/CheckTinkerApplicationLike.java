package text.mycheckdemo;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.multidex.MultiDex;

import com.tencent.tinker.anno.DefaultLifeCycle;
import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.tinker.TinkerInstaller;
import com.tencent.tinker.loader.app.DefaultApplicationLike;
import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.shareutil.ShareConstants;

/**
 * Created by jh on 2018/3/9.
 */

@SuppressWarnings("unused")
@DefaultLifeCycle(application = "text.mycheckdemo.CheckTinkerApplication",
        flags = ShareConstants.TINKER_ENABLE_ALL,
        loadVerifyFlag = false)
public class CheckTinkerApplicationLike extends DefaultApplicationLike {

    public CheckTinkerApplicationLike(
            Application application,int tinkerFlags,boolean tinkerLoadVerifyFlag,
            long applicationStartElapsedTime,long applicationStartMillisTime,
            Intent tinkerResultIntent) {
        super(application, tinkerFlags,
                tinkerLoadVerifyFlag,applicationStartElapsedTime,
                applicationStartMillisTime,
                tinkerResultIntent);
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    public void onBaseContextAttached(Context base) {
        super.onBaseContextAttached(base);
        MultiDex.install(base);

//        SampleApplicationContext.application = getApplication();
//        SampleApplicationContext.context = getApplication();
//        TinkerManager.setTinkerApplicationLike(this);

//        TinkerManager.initFastCrashProtect();
//        //should set before tinker is installed
//        TinkerManager.setUpgradeRetryEnable(true);
//
//        //optional set logIml, or you can use default debug log
//        TinkerInstaller.setLogIml(new MyLogImp());
//
//        //installTinker after load multiDex
//        //or you can put com.tencent.tinker.** to main dex
//        TinkerManager.installTinker(this);
//        Tinker tinker = Tinker.with(getApplication());
    }


    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    public void registerActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks callback) {
        getApplication().registerActivityLifecycleCallbacks(callback);
    }
}
