
public class DescriptionActivity extends Activity {
    private String description;
    DescriptionActivity(String cActivityName, String cDueDate, String cDueHour,String cDescription) {
        super(cActivityName, cDueDate, cDueHour);
        this.description = cDescription;
    }
    @Override
    public String toString() {
        return super.toString()+","+description;
    }
    public String getDescription() {
        return description;
    }    
    public void setDescription(String sDescription) {
        description = sDescription;
    }
}
