package Job;

import com.hand.hap.job.AbstractJob;
import org.quartz.JobExecutionContext;

/**
 * Created by nishuai on 2017/4/19.
 */
public class HelloJob extends AbstractJob {
    @Override
    public void safeExecute(JobExecutionContext jobExecutionContext) throws Exception {
        System.out.println("hello world");
    }
}
