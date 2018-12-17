# Summary
## Project Name
Patterns

## Project Repository
https://github.com/Lukeekul/wahlzeit

## Project CI
https://travis-ci.org/Lukeekul/wahlzeit

## Current Tag
adap-hw09 on master

## Diff to last tag
https://github.com/Lukeekul/wahlzeit/compare/adap-hw08...Lukeekul:adap-hw09

# Overview
* Implementing Value Type for Coordinate Classes
* Adapting Tests for Coordinate Classes.

# Details

## Implementation
* All Constuctors of Coordinate Leaf Classes are now private. Coordinate Instances get by shared by calling getCoordinate method.
* GetCoordinate Methode implemented as in lecture described.
* Unfortunately Build Error on latest commit, some issues because interchangability of Coordinate Classes. The interchange methods *asCartesianCoordinate()* and *asSphericCoordinate()* need to be rewritten.

