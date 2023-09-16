package Bank.domain.repository;

import Bank.domain.Activity;

import java.util.ArrayList;

public interface ActivityRepository {
   public Activity getActivityByCode(String code);
   public ArrayList<Activity> getActivitiesByAccountId(long id);
   public void save(Activity activity);
}
