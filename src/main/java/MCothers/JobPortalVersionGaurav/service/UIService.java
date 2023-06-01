package MCothers.JobPortalVersionGaurav.service;

import MCothers.JobPortalVersionGaurav.datastore.DataStore;
import MCothers.JobPortalVersionGaurav.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by gaurav.kum on 13/12/17.
 */
public class UIService {
    public void askUserForInput() throws Exception {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("Select 1 to add user , 2 to delete user, 3 to modifyUser");

            int val = sc.nextInt();
            switch (val) {
                case 1:
                    User user = addUserUI(sc);
                    SearchService.addUserGlobalSearch(user);
                    SearchService.addUserSpecificSearch(user);
                    break;
                case 2:
                    deleteUserUI(sc);
                    break;
                case 3:
                    modifyUserUI(sc);
                    break;
                case 4:
                    getUser(sc);
                    break;
                case 5:
                    searchGlobally(sc);
                    break;
                case 6:
                    searchSpecifically(sc);
                    break;
                default:
                    throw new Exception("Invalid input");
            }
        }
    }

    private void searchSpecifically(Scanner sc) {
        System.out.println("Enter field to search");

        String field = sc.next();

        System.out.println("Enter value to search");

        String value = sc.next();

        HashMap<String, Set<String>> jobIdsUser = SearchService.getSpecificSearch().get(field);
        if(jobIdsUser == null) {
            System.out.println("no such 1 found");
            return;
        }
        Set<String> jobIds = jobIdsUser.get(value);
        if(jobIds.size() == 0) {
            System.out.println("no such field found");
            return;
        }
        ArrayList<String> userList = new ArrayList<>();
        for(String jobID: jobIds) {
            userList.add(DataStore.getUser(jobID).toString());
        }

        System.out.println(userList);
    }

    private void searchGlobally(Scanner sc) {
        System.out.println("Enter term to search");

        String term = sc.next();

        Set<String> jobIds = SearchService.getGlobalSearch().get(term);

        if(jobIds.size() == 0) {
            System.out.println("no user found");
            return;
        }
        ArrayList<String> userList = new ArrayList<>();
        for(String jobID: jobIds) {
            userList.add(DataStore.getUser(jobID).toString());
        }
        System.out.println(userList);
    }

    private void modifyUserUI(Scanner sc) {
        System.out.println("Wanna modify user");

        User user = getInputUserDetails(sc);
        DataStore.modifyUser(user.getJobId(), user);
    }

    private void deleteUserUI(Scanner sc) {
        System.out.println("Wanna delete user");

        System.out.println("Enter Job Id");
        String jobId = sc.next();
        DataStore.deleteUser(jobId);
    }

    private User  addUserUI(Scanner sc) {
        System.out.println("Wanna add new user");

        User user = getInputUserDetails(sc);
        DataStore.addUser(user);
        return user;
    }


    private User getInputUserDetails(Scanner sc) {
        User user = new User();

        System.out.println("Job Id");
        String jobId = sc.next();
        user.setJobId(jobId);

        System.out.println("User Name");
        String name = sc.next();
        user.setName(name);

        System.out.println("Company Name");
        String companyName = sc.next();
        user.setCompanyName(companyName);

        System.out.println("Designation");
        String designation = sc.next();
        user.setDesgination(designation);

        System.out.println("Experience");
        int experience = sc.nextInt();
        user.setExperience(experience);

        System.out.println("Number of skills");
        int noSkills = sc.nextInt();

        ArrayList<String> skillSet = new ArrayList<>();
        int i = 1;
        while(noSkills > 0) {
            System.out.println("Skill: " + i++);
            String skill = sc.next();
            skillSet.add(skill);
            noSkills--;
        }
        user.setSkillSet(skillSet);

        System.out.println("Number of locations");
        int noLocations = sc.nextInt();

        i = 1;
        ArrayList<String> locations = new ArrayList<>();
        while(noLocations > 0) {
            System.out.println("Location :" + i++);
            String location = sc.next();
            locations.add(location);
            noLocations--;
        }
        user.setLocation(locations);
        return user;
    }

    private String getUser(Scanner sc) {
        System.out.println("Wanna get user");

        System.out.println("Enter Job Id");
        String jobId = sc.next();
        User user = DataStore.getUser(jobId);
        System.out.println(user.toString());
        return user.toString();
    }
}
