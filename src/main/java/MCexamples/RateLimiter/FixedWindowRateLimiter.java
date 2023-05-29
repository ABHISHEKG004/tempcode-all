package MCexamples.RateLimiter;

import java.util.HashMap;

public class FixedWindowRateLimiter implements RateLimiter{

    private HashMap<String, UserData> data;
    private int allowedRequests;
    private int timeInterval;

    public FixedWindowRateLimiter(int allowedRequests, int timeInterval){
        this.data = new HashMap<>();
        this.allowedRequests = allowedRequests;
        this.timeInterval = timeInterval;
    }

    //rateLimit(String userId, int allowedRequests, int timeInterval)
    public boolean rateLimit(String userId, int hitTime){

        if(data.get(userId)==null){

            data.put(userId, new UserData(1,hitTime));
            return true;
        } else {

            UserData userdata = data.get(userId);

            if(hitTime-userdata.getStartTime()<timeInterval){

                if((userdata.getCount() + 1) <= allowedRequests){

                    userdata.incCount(1);
                    return true;
                }else {

                    return false;
                }
            } else {
                //resetting info as we are now in next window

                // remCredits = totalallwoo -usercoout;
                // remCredit = (allowedrequests -usercount) +  ((curr- start)/window) *allowedrequest;

                userdata = new UserData(1, hitTime);
                // userdata = new UserData(1, hitTime, rem + allowedRequest);
                return true;
            }

        }


    }
}
