# Genetic Algorithm

This is a side project for learning purposes.

This genetic algorithm simulates natural selection on a chromosome that is realized as a 32bit binary number (can change).

###Ex. 10001101011010101101101010001111

An initial population is set by the user and then randomly generated. After creating the population, a normalized fitness
value is assigned to each chromosome. Then, pairs are selected to reproduce. Reproduction is accomplished by randomly
switching segments of the parent chromosomes. After reproduction, every gene in the chromosome has a chance to mutate,
which flips a 1 to 0 or 0 to 1. Then, the chromosomes are evaluated for fitness again. The process continues until a
desired evolution, entered by the user, is reached.

This program is implemented in Java.

The last run of the simulation consisted of a population of 1000 chromosomes with a 1/10000 chance of mutation.
The desired evolution was reached after 19 generation and a total of 59 mutations.