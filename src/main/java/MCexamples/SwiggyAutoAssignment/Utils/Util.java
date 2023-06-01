package MCexamples.SwiggyAutoAssignment.Utils;

import MCexamples.lowlevel.mine.SwiggyAutoAssignment.Models.Item;
import MCexamples.lowlevel.mine.SwiggyAutoAssignment.Models.Location;

import java.util.ArrayList;

/**
 * Created by abhishek.gupt on 26/05/18.
 */
public class Util {


    public static double getCostForItems(ArrayList<Item> items){
        double cost = 0.0f;

        for (Item item : items) {
            cost += item.getPrice();
        }
        return cost;
    }

    public static void showItems(ArrayList<Item> items){

        for (Item item : items) {
            System.out.print("Item : " + item.getName());
            System.out.println(", Price : " + item.getPrice());
        }
    }

    public static double getDistance(Location location1, Location location2){
        //assuming lat and long as x,y cordinate
        int lat1 = location1.getLatitude();
        int lat2 = location2.getLatitude();

        int long1 = location1.getLongitude();
        int long2 = location2.getLongitude();

        double distance = (lat1-lat2)*(lat1-lat2) + (long1-long2)*(long1-long2);
        return Math.sqrt(distance);
    }

    //referred from here : https://www.nayuki.io/page/next-lexicographical-permutation-algorithm
    public static boolean nextPermutation(int[] array) {
        int i = array.length - 1;
        while (i > 0 && array[i - 1] >= array[i])
            i--;

        if (i <= 0)
            return false;

        int j = array.length - 1;
        while (array[j] <= array[i - 1])
            j--;

        int temp = array[i - 1];
        array[i - 1] = array[j];
        array[j] = temp;

        j = array.length - 1;
        while (i < j) {
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }

        return true;
    }
}
