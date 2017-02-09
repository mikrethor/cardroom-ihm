package fr.mikrethor.cardroom.app.factories;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

import fr.mikrethor.cardroom.app.utils.ColorUtils;

public class ButtonFactory {
    private static ButtonFactory instance;

    public static ButtonFactory getInstance() {
        if (instance == null) {
            instance = new ButtonFactory();
        }
        return instance;
    }

    public Button getButton(final Composite parent, final int style) {
        final Button res = new Button(parent, style);
        res.setBackground(ColorUtils.FOND);
        return res;
    }

    public Button getButton(final Composite parent, final int style,
            final String text) {
        final Button res = this.getButton(parent, style);
        res.setText(text);
        
        return res;
    }

}
