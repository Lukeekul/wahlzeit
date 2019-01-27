# Summary
## Project Name
Patterns

## Project Repository
https://github.com/Lukeekul/wahlzeit

## Project CI
https://travis-ci.org/Lukeekul/wahlzeit

## Current Tag
adap-hw12 on master

## Diff to last tag
https://github.com/Lukeekul/wahlzeit/compare/adap-hw11...Lukeekul:adap-hw12

# Overview
* Remove Type from Photo
* Instantiation Process of PatternPhoto Class
* Instantiation Process of Pattern Class

# Details

## Remove Type from Photo
* To make the Application run again, the type member of the PatternPhoto Class is removed.
* In Test Case for testing type of PatternPhoto, asserts for type are removed.

## Instantiation Process of PatternPhoto Class

### Callstack for Object Creation of PatternPhoto Class
1. PatternPhotoManager: createPhoto calls
2. PhotoUtil: createPhoto calls
3. PhotoFactory: createPhoto calls
4. Photo: Constructor

### Object Creation Table for PatternPhotoClass

||Abstract Factory|
|--------|--------|
|Delegation|seperate-object, *PatternPhotoFactory*|
|Selection| On-the-spot, only *PatternPhoto*|
|Configuration|In-code|
|Instantiation|In-code|
|Initialization|Default, In-second-step|
|Building|Default|

## Instatiation Process of Pattern Class
### Callstack for Object Creation of Pattern Class
1. PatternManager: createPattern calls
2. PatternType: createInstance calls
3. Pattern: Constructor

### Object Creation Table for Pattern Class
||Abstract Factory|
|--------|--------|
|Delegation|seperate-object, *PatternType*|
|Selection|On-the-spot, only *Pattern*|
|Configuration|In-code|
|Instantiation|In-code|
|Initialization|Default|
|Building|Default|

