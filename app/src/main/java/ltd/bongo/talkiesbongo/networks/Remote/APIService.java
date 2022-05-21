package ltd.bongo.talkiesbongo.networks.Remote;

import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ltd.bongo.talkiesbongo.models.MovieDataModel;
import ltd.bongo.talkiesbongo.models.NotificationList;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIService {


/*
    //.......login.........
    @POST("api-gateway/web/login")
    Call<LogInModel> getSignInInfo(@Body Map<String, Object> signInMap);


    //........ Auth check ..........
    @POST("/api-gateway/check-authorize-for-sup")
    Call<AuthCheckModel> checkAuth(@Body Map<String, Object> authMap);

    @Headers({"Content-Type: application/json;charset=UTF-8"})
    @GET("/campaign/get-campaigns")
    Call<List<CampaignsModel>> getCampaignsList(@Header("Authorization") String authToken);


    @Headers({"Content-Type: application/json;charset=UTF-8"})
    @GET("/campaign/get-br-list/{id}")
    Call<List<BrModel>> getBrList(@Header("Authorization") String authToken, @Path("id") int id);


    // get all br list
    @Headers({"Content-Type: application/json;charset=UTF-8"})
    @GET("/campaign/get-brs")
    Call<List<AllBRListModel>> getAllBrList(@Header("Authorization") String authToken);

  //  Call<SupSurvayQuestion> getSurveyQuestiondata(String token, Integer campId);
    @Headers({"Content-Type: application/json;charset=UTF-8"})
    @GET("/campaign/get-flow/{id}")
    Call<JsonObject> getSurveyQuestiondata(@Header("Authorization") String authToken, @Path("id") int id);


    // Post/Submit Survey Data
    @Headers({"Content-Type: application/json;charset=UTF-8"})
    @POST("/campaign/post-fieldvisit")
    Call<ResponseBody> submitData(@Body HashMap<String, Object> survey, @Header("Authorization") String token);

    @POST("/campaign/get-contacts")
    Call<ResponseBody> getConsumerList(@Body Map<String, Object> signInMap, @Header("Authorization") String token);

    @POST("/campaign/get-route-cluster")
    Call<List<RouteClusterModel>> getRouteClusterList(@Body Map<String, Object> Map, @Header("Authorization") String token);

    // post call data
    @POST("/campaign/post-callback")
    Call<JsonObject> submitCallData(@Body Map<String, Object> model, @Header("Authorization") String token);

    @Headers({"Content-Type: application/json;charset=UTF-8"})
    @GET("/campaign/get-location/{id}")
    Call<BrLatLongModel> ShowBrlocation(@Header("Authorization") String authToken, @Path("id") int id);

    //void ShowBrlocation(Integer id, String s);
    @Headers({"Content-Type: application/json;charset=UTF-8"})
    @GET("/campaign/get-jointcalls")
    Call<List<JointCallSummaryModel>> getJoinSumary(@Header("Authorization") String authToken);

    @Headers({"Content-Type: application/json;charset=UTF-8"})
    @GET("/campaign/get-callbacks")
    Call<List<CallbackSummaryModel>> getCallbackSumary(@Header("Authorization") String authToken);


    @Headers({"Content-Type: application/json;charset=UTF-8"})
    @GET("/campaign/get-br-stocks/{id}")
    Call<ResponseBody> getStockList(@Header("Authorization") String authToken, @Path("id") int id);

    @POST("/campaign/ptr-dispute")
    Call<ResponseBody> savePtrDispute(@Body Map<String, Object> signInMap, @Header("Authorization") String token);


    @GET("/campaign/get-contacts/{id}")
    Call<ResponseBody> setConsumerListByCampid(@Header("Authorization") String authToken, @Path("id") int id);

    @Headers({"Content-Type: application/json;charset=UTF-8"})
    @GET("/campaign/callback-trgt-achv")
    Call<CallCheckBackAchibTargetModel> getCallChecBackAchivmnet(@Header("Authorization") String authToken);

    @Headers({"Content-Type: application/json;charset=UTF-8"})
    @GET("/campaign/get-notifications")
    Call<NotificationList> getNotificationlist(@Header("Authorization") String token);

    @Headers({"Content-Type: application/json;charset=UTF-8"})
    @PUT("/campaign/seen-notification/{id}")
    Call<ResponseBody> setNotificationSeen(@Header("Authorization") String token, @Path("id") String notifcID);

    @Multipart
    @POST("/field-force-manager/upload")
    Call<List<SurveyImgData>> uploadSurveyPhoto(@Header("Authorization") String token,
                                                @Part MultipartBody.Part[] images);*/

    @Headers({"Content-Type: application/json;charset=UTF-8"})
    @GET("/campaign/get-notifications")
    Call<NotificationList> getNotificationlist(@Header("Authorization") String token);

    @Headers({"Content-Type: application/json;charset=UTF-8"})
    @PUT("/campaign/seen-notification/{id}")
    Call<ResponseBody> setNotificationSeen(@Header("Authorization") String token, @Path("id") String notifcID);

    @GET("movie/top_rated") //i.e https://api.test.com/Search?
    Call<MovieDataModel> getMovies(@Query("api_key") String apikey, @Query("language") String language,
                                     @Query("page") String page);

}
