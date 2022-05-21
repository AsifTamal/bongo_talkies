package ltd.bongo.talkiesbongo.networks.Remote;

import com.ihsanbal.logging.Level;
import com.ihsanbal.logging.LoggingInterceptor;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


import ltd.bongo.talkiesbongo.BuildConfig;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.internal.platform.Platform;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroClient {
    public static Retrofit retrofit = null;
    private static OkHttpClient okHttpClient;
    private static LoggingInterceptor interceptor;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BuildConfig.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(getOkHttpClient())
                    .build();
        }

        return retrofit;
    }
    private static OkHttpClient getOkHttpClient() {
        if (okHttpClient == null)
            okHttpClient = new OkHttpClient().newBuilder()
                    .addInterceptor(getLoggingInterceptor())
                    .connectTimeout(40, TimeUnit.SECONDS)
                    .readTimeout(60, TimeUnit.SECONDS)
                    .writeTimeout(60, TimeUnit.SECONDS)
                    .addInterceptor(chain -> {
                        Request request = chain.request().newBuilder().addHeader("lang", "en").build();
                        return chain.proceed(request);
                    })
                    .build();
        return okHttpClient;
    }
    private static LoggingInterceptor getLoggingInterceptor() {
        if (interceptor == null)
            interceptor = new LoggingInterceptor.Builder()
                    .loggable(BuildConfig.DEBUG)
                    .setLevel(Level.BASIC)
                    .log(Platform.INFO)
                    .request("API_REQ")
                    .response("API_RES")
                    .executor(Executors.newSingleThreadExecutor())
                    .enableAndroidStudio_v3_LogsHack(true)
                    .build();
        return interceptor;
    }
}
