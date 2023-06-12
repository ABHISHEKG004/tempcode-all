package MCexamples.calenderscheduler;

import java.util.ArrayList;

public class HierarchyResolver implements Resolver{


    int priority;

    public HierarchyResolver(int priority){
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public ArrayList<Meeting> resolve(ArrayList<Meeting> input) {

        ArrayList<Meeting> inpu = new ArrayList<>(input);

        int st = input.get(0).startTime;
        int en = input.get(0).endTime;

        int i = 1;
        int k = input.size();
        int prev = 0;

        while(i<k){

            int curst = input.get(i).startTime;
            int curen = input.get(i).endTime;

            if(curst>=en){ //no overlapping
                st = curst;
                en = curen;
//                out.add(input.get(prev));

            } else {

                String curOrganizer = input.get(i).getOrganizer();
                String prevOrganizer = input.get(prev).getOrganizer();

                if(Datastore.hierrachyHashMap.get(curOrganizer).pri < Datastore.hierrachyHashMap.get(prevOrganizer).pri ){
                    inpu.remove(input.get(prev));
                    prev = i;
                } else {
                    inpu.remove(input.get(i));
                }

                st=input.get(prev).startTime;
                en=input.get(prev).endTime;

            }

            i++;

        }
        return inpu;
    }
}
