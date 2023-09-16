package Bank.infra.repos.postgres;

import Bank.domain.Activity;
import Bank.domain.repository.ActivityRepository;
import Bank.infra.repos.postgres.entities.ActivityMapper;
import Bank.infra.repos.postgres.jpa_repos.JpaActivityRepository;

import java.util.ArrayList;
import java.util.List;

public class ActivitiesRepositoryPostgres implements ActivityRepository {
    final JpaActivityRepository repository;

    public ActivitiesRepositoryPostgres(JpaActivityRepository repository) {
        this.repository = repository;
    }

    @Override
    public Activity getActivityByCode(String code) {
        ActivityMapper activityMapper = this.repository.findByCode(code);

        return new Activity(
            activityMapper.getSource_account_id(),
            activityMapper.getTarget_account_id(),
            activityMapper.getMoney(),
            activityMapper.getType()
        );
    }

    @Override
    public ArrayList<Activity> getActivitiesByAccountId(long id) {
        ArrayList<Activity> activities = new ArrayList<>();
        List<ActivityMapper> activityMapper = this.repository.findAllBySourceAccounts_Id(id);
        activityMapper.forEach(activity -> {
           activities.add(
               new Activity(
                   activity.getSource_account_id(),
                   activity.getTarget_account_id(),
                   activity.getMoney(),
                   activity.getType()
               )
           );
        });
        return activities;
    }

    @Override
    public void save(Activity activity) {
        ActivityMapper activityMapper = new ActivityMapper();
        activityMapper.setMoney(activity.getMoney());
        activityMapper.setSource_account_id(activity.getSourceAccountId());
        activityMapper.setTarget_account_id(activity.getTargetAccountId());
        activityMapper.setCode(activity.getActivityCode());
        activityMapper.setType(activity.getActivityType());
        this.repository.save(activityMapper);
    }
}
