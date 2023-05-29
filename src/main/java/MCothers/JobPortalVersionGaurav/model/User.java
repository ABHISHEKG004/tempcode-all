package MCothers.JobPortalVersionGaurav.model;

import com.design.lowlevel.others.JobPortalVersionGaurav.constants.UserDetails;

import java.util.HashMap;
import java.util.List;

/**
 * Created by gaurav.kum on 13/12/17.
 */
public class User {
    private String jobId;
    private String name;
    private String category;
    private String companyName;
    private String desgination;
    private int experience;
    private List<String> skillSet;
    private List<String> location;

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDesgination() {
        return desgination;
    }

    public void setDesgination(String desgination) {
        this.desgination = desgination;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public List<String> getSkillSet() {
        return skillSet;
    }

    public void setSkillSet(List<String> skillSet) {
        this.skillSet = skillSet;
    }

    public List<String> getLocation() {
        return location;
    }

    public void setLocation(List<String> location) {
        this.location = location;
    }

    @Override
    public String toString() {
        User user = this;
        HashMap<String, Object> data = new HashMap<>();
        data.put(UserDetails.NAME.getDetail(), user.getName());
        data.put(UserDetails.CATEGORY.getDetail(), user.getCategory());
        data.put(UserDetails.COMPANY_NAME.getDetail(), user.getCompanyName());
        data.put(UserDetails.DESIGNATION.getDetail(), user.getDesgination());
        data.put(UserDetails.EXPERIENCE.getDetail(), user.getExperience());
        return data.toString();
    }
}
