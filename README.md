# Roman numeral statement
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

|Symbol|Value|
| --- | --- |
|I|1|
|V|5|
|X|10|
|L|50|
|C|100|
|D|500|
|M|1000|

For example, 2 is written as II in Roman numeral, just two one's added together. 
12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. 
Instead, the number four is written as IV. Because the one is before the five we subtract it making four. 
The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

* 'I' can be placed before V (5) and X (10) to make 4 and 9.
* 'X' can be placed before L (50) and C (100) to make 40 and 90.
* 'C' can be placed before D (500) and M (1000) to make 400 and 900.

# What is given
* The project has a [test class](src/test/java/com/ul/RomanNumeralTest.java) that is ready to be used.
* It has an [Enum](src/main/java/com/ul/roman/RomanEnum.java) with the possible basic roman values. 
Please read all the methods from the enum carefully. 
* The [RomanApplication](src/main/java/com/ul/RomanApplication.java) is configured to start up a Spring boot 
application with the Swagger/Open API already configured. Please don't change this file.
* On the resources we have 3 files.
  * [IntegerList.txt](src/main/resources/IntegerList.txt) This is a list of numbers from 1 to 3999.
  * [RomanNumber.txt](src/main/resources/RomanNumber.txt) This is the place that you could write the roman numerals 
  from exercises 2 onwards 
  * [RomanNumberValidation.txt](src/main/resources/RomanNumberValidation.txt) That is the place that you can use to 
  * validate the responses from exercises 3 onwards. 
* We have a controller file that is not working [RomanController](src/main/java/com/ul/roman/RomanController.java) you 
could use it from the exercise 4 onwards. 

# What is expected
We expect that the developer should be able to solve one of the exercises given below using the maximum of their 
knowledge of algorithms, java 17, design patterns and principles, clean code, and code readability.

The developer should be able to read this README fully, understand the requirements and be able to developer what was 
required.

This whole assessment should not take more than 3 hours to be made. 
At the same time, the candidate should be prepared to spend at least 1h30m. 

The developer should choose one, and only one of the exercises, they have different levels of complexity.
The first one is the easiest one, and the last one is the most difficult.
the second exercise will be necessary to have part of the code that is present in the first exercise.
The third one will need part of the code from the second one. and the same is valid for every exercise after this one. 
This means that the last exercise will be a composition of all the previous exercises.

Based on the level of the position that your assessment is for we recommend reading carefully the exercises and 
choosing the correct exercise for you.
If you wish, you could start from the first exercise and improve the code exercise by exercise until the last exercise.

All the exercises have no time limit, but it has a tip telling you how long it should take, 
only to you prepare yourself for this exercise.

# Exercises 
## 1<sup>st</sup> Exercise. 
### Make a basic conversion from a primitive int to a roman numeral (string).
#### Details
* You should use only the file com.ul.RomanNumeralTest
* Inside this class it has the method com.ul.RomanNumeralTest.convertIntToRoman, all you code changes should be made inside  it.
* It is a test, so you can execute it as a Junit test.
* You can/should use the com.ul.roman.RomanEnum to help you.
* Please read all the classes before you start and see all the methods that exists and what it does.
#### Tips
* This exercise should take from 20 to 40 minutes.
* The enum has method sort not implemented. Why not implement it? Show us your lambda knowledge. Do the sort as desc, it will help you.
* If you build a recursive method you will have some extra points.
#### What is expected
* I'm expecting to see a good code structure.
* clear examples of clean code.
* a nice logic implemented. 
* Good understanding of Java principles. 
* I want to see lambda, array conversion, recursivity, and logic.
## 2<sup>nd</sup> Exercise. 
### Make the Service file read a file with the integer numbers convert it and write in a file the answer.
#### Details
* you should use this file com.ul.roman.service.RomanNumeralServiceDefault and the test file.
* You should change your test moving the content of the method that you created on the exercise 1 to the service.
* To call the service you should be using the test file.
* So adapt the test file to be able to test your service. 
* you should not change or remove the current com.ul.RomanNumeralTest.testRomanValues method.
* you should have a method on the service that convert the number. and the method that read and write in a file.
* you should read your input on the file src/main/resources/IntegerList.txt
* you should write your result on the file src/main/resources/RomanNumber.txt
#### Tips
* This exercise should take an extra 15 to 30 minutes, or a total of 35 to 70 minutes.
* The read and write a file is not necessary working properly, and it was written in an ond way. Why you don't improve it? 
* If the names of the files come from a property, that is a plus.
* Do a better exception handler.
#### What is expected
* A good troubleshoot skill.
* I expect that the candidate will be able to show a good comprehension of Java and logic.
* It has a lot of space for clean code examples.
* I would love to see a try with resources well implemented.
* The result of your file should be equal of the one on src/main/resources/RomanNumberValidation.txt
## 3<sup>th</sup> Exercise.
### For the third exercise I would like to see a method that do exactly the opposite. Receive a string and convert it to a number.
#### Details
* This method should be build on the service com.ul.roman.service.RomanNumeralServiceDefault
* It is a new method, so don't need to change the previous one.
* Please remember the exceptions use 2 letters.
#### Tips
* This exercise should take an extra 15 to 30 minutes, or a total of 50 to 100 minutes.
* if a letter is smaller than the letter on its right, it means that it is an exception.
#### What is expected
* Good logic and good use of java commands.
## 4<sup>rd</sup> Exercise. 
### Make the controller work properly and be able to execute by a http call.
#### Details
* we have a controller file that is not working: src/main/java/com/ul/roman/RomanController.java
* Make it work properly.
* All the requests should be working making a call to the service that you have created.
#### Tips
* This exercise should take an extra 10 to 30 minutes, or a total of 60 to 120 minutes.
#### What is expected
* A good comprehension of Spring and dependency injection.
## (Extra) 5<sup>th</sup> Exercise. 
### We would like to have the best Architecture, design pattern and principle for what we have until now. Be creative.
#### Details
* this exercise is free. Please change whatever you think that would be necessary under the src/main.
* make it pretty and functional.
#### What is expected
* This will help me comprehend your seniority level.
