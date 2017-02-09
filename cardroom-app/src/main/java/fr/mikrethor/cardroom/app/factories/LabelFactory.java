package fr.mikrethor.cardroom.app.factories;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import fr.mikrethor.cardroom.app.utils.ColorUtils;

public class LabelFactory {
    private static LabelFactory instance;

    private final GridData layoutData = new GridData(SWT.FILL, SWT.CENTER,
            true, true);

    public static LabelFactory getInstance() {
        if (instance == null) {
            instance = new LabelFactory();
        }
        return instance;
    }

    public Label getLabel(final Composite parent, final int style) {
        final Label res = new Label(parent, style);
        res.setLayoutData(layoutData);
        res.setBackground(ColorUtils.FOND);
        return res;
    }

    public Label getLabel(final Composite parent, final int style,
            final String text) {
        final Label res = this.getLabel(parent, style);
        res.setText(text);
        return res;
    }

}
