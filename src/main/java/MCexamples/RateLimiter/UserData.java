package MCexamples.RateLimiter;

public class UserData {

    private int count;
    private int startTime;

    public UserData(int count, int startTime){
        this.count = count;
        this.startTime= startTime;
    }

    public int getCount(){
        return count;
    }
    public void incCount(int val){
        this.count += val;
    }

    public int getStartTime(){
        return startTime;
    }

    public void setStartTime(int startTime){
        this.startTime = startTime;
    }
}