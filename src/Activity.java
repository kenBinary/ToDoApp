public class Activity {
    public String activityName;
    public String dueDate;
    public String dueHour;

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

    

}
