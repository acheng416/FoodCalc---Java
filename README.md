# FoodCalc---Java
## Optimizing diet using linear programming


###### Idea:
My brother once asked me to give him a recommended diet because he was too lazy to calculate macro-nutrients for each meal. Instead of manually giving him the best diet I can think of for every day of the week, I decided to utilize what I learned from my previous linear optimization class to do so instead. 

1. **What I needed figure out**:
   * How to implement the algorithmns from class into Java
   * How to get the nutritional data I needed to cover most diets and parse that info into my program
   * Which data structure to use to store the food items and their data
   * How to make the diet realistic and versatile
2. **How I tackled each problem**:
   * Implemented regular Simplex method, DualSimplex method, and Two-Phase method
   * Obtained the publically available USDA nutritional data of over 8,000 food items in the form of a .csv file and put each        column into their own .txt file. These .txt files would be parsed and put into a food item.
   * I decided that a **hashmap** would allow me to have **quick random access** and **insertion times**, which I need to            perform Simplex method and also dynamically insert variables. The **space trade-off** of using a hashmap would not affect        the program as much because after adding artificial and slack variables, there would be no additional need to enlarge the        hashmap.
   * I implemented a function to add additional constraint equations, which would allow the user to define realistic bounds for      food items, as well as to give more customizability to desired foods and amounts.
   
###### Features:
  * Parses data from USDA website for over 8,000 food items and their nutritional content
  * Implements **Simplex method**
  * Implements **DualSimplex method**
  * Supports **artificial and slack variables**
  * Allows the addition of **constraint equations** (feasibility restored through DualSimplex)
###### Planned Features:
  * Friendly gui for easy selection of food items
  * User-inputted constraints
  * Custom nutrition data input from the user
  * Make the optimal solution also realistic
  * Implementation in C for manual memory management and support for multithreading
###### Screenshots:
#### Example of loading food:
![alt text](https://github.com/acheng416/FoodCalc---Java/blob/master/Food%20Calc%20-%20Java.png) 

#### Example of an optimal solution to the constraints:
![alt text](https://github.com/acheng416/FoodCalc---Java/blob/master/Food%20Calc%20-%20Java%202.png)
