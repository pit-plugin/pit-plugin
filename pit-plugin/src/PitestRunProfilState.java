import com.intellij.execution.ExecutionException;
import com.intellij.execution.configurations.JavaCommandLineState;
import com.intellij.execution.configurations.JavaParameters;
import com.intellij.execution.configurations.ParametersList;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.openapi.roots.ProjectRootManager;
import com.intellij.util.PathUtil;
import org.jetbrains.annotations.NotNull;

public class PitestRunProfilState extends JavaCommandLineState {
    PitestRunConfiguration importantConfiguration;

    protected PitestRunProfilState(@NotNull ExecutionEnvironment environment, PitestRunConfiguration rc) {
        super(environment);
        importantConfiguration = rc;
    }

    @Override
    protected JavaParameters createJavaParameters() throws ExecutionException {
        JavaParameters myNewParams = new JavaParameters();

        //Ustawiamy parametry maszyny wirtualnej
        //TODO: dodać classPath danego modułu do argumentów

        myNewParams.setJdk(ProjectRootManager.getInstance(getEnvironment().getProject()).getProjectSdk());

        StringBuilder pitestClassWithArguments = new StringBuilder();
        pitestClassWithArguments.append("org.pitest.mutationtest.commandline.MutationCoverageReport ");

        myNewParams.getClassPath().add(PathUtil.getJarPathForClass(getClass()));
        pitestClassWithArguments.append("--reportDir . --sourceDirs src/ ");
        pitestClassWithArguments.append("--targetClasses ");
        pitestClassWithArguments.append(importantConfiguration.getClassToMutate());
        pitestClassWithArguments.append(" --targetTests /* ");

        myNewParams.setMainClass(pitestClassWithArguments.toString());
        final ParametersList par = myNewParams.getVMParametersList();

        return myNewParams;
    }
}
