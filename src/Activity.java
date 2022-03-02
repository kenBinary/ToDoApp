public class Activity {
    public String activityName;
    public String dueDate;
    public String dueHour;
    public boolean finished = false;

    Activity(String cActivityName, String cDueDate,String cDueHour){
        activityName = cActivityName;
        dueDate = cDueDate;
        dueHour = cDueHour;
    }

    public boolean isFinished() {
        System.out.println(finished ? finished:false);
        return finished ? finished:false;
    }

    public String toString() {
        return activityName+","+dueDate+","+dueHour+","+finished;
    }
    
    public boolean setfinished() {
        return finished = true;
    }

    

}
