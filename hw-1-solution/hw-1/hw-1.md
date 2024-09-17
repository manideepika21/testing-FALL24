# CSC 712 Fall 2024, Homework 1

## 1. Deadline

This homework is due on 16-Sep-2024 at 11:59PM

## 2. Goals and Overview

This homework aims to reinforce the concepts that we learned in the lectures on input space partitioning.


## 3. Instructions

This homework is to be completed individually. You may not discuss or share your solutions with others. Your submitted code and text must be entirely your own work. Parts of this homework are deliberately under-specified.

If you find that you are spending excessive time on repetitive tasks during this homework, you are likely not using the tips that we discussed in the lectures on test automation. Or, you may have made sub-optimal choices with respect to the ISP criteria that you are using. Let us know ASAP.

The file, `hw-1-files.zip`, contains files that should be starting points for your Problem 1.k and the debriefing. Download `hw-1-files.zip` and extract it. 
By the due date, you must commit your solution in same-named files in a repository called `hw-1-solution` under your profile on https://github.com. That is, you should write your solutions in the files that we provided or files that we mention in each problem, but you should put those files as specified in your `hw-1-solution` repository and `.gitignore` file at the root of your repository, you may get negative points if you commit any unnecessary files (e.g., `target`).

follow the below folder structure in your repository:
```
NOTE: hw-1-solution is the root of the repository

hw-1-solution
├── hw-1
│   ├── hw-1-files
│   │   ├── coding-problems
│   │   │   ├── pom.xml
│   │   │   └── src
│   │   └── debriefing.txt
│   └── hw-1.md
```

NOTE: your `hw-1-solution` repository MUST be private.

Your code must compile and run on Github. You will get no points if your code does not compile, or if you return our code as your solution.

You may write your code in any IDE or other programming environment of your choice.

## 4. Problem 0: Setup  (5%)

a. Set up your `hw-1-solution` repository **as a private repository of GitHub (not GitHub NCSU, regular GitHub.com)** and make sure to add `aaeagal` and `damorim` as collaborators.

b. Set up your `hw-1/hw-1-files/coding-problems/` Maven project, using the `coding-problems` directory that you obtain from extracting the `hw-1-files.zip` archive.

c. Set up Continuous Integration for your repository. You may put the following in your `actions.yml` file under `.github/workflows`:

```yml
name: Maven Build and Test

on:
  push:
    branches:
      - main 

jobs:
  build-and-test:
    runs-on: ubuntu-latest

    steps:
      - name: Checkout code
        uses: actions/checkout@v3

      - name: Set up JDK 8
        uses: actions/setup-java@v3
        with:
          java-version: 8
          distribution: 'adopt'


      - name: Cache Maven dependencies
        uses: actions/cache@v2
        with:
          path: ~/.m2/repository
          key: ${{ runner.os }}-maven-${{ hashFiles('**/*.xml') }}
          restore-keys: |
            ${{ runner.os }}-maven-
            
        
      - name: Build and Test with Maven
        run: |
          cd hw-1/hw-1-files/coding-problems/
          echo "Building project and Test with Maven"
          mvn test
```

## 4. Problem 1: Input Space Partitioning for `intersection` (45%)

Consider the `intersection` method below and the mathematical definition of set intersection:

```Java
// Effects: Return a (non null) Set equal to the intersection of sets s1 and s2
//          A null argument is treated as an empty set
public static Set intersection(Set s1, Set s2)
```

Also, consider the following input domain model for `intersection`:

```txt
Characteristic 1: Type of s1

  Block 1: s1 = null
  Block 2: s1 = {}
  Block 3: s1 has at least one element
  
Characteristic 3: Relation between s1 and s2

  Block 1: s1 and s2 represent the same set
  Block 2: s1 is a subset of s2
  Block 3: s2 is a subset of s1
  Block 4: s1 and s2 do not have any elements in common
```

Provide solutions to questions (a)--(j) below in a file `hw-1-solution/problem-1.pdf`. The solution to question (k) should be in the Maven project described therein.

a. Describe the input domain for the `intersection()` method.

b. Does the partition "Type of s1" satisfy the completeness property? If not, give a value for s1 that does not fit in any block.

c. Does the partition "Type of s1" satisfy the disjointness property? If not, give a value for s1 that fits in more than one block.

d. Does the partition "Relation between s1 and s2" satisfy the completeness property? If not, give a pair of values for s1 and s2 that does not fit in any block.

e. Does the partition "Relation between s1 and s2" satisfy the disjointness property? If not,
give a pair of values that fits in more than one block.

f. Change the blocks for the partitions "Type of s1" and "Relation between s1 and s2" such that they do not suffer from any disjointness or completeness problems, but do not just use partitions with two blocks (i.e., blocks that are effectively "true" and "false").

g. Create a partition for Characteristic 2, "Type of s2" which is analogous to "Type of s1".

h. Choose a representative input for each block from the three partitions "Type of s1", "Type of s2", and "Relation between s1 and s2".

i. Describe the constraints among the three partitions used in (h) above.

j. Construct test cases that obey the constraints among the three partitions and satisfy the pair-wise coverage criteria. 

`Pair-Wise Coverage (PWC) Criterion : A value from each block for
each characteristic must be combined with a value from every block
for all other characteristics.`

Each test case should have two input sets and an expected output.

k. Complete the `intersection` method in `Sets.java`. 

l. Use your answer in (j) to create JUnit tests for `intersection` in `Test*.java` files (such as the provided `TestPairwise.java` file) in the `hw-1-solution/coding-problems` Maven project.

## 5. Problem 2: Input Space Partitioning for `BoundedQueue` (45%)

Derive input space partitioning test inputs for the `BoundedQueue` class with methods that have the following signatures:

```java
public BoundedQueue (int capacity); // capacity is the maximum no. of elements
public void enQueue (Object X);
public Object deQueue ();
public boolean isEmpty ();
public boolean isFull ();
```

Assume the usual semantics for a queue with a fixed, maximal capacity. Try to keep your partitioning simple--choose a small number of partitions and blocks. Provide your answers in the file, `hw-1-solution/problem-2.pdf`.

a. List all of the input parameters, including the state variables.

b. Define characteristics for the input parameters. Make sure you cover all input parameters.

c. Partition the characteristics into blocks. Choose one block per partition as the “Base” block.

d. Define values for each block.

e. Define a set of Test cases. That is, write test inputs for test cases, together with the expected output of those inputs on the `enQueue` method. You are not required to write JUnit tests for this problem.


## Debriefing (5%)

Answer the questions in the file, `hw-1-solution/hw-1/hw-1-files/debriefing.txt` that is in the `hw-1-files.zip` file. Follow the instructions at the top of the file. Each student should commit their `debriefing.txt` file in a `hw-1-solution/hw-1/hw-1-files`.
