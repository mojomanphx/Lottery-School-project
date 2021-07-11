//Final Exercises CIS263AA
//JLottery Class 




import java.util.*; 
import javax.swing.*; 
import java.awt.*; 
import java.awt.Font; 
import java.awt.Color; 
import java.awt.event.*; 

public class JLottery extends JFrame implements ItemListener, ActionListener 
{  //declarations
   //JMenu declarations
   JMenuBar main = new JMenuBar();//main menu bar
   JMenu file = new JMenu("File");//file options 
   JMenuItem about = new JMenuItem("About");//about submenu option
   //JPanel creation for each of the sections of JFrame
   JPanel center = new JPanel();//Center location will hold gridlayout for checkboxes 
   JPanel right = new JPanel();//right will hold gridlayout for winning amount explinations
   JPanel bottom = new JPanel();//Panel to align label on bottom of JFrame   
   //JPanel to hold center alignment within east portion of JFrame
   JPanel w1 = new JPanel(); 
   JPanel w2 = new JPanel(); 
   JPanel w3 = new JPanel(); 
   JPanel w4 = new JPanel(); 
   JPanel w5 = new JPanel(); 
   JPanel w6 = new JPanel(); 
   //Labels to explain winning details
   JLabel win1 = new JLabel("Winnings"); 
   JLabel win2 = new JLabel("3 = $100"); 
   JLabel win3 = new JLabel("4 = $10000"); 
   JLabel win4 = new JLabel("5 = $50000"); 
   JLabel win5 = new JLabel("6 = $1000000"); 
   JLabel win6 = new JLabel("0,1,2 = $0");
   //message for user instructions 
   JLabel lotMessage = new JLabel("Please choose six numbers to play!"); 
   //new font to assign to labels for consistency
   Font font = new Font("Arial",Font.BOLD, 30); 
   //Int and String variable for various functions 
   int x,z,control, correctChoices; 
   String message; 
   //ArrayList and Array declarations
   ArrayList<Integer> playerChoices = new ArrayList<Integer>();//List to save user picks
   ArrayList<Integer> winningnums = new ArrayList<Integer>(); //List to hold winning numbers
   JCheckBox[] nums = new JCheckBox[30];//array for 30 checkbox objects 
   //method to load all user checkboxes into an array
   public void loadUserNumbers()
   {  int y =1;//variable to set text for checkbox 
      for(x = 0; x < 30; ++x)//loops through array and adds 30 unique checkboxes
      {   
         nums[x] = new JCheckBox(Integer.toString(y),false);//names new checkbox and adds number to set text 
         ++y;//increases setText variable    
      }
   }
   //Constructor   
   public JLottery()
   {
      super("J-Rod's Lottery Extravaganza");//Call to super and adds title to JFrame
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//sets the close operation 
      setLayout(new BorderLayout());//Sets layout for overall JFrame 
      setSize(800,800);//sets the size of the JFrame 
      center.setLayout(new GridLayout(5,6));//sets layout to grid for center objects 30 items 5 row and 6 columns 
      right.setLayout(new GridLayout(0,1)); //sets layout to grid for East will hold 6 JPanels and 6 labels to explain win structure
      lotMessage.setFont(new Font("Times",Font.BOLD, 23));//sets instructions message font and size 
      lotMessage.setForeground(Color.BLUE);//sets instructions message text color to blue  
      add(main, BorderLayout.NORTH);//adds JMenuBar to JFrame North 
      add(right, BorderLayout.EAST);//adds panel to JFrame East 
      add(center, BorderLayout.CENTER);//adds panel to Center section with gridlayout
      add(bottom, BorderLayout.SOUTH);//adds panel to South setion 
      main.add(file);//adds JMenu to Menu bar  
      file.add(about);//adds about submenu to file menu 
      about.addActionListener(this);//add action listener for button push 
      loadUserNumbers();//calls methods to load array of Checkboxes 
      for(x = 0; x < nums.length; ++x)//Loop to add Checkboxes to center of JFrame
      {
         center.add(nums[x]);//adds to JFrame  
         nums[x].setFont(font);//changes font  
         nums[x].addItemListener(this);//adds Item Listener 
      }
       
      bottom.add(lotMessage);//adds user game instructions
      //adds panels and labels to outline pay information
      right.add(w1);//adds panel  
      w1.add(win1);//adds label 
      win1.setFont(font);//sets font to label 
      right.add(w2); 
      w2.add(win2); 
      win2.setFont(font); 
      right.add(w3); 
      w3.add(win3); 
      win3.setFont(font); 
      right.add(w4); 
      w4.add(win4); 
      win4.setFont(font); 
      right.add(w5); 
      w5.add(win5); 
      win5.setFont(font); 
      right.add(w6); 
      w6.add(win6); 
      win6.setFont(font);  
      //Changes the color of the pay information
      win1.setForeground(Color.RED);
      win2.setForeground(Color.RED); 
      win3.setForeground(Color.RED); 
      win4.setForeground(Color.RED); 
      win5.setForeground(Color.RED); 
      win6.setForeground(Color.RED);  
      
       
   }
   //method to analyze how many Jcheckboxes are selected and returns the amount
   public int analyzeSelected()
   {  //variables 
      int temp = 0; 
      int tnum = 0; 
      playerChoices.clear();//clears arraylist for player choices  
      for(x = 0; x < nums.length; ++x)//traverses checkbox array
      {
         if(nums[x].isSelected())//grabs any selected checkboxes
         {
            ++temp;//adds to the number of selected numbers 
            tnum = Integer.parseInt(nums[x].getText());//takes the value of checkbox and converts it to integer 
            playerChoices.add(tnum);//adds to array of player choices 
            
         }
      }
      return temp;//returns the amount of selected checkboxes
   }
   //array to create and store 6 unique numbers between 1 - 30
   public void winningNumbers()
   {   int randomnum;//random number variable
       int exloop;//variable to handle loop
          
       Random rand = new Random();//creates new instance of random 
      for(x = 0; x < 6; ++x)//loop to create 6 numbers 
      {
        do//do while loop to keep randomizing until a unique number is achieved
         {
            exloop = 0;//instantiates loop control to zero
            randomnum = rand.nextInt(30)+1;//gets random number that is between 1 and 30
            for(z = 0; z < winningnums.size();++z)//for loop to traverserse winningnumbers in array
            {
               if(winningnums.get(z) == randomnum)//if the random number matches a winning number
               {
                exloop = 1;//changes loop control to continue while loop 
                break;//breaks out of for loop that analyzes random num to create new random number   
               }
               else
               {
                  exloop = 0;//once a unique number is found breaks out of do while loop 
               }
            } 
         }while(exloop == 1);
         
         winningnums.add(randomnum);//adds unique random number to winning numbers 
     }  
     //This process will continue until you have 6 unique numbers  
   }
   //method to analyze player choices againist winning numbers
   public void playLottery()
   {  correctChoices = 0;//resets number of correct choices 
      for(x = 0; x < playerChoices.size(); ++x)//traverses the player choices 
      {
         for(z = 0; z < winningnums.size(); ++z)//traverses the winning numbers
         {
            if(playerChoices.get(x) == winningnums.get(z))//looks to see if the two numbers are equal
            {
               ++correctChoices;//keeps running total of correct choices
            }
         } 
      }
      Output();//calls output method to show results 
   }
   //method to Output information and results to user 
   public void Output()
   {  //12 variables to hold both player choices and winning numbers
      int win1 = winningnums.get(0);
      int win2 = winningnums.get(1); 
      int win3 = winningnums.get(2); 
      int win4 = winningnums.get(3); 
      int win5 = winningnums.get(4); 
      int win6 = winningnums.get(5);
      int pl1 = playerChoices.get(0);
      int pl2 = playerChoices.get(1);
      int pl3 = playerChoices.get(2);
      int pl4 = playerChoices.get(3);
      int pl5 = playerChoices.get(4);
      int pl6 = playerChoices.get(5);
      //String to hold the amount of winnings based on results of lottery
      String playerWinAmount= " "; 
      //if  else..if nest to determine which message should apply and applies to variable
      if(correctChoices < 3)
      { playerWinAmount = "You did not qualify for any winnings, please try again"; }
      else if( correctChoices == 3)
      { playerWinAmount = "You won $100.00, you can redeem that at your local retailer"; }
      else if (correctChoices == 4)
      { playerWinAmount ="Congratulations You won $10,000.00"; }
      else if (correctChoices == 5)
      { playerWinAmount ="Wow you are really good you got 5 worth $50,000.00"; }
      else if (correctChoices == 6)
      { playerWinAmount = "AMAZING you got all 6 you win ONE MILLION DOLLARS ($1,000,000.00)"; }
      //Overall message construction that will appear in JOptionPane
      message = "Winning Numbers : "+win1+","+win2+","+win3+","+win4+","+win5+","+win6+"\n"+
                "Players Numbers : "+pl1+","+pl2+","+pl3+","+pl4+","+pl5+","+pl6+"\n\n"+
                "You recieved "+correctChoices+"\n"+playerWinAmount; 
     //call to JOption pane to send output to user
     JOptionPane.showMessageDialog(null, message); 
  }
   //handles item state change for checkboxes
   @Override
   public void itemStateChanged (ItemEvent e)
   {  
      Object source = e.getSource();//finds source of check
      int select = e.getStateChange();//finds if it was checked or unchecked 
      if(select == ItemEvent.SELECTED)//if it is selected 
      {  
            control = analyzeSelected();//sets control variable...
            //this control variable will leave game pane open for user to continue additional selections  
            
            if (control == 6)//once the game board is analyzed to include 6 selected components the following will occur
            {
               for(x = 0; x < nums.length; ++x)//traverses game board
               {
                  nums[x].setEnabled(false);//disables all game components and does not allow additional selections
               }
               winningNumbers();//runs method to create unique array of winning numbers 
               playLottery();//runs method to actually play the lottery 
                
            }   
               
      } 
   }
   @Override
   public void actionPerformed(ActionEvent e)//method that handles button click on about submenu component outputs information
   {
        JOptionPane.showMessageDialog(null, "Jeriod W. Ruschell\nCIS 263AA Final Project\nMEID JER2181272");  
   }

   
   public static void main(String[] args)
   {//main method
      JLottery frame = new JLottery();//creates new frame 
      frame.setVisible(true);//makes it visible.   
   }
}