package matrial.aka.facebook;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import android.util.Log;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// when extending application it means what ever being applied to the application
// wil be applied to the application first instance [when you lunch the app hs will class will run]

public class MainActivity extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // this code for tracking the number of time the app opens and installs
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
        // making hash key for the app
try {
    PackageInfo info = getPackageManager().getPackageInfo("matrial.aka.facebook", PackageManager.GET_SIGNATURES);
for (Signature signature: info.signatures){
    MessageDigest md = MessageDigest.getInstance("SHA");
    md.update(signature.toByteArray());
    Log.e("this is your keyHash :", Base64.encodeToString(md.digest(),Base64.DEFAULT));
}

} catch (PackageManager.NameNotFoundException e) {
    e.printStackTrace();
} catch (NoSuchAlgorithmException e) {
    e.printStackTrace();
}
    }
}
