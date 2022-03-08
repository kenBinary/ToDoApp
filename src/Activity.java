public class Activity {
    private String activityName;
    private String dueDate;
    private String dueHour;

    Activity(String cActivityName, String cDueDate,String cDueHour){
        activityName = cActivityName;
        dueDate = cDueDate;
        dueHour = cDueHour;
    }


    public String toString() {
        return activityName+","+dueDate+","+dueHour;
    }
    public String getActivityName(){
        return activityName;
    }
    public String getDueDate(){
        return dueDate;
    }
    public String getDueHour(){
        return dueHour;
    }

    public void setActivityName(String sActivityName){
        activityName = sActivityName;
    }

    public void setDueDate(String sDuedate){
        dueDate = sDuedate;
    }

    public void setDueHour(String sDueHour){
        dueHour = sDueHour;
    }

}
