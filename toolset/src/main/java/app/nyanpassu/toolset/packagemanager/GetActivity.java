package app.nyanpassu.toolset.packagemanager;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 丢猫 on 2015/3/2.
 */
public class GetActivity {

    public static final List<ResolveInfo> getPackageActivity(Context context,String action) {
        List<ResolveInfo> list;

        Intent queryIntent = new Intent();
        queryIntent.setPackage(context.getPackageName());
        queryIntent.setAction(action);

        PackageManager pm = context.getPackageManager();
        list = pm.queryIntentActivities(queryIntent,PackageManager.GET_ACTIVITIES);

        return list == null ? new ArrayList<ResolveInfo>() : list;
    }
}
