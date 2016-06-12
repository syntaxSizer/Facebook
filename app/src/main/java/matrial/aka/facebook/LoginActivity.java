package matrial.aka.facebook;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONObject;

/**
 * Created by geckozila on 12/06/16.
 */
public class LoginActivity extends Activity {

    private CallbackManager callbackManager;
    private LoginButton loginbutton;
    private TextView btnLogin;
    private ProgressDialog didi;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(PrefUtils.getCurrentUser(LoginActivity.this) != null){
            Intent homeIntent = new Intent(LoginActivity.this,LogoutActivity.class);
            startActivity(homeIntent);
            finish();
        }

     }
    @Override
    protected void OnResume(){
        super.onResume();


        callbackManager = CallbackManager.Factory.create();

        loginbutton = (LoginButton) findViewById(R.id.Login_button);
        loginbutton.setPublishPermissions("public_profile","email","user_friends");
      btnLogin =(TextView) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                //A dialog showing a progress indicator and an optional text
                // message or view. Only a text message or a view
                // can be used at the same time.

                didi = new ProgressDialog(LoginActivity.this);
                didi.setMessage("SKYNET Reloading...");
                didi.show();

                loginbutton.setPressed(true);
                // invalidate function used to kill the session after redirection
                loginbutton.invalidate();
                loginbutton.registerCallback(callbackManager, mCallback);

                loginbutton.setPressed(false);
                loginbutton.invalidate();
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode , int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode,data);
        callbackManager.onActivityResult(requestCode,resultCode,data);
    }


    private FacebookCallback<LoginResult>mCallback=new FacebookCallback<LoginResult>() {
        @Override
        public void onSuccess(LoginResult loginResult) {
didi.dismiss();
            //app code
            // getting user data
            GraphRequest request= GraphRequest.newMeRequest();
            loginResult.getAccessToken();
            new GraphRequest.GraphJSONObjectCallback(){

                @Override
                public void onCompleted(JSONObject object, GraphResponse response) {
                    Log.e("resoponse", "response" + "");
                    try{

                    }
                    catch(){

                    }

                }
            }
        }

        @Override
        public void onCancel() {

        }

        @Override
        public void onError(FacebookException error) {

        }
    }
}
