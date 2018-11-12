package org.wahlzeit.model;


import org.wahlzeit.model.PhotoFactory;
import org.wahlzeit.services.LogBuilder;
import java.util.logging.Logger;


public class PatternPhotoFactory extends PhotoFactory {

	private static final Logger log = Logger.getLogger(PhotoFactory.class.getName());

	private static PatternPhotoFactory instance = null;


	public static synchronized PatternPhotoFactory getInstance() {
		if (instance == null) {
			log.config(LogBuilder.createSystemMessage().addAction("setting generic PatternPhotoFactory").toString());
			setInstance(new PatternPhotoFactory());
		}
		return instance;
	}

	protected static synchronized void setInstance(PatternPhotoFactory patternPhotoFactory) {
		if (instance != null) {
			throw new IllegalStateException("attempt to initalize PatternPhotoFactory twice");
		}

		instance = patternPhotoFactory;
	}


	protected PatternPhotoFactory() {
		super();
	}
	/**
	 * @methodtype factory
	 */
	@Override
	public PatternPhoto createPhoto() {
		return new PatternPhoto();
	}

	/**
	 * @methodtype factory
	 * Create new pattern photo from ID
	 */
	@Override
	public PatternPhoto createPhoto(PhotoId id) {
		return new PatternPhoto(id);
	}

}