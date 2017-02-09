package fr.mikrethor.cardroom.app.factories;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

public class TextFactory {
    private static TextFactory instance;

    public static final int HORIZONTAL_INDENT = 1;

    public static final int TEXT_HEIGHT = 18;

    public static final int TEXT_WIDTH = 150;

    private final GridData layoutData = new GridData(SWT.NONE);

    public static TextFactory getInstance() {
        if (instance == null) {
            instance = new TextFactory();
        }
        return instance;
    }

    public Text getText(final Composite parent, final int style) {
        final Text res = new Text(parent, style | SWT.BORDER);
        layoutData.heightHint = TEXT_HEIGHT;
        layoutData.horizontalIndent = HORIZONTAL_INDENT;
        layoutData.widthHint = TEXT_WIDTH;
        res.setLayoutData(layoutData);
        return res;
    }
}
