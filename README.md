# Genetic Algorithm

##Decription
This genetic algorithm simulates natural selection on a chromosome that is realized as a 32bit binary sequence(length can be changed). A set number of chromosome are randomly generated. After being generated, the chromosomes are paired and reproduce. Reproduction is achieved by swapping a randomly selected group of each parent. Then the new chromosomes have a small chance to mutate (flip a digit). This process is continued until the desired evolution is reached.
#####Ex. 10001101011010101101101010001111

##Instructions
**This program requires a Java JRE/JDK.**

![alt text](http://i.imgur.com/5SuY7hj.jpg "Compile In Terminal")

Use the terminal to compile the source files.

![alt text](http://i.imgur.com/UeQ1lac.jpg "Run The Program")

Use "java GeneticAlgorithm" in the terminal to run the program. The results will be displayed to the screen.

##Miscellaneous
The last run of the simulation consisted of a population of 1000 chromosomes with a 1/10000 chance of mutation.
The desired evolution was reached after 19 generation and a total of 59 mutations.
