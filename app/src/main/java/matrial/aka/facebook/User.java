package matrial.aka.facebook;

import com.google.gson.annotations.SerializedName;

/**
 * Created by geckozila on 12/06/16.
 * This class will hold my pojo that retrived from fb
 */
public class User {

    @SerializedName("name")
    private String mName;

    @SerializedName("email")
    private String mEmail;
    @SerializedName("facebookID")
    private int mFacebookID;
    @SerializedName("gender")
    private String mGender;


}


