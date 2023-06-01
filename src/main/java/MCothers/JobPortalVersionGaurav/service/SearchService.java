package MCothers.JobPortalVersionGaurav.service;

import MCothers.JobPortalVersionGaurav.constants.UserDetails;
import MCothers.JobPortalVersionGaurav.model.User;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by gaurav.kum on 13/12/17.
 */
public class SearchService {
    private static HashMap<Object, Set<String>> globalSearch = new HashMap<>();

    private static HashMap<String, HashMap<String, Set<String>>> specificSearch = new HashMap<>();

    public static HashMap<Object, Set<String>> getGlobalSearch() {
        return globalSearch;
    }

    public static HashMap<String, HashMap<String, Set<String>>> getSpecificSearch() {
        return specificSearch;
    }

    public static void addUserGlobalSearch(User user) {

        if(globalSearch.get(user.getName()) == null) {
            Set<String> users = new HashSet<>();
            users.add(user.getJobId());
            globalSearch.put(user.getName(), users);
        } else {
            globalSearch.get(user.getName()).add(user.getJobId());
        }

        if(globalSearch.get(user.getCategory()) == null) {
            Set<String> users = new HashSet<>();
            users.add(user.getJobId());
            globalSearch.put(user.getCategory(), users);
        } else {
            globalSearch.get(user.getCategory()).add(user.getJobId());
        }

        if(globalSearch.get(user.getCompanyName()) == null) {
            Set<String> users = new HashSet<>();
            users.add(user.getJobId());
            globalSearch.put(user.getCompanyName(), users);
        } else {
            globalSearch.get(user.getCompanyName()).add(user.getJobId());
        }

        if(globalSearch.get(user.getDesgination()) == null) {
            Set<String> users = new HashSet<>();
            users.add(user.getJobId());
            globalSearch.put(user.getDesgination(), users);
        } else {
            globalSearch.get(user.getDesgination()).add(user.getJobId());
        }

        if(globalSearch.get(user.getExperience()) == null) {
            Set<String> users = new HashSet<>();
            users.add(user.getJobId());
            globalSearch.put(user.getExperience(), users);
        } else {
            globalSearch.get(user.getExperience()).add(user.getJobId());
        }

        List<String> skills = user.getSkillSet();
        addUserFromListToGlobalSearch(skills, user);

        List<String> locations = user.getLocation();
        addUserFromListToGlobalSearch(locations, user);
    }

    public static void addUserFromListToGlobalSearch(List<String> values, User user) {
        for(String value: values) {
            if(globalSearch.get(value) == null) {
                Set<String> users = new HashSet<>();
                users.add(user.getJobId());
                globalSearch.put(value, users);
            } else {
                globalSearch.get(value).add(user.getJobId());
            }
        }
    }

    public static void addUserSpecificSearch(User user) {

        if(specificSearch.get(UserDetails.NAME.getDetail()) == null) {
            HashMap<String, Set<String>> userJobIds = new HashMap<>();
            Set<String> jobIds = new HashSet<>();
            jobIds.add(user.getJobId());
            userJobIds.put(user.getName(), jobIds);
            specificSearch.put(UserDetails.NAME.getDetail(), userJobIds);
        } else {
            HashMap<String, Set<String>> userJobIds = specificSearch.get(UserDetails.NAME.getDetail());
            if(userJobIds.get(user.getName()) == null) {
                Set<String> jobIds = new HashSet<>();
                jobIds.add(user.getJobId());
                userJobIds.put(user.getName(), jobIds);
            } else {
                specificSearch.get(UserDetails.NAME.getDetail()).get(user.getName()).add(user.getJobId());
            }
        }
/*
        if(globalSearch.get(user.getCategory()) == null) {
            Set<String> users = new HashSet<>();
            users.add(user.getJobId());
            globalSearch.put(user.getCategory(), users);
        } else {
            globalSearch.get(user.getCategory()).add(user.getJobId());
        }

        if(globalSearch.get(user.getCompanyName()) == null) {
            Set<String> users = new HashSet<>();
            users.add(user.getJobId());
            globalSearch.put(user.getCompanyName(), users);
        } else {
            globalSearch.get(user.getCompanyName()).add(user.getJobId());
        }

        if(globalSearch.get(user.getDesgination()) == null) {
            Set<String> users = new HashSet<>();
            users.add(user.getJobId());
            globalSearch.put(user.getDesgination(), users);
        } else {
            globalSearch.get(user.getDesgination()).add(user.getJobId());
        }

        if(globalSearch.get(user.getExperience()) == null) {
            Set<String> users = new HashSet<>();
            users.add(user.getJobId());
            globalSearch.put(user.getExperience(), users);
        } else {
            globalSearch.get(user.getExperience()).add(user.getJobId());
        }
        */
    }

}
