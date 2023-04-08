package week06;

import java.util.Arrays;

public class GameBoard {

  
  //what is a gameboard:
  String[] gameBoard = new String[9];
  
  
  
  //initialize method, to fill each index of the gameboard array with a number from 1-9
  public void initialize() {
    for(int i = 1; i<= 9; i++) {
      this.gameBoard[i-1] = String.valueOf(i);
    }
  }
    
  
  //display gameboard method, to design the shape of the gameboard and insert each array value in each square
    public void displayGameBoard() {
      System.out.println();
      System.out.println("+---+---+---+");
      System.out.println("| " + this.gameBoard[0] + " | " + this.gameBoard[1] + " | " + this.gameBoard[2] + " | ");
      System.out.println("+---+---+---+");
      System.out.println("| " + this.gameBoard[3] + " | " + this.gameBoard[4] + " | " + this.gameBoard[5] + " | ");
      System.out.println("+---+---+---+");
      System.out.println("| " + this.gameBoard[6] + " | " + this.gameBoard[7] + " | " + this.gameBoard[8] + " | ");
      System.out.println("+---+---+---+"); 
  }

    
    
 /*
  * given the squareNumber, the user input, and the player X or O,
  * if the gameboard index space is equal to the user input
  *     change the gameboard index space value to the same as the player X or O
  *      return true
  *   otherwise return false, because there is already a letter there and you cant choose this space   
  */
    
    public boolean ifValidSetSquare(int squareNumber, String input, String player) {
      if(this.gameBoard[squareNumber-1].equals(input)) {
        this.gameBoard[squareNumber-1] = player;
        return true;
      }
      return false;
    }
    
    
    /*
     * there are 8 ways to win
     * start at 0 end at less than 8 = 8 times this loop can run
     *  create a string to concatenate each position in the string array for each winning combination   
     *      set as an empty string to start
     *      
     *      
     *  check each possible way you can win:
     *   case 0 changes the winningcombo string to equal the values of each gameboard index space
     *      - ie. 'XXX' or OOO
     *    if any of these combinations do equal XXX then return "X"
     *    else if any of these combinations equal OOO return "O"  
     *  
     *      checking whether or not this is a draw game
     *   for iterating from 1 through less than or 9, adding one each time
     *   if  this gameboard array contains the value of the string pos 
     *      essentially asking if any of these integers (1-9) are still in the array? or are they
     *          all Xs and Os now?
     *      if there is a 1-9 still are on the board then break; and return an empty string
     *      else if we are at the last position (pos == 9) and no numbers have been found yet
     *          then return "draw" because all the squares are full and there are no numbers remaining
     *      
     *      
     *      
     *      (Arrays.asList - treats the array like a list so you can use List methods to find things)
     *        
     *      
     *          
     */

    public String checkWinStatus() {
      for(int pos = 0; pos < 8; pos++) {
        String winningCombo = "";
        
        switch(pos) {
          case 0:
            winningCombo = this.gameBoard[0] + this.gameBoard[1] + this.gameBoard[2];
            break;
          case 1:
            winningCombo = this.gameBoard[3] + this.gameBoard[4] + this.gameBoard[5];
            break;
          case 2:
            winningCombo = this.gameBoard[6] + this.gameBoard[7] + this.gameBoard[8];
            break;
          case 3:
            winningCombo = this.gameBoard[0] + this.gameBoard[3] + this.gameBoard[6];
            break;
          case 4:
            winningCombo = this.gameBoard[1] + this.gameBoard[4] + this.gameBoard[5];
            break;
          case 5:
            winningCombo = this.gameBoard[2] + this.gameBoard[5] + this.gameBoard[8];
            break;
          case 6:
            winningCombo = this.gameBoard[0] + this.gameBoard[4] + this.gameBoard[8];
            break;
          case 7:
            winningCombo = this.gameBoard[2] + this.gameBoard[4] + this.gameBoard[6];
            break;       
        }
        if(winningCombo.equals("XXX")) {
          return "X";
        } else if(winningCombo.equals("OOO")) {
          return "O";
        }
      }
      for(int pos = 1; pos <= 9; pos++) {
        if(Arrays.asList(this.gameBoard).contains(String.valueOf(pos))) {
          break;
        } else if (pos == 9) {
          return "draw";
        }
      }
      return "";
    }
    
    
    
}
