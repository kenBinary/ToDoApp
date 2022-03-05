public class Activity {
    private String activityName;
    private String dueDate;
    private String dueHour;
    private int index;
    

    Activity(String cActivityName, String cDueDate,String cDueHour){
        activityName = cActivityName;
        dueDate = cDueDate;
        dueHour = cDueHour;
    }


    public String toString() {
        return index+","+activityName+","+dueDate+","+dueHour;
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
    public int getIndex(){
        return index;
    }
    public void setIndex(int sIndex){
        index = sIndex;
    }
}
