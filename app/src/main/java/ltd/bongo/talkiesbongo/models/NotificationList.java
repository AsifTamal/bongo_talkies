package ltd.bongo.talkiesbongo.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class NotificationList implements Serializable {

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("notifications")
    @Expose
    private List<NotificationData> notifications = null;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<NotificationData> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<NotificationData> notifications) {
        this.notifications = notifications;
    }
}
