package MCexamples.ParkingLotSample;//package Design.ParkingLot;
//
///**
// * Created by abhishek.gupt on 28/12/17.
// */
//public class Parking {
//}
//package Garage;
//
//        import java.io.BufferedReader;
//        import java.io.InputStreamReader;
//        import java.util.Hashtable;
//        import java.util.LinkedList;
//        import java.util.Queue;
//        import java.util.Random;
//
//        import Vehicles.Car;
//        import Vehicles.Motorbike;
//        import Vehicles.Vehicle;
//
//public class Garage {
//
//    public static class Pair {
//        private int level;
//        private int lot;
//
//        public Pair(int level , int lot) {
//            this.level = level;
//            this.lot = lot;
//        }
//
//        public int getLevel() {
//            return level;
//        }
//
//        public int getLot() {
//            return lot;
//        }
//    }
//
//    private int [] parkingSpaces;
//    private LinkedList<Vehicle> [] garage;
//    private Hashtable<Integer , Pair> idToLots =  new Hashtable<Integer, Pair> ();
//
//    @SuppressWarnings("unchecked")
//    public Garage(int [] parkingSpaces) throws IllegalArgumentException {
//        if( parkingSpaces == null || parkingSpaces.length < 1 ) throw  new IllegalArgumentException("Invalid parking space!");
//        for(Integer i:parkingSpaces)
//            if(i<=0)
//                throw new IllegalArgumentException();
//
//        this.parkingSpaces = parkingSpaces;
//        garage =  new LinkedList [parkingSpaces.length];
//        for(int i = 0; i<parkingSpaces.length;i++)
//            garage[i] = new LinkedList<Vehicle>();
//    }
//
//    public boolean enter(Vehicle v) {
//        if(v == null) throw new IllegalArgumentException("Invalid Vehcle argument");
//        if(idToLots.containsKey(v.getId())) throw new IllegalArgumentException("A Vehicle with this id already exists in the garage!");
//        for(int i = 0;i<garage.length;i++) {
//            if((parkingSpaces[i] - garage[i].size()) >0) {
//                garage[i].add(v);
//                idToLots.put(v.getId(), new Pair(i,garage[i].size()));
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public Vehicle exit() {
//        for(int i = garage.length-1;i>=0;i--) {
//            if(garage[i].size() > 0) {
//                idToLots.remove( garage[i].getFirst().getId());
//                return garage[i].remove();
//            }
//        }
//
//        return null;
//    }
//
//    public Pair getParkingPlace(int vehicleId) {
//        return idToLots.get(vehicleId);
//    }
//
//    public int getFreeParkingLots() {
//        int sum = 0;
//        for(int i = 0; i< garage.length;i++) {
//            sum += parkingSpaces[i] - garage[i].size();
//        }
//        return sum;
//    }
//
//    public static final String EXIT_COMMAND = "exit";
//
//    public static void main(String[] args) {
//
//        try {
//            int [] parkingSpaces = {5,4,3};
//            Garage g = new Garage(parkingSpaces);
//            Queue<Vehicle> vq = new LinkedList<Vehicle>();
//            final int size = 20;
//            for(int i = 0;i<size;i+=2) {
//                vq.add(new Car(1000 + i));
//                vq.add(new Motorbike(1000 +i+1));
//            }
//
//            Random r = new Random();
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//            while (true) {
//                System.out.println("****************");
//                for (int i = 0; i<r.nextInt(vq.size());i++) {
//                    System.out.println(" Vehicle with id = " + vq.peek().getId() + " is entering the garage");
//                    if(!g.enter(vq.poll())) break;
//                }
//
//                System.out.println(" Available lots in the garage are: " + g.getFreeParkingLots());
//
//                int id = 1000 + r.nextInt(size);
//                Pair p = g.getParkingPlace(id);
//                if(p == null) {
//                    System.out.println(" The vehicle with id = " + id + "is not in the garage!");
//                } else {
//                    System.out.println(" The place of the vehicle with id = " + id + " is on level : " + p.getLevel() + " and lot : " + p.getLot());
//                }
//
//                for (int i = 0; i<r.nextInt(size-g.getFreeParkingLots()-1);i++) {
//                    Vehicle v = g.exit();
//                    if(v== null) break;
//                    vq.add(v);
//                    System.out.println(" Vehicle with id = " + v.getId() + " is leaving the garage");
//                }
//                System.out.println();
//                System.out.println();
//
//                System.out.println("Press enter to continue or type exit!");
//                System.out.print(">>> ");
//                String input = br.readLine();
//                if (input.length() == EXIT_COMMAND.length() && input.toLowerCase().equals(EXIT_COMMAND)) {
//                    System.out.println("Terminating .... ");
//                    return;
//                }
//
//                System.out.println("****************");
//            }
//        } catch (IllegalArgumentException ex) {
//            System.err.println(ex.getLocalizedMessage());
//        } catch (Exception ex) {
//            // TODO :: general case
//            System.err.println(ex.getLocalizedMessage());
//        }
//    }
//}
//
//
//package Vehicles;
//
//public abstract class Vehicle {
//
//    private int id;
//
//    public int getId() {
//        return id;
//    }
//
//    public Vehicle(int id) throws IllegalArgumentException {
//        if(id<=0 ) throw new IllegalArgumentException();
//        this.id  = id;
//    }
//
//    public static void main(String[] args) {
//        // TODO Auto-generated method stub
//
//    }
//
//}
//
//
//
//package Vehicles;
//
//public class Car extends Vehicle {
//
//    public Car(int id) throws IllegalArgumentException {
//        super(id);
//        // TODO Auto-generated constructor stub
//    }
//
//    public static void main(String[] args) {
//        // TODO Auto-generated method stub
//
//    }
//
//}
//
//
//package Vehicles;
//
//public class Motorbike extends Vehicle {
//
//    public Motorbike(int id) throws IllegalArgumentException {
//        super(id);
//        // TODO Auto-generated constructor stub
//    }
//
//    public static void main(String[] args) {
//        // TODO Auto-generated method stub
//
//    }
//
//}
