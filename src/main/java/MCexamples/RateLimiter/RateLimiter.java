package MCexamples.RateLimiter;

public interface RateLimiter {

    boolean rateLimit(String userid, int hitTime);
}
