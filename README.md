# DA3018
This is a repository for the project in the computer scince course DA3018 at Stockholm University by Anton Pinet Magnusson. 

To run DataPreprocessor.java be sure to have the "Spruce_fingerprint_2017-03-10_16.48.olp.m4" in the same repository and run the following comands:

-"javac DataPreprocessor.java" (to compile).

-"java DataPreprocessor" (to run the program after compiling).

When you have done this the program should have created a text-file named "preprocessed_data.txt".


To run BuildGraphFromPreprocessedData.java be sure to have "preprocessed_data.txt" in the same repository and run the following commands:
- javac BuildGraphFromPreprocessedData.java
- java -Xss1G -Xms7G BuildGraphFromPreprocessedData
When you have done this the program should have created a csv-file called "node_degree_distribution.csv".
