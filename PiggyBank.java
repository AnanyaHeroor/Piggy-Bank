// Title:   Piggy Bank
// Author:  Ananya Heroor
///////////////////////////////////////////////////////////////////////////////
import java.util.Random;

public class PiggyBank {
  
  //coin specifications
  public final static int[] COINS_VALUES = {1, 5, 10, 25}; // coins values in cents
  public final static String[] COINS_NAMES = {"PENNY", "NICKEL", "DIME", "QUARTER"}; 
  // coins names
  public final static String NO_SUCH_COIN = "N/A"; // N/A string
  private final static Random RAND_GEN = new Random(100); // generator of random integers
  
  /**
  * Returns the name of a specified coin value
  * 
  * @param coin represents a coin value in cents.
  * @return the String name of a specified coin value if it is valid and N/A if the
  * coin value is not valid
  */
  public static String getCoinName(int coin) {
    String coinName;
    int i = 0;
    for (i = 0; i < COINS_VALUES.length; i++) {
      if (COINS_VALUES[i] == coin) {
        coinName = COINS_NAMES[i];
        return coinName;
      }
   // iterate through COINS_VALUES array until match obtained
    }
    return NO_SUCH_COIN;
   // return NO_SUCH_COIN if invalid coin
  }
  
  /**
  * Returns the balance of a piggy bank in cents
  * 
  * @param coins an oversize array which contains all the coins held in a piggy bank
  * @param size the total number of coins stored in coins array
  * @return the total value of the coins held in a piggy bank in cents
  */
  public static int getBalance(int[] coins, int size) {
    int all = 0;
    for (int i = 0; i < size; i++) {
      all += coins[i];
    }
    return all;
  }
  
  /**
  * Returns the total number of coins of a specific coin value held in a piggy bank
  *
  * @param coinValue the value of a specific coin
  * @param coins an oversize array which contains all the coins held in a piggy
  * bank
  * @param size the total number of coins stored in coins array
  * @return the number of coins of value coinValue stored in the array coins
  */
  public static int getSpecificCoinCount(int coinValue, int[] coins, int size) {
    int coinCount = 0;
    //go through array and check for match
    for (int i = 0; i < size; i++) {
      if (coins[i] == coinValue) { //add to coinCount when match is found
        coinCount++;
      }
    }
    return coinCount; //this returns the total number of matches found
  }
  
  /**
  * Displays information about the content of a piggy bank
  *
  * @param coins an oversize array storing the coins held in a piggy bank
  * @param size number of coin held array coins
  */
  public static void printPiggyBank(int[] coins, int size) {
    System.out.println("QUARTERS: " + getSpecificCoinCount(25, coins, size));
    System.out.println("DIMES: " + getSpecificCoinCount(10, coins, size));
    System.out.println("NICKELS: " + getSpecificCoinCount(5, coins, size));
    System.out.println("PENNIES: " + getSpecificCoinCount(1, coins, size));
    System.out.println("Balance: $" + getBalance(coins, size) * 0.01);
  }
  
  /**
  * Adds a given coin to a piggy bank. This operation can terminate
  * successfully or unsuccessfully. For either cases, this method
  * displays a descriptive message for either cases.
  *
  * @param coin the coin value in cents to be added to the array coins
  * @param coins an oversize array storing the coins held in a piggy bank
  * @param size the total number of coins contained in the array coins
  * before this addCoin method is called.
  * @return the new size of the coins array after trying to add coin.
  */
  public static int addCoin(int coin, int[] coins, int size) {
    boolean coinAvailable = false;
    String coinName = "";
    for (int i = 0; i < COINS_VALUES.length; i++) {
      if (COINS_VALUES[i] == coin) {
        coinAvailable = true;
        coinName = COINS_NAMES[i];
        break;
      }
    }
    if (coins.length == size ) {
      System.out.println("tried to add a " + coinName + ", but could not because the piggy bank is full");
      return size;
    }
    if (!coinAvailable) {
      System.out.println(coin + " cents is not a valid US currency coin.");
      return size;
    }
    coins[size] = coin;
    size = size + 1;
    System.out.println("Added a " + coinName + ".");
    return size;
  }
  
  /**
  * Removes an arbitrary coin from a piggy bank. This method may terminate
  * successfully or unsuccessfully. In either cases, a descriptive message
  * is displayed.
  *
  * @param coins an oversize array which contains the coins held in a piggy bank
  * @param size the number of coins held in the coins array before this method
  * is called
  * @return the size of coins array after this method returns successfully
  */
  public static int removeCoin(int[] coins, int size) {
    if (size == 0) {
      System.out.println("Tried to remove a coin, but could not because the piggy bank is empty.");
      return size;
    }
    Random rand = new Random();
    int i = 0;
    i = rand.nextInt(size - 1);
    String coinName = "";
    int coin = coins[i];
    coinName = getCoinName(coin);
    coins[i] = 0;
    size = organizeArray(coins, size);
    System.out.println("removed a " + coinName);
    return size;
  }
  
  /**
  * Removes all the coins in a piggy bank. It also displays the total value
  * of the removed coins
  *
  * @param coins an oversize array storing the coins held in a piggy bank application
  * @param size number of coins held in coins array before this method is called
  * @return the new size of the piggy bank after removing all its coins.
  */
  public static int emptyPiggyBank(int[] coins, int size) {
    if (size == 0) {
      System.out.println("Zero coin removed. The piggy bank is already empty");
    }
    int total = 0;
    for (int i = 0; i < size; i++) {
      total += coins[i];
      coins[i] = 0;
    }
    size = 0;
    return size;
  }
  
  public static int organizeArray (int[] coins, int size) {
    for (int i = 0; i < size; i++) {
      if (coins[i] == 0) {
        coins [i] = coins[size -1];
        coins[size - 1] = 0;
        size--;
        return size;
      }
    }
    return size;
  }
  
}
