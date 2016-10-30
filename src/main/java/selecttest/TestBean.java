package selecttest;

import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

@ManagedBean(name = "testbean")
@ViewScoped
public class TestBean {

    private List<Job> jobTypes;
    Job newJobType;
    double newJobWages;

    public TestBean() {
        jobTypes = Arrays.asList(
                                 new Job("Vacuum", 35.0),
                                 new Job("Take out trash", 25.0),
                                 new Job("Do the dishes", 75.0)
                                 );
    }

    public Job getNewJobType() {
        return newJobType;
    }

    public void setNewJobType(Job newJobType) {
        this.newJobType = newJobType;
        if (newJobType != null) {
            setNewJobWages(newJobType.getAmount());
        }
    }

    public double getNewJobWages() {
        return newJobWages;
    }

    public void setNewJobWages(double newJobWages) {
        this.newJobWages = newJobWages;
    }

    public List<Job> getJobTypes() {
        return jobTypes;
    }

    public void registerNewJob(ActionEvent event) {
        clearNewJobValues();
    }

    private void clearNewJobValues() {
        setNewJobType(null);
        setNewJobWages(0);
    }

}
