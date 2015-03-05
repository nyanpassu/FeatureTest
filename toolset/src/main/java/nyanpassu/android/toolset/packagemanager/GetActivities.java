package nyanpassu.android.toolset.packagemanager;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 丢猫 on 2015/3/2.
 */
public class GetActivities {

    public static class Result {
        public int size;

        public List<String> activitiesLabelList = new ArrayList<>();
        public List<Drawable> activitiesIconList = new ArrayList<>();
        public List<Intent> activitiesIntentList = new ArrayList<>();
    }

    public static Result getPackageActivity(@NonNull Context context,
                                            @Nullable String queryAction,
                                            @Nullable String queryCategory,
                                            @Nullable String queryPackageName) {
        Result result = new Result();

        List<ResolveInfo> list;

        Intent queryIntent = new Intent();
        if (queryCategory != null) {
            queryIntent.addCategory(queryCategory);
        }
        if (queryPackageName != null) {
            queryIntent.setPackage(queryPackageName);
        }
        if (queryAction != null) {
            queryIntent.setAction(queryAction);
        }

        PackageManager pm = context.getPackageManager();
        list = pm.queryIntentActivities(queryIntent, PackageManager.GET_ACTIVITIES);

        if (list != null) {
            for (ResolveInfo info : list) {
                String activityLabel = info.loadLabel(pm).toString();
                Drawable activityIcon = info.loadIcon(pm);
                String activityName = info.activityInfo.name;
                String packageName = info.activityInfo.packageName;

                Intent intent = new Intent();
                intent.setComponent(new ComponentName(packageName, activityName));

                result.activitiesLabelList.add(activityLabel);
                result.activitiesIconList.add(activityIcon);
                result.activitiesIntentList.add(intent);
                result.size = result.size + 1;
            }
        }

        return result;
    }
}
