package ltd.bongo.talkiesbongo.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;



public class AppSessionManager {

    private static final String USER_INFO = "USER_INFO";
    private static final String CAMP_LIST_INFO = "CAMP_LIST_INFO";
    private static final String CAMP_BR_LIST_INFO = "CAMP_BR_LIST_INFO";
    private static final String CAMP_NAME = "CAMP_NAME";
    private static final String JOINTSUBBRLIST = "JOINTSUBBRLIST";
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context _context;
    int PRIVATE_MODE = 0;
    private static final String LOCATIONMODEL = "LOCATIONMODEL";

    //..............Merchant .........................
    public static final String PREF_NAME = "SUP_PREFERENCES";
    public static final String USER_NAME = "userName";
    public static final String USER_ID = "userId";
    public static final String USER_IS_LOGIN = "USERIsLoggedIn";
    //public static final String USER_ROLE = "userRole";
    public static final String USER_TOKEN = "token";
    public static final String USER_EXPIRESIN = "userExpire";
    public static final String USER_DESIGNATION = "designation";
    public static final String SUPERVISOR_NAME = "supervisor_name";
    public static final String SUPERVISOR_CONTACT = "supervisor_contact";
    public static final String DISTRIBUTION_HOUSE = "distribution_house";
    public static final String TERRITORY = "territory";
    //public static final String USER_GENDER = "gender";
    public static final String ID = "sup_id";
    public static final String FRANCHISE_CALL_PROGRESS = "FRANCHISE_CALL_PROGRESS";
    public static final String FRANCHISE_SWAPPING_PROGRESS = "FRANCHISE_SWAPPING_PROGRESS";
    public static final String SOB_CALL_PROGRESS = "SOB_CALL_PROGRESS";
    public static final String SOB_SWAPPING_PROGRESS = "SOB_SWAPPING_PROGRESS";
    public static final String PTR_PROGRESS = "PTR_PROGRESS";
    public static final String USER_IMAGE = "user_image";
    public static final String USER_DISTRIBUTION_POINT = "distribution_point";
    public static final String USER_ROUT_SECTION = "routeSection";

    public static final String CAMPGAIN_DATA = "Campaign_data";
    public static final String KEY_FIREBASETOKEN = "fcmToken";

    public static final String VIDEO_VERSION = "video_version" ;
    public static final String IMAGE_VERSION ="image_version" ;

    public static final String SURVEY_START_END="STARTEND";

    public static final String STOCK_COL_SUBMIT="SUBMITCOL";
    public static final String STOCK_RECOL_SUBMIT="SUBMITRECONCI";

    public static final String DATE_OF_MONTH="DateOfMonth";
    public static final String CAMPAIGN_ID ="CAMPAIGN_ID";

    public static int VIDEO_VERSION_NUMBER=0;

    public static int IMAGE_VERSION_NUMBER=0;

    public AppSessionManager(Context context) {
        this._context = context;
        sharedPreferences = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = sharedPreferences.edit();
    }

    // Shared preference data store for Merchant login session
    public void createMerchantLoginSession(String userName, String userId, String token, String userExpire, String designation, String supervisor_name, String distribution_house, String territory, String supervisor_contact, String user_image, String distribution_point, String routeSection) {
        editor.putBoolean(USER_IS_LOGIN, true);
        editor.putString(USER_NAME, userName);
        editor.putString(USER_ID, userId);
       // editor.putString(USER_ROLE, userRole);
        editor.putString(USER_TOKEN, token);
        editor.putString(USER_EXPIRESIN, userExpire);
        editor.putString(USER_DESIGNATION, designation);
        editor.putString(SUPERVISOR_NAME, supervisor_name);
        editor.putString(DISTRIBUTION_HOUSE, distribution_house);
        editor.putString(TERRITORY, territory);
       // editor.putString(USER_GENDER, gender);
        editor.putString(SUPERVISOR_CONTACT, supervisor_contact);
        editor.putString(USER_IMAGE, user_image);
        editor.putString(USER_DISTRIBUTION_POINT, distribution_point);
        editor.putString(USER_ROUT_SECTION, routeSection);
        editor.commit();
    }


