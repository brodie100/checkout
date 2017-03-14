## Synopsis

This is an exercise to create a Sample Checkout application that takes in a function name 
and a number of items (Currently set to 4 as they are typed) which it then processes against 
a static list of discounts to work out the total cost of the basket.

### The actual problem according to the assignment

Write a program and associated unit tests that can price a basket of goods taking into account some special offers.
The goods that can be purchased, together with their normal prices are:
* Soup – 65p per tin
* Bread – 80p per loaf
* Milk – £1.30 per bottle
* Apples – £1.00 per bag

Current special offers:
* Apples have a 10% discount off their normal price this week
* Buy 2 tins of soup and get a loaf of bread for half price

The program should accept a list of items in the basket and output the subtotal, the special
offer discounts and the final price.
Input should be via the command line in the form PriceBasket item1 item2 item3 ... For example:
Output should be to the console, for example:
If no special offers are applicable the code should output:
The code and design should meet these requirements, but be sufficiently flexible to allow future changes to the product list and/or discounts applied.
The code should be well structured, commented, have error handling and be tested.

## Improvements

This is a basic application that needs a lot of work and design done to it to see it each item 
should be a generic item that is distinguished by it's attributes instead of its class. Reflection
should be used here if the items are to be statically typed
The items should also have dynamic external sources for defining their values as opposed to the 
hacky ItemFactory that was created due to time constraints. 
In general there is a lot that can be done with this code to fix it but this was done within a 
constrained time-frame and more time is just not feasible to spend on it.
 
There is no logging at all which would be added before it was actually used.

## Running the application - Two Modes

To run on the command line:

~~~~

> cd <java file location>

> java PriceBasket

~~~~

Running the application with no arguments will apply the current discounts

`> java PriceBasket`

Running the application with the argument noOffers will result inn no discounts being applied. 

`> java PriceBasket noOffers`


See the PriceBasket integration test for a further example of this.


### Test Coverage 
Cobertura was used but not integrated into the POM.  For a CD environment this would be added to 
monitor coverage.

Test coverage is c.90% 

Integration tests were created to output the various values that are calculated for each set of 
items.  The input file (PriceBasketTestInput) is located in `src/test/resources`.  Output is also 
stored at this location, the files have a suffix of 'Output". 
