// Title:   Piggy Bank
// Course:  COMP SCI 300 Summer 2020
//
// Author:  Ananya Heroor
// Email:   heroor@wisc.edu
// Lecturer's Name: Mouna Kacem
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Students who get help from sources other than the course staff must fully
// acknowledge and credit those sources here.  If you did not receive any help
// of any kind from outside sources, explicitly indicate NONE next to each of 
// the labels below.
//
// Persons:         NONE
// Online Sources:  NONE
//
///////////////////////////////////////////////////////////////////////////////
public class PiggyBankTester {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    /**
    * Calls the test methods implemented in this class and displays their output
    * @param args input arguments if any
    */
      System.out.println("testGetCoinName(): " + testGetCoinName());
  }
  
  /**
  * Checks whether PiggyBank.getCoinName() method works as expected.
  * @return true when this test verifies a correct functionality, and false otherwise
  */
  public static boolean testGetCoinName() {
 // change some coin values and names
 PiggyBank.COINS_NAMES[1] = "Two cents";
 PiggyBank.COINS_NAMES[3] = "Fifty Cents";
 PiggyBank.COINS_VALUES[1] = 2;
 PiggyBank.COINS_VALUES[3] = 50;
 
 // consider all coin values as input arguments
   for (int i = 0; i < PiggyBank.COINS_VALUES.length; i++) {
     if (!PiggyBank.getCoinName(PiggyBank.COINS_VALUES[i]).equals(PiggyBank.COINS_NAMES[i]))
       return false;
 // consider input argument which does not correspond to a coin value
     if (!PiggyBank.getCoinName(7).equals(PiggyBank.NO_SUCH_COIN))
 return false;
     if (!PiggyBank.getCoinName(-10).equals(PiggyBank.NO_SUCH_COIN))
 return false;
   }
   return true;
 }
  
  /**
  * Checks whether PiggyBank.getBalance() method works as expected.
  * @return true when this test verifies a correct functionality, and false otherwise
  */
  public static boolean testGetBalance() {
    
  // scenario 1 - empty piggy bank
  int[] coins = new int[10]; // array storing the coins held in a piggy bank
  int size = 0; // number of coins held in coins array
  if (PiggyBank.getBalance(coins, size)!= 0) {
  System.out.println("Problem detected. Your PiggyBank.getBalance() did not "
  + "return the expected output when passed an empty piggy bank.");
  return false;
  }
  
  // scenario 2 - non empty piggy bank
  coins = new int[] {10, 1, 5, 25, 1, 0, 0};
  size = 5;
  if (PiggyBank.getBalance(coins, size)!= 42) {
  System.out.println("Problem detected. Your PiggyBank.getBalance() did not "
  + "return the expected output when passed an piggy bank that holds "
  + "two pennies, a nickel, a dime, and a quarter.");
  return false;
  }
  
  // scenario 3 - another non empty piggy bank
  coins = new int[] {10, 1, 5, 25, 1, 0};
  size = 3;
  if(PiggyBank.getBalance(coins, size)!= 16) {
  System.out.println("Problem detected. Your PiggyBank.getBalance() did not "
  + "return the expected output when passed an piggy bank that holds "
  + "a penny, a nickel, and a dime, only.");
  return false;
  }
  return true;
  }
  
  public static boolean testGetSpecificCoinCount() {
    //scenario 1
    int [] coins = new int [6];
    int size = 0;
    int coinValueSent = PiggyBank.COINS_VALUES[1];
    
    if (PiggyBank.getSpecificCoinCount(coinValueSent, coins, size) !=0) {
      System.out.println("Problem detected. Your PiggyBank.getSpecificCoin() did" + "not return - when no value was sent");
      return false;
    }
    //scenario 2: send an array to look at count
    coins = new int [] {1, 5, 10, 5, 0, 0};
    size = 4;
    coinValueSent = 5;
    
    if (PiggyBank.getSpecificCoinCount(coinValueSent, coins, size) != 2) {
      System.out.println("Problem detected. Your PiggyBank.getSpecificCoin() did" + " not return 2 when in scenario 2");
      return false; 
    }
    //scenario 3: send a different array to look at the count
    coins = new int [] {5, 25, 10, 1, 25, 1, 25, 0, 0, 0};
    size = 7; 
    coinValueSent = 25;
    
    if (PiggyBank.getSpecificCoinCount(coinValueSent, coins, size) != 3) {
      System.out.println("Problem detected. Your PiggyBank.getSpecificCoin() did" + " not return 3 when in scenario 3");
      return false;
    }
    return true;
  }
/**
 * checks whether PiggyBank.removeCoin() works as expected
 * 
 * @return true when this test verifies a correct functionality, and false otherwise
 */
  public static boolean testRemoveCoin() {
    int[] coins = new int [] {1, 5, 1, 25, 1, 10, 0, 0, 0};
    int size = 6;
    if (PiggyBank.removeCoin(coins, size) != 5) {
      System.out.print("Problem detected. Your PiggyBank.removeCoin() did not return"
          + " the correct size of array");
      return false;
    }
    return true;
  }
  
/**
 * Checks if the PiggyBank.emptyPiggyBank() method works as expected
 * @return true if this test verifies a correct functionality, and false otherwise 
 */
  public static boolean emptyPiggyBankTest() {
    int [] coins = new int [] {1, 5, 1, 25, 1, 10, 0, 0, 0};
    int size = 6;
    if (PiggyBank.emptyPiggyBank(coins, size) != 0) {
      System.out.println("Problem detected. Your PiggyBank.removeCoin() did not return" + " an array of zero size");
      return false;
    }
    coins = new int [] {0, 0, 0};
    size = 0;
    if (PiggyBank.emptyPiggyBank(coins, size) != 0) {
      System.out.print("Problem detected. Your PiggyBank.removeCoin() did not return" + " an array of zero size");
      return false;
    }
    return true;
  }


}
