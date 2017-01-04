import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SettingsEditor;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;


public class PitestForm extends SettingsEditor<PitestRunConfiguration> {
    private JPanel panel1;
    private JTextField textField1;


    @Override
    protected void resetEditorFrom(@NotNull PitestRunConfiguration pitestRunConfiguration) {

    }

    @Override
    protected void applyEditorTo(@NotNull PitestRunConfiguration pitestRunConfiguration) throws ConfigurationException {
        pitestRunConfiguration.setClassToMutate(textField1.getText());
    }

    @NotNull
    @Override
    protected JComponent createEditor() {
        return panel1;
    }
}
