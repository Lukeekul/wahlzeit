package org.wahlzeit.model;


import org.wahlzeit.model.PhotoFactory;
import org.wahlzeit.services.LogBuilder;
import org.wahlzeit.annotation.PatternInstance;
import java.util.logging.Logger;
import java.util.logging.Level;


@PatternInstance(
	patternName = "Factory",
	participants = {
		"AbstractFactory",
		"ConcreteFactory"
	}
)
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
	//@Override
	public PatternPhoto createPhoto(String typename) {
		return new PatternPhoto(typename);
	}

	/**
	 * @methodtype factory
	 * Create new pattern photo from ID
	 */
	//@Override
	public PatternPhoto createPhoto(PhotoId id, String typename) {
		PatternPhoto result;
		try{
			result = new PatternPhoto(id, typename);
		} catch (IllegalArgumentException illarg)  {
			log.log(Level.SEVERE, "Trying to create PatternPhoto with Illegal ID", illarg);
			result = new PatternPhoto(typename);
		}
		return result;
	}

}
