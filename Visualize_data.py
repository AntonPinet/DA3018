import pandas as pd
import matplotlib.pyplot as plt

# Load the node degree distribution data
degree_df = pd.read_csv('node_degree_distribution.csv')

# Display the node degree distribution
print(degree_df)

# Plot the node degree distribution
# The plot uses a logarithmic scale on the y-axis to accommodate for a large range of frequencies
# It's a histogram where the x-axis represents node degrees, and the y-axis represents their frequencies
plt.figure(figsize=(10,8))
plt.hist(degree_df['Degree'], weights=degree_df['Frequency'], bins=50, color='#0504aa', alpha=0.7, rwidth=0.85, log=True)
plt.yscale('log')
plt.grid(axis='y', alpha=0.75)
plt.xlabel('Degree')
plt.ylabel('Frequency')
plt.title('Node Degree Distribution')
plt.savefig('node_degree_distribution.png')
plt.show()

# The number of components of G with at least three vertices is printed out by the Java program. 
# We don't have the data in a CSV format to visualize in this script.

# Load the component density distribution data
density_df = pd.read_csv('densities.txt', header=None, names=['Density'])

# Display the component density distribution
print(density_df)

# Plot the component density distribution
# The plot uses a logarithmic scale on the y-axis to accommodate for a large range of frequencies
# It's a histogram where the x-axis represents densities, and the y-axis represents their frequencies
plt.figure(figsize=(10,8))
plt.hist(density_df['Density'], bins=30, edgecolor='black', log=True)
plt.yscale('log', nonpositive='clip')
plt.grid(axis='y', alpha=0.75)
plt.xlabel('Density')
plt.ylabel('Frequency')
plt.title('Component Density Distribution')
plt.savefig('component_density_distribution.png')
plt.show()
