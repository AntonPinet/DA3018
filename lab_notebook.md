# Lab Notebook for DA3018 project

## By: [Anton Pinet Magnusson]

## Date: Start from 2023-05-27

## Project Description:
The project aims to analyze, visualize, and understand a graph G=(V, E) generated from a genome assembly data set. Each vertex in this graph represents a DNA segment, also known as a contig, while an edge signifies an overlap between two contigs. The goal is to extract features from this graph, such as node degree distribution, number of components with at least three vertices, and component density distribution, to help an imaginary collaborator better understand the dataset. The ultimate aim is to simplify the graph for standard genome assembly tools without losing crucial data. 

## Day 1 - 2023-05-27

**Activities:**
1. Project initiation: Understood the project requirements and the provided set.

2. Studied the genome assembly process and the significance of contigs and their overlaps.

3. We make an overall plan for the projekt. The overall steps in completing the project consists of 
-  Making scripts for data cleaning and reading.
-  Analysing the data once it is clean.
-  Buldning the overlaps graph.
-  Analysing the the graph to answer the questions possed in the assignment abou the graph.
-  Writing a report displaying the results of the project.
4. Since we are dealing with a massive data file we need to find a way to clean and extract the useful data and make it ready for processing. This will be where the we start the project. We will write a data processing program to clean the data and store it in a readable file. 

**Outcomes:**
1. The requirements have been read through and the data format has been understood as describing the details of contig overlaps in genome sequencing data. Specifically, each line in the dataset represents a pair of contigs that overlap, along with the start, end, and length of the overlapping region for each contig. The identifiers for each contig are also provided. This data is crucial for assembling the entire genome sequence from the given contigs by understanding their overlapping regions.
2. The identified computational problems to be solved are:
 -  Find node Degree Distribution.
 -  Find number of Components with At Least Three Vertices.
 -  Find component Density Distribution.
3. The java program "DataPreprocessor.java" has been created to clean the data. The code reads the genome data from the input file, processes it, and writes the preprocessed data into the output file. The preprocessed data consists of integer identifiers for the contigs and the respective start, end, and length information. The outcome facilitates downstream tasks in the genome assembly project by providing cleaned, structured, and consistent data. 

