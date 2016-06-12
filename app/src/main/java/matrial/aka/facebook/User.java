package matrial.aka.facebook;

import com.google.gson.annotations.SerializedName;

/**
 * Created by geckozila on 12/06/16.
 * This class will hold my pojo that retrived from fb
 */
public class User {

   @SerializedName("name")
    public String mName;

   @SerializedName("email")
    public String mEmail;
    @SerializedName("facebookID")
    public String mFacebookID;
    @SerializedName("gender")
    public String mGender;


    public String getName() {
        return mName;
    }

    public String getEmail() {
        return mEmail;
    }

    public String getFacebookID() {
        return mFacebookID;
    }

    public String getGender() {
        return mGender;
    }
}




