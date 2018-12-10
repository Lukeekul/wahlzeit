# Summary
## Project Name
Patterns

## Project Repository
https://github.com/Lukeekul/wahlzeit

## Project CI
https://travis-ci.org/Lukeekul/wahlzeit

## Current Tag
adap-hw08 on master

## Diff to last tag
https://github.com/Lukeekul/wahlzeit/compare/adap-hw07...Lukeekul:adap-hw08

# Overview
* Implementing advanced Error Handling for PatternPhoto and Coordinate.
* Implementing Test for PatternPhotoFactory.

# Details

## Implementation
* Using only checked Exceptions to avoid unchecked Exceptions being propagated to higher software level.
* Location: Make sure Illegal Arguments throw Exception, propagation to caller: The methods setLocation and getLocation are implemented. Exceptions that a thrown by the Design-by-Contract implementation of the Coordinate Classes are not handle here, must be handled by the caller.
* PatternPhotoFactory: Adding Exceptions in Photo Base Class to be thrown when a PatternPhoto with illegal id is created. The PatternPhotoFactory catches that Exception and creates a PatternPhoto without specific id instead.

## Test
* Adding new ValueTest for PatternPhotoFactory. Two PatternPhotos with same are id are tried to be created. It is ensured no exception at this point is thrown to higher software levels, the PatternPhotoFactory catches the Exception. It is tested that the ids of those to photos are different, as it is expected.

