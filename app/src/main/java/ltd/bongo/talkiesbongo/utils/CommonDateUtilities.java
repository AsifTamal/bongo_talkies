package ltd.bongo.talkiesbongo.utils;

import android.content.Context;
import android.text.format.DateUtils;
import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class CommonDateUtilities {

    Context context;

    public CommonDateUtilities(Context context) {
        this.context = context;
    }

    public String calculatelastSeen(String createdAt) {
        CharSequence ago ="";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        try {
            long time = sdf.parse(createdAt).getTime();
            long now = System.currentTimeMillis();
            ago = DateUtils.getRelativeTimeSpanString(time, now, DateUtils.MINUTE_IN_MILLIS);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return ago.toString();
    }

    public int getYearDifference(String date){
        //    String dateFromDB = "10/02/2002";
        int deff= 0;
        try {
            SimpleDateFormat dateFormatprev = new SimpleDateFormat("yyyy-MM-dd");
            Date d = null;
            try {
                d = dateFormatprev.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            // SimpleDateFormat dateFormat = new SimpleDateFormat("EEE dd MMM yyyy");
            // String changedDate = dateFormat.format(d);
            Calendar cal = Calendar.getInstance();
            cal.setTime(d);
//        int month = (cal.get(Calendar.MONTH)+1);
//        int  dd = (cal.get(Calendar.DATE));
            int  yer = (cal.get(Calendar.YEAR));
            Calendar caal = Calendar.getInstance();
            int  pyer = (caal.get(Calendar.YEAR));

            deff = pyer-yer;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deff;

    }

    public String getTimeDifference(String Starttime, String Endtime){
        //  String Starttime = "16:01:02";
        // String Endtime = "16:03:44";
        int deffhr= 0,deffmn=0,deffsc=0;
        String timedefference="";
        try {
            SimpleDateFormat dateFormatprev = new SimpleDateFormat("HH:mm:ss");
            Date d = null;
            try {
                d = dateFormatprev.parse(Starttime);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            //SimpleDateFormat dateFormat = new SimpleDateFormat("HH mm ss");
            Date endt = null;
            try {
                endt = dateFormatprev.parse(Endtime);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            Calendar cal = Calendar.getInstance();
            cal.setTime(d);

            Calendar caal = Calendar.getInstance();
            caal.setTime(endt);


            Date d1 = cal.getTime();
            Date d2 = caal.getTime();
            long mills = d1.getTime() - d2.getTime();

            timedefference=  String.format("%02d : %02d ",
                    TimeUnit.MILLISECONDS.toMinutes(Math.abs(mills)),
                    TimeUnit.MILLISECONDS.toSeconds(Math.abs(mills)) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes( Math.abs(mills)))
            );

            Log.d("gfdfsgdfgd", String.valueOf(timedefference));
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("gfdfsgdfgd", String.valueOf(e.getMessage()));
        }
        return timedefference;

    }


    public String getSessionTimeDiff(String Starttime, String Endtime){
        //  String Starttime = "16:01:02";
        // String Endtime = "16:03:44";
        int deffhr= 0,deffmn=0,deffsc=0;
        String timedefference="";
        try {
            SimpleDateFormat dateFormatprev = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
            Date d = null;
            try {
                d = dateFormatprev.parse(Starttime);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            //SimpleDateFormat dateFormat = new SimpleDateFormat("HH mm ss");
            Date endt = null;
            try {
                endt = dateFormatprev.parse(Endtime);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            Calendar cal = Calendar.getInstance();
            cal.setTime(d);

            Calendar caal = Calendar.getInstance();
            caal.setTime(endt);


            Date d1 = cal.getTime();
            Date d2 = caal.getTime();
            long mills = d1.getTime() - d2.getTime();

            timedefference=  String.format("%d",TimeUnit.MILLISECONDS.toMinutes(Math.abs(mills)));

            Log.d("gfdfsgdfgd", String.valueOf(timedefference));
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("gfdfsgdfgd", String.valueOf(e.getMessage()));
        }
        return timedefference;

    }



    public int getCurrentDate(){
        Calendar caal = Calendar.getInstance();
        int  date = (caal.get(Calendar.DATE));
        return date;
    }

    public String getdatetime(){
        String newdate="";
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sdt = df.format(new Date(System.currentTimeMillis()));
        Log.d("getdatetie", sdt);
        return sdt;
    }

    public String getContactDate(){
        String newdate="";
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String sdt = df.format(new Date(System.currentTimeMillis()));
        Log.d("getdatetie", sdt);
        return sdt;
    }

    public String getHourMintSecond(String time){
        SimpleDateFormat dateFormatprev = new SimpleDateFormat("HH:mm:ss");
        Date d = null;
        try {
            d = dateFormatprev.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        DateFormat df = new SimpleDateFormat("hh:mm a");
        String sdt = df.format(d);
        Log.d("getdatetie", sdt);
        return sdt;
    }
}
