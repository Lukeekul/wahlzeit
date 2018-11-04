package org.wahlzeit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import org.wahlzeit.handlers.TellFriendTest;
// import org.wahlzeit.model.persistence.AbstractAdapterTest;
// import org.wahlzeit.model.persistence.DatastoreAdapterTest;
import org.wahlzeit.model.*;
import org.wahlzeit.services.*;
import org.wahlzeit.services.mailing.EmailServiceTestSuite;
import org.wahlzeit.utils.*;

@RunWith(Suite.class)
@SuiteClasses({
	TellFriendTest.class,
	// AbstractAdapterTest.class,
	// DatastoreAdapterTest.class,
	AccessRightsTest.class,
	FlagReasonTest.class,
	GenderTest.class,
	GuestTest.class,
	PhotoFilterTest.class,
	TagsTest.class,
	UserStatusTest.class,
	ValueTest.class,
	EmailServiceTestSuite.class, 
	EmailAddressTest.class,
	LogBuilderTest.class,
	StringUtilTest.class,
	VersionTest.class
})
public class AllTests {

}

