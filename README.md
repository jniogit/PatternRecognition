# PatternRecognition
## Synopsis

Given a set of P feature points in the bidimensional plane, the algorithm executes basic operation on the space defined (add point to space, read all points from the space, delete all points from the space) and allows to retreive every line that contains at least N or more COLLINEAR points.

## Code Example

Show what the library does as concisely as possible, developers should be able to figure out **how** your project solves their problem by looking at the code example. Make sure the API you are showing off is obvious, and that your code is short and concise.

## Motivation

A short description of the motivation behind the creation and maintenance of the project. This should explain **why** the project exists.

## Installation

Provide code examples and explanations of how to get the project.

## API Reference

To generate REST API has been used Swagger Editor. Below the REST methods implemented:

POST /point with body { "x": ..., "y": ... }

GET /space

GET /lines/{n}

DELETE /space

## Tests

The Tests are made through main execution.

## Contributors

Let people know how they can dive into the project, include important links to things like issue trackers, irc, twitter accounts if applicable.

## License

A short snippet describing the license (MIT, Apache, etc.)
