package MCexamples.SwiggyAutoAssignment.Models;

/**
 * Created by abhishek.gupt on 26/05/18.
 */
public class PriorityModel {

    String priorityId;
    String priorityName;
    double weightFactor;

    public PriorityModel(String priorityId, String priorityName, double weightFactor) {
        this.priorityId = priorityId;
        this.priorityName = priorityName;
        this.weightFactor = weightFactor;
    }

    public String getPriorityId() {
        return priorityId;
    }

    public String getPriorityName() {
        return priorityName;
    }

    public double getWeightFactor() {
        return weightFactor;
    }

    public void setPriorityId(String priorityId) {
        this.priorityId = priorityId;
    }

    public void setPriorityName(String priorityName) {
        this.priorityName = priorityName;
    }

    public void setWeightFactor(double weightFactor) {
        this.weightFactor = weightFactor;
    }
}
