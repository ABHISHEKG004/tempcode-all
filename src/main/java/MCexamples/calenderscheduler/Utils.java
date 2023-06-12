package MCexamples.calenderscheduler;

public class Utils {

    //       example time - 10:15AM
    //24*60 minutes in a day

    public static int convertToDayMinutes(String time){

        int hour = (time.charAt(0)-'0')*10 + (time.charAt(1)-'0');
        int min = (time.charAt(3)-'0')*10 + (time.charAt(4)-'0');

        if(time.charAt(5)=='P' && hour!=12){
            hour = hour+12;
        }



        return hour*60 + min;

    }

    public static boolean validateStartEndTime(String start, String end){

        if(convertToDayMinutes(start) >= convertToDayMinutes(end)){
            return false;
        }
        return true;
    }


    public static boolean validateTimeFormat(String time){

        if(time.length()!=7){
            return false;
        }

        if(time.charAt(0)<'0' || time.charAt(0)>'9' || time.charAt(1)<'0' || time.charAt(1)>'9'){
            return false;
        }

        if(time.charAt(3)<'0' || time.charAt(3)>'9' || time.charAt(4)<'0' || time.charAt(4)>'9'){
            return false;
        }

        if(time.charAt(2)!=':' || time.charAt(6)!='M' || !(time.charAt(5)=='A' || time.charAt(5)=='P')) {
            return false;
        }

       return true;
    }
}
