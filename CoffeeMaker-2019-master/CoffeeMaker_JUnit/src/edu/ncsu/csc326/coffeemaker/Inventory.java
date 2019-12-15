package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;

/**
 * Inventory.
 * @author Sarah Heckman
 *
 *         Inventory for the coffee maker
 */
public class Inventory {

  private static int coffee;
  private static int milk;
  private static int sugar;
  private static int chocolate;

  /**
   * Creates a coffee maker inventory object and fills each item in the inventory
   * with 15 units.
   */
  public Inventory() {
    setCoffee(15);
    setMilk(15);
    setSugar(15);
    setChocolate(15);
  }

  /**
   * Returns the current number of chocolate units in the inventory.
   * 
   * @return int
   */
  public int getChocolate() {
    return chocolate;
  }

  /**
   * Sets the number of chocolate units in the inventory to the specified amount.
   * 
   * @param chocolate number of chocolate
   */
  public synchronized void setChocolate(int chocolate) {
    if (chocolate >= 0) {
      Inventory.chocolate = chocolate;
    }

  }

  /**
   * Add the number of chocolate units in the inventory to the current amount of
   * chocolate units.
   * 
   * @param chocolate number of chocolate
   * @throws InventoryException exception message prompted to user 
   */
  public synchronized void addChocolate(String chocolate) throws InventoryException {
    int amtChocolate = 0;
    try {
      amtChocolate = Integer.parseInt(chocolate);
    } catch (NumberFormatException e) {
      throw new InventoryException("Units of chocolate must be a positive integer");
    }
    if (amtChocolate >= 0) {
      Inventory.chocolate += amtChocolate;
    } else {
      throw new InventoryException("Units of chocolate must be a positive integer");
    }
  }

  /**
   * Returns the current number of coffee units in the inventory.
   * 
   * @return int
   */
  public int getCoffee() {
    return coffee;
  }

  /**
   * Sets the number of coffee units in the inventory to the specified amount.
   * 
   * @param coffee number of coffee
   */
  public synchronized void setCoffee(int coffee) {
    if (coffee >= 0) {
      Inventory.coffee = coffee;
    }
  }

  /**
   * Add the number of coffee units in the inventory to the current amount of
   * coffee units.
   * 
   * @param coffee number of coffee needed to be added
   * @throws InventoryException exception message
   */
  public synchronized void addCoffee(String coffee) throws InventoryException {
    int amtCoffee = 0;
    try {
      amtCoffee = Integer.parseInt(coffee);
    } catch (NumberFormatException e) {
      throw new InventoryException("Units of coffee must be a positive integer");
    }
    if (amtCoffee >= 0) {
      Inventory.coffee += amtCoffee;
    } else {
      throw new InventoryException("Units of coffee must be a positive integer");
    }
  }

  /**
   * Returns the current number of milk units in the inventory.
   * 
   * @return int
   */
  public int getMilk() {
    return milk;
  }

  /**
   * Sets the number of milk units in the inventory to the specified amount.
   * 
   * @param milk number of milk
   */
  public synchronized void setMilk(int milk) {
    if (milk >= 0) {
      Inventory.milk = milk;
    }
  }

  /**
   * Add the number of milk units in the inventory to the current amount of milk
   * units.
   * 
   * @param milk number of milk
   * @throws InventoryException exception message
   */
  public synchronized void addMilk(String milk) throws InventoryException {
    int amtMilk = 0;
    try {
      amtMilk = Integer.parseInt(milk);
    } catch (NumberFormatException e) {
      throw new InventoryException("Units of milk must be a positive integer");
    }
    if (amtMilk >= 0) {
      Inventory.milk += amtMilk;
    } else {
      throw new InventoryException("Units of milk must be a positive integer");
    }
  }

  /**
   * Returns the current number of sugar units in the inventory.
   * 
   * @return int
   */
  public int getSugar() {
    return sugar;
  }

  /**
   * Sets the number of sugar units in the inventory to the specified amount.
   * 
   * @param sugar number of sugar unit
   */
  public synchronized void setSugar(int sugar) {
    if (sugar >= 0) {
      Inventory.sugar = sugar;
    }
  }

  /**
   * Add the number of sugar units in the inventory to the current amount of sugar
   * units.
   * 
   * @param sugar sugar
   * @throws InventoryException exception message
   */
  public synchronized void addSugar(String sugar) throws InventoryException {
    int amtSugar = 0;
    try {
      amtSugar = Integer.parseInt(sugar);
    } catch (NumberFormatException e) {
      throw new InventoryException("Units of sugar must be a positive integer");
    }
    if (amtSugar >= 0) {
      Inventory.sugar += amtSugar;
    } else {
      throw new InventoryException("Units of sugar must be a positive integer");
    }
  }

  /**
   * Returns true if there are enough ingredients to make the beverage.
   * 
   * @param r recipe
   * @return boolean
   */
  protected synchronized boolean enoughIngredients(Recipe r) {
    boolean isEnough = true;
    if (Inventory.coffee < r.getAmtCoffee()) {
      isEnough = false;
    }
    if (Inventory.milk < r.getAmtMilk()) {
      isEnough = false;
    }
    if (Inventory.sugar < r.getAmtSugar()) {
      isEnough = false;
    }
    if (Inventory.chocolate < r.getAmtChocolate()) {
      isEnough = false;
    }
    return isEnough;
  }

  /**
   * Removes the ingredients used to make the specified recipe. Assumes that the
   * user has checked that there are enough ingredients to make
   * 
   * @param r recipe
   */
  public synchronized boolean useIngredients(Recipe r) {
    if (enoughIngredients(r)) {
      Inventory.coffee -= r.getAmtCoffee();
      Inventory.milk -= r.getAmtMilk();
      Inventory.sugar -= r.getAmtSugar();
      Inventory.chocolate -= r.getAmtChocolate();
      return true;
    } else {
      return false;
    }
  }

  /**
   * Returns a string describing the current contents of the inventory.
   * 
   * @return String
   */
  public String toString() {
    StringBuffer buf = new StringBuffer();
    buf.append("Coffee: ");
    buf.append(getCoffee());
    buf.append("\n");
    buf.append("Milk: ");
    buf.append(getMilk());
    buf.append("\n");
    buf.append("Sugar: ");
    buf.append(getSugar());
    buf.append("\n");
    buf.append("Chocolate: ");
    buf.append(getChocolate());
    buf.append("\n");
    return buf.toString();
  }
}
