
public class Activity {
    public String activityName;
    public String dueDate;
    public String dueHour;
    public boolean finished;

    Activity(String cActivityName, String cDueDate,String cDueHour,boolean cfinished){
        activityName = cActivityName;
        dueDate = cDueDate;
        dueHour = cDueHour;
        finished = cfinished;
    }

    public boolean isFinished() {
        System.out.println(finished ? finished:false);
        return finished ? finished:false;
    }
    

}