    //Get Stored Session Data from SharedPreference
    public HashMap<String, String> getUserDetails() {
        HashMap<String, String> userData = new HashMap<String, String>();
        userData.put(USER_NAME, sharedPreferences.getString(USER_NAME, null));
        userData.put(USER_ID, sharedPreferences.getString(USER_ID, null));
        //userData.put(USER_ROLE, sharedPreferences.getString(USER_ROLE, null));
        userData.put(USER_TOKEN, sharedPreferences.getString(USER_TOKEN, null));
        userData.put(USER_EXPIRESIN, sharedPreferences.getString(USER_EXPIRESIN, null));
        userData.put(USER_DESIGNATION, sharedPreferences.getString(USER_DESIGNATION, null));
        userData.put(SUPERVISOR_NAME, sharedPreferences.getString(SUPERVISOR_NAME, null));
        userData.put(SUPERVISOR_CONTACT, sharedPreferences.getString(SUPERVISOR_CONTACT, null));
        userData.put(DISTRIBUTION_HOUSE, sharedPreferences.getString(DISTRIBUTION_HOUSE, null));
        userData.put(TERRITORY, sharedPreferences.getString(TERRITORY, null));
        userData.put(KEY_FIREBASETOKEN, sharedPreferences.getString(KEY_FIREBASETOKEN, null));
        userData.put(ID, sharedPreferences.getString(ID, null));
        userData.put(USER_IMAGE, sharedPreferences.getString(USER_IMAGE, null));
        userData.put(USER_DISTRIBUTION_POINT, sharedPreferences.getString(USER_DISTRIBUTION_POINT, null));
        userData.put(USER_ROUT_SECTION, sharedPreferences.getString(USER_ROUT_SECTION, null));
        return userData;
    }

    //Remove data from sharedPreferences when user is logout
    public void logoutUser() {
        sharedPreferences = _context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        sharedPreferences.edit().putBoolean(USER_IS_LOGIN, false).apply();
        sharedPreferences.edit().remove(USER_NAME).apply();
        sharedPreferences.edit().remove(USER_ID).apply();
       // sharedPreferences.edit().remove(USER_ROLE).apply();
        sharedPreferences.edit().remove(USER_TOKEN).apply();
        sharedPreferences.edit().remove(USER_EXPIRESIN).apply();
        sharedPreferences.edit().remove(USER_DESIGNATION).apply();
        sharedPreferences.edit().remove(SUPERVISOR_NAME).apply();
        sharedPreferences.edit().remove(DISTRIBUTION_HOUSE).apply();
        sharedPreferences.edit().remove(TERRITORY).apply();
        sharedPreferences.edit().remove(KEY_FIREBASETOKEN).apply();
        sharedPreferences.edit().remove(USER_IMAGE).apply();
        sharedPreferences.edit().remove(USER_DISTRIBUTION_POINT).apply();
        sharedPreferences.edit().remove(USER_ROUT_SECTION).apply();
    }

    //Check is user Login or not
    public boolean isLoggedIn() {
        return sharedPreferences.getBoolean(USER_IS_LOGIN, false);
    }
    public void setLoggedIn(boolean status) {
        editor.putBoolean(USER_IS_LOGIN, status);
        editor.apply();

    }




    public void setuserInfoAlldata(String userdata) {
        editor.putString(USER_INFO, userdata);
        editor.apply();
    }
    public String getuserInfoAlldata(){
        return sharedPreferences.getString(USER_INFO, "");
    }
    public void setCampdata(String camlist) {
        editor.putString(CAMP_LIST_INFO, camlist);
        editor.apply();
    }
    public String getCampdata(){
      return sharedPreferences.getString(CAMP_LIST_INFO, "");
    }

    public void setBrListdata(String brcamplist) {
        editor.putString(CAMP_BR_LIST_INFO, brcamplist);
        editor.apply();
    }
    public String getBrListdata(){
        return sharedPreferences.getString(CAMP_BR_LIST_INFO, "");
    }

    public void setCampName(String campName) {
        editor.putString(CAMP_NAME, campName);
        editor.apply();
    }
    public String getCampName(){
        return sharedPreferences.getString(CAMP_NAME, "");
    }

    public void setLocdata(String locdata) {
        editor.putString(LOCATIONMODEL, locdata);
        editor.apply();
    }
    public String getLocdata() {
        return sharedPreferences.getString(LOCATIONMODEL, "");
    }

//    public void setJointcallsubmitedbrlist(String userdata) {
//        editor.putString(JOINTSUBBRLIST, userdata);
//        editor.apply();
//    }
//
//    public String getJointcallsubmitedbrlist() {
//        return sharedPreferences.getString(JOINTSUBBRLIST, "");
//    }
}
