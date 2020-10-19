# Software Requirements Specification

## Introduction

-Our team consists of four developers, who are eagerly helping out each other and solve problems together.
We want to create a device which makes an easier way for slides in the aquapark.
This device would be an identifier. The guests get this when they enter the aquapark, and have to use when they use a slide.
When they leave, they give back the identifier, and they get a detailed reciept about the slides.
If someone give the identifier back, another guests could use it. The usage of slides also
should be monitored because the management wants to check daily reports about the slides.


## Problems of current situation

-Many people have to stand beside the slide and supervise it.
-Time consuming
-Can't be monitored


## Vision

-The guests can use the slide more effectivly. The aquapark workers gets the full statistic, so their job will be easier.
At the end of the day each guest get a detailed reciept, where they find which slides and how many times did they use.


## Requirement list

-Every guest gets an identifier when enter the aquapark
-Every identifier should be unique


## Admin interface

-Get a message when somebody enters or leaves
-Get a detailed statistic

# Use Case

## Use Case Details

-The customer recieves a unique ID when entering the aquapark, the ID is given out by the aquapark system; data types: ID is a four digit long number that is unique to every customer, however when a costumer leaves their id can be given out again on the same day
-The customer can use slides which includes being charged for that slide by the aquapark system; data types: A function in the project counts a certain ID's slide usage with an integer value, which it then stores for use later
-The costumer gives back their unique ID to the aquapark system when leaving the facility, this includes the reception and payment of a detailed reciept containing the information about which slides the customer used; data types: When the costumer leaves a function in the project compiles all data on slide usage giving back a numeric value to each slide as well as a complete sum of all slide uses and the price that costumer has to pay when leaving as a numeric value, also this function clears all data on the said ID so that it could be used later that day
