package MCexamples.RateLimiter;


public class Controller {


    public static void main (String args[]){


        //5 requests are allowed peer 3 sec
        FixedWindowRateLimiter fixedRateLimiter = new FixedWindowRateLimiter(5, 3);

        System.out.println(fixedRateLimiter.rateLimit("user1", 1));//t
        System.out.println(fixedRateLimiter.rateLimit("user1", 2));//t
        System.out.println(fixedRateLimiter.rateLimit("user1", 2));//t
        System.out.println(fixedRateLimiter.rateLimit("user1", 3));//t
        System.out.println(fixedRateLimiter.rateLimit("user1", 3));//t
        System.out.println(fixedRateLimiter.rateLimit("user1", 3));//false

        System.out.println(fixedRateLimiter.rateLimit("user1", 6)); //true




    }
}
