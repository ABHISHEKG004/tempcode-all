package MCexamples.calenderscheduler;

import java.util.ArrayList;

public interface Resolver {
    //assuming user itself won't add conflict meetings with meetings organized by himself in past
    public ArrayList<Meeting> resolve(ArrayList<Meeting> input);

    public int getPriority();

}
