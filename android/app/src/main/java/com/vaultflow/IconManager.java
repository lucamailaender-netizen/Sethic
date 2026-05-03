package com.vaultflow;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;

public class IconManager {

    public static void setAppIcon(Context context, boolean useNeonIcon) {
        PackageManager pm = context.getPackageManager();
        String packageName = context.getPackageName();

        // Diese Namen müssen exakt mit den "android:name" Einträgen in deiner Manifest übereinstimmen
        ComponentName defaultAlias = new ComponentName(packageName, packageName + ".MainActivityDefault");
        ComponentName neonAlias = new ComponentName(packageName, packageName + ".MainActivityFlowNeon");

        if (useNeonIcon) {
            // Aktiviere das dunkle Neon Icon
            pm.setComponentEnabledSetting(neonAlias, 
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
            // Deaktiviere das Standard Icon
            pm.setComponentEnabledSetting(defaultAlias, 
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
        } else {
            // Aktiviere das Standard Icon
            pm.setComponentEnabledSetting(defaultAlias, 
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
            // Deaktiviere das Neon Icon
            pm.setComponentEnabledSetting(neonAlias, 
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
        }
    }
}
