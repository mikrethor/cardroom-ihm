package fr.mikrethor.cardroom.app.factories;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;

public class ImageFactory {

	private static final String APP_NAME = "cardroom-app";

	public static final ImageDescriptor IMDESC_PLAY = AbstractUIPlugin.imageDescriptorFromPlugin(APP_NAME,
			"icons/ic_play_arrow_grey600_18dp.png");

	public static final ImageDescriptor IMDESC_STOP = AbstractUIPlugin.imageDescriptorFromPlugin(APP_NAME,
			"icons/ic_stop_grey600_18dp.png");
	
	public static final ImageDescriptor IMDESC_PAUSE = AbstractUIPlugin.imageDescriptorFromPlugin(APP_NAME,
			"icons/ic_pause_grey600_18dp.png");

	public static final ImageDescriptor IMDESC_FOND = AbstractUIPlugin.imageDescriptorFromPlugin(APP_NAME,
			"images/poker.jpg");

	private static ImageFactory instance;

	public static ImageFactory getInstance() {
		if (instance == null) {
			instance = new ImageFactory();
		}
		return instance;
	}

	public Image createImage(ImageDescriptor imageDescriptor) {
		return imageDescriptor.createImage();
	}
}
