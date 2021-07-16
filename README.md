# Lottery Project

## Overview 
 This was a school project for my Java II class.  The program should allow the user to choose 6 different 
 numbers via checkboxes.  Then the program will randomly choose six unique numbers.  Finally, the program will award money 
 based on amount of correctly matching numbers.  

### How I accomplished this....
 First, I needed to identify the components of the program.  What did it need to do, how does it interact with the user? 
 what information needed to be captured and how would the output look.
 * This was successful because of a crude flowchart, and from that created a list of needed variables, objects, and storage solutions. 
 
 Next, I broke the program down into sections that I could build in a sequential order.  I experienced some problems with not thinking about how methods information could be used in multiple ways.  The information I learned from this experience enhanced the code for other projects.  Here is what I am most proud of out of each section.    
 * Container  
   - Use of multiple for loops to create, add and initiate action listener for all checkbox objects. 
   - Use of arrays as storage units for checkbox objects.  
 * User Entry
   - Created a method to look at the game board and return a control integer.  I used this method in the action listener as a control to start the game.  This to allow user to click/unclick the first five numbers indefinitely and upon the sixth choice the game begins, and the game board is deactivated.      
 * Game Operation  
   - The use of nested for loops to traverse and compare two Array Lists.    
 * Winning Analyzation and Output
   - The successful use of if...else statements to set appropriate results for output.  
 
 **_Each of the sections above used pseudocode, then entered into JGrasp, finally debugged before moving onto the next section._**
 
 ### What I would improve... 
  Due to the short time frame to complete the program, there are several things I would like to improve.  
  * It is use once program and does not reload to allow the player to continue.  I would add this feature as well as a player pot of winnings and track game statistics.  
  * I would like to clean up the interface allowing the player to change all six choices before the game begins. 
 
 ### I am showcasing this project in part due to the amount of inefficient code woven into the project.  This was a couple of weeks before the Blackjack Project (Blackjack School Project repository) and shows the improvement in coding efficiency over a short period of time.

