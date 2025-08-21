package co.kozao.kotask.utils.actionvalidation;

import co.kozao.kotask.models.Project;
import java.time.LocalDate;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;

public class ProjectActionValidationUtils {

    
    public static boolean validate(Project project) throws IllegalArgumentException {
        if (project == null) {
            throw new IllegalArgumentException("Project cannot be null.");
        }

        validateName(project.getName());
        validateProjectKey(project.getProjectKey());
        validateDates(project.getStartDate(),project.getEndDate());
        validateProjectManager(project.getIdProjectManager());
        //validateMembers(project.getMembers());
		return true;
   
    }
     private static void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Project name cannot be empty.");
        }
        if (name.length() < 3 || name.length() > 100) {
            throw new IllegalArgumentException("Project name must be between 3 and 100 characters.");
        }
    }

    private static void validateProjectKey(String key) {
        if (key == null || key.trim().isEmpty()) {
            throw new IllegalArgumentException("Project key cannot be empty.");
        }
        if (!key.matches("^[A-Z0-9]+$")) {
            throw new IllegalArgumentException("Project key must contain only uppercase letters and numbers, no spaces.");
        }
    
    }

    private static void validateDates(LocalDate startDate, LocalDate endDate) {
        if (startDate != null && endDate != null && startDate.isAfter(endDate)) {
            throw new IllegalArgumentException("Start date must be before end date.");
        }
    }

    private static void validateProjectManager(Integer idProjectManager) {
        if (idProjectManager == null) {
            throw new IllegalArgumentException("Project manager cannot be null.");
        }
        
    }
    
    //private static void validateMembers(List<User> members) {
     //   if (members != null) {
      //      Set<Integer> ids = new HashSet<>();
        //    for (User u : members) {
          //      if (u == null) {
            //        throw new IllegalArgumentException("Member cannot be null.");
              //  }
                //if (!ids.add(u.getIdUser())) {
                  //  throw new IllegalArgumentException("Duplicate members are not allowed.");
                //}
            //}
        //}
    //}
    
    
}
