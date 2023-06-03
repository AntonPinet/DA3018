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


To run GenerateSubset.java be sure to have "preprocessed_data.txt" in the same repository and run the following commands:
- javac GenerateSubset.java
- java GenerateSubset.java
When you have done this the program should have created a three txt-files named subsetData10.txt, subsetData1000.txt and subsetData100000.txt you can use this data to test BuildGraphFromPreprocessedData.java on this smaller data sets.


To run Visualize_data.py be sure to have node_degree_distribution.csv and densities.txt produced by BuildGraphFromPreprocessedData.java in the same repository and run the following command:
- python Visualize_data.py

 When you have done this the program should display two histograms and also save these as node_degree_distribution.png and component_density_distribution.png.
