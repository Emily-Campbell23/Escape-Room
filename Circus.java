import java.util.Scanner;


class Circus extends Room{
  public Circus(){
    super("Circus room description", 100, 3);
  }


  @Override
  public void interact(Player player) {
    Inventory inventory = new Inventory();
      Scanner scan = new Scanner(System.in);
      boolean hasKey = false; // Track whether the key has been obtained
      int points = 100; // Starting points
      int lives = player.getLives(); // Starting lives


      // Welcome message
      System.out.println("Welcome to the Circus room! You have " + points + " points and " + lives + " lives.");


      // Continuous loop until the user exits through the door
      while (true) {
          // Presenting options to the user
          System.out.println("\n What will you do next?");
          System.out.println("\n1) Go to the group of clowns" +
                  "\n2) Go watch the acrobats" + "\n3) Go to the door" + "\n4) Go to the cage");


          String choice = scan.nextLine();


          // Handling user's choice
          switch (choice) {
              case "1":
                  System.out.println("You walk over to the group of clowns. They just seem to be doing party tricks.");
                  break;
              case "2":
                  System.out.println("You watch the acrobats and notice they are wearing different colors: red, blue, and green.");
                  break;
              case "3":
                  if (hasKey) {
                      System.out.println("You go to the door on the other side of the room. There is a small note attached: 'Input the secret words to unlock.'");
                      System.out.println("Enter the three secret words separated by spaces:");
                      String inputWords = scan.nextLine(); // Consume newline character
                      // inputWords = scan.nextLine(); // Read user input
                      String[] words = inputWords.split(" ");


                      if (words.length != 3) {
                          System.out.println("Incorrect number of words inputted.");
                          continue; // Go back to the beginning of the loop
                      } else {
                          if (words[0].equalsIgnoreCase("juggling") && words[1].equalsIgnoreCase("knives") && words[2].equalsIgnoreCase("unicycle")) {
                              System.out.println("The door unlocks and swings open. You exit the room.");
                              return; // Exiting the program
                          } else {
                              System.out.println("The door remains locked.");
                              lives--;
                              System.out.println("You lost one life. Remaining lives: " + lives);
                              if (lives == 0) {
                                  System.out.println("You have lost all your lives. Game over!");
                                  return; // Exiting the program
                              }
                          }
                      }
                  } else {
                    System.out.println("You can't go to the door without the key.");
                  }
                  break;
              case "4":
                  System.out.println("You walk over to the cage. There are large scratch marks on the floor and you notice a key covered by hay.");
                  break;
              case "inventory": System.out.println("Items in Inventory: " + inventory.getInventory());
                  break;
          }


          // Handling actions based on user's choices
          if (choice.equals("1")) {
              System.out.println("What will you do now?");
              System.out.println("1) Investigate the clowns" + "\n2) Exit");


              String choice1 = scan.nextLine();


              switch (choice1) {
                  case "1":
                      System.out.println("You notice the clowns are doing three different party tricks including juggling, throwing knives, and playing \non a unicycle");
                      break;
                  case "2":
                      System.out.println("You back away from the clowns...");
                      break;
                  case "inventory": System.out.println("Items in Inventory: " + inventory.getInventory());
                      break;
              }
          } else if (choice.equals("2")) {
              System.out.println("What will you do now?");
              System.out.println("1) Watch the acrobats' performance" + "\n2) Exit");


              String choice2 = scan.nextLine();


              switch (choice2) {
                  case "1":
                      System.out.println("You watch the acrobats' performance. They execute breathtaking stunts with grace and precision.");
                      break;
                  case "2":
                      System.out.println("You decide to leave the acrobats to their performance.");
                      break;
                  case "inventory": System.out.println("Items in Inventory: " + inventory.getInventory());
                      break;
              }
          } else if (choice.equals("4")) {
              System.out.println("You walk over to the cage. There are large scratch marks on the floor and you notice a key covered by hay.");
              System.out.println("What will you do now?");
              System.out.println("1) Take the key" + "\n2) Leave");


              String choice3 = scan.nextLine();


              switch (choice3) {
                  case "1":
                      hasKey = true;
                      System.out.println("You take the key from the cage.");
                      inventory.addItem("Key");
                      break;
                  case "2":
                      System.out.println("You leave the key in the cage.");
                      break;
                  case "inventory": System.out.println("Items in Inventory: " + inventory.getInventory());
                      break;
              }
          }
      }
  }
}