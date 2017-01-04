import org.pitest.mutationtest.ListenerArguments;
import org.pitest.mutationtest.MutationResultListener;

import java.util.Properties;

/**
 * Created by marek on 21.12.16.
 */
public class pitestListenerFactory implements org.pitest.mutationtest.MutationResultListenerFactory {

    @Override
    public MutationResultListener getListener(Properties properties, ListenerArguments listenerArguments) {
        return new pitestListener();
    }

    @Override
    public String name() {
        return "niceOne";
    }

    @Override
    public String description() {
        return null;
    }
}
