# Summary
## Project Name
Patterns

## Project Repository
https://github.com/Lukeekul/wahlzeit

## Project CI
https://travis-ci.org/Lukeekul/wahlzeit

## Current Tag
adap-hw13 master

## Diff to last tag
https://github.com/Lukeekul/wahlzeit/compare/adap-hw12...Lukeekul:adap-hw13

# Overview
* Collaboration of PatternPhoto with Pattern
* Collaboration of Pattern with PatternType
* Collaboration of Pattern with PatternManager

# Details

## Collaboration of PatternPhoto with Pattern
* Purpose: Provide main domain functionality
* Roles:
  * PatternPhoto: Client
  * Pattern: Service
* pseudo Java Code:
```java
public collaboration ServiceCollab{
	public role Client {
		...
	}
	public role Service {
		...
	}
};

public class PatternPhoto binds ServiceCollab.Client {
	...
};

public class Pattern binds ServiceCollab.Service {
	...
};
```
## Collaboration of Pattern with PatternType
* Purpose: Provide information common to all instances of a type
* Roles:
  * Pattern: BaseObject
  * PatternType: TypeObject
* pseudo Java Code:

```java
public collaboration TypeObjectCollab {
	public role BaseObject {
		...
	}
	public role TypeObject {
	}
};

public class Pattern binds TypeObjectsCollab.BaseObject {
	...
};

public class PatternType binds TypeObjectsCollab.TypeObject {
	...
};
```
## Collaboration of Pattern with PatternManager
* Purpose: Centralize object managment in one place
* Roles:
  * Pattern: Element
  * PatternManager: Manager
* pseudo Java Code:
```java
public collaboration ManagerCollab {
	public role Element {
		...
	}
	public role Manager {
	}
};

public class Pattern binds ManagerCollab.Element {
	...
};

public class PatternManager binds ManagerCollab.Manager {
	...
};
```
