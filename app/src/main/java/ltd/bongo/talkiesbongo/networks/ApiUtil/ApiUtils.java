package ltd.bongo.talkiesbongo.networks.ApiUtil;


import ltd.bongo.talkiesbongo.networks.Remote.APIService;
import ltd.bongo.talkiesbongo.networks.Remote.RetroClient;

public class ApiUtils {
    public static APIService getApiService(){
        return RetroClient.getClient().create(APIService.class);
    }
}
