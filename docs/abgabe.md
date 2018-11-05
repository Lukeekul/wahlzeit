# Summary
## Project Name
Patterns

## Project Repository
https://github.com/Lukeekul/wahlzeit

## Project CI
https://travis-ci.org/Lukeekul/wahlzeit

## Current Tag
adap-hw03 on master

## Diff to last tag
https://github.com/Lukeekul/wahlzeit/compare/adap-hw02...Lukeekul:adap-hw03

# Details
* Added EmailServiceTestSuite.java to call EmailServiceTest Class in Suite Class
* Added AllTests.java as Suite Class, all Test Classes are called in Suite Class
* Change build.gradle: instead of matching filter, include **\*\*/AllTests.class** as test task
* Add Test Case to EmailServiceTest, send two emails to second valid Address
* Add Test Case to EmailAddressTest, try to use Illegal Characters (not in utf-8), but for local testing those characters are allowed
* Travis build succeeded, tests passed

