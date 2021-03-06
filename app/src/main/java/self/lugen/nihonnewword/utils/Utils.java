package self.lugen.nihonnewword.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;

/**
 * Created by lugen on 3/11/17.
 */

public class Utils {

    public static int getResourceId(Context context, String pVariableName, String pResourcename, String pPackageName)
    {
        try {
            return context.getResources().getIdentifier(pVariableName, pResourcename, pPackageName);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static void putSharePreferenceBooleanValue(Context context, String key, Boolean value) {
        SharedPreferences pref = context.getApplicationContext().getSharedPreferences(Constants.APP_PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public static boolean getSharePreferenceBooleanValue(Context context, String key) {
        SharedPreferences pref = context.getApplicationContext().getSharedPreferences(Constants.APP_PREF, Context.MODE_PRIVATE);
        return pref.getBoolean(key, false);
    }

    public static Character getChar(int id) {
        return (char) (Constants.FIRST_CHARACTER_A + id);
    }
    private static boolean isExternalStorageReadOnly() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(extStorageState)) {
            return true;
        }
        return false;
    }

    private static boolean isExternalStorageAvailable() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(extStorageState)) {
            return true;
        }
        return false;
    }
}
