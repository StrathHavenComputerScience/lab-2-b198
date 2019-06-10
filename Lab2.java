public class Lab2
{
  public static void cleanSquare()
  {
    Robot.load("square.txt");
    Robot.setDelay(0.1);
    
    cleanAndTurn();
    cleanAndTurn();
    cleanAndTurn();
    cleanSide();
  }
  public static void cleanAndTurn()
  {
      /* precondition: Robot is at corner of square, facing dark side
       * of square
       * postcondition: Robot is at other corner of formerly dark side
       * which is now light and is facing the next side of the square
       */
      cleanSide();
      Robot.turnLeft();
    }
  public static void cleanSide()
  {
      /* precondition: Robot is at corner of square, facing dark side
       * of square
       * postcondition: Robot is at other corner of formerly dark side
       * which is now light
       */
      moveAndMakeLight();
      moveAndMakeLight();
      moveAndMakeLight();
      moveAndMakeLight();
      moveAndMakeLight();
      Robot.move();
    }
  public static void moveAndMakeLight()
  {
      /* precondition: Robot is on light square facing dark square
       * postcondition: Robot is on next square, facing same direction,and has
       * lightened the square
       */
      Robot.move();
      Robot.makeLight();
    }
  
  public static void darkenComb()
  {
    Robot.load("comb.txt");
    Robot.setDelay(0.05);
    
    cleanRowAndMoveUp();
    cleanRowAndMoveUp();
    cleanRowAndMoveUp();
    cleanRowAndMoveUp();
    cleanRow();
  }
  public static void turnRight()
  {
    //makes the robot turn right
    Robot.turnLeft();
    Robot.turnLeft();
    Robot.turnLeft();
    }
  public static void cleanRow()
  {
     /* precondition: Robot is at the far left end of a light row facing north
      * post condition: Robot is at the far right end of the same row facing
      * east and all of the spaces in the row are dark
      */
     Robot.makeDark();
     turnRight();
     moveAndMakeDark();
     moveAndMakeDark();
     moveAndMakeDark();
     moveAndMakeDark();
     moveAndMakeDark();
     moveAndMakeDark();
    }
  public static void moveAndMakeDark()
  {
      /* precondition: Robot is on a dark space facing a light space
       * postcondition: Robot has moved forward one and the formerly light
       * space is dark
       */
      Robot.move();
      Robot.makeDark();
    }
  public static void goBack()
  {
      /* precondition: Robot is at the far right end of a row facing east
       * postcondition: Robot is at the far left end of a row facing west
       */
      Robot.turnLeft();
      Robot.turnLeft();
      Robot.move();
      Robot.move();
      Robot.move();
      Robot.move();
      Robot.move();
      Robot.move();
    }
  public static void cleanRowAndMoveUp()
  {
      /* precondition: Robot is at the far left end of a light row facing
       * north
       * postcondition: Robot is facing north and is 2 spaces north of its
       * pre-method postion,the row it was previously on now dark and the
       * space directly south of the robot also dark
       */
      cleanRow();
      goBack();
      turnRight();
      moveAndMakeDark();
      Robot.move();
    }
    
  public static void makeCheckered()
  {
    Robot.load("blank.txt");
    Robot.setDelay(0.05);
    
    fillTwoColumns();
    fillTwoColumns();
    fillTwoColumns();
    fillColumnNorth();
    skipSpaceAndMakeDark();
    skipSpaceAndMakeDark();
    skipSpaceAndMakeDark();
    Robot.makeDark();
  }
  public static void skipSpaceAndMakeDark()
  {
      /* precondition: Robot is on a light space (facing either north or south)
       * postcondition: The space the robot was previously on is dark and
       * the robot has moved forward 2 spaces
       */
      Robot.makeDark();
      Robot.move();
      Robot.move();
    }
  public static void northTurn()
  {
      /* precondition: Robot is facing north on a light space one space south
       * of the top of the grid
       * postcondition: Robot has moved one unit north and one unit east
       * (at the top of a column) and is facing south. The space it was
       * previously on is dark.
       */
      Robot.makeDark();
      Robot.move();
      turnRight();
      Robot.move();
      turnRight();
    }
  public static void southTurn()
  {
      /* precondition: Robot is facing south on a light space one space north
       * of the bottom of the grid
       * postcondition: Robot has moved one unit south and one unit east
       * (at the bottom of a column) and is facing north. The space it was
       * previously on is dark.
       */
      Robot.makeDark();
      Robot.move();
      Robot.turnLeft();
      Robot.move();
      Robot.turnLeft();
    }
  public static void fillColumnNorth()
  {
    /* precondition: Robot is at the bottom of a light column and is facing
     * north
     * postcondition: Robot has moved seven units north and one unit east
     * (at the top of a column) and is facing south. The robot has darkened
     * alternating squares (checkers) on the previous column.
     */
    skipSpaceAndMakeDark();
    skipSpaceAndMakeDark();
    skipSpaceAndMakeDark();
    northTurn();
    }
  public static void fillColumnSouth()
  {
    /* precondition: Robot is at the top of a light column and is facing
     * south
     * postcondition: Robot has moved seven units south and one unit east
     * (at the bottom of a column) and is facing north. The robot has darkened
     * alternating squares (checkers) on the previous column.
     */
    skipSpaceAndMakeDark();
    skipSpaceAndMakeDark();
    skipSpaceAndMakeDark();
    southTurn();
    }
  public static void fillTwoColumns()
  {
    /* precondition: Robot is at the bottom of a light column and is facing
     * north
     * postcondition: Robot has moved two units east and is at the bottom of
     * a light column, facing north. It has darkened the previous two columns
     * in a checkerboard pattern.
     */
    fillColumnNorth();
    fillColumnSouth();
    }
}
