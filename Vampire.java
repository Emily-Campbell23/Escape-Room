import java.util.Scanner;



class Vampire extends Room {
 private int points;
 private int objects;
 private boolean hasBook;
 private boolean hasGRobe;
 private boolean hasSRobe;
 private boolean hasRRobe;
 private boolean hasHRobe;
 private boolean fireOpen;
 private boolean wardFin;
 private boolean caskFin;
 private boolean bookFin;
 private boolean escaped;

 public Vampire() {
   super("The Mansion stands tall as you approach the front door...", 100, 3);
   this.points = 0;
   this.objects = 0;
   this.hasBook = false;
   this.hasGRobe = false;
   this.hasSRobe = false;
   this.hasRRobe = false;
   this.hasHRobe = false;
   this.fireOpen = false;
   this.wardFin = false;
   this.caskFin = false;
   this.bookFin = false;
   this.escaped = false;
 }

 @Override
 public void interact(Player player) {
   Inventory inventory = new Inventory();
   int lives = player.getLives();
   Scanner scan = new Scanner(System.in);
   System.out.println("As you walk into the mansion, a chill runs down your back...");
   System.out.println("The door slams shut behind you!");
   System.out.println("A closed casket is on your left, in the corner. \n" +
   "A large bookshelf, covering the wall to your right from floor to ceiling. \n" +
   "A wardrobe stands tall in the back right corner, closed shut. \n" +
   "A massive stone fireplace envelopes the wall in front of you. \n" +
   "No other doors seem to be present in the room.");

   while(lives >= 0 && escaped == false) {
     System.out.println("you have " + lives + " lives and " + points + " points.");
     System.out.println("What will you do now?");
     System.out.println("1) Open the front door \n" +
     "2) Go to the Casket \n" +
     "3) Go to the Bookshelf \n" +
     "4) Go to the Wardrobe \n" +
     "5) Go to the Fireplace \n");
     String choice1 = scan.nextLine();
     switch (choice1) {
       case "1": System.out.println("You pull on the door handle, but it doesn't budge. You are trapped in here. \n");
       break;
       case "2": System.out.println("You walk over to the casket. Its hard wood top seems to be slightly ajar. \n");
       if(caskFin == true) {
         System.out.println("All that could be done with the casket has already been done. \n");
       }
       break;
       case "3": System.out.println("You walk over to the bookshelf. It is filled with row after row of books, " +
       "ranging from thin, childrens books to thick, old books. \n");
       if(bookFin == true) {
         System.out.println("All that could be done with the bookshelf has already been done. \n");
       }
       break;
       case "4": System.out.println("You walk over to the wardrobe. Its meticulously decorated doors are closed shut. \n");
       if(wardFin == true) {
         System.out.println("All that could be done with the wardrobe has already been done. \n");
       }
       break;
       case "5": System.out.println("You walk over to the fireplace. Charcoal fills it's pit, and bunch of wood is stacked next to it.");
       if(fireOpen == true) {
         System.out.println("The fireplace has shifted to the side, revealing an exit! \n");
       }
       break;
       case "inventory": System.out.println("Items in Inventory: " + inventory.getInventory());
       break;
     }

       if(choice1.equals("2")&& caskFin == false) {
         System.out.println("What will you do now?");
         System.out.println("1) Open the Casket \n" +
         "2) Exit");
         String choice2 = scan.nextLine();
         switch (choice2) {
           case "1": System.out.println("You push the top off of the casket. it falls to the floor with a loud thud. \n");
           break;
           case "2": System.out.println("You walk away from the casket.");
           break;
           case "inventory": System.out.println("Items in Inventory: " + inventory.getInventory());
           break;
         }

         if (choice2.equals("1")) {
           System.out.println("What will you do now?");
           System.out.println("1) Investigate the inside \n" +
           "2) Exit");
           String choice21 = scan.nextLine();
           switch (choice21) {
             case "1": System.out.println("You search the inside of the casket. It is void of anything, but when you look closely, " +
             "you find, etched into the wood, is two phrases... \n" +
             "╭━━━━┳╮╱╱╱╱╱╭╮╱╱╱╱╱╱╱╱╱╱╱╱╭╮╭╮╱╱╱╱╱╭╮╭╮╭╮╭╮╱╱╱╭╮╱╱╱╱╱╱╱╱╱╱╱╭╮╱╭╮╭╮╱╱╱╱╱╭╮╭╮╭╮╱╱╱╱╱╱╭╮╱╱╱╱╭╮ \n" +
             "┃╭╮╭╮┃┃╱╱╱╱╱┃┃╱╱╱╱╱╱╱╱╱╱╱╭╯╰┫┃╱╱╱╱╱┃┃┃┃┃┣╯╰╮╱╱┃┃╱╱╱╱╱╱╱╱╱╱╱┃┃╭╯╰┫┃╱╱╱╱╱┃┃┃┃┃┃╱╱╱╱╱╱┃┃╱╱╱╱┃┃ \n" +
             "╰╯┃┃╰┫╰━┳━━╮┃┃╱╱╭┳━━┳━╮╱╱╰╮╭┫╰━┳━━╮┃┃┃┃┃┣╮╭╋━━┫╰━╮╱╭━━┳━╮╭━╯┃╰╮╭┫╰━┳━━╮┃┃┃┃┃┣━━┳━┳━╯┣━┳━━┫╰━┳━━╮ \n" +
             "╱╱┃┃╱┃╭╮┃┃━┫┃┃╱╭╋┫╭╮┃╭╮╮╱╱┃┃┃╭╮┃┃━┫┃╰╯╰╯┣┫┃┃╭━┫╭╮┃╱┃╭╮┃╭╮┫╭╮┃╱┃┃┃╭╮┃┃━┫┃╰╯╰╯┃╭╮┃╭┫╭╮┃╭┫╭╮┃╭╮┃┃━┫ \n" +
             "╱╱┃┃╱┃┃┃┃┃━┫┃╰━╯┃┃╰╯┃┃┃┣╮╱┃╰┫┃┃┃┃━┫╰╮╭╮╭┫┃╰┫╰━┫┃┃┣╮┃╭╮┃┃┃┃╰╯┃╱┃╰┫┃┃┃┃━┫╰╮╭╮╭┫╭╮┃┃┃╰╯┃┃┃╰╯┃╰╯┃┃━┫ \n" +
             "╱╱╰╯╱╰╯╰┻━━╯╰━━━┻┻━━┻╯╰┻┫╱╰━┻╯╰┻━━╯╱╰╯╰╯╰┻━┻━━┻╯╰┻┫╰╯╰┻╯╰┻━━╯╱╰━┻╯╰┻━━╯╱╰╯╰╯╰╯╰┻╯╰━━┻╯╰━━┻━━┻━━╯ \n" +
             "╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╯╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╯ \n" +
             "╭━━━╮╱╱╱╱╱╱╱╱╱╱╱╱╭╮╱╱╱╱╱╭╮╭━╮╭╮╭╮╱╱╱╱╱╭╮╱╭╮╭╮╱╱╱╱╱╭━━━╮╱╱╭╮ \n" +
             "┃╭━╮┃╱╱╱╱╱╱╱╱╱╱╱╭╯╰╮╱╱╱╱┃┃┃╭╯┃┃┃┃╱╱╱╱╱┃┃╭╯╰┫┃╱╱╱╱╱┃╭━╮┃╱╭╯╰╮ \n" +
             "┃┃╱╰╋╮╭┳━┳┳━━┳━━╋╮╭╋╮╱╭╮┃╰╯╯╭┫┃┃┃╭━━┳━╯┃╰╮╭┫╰━┳━━╮┃┃╱╰╋━┻╮╭╯ \n" +
             "┃┃╱╭┫┃┃┃╭╋┫╭╮┃━━╋┫┃┃┃╱┃┃┃╭╮┃┣┫┃┃┃┃┃━┫╭╮┃╱┃┃┃╭╮┃┃━┫┃┃╱╭┫╭╮┃┃ \n" +
             "┃╰━╯┃╰╯┃┃┃┃╰╯┣━━┃┃╰┫╰━╯┃┃┃┃╰┫┃╰┫╰┫┃━┫╰╯┃╱┃╰┫┃┃┃┃━┫┃╰━╯┃╭╮┃╰╮ \n" +
             "╰━━━┻━━┻╯╰┻━━┻━━┻┻━┻━╮╭╯╰╯╰━┻┻━┻━┻━━┻━━╯╱╰━┻╯╰┻━━╯╰━━━┻╯╰┻━╯ \n" +
             "╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╭━╯┃ \n" +
             "╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╰━━╯ \n");
             break;
             case "2": System.out.println("You walk away from the open casket.");
             break;
             case "inventory": System.out.println("Items in Inventory: " + inventory.getInventory());
             break;
           }

           if (choice21.equals("1")) {
             System.out.println("What will you do now?");
             System.out.println("1) Lie inside the casket \n" +
             "2) Exit");
             String choice211 = scan.nextLine();
             switch (choice211) {
               case "1": System.out.println("You lie down inside of the casket. The bottom sinks down slowly. suddenly, " +
               "the bottom opens out from under you! \n" +
               "You Have Died. \n" +
               "REST IN PIECE \n" +
               "YOU HAVE PERISHED IN THE VAMPIRE ROOM \n");
               lives--;
               break;
               case "2": System.out.println("You get a bad feeling from the casket, and walk away.");
               caskFin = true;
               break;
               case "inventory": System.out.println("Items in Inventory: " + inventory.getInventory());
               break;
             }
           }
         }
       }
       if(choice1.equals("3") && bookFin == false) {
         System.out.println("What will you do now?");
         System.out.println("1) Investigate the books \n" +
         "2) Exit \n");
         String choice3 = scan.nextLine();

         switch (choice3) {
           case "1": System.out.println("You look through the titles of the books that stand out to you. \n" +
           "\"The Chronicles of Narnia: The Lion, the Witch and the Wardrobe\" \n" +
           "\"The Chronicles of Narnia: Prince Caspian\" \n" +
           "\"The Chronicles of Narnia: The Voyage of the Dawn Treader\" \n" +
           "\"The Chronicles of Narnia: The Silver Chair\" \n" +
           "\"The Chronicles of Narnia: The Horse and His Boy\" \n" +
           "\"The Chronicles of Narnia: The Magician's Nephew\" \n" +
           "\"The Chronicles of Narnia: The Last Battle\" \n" +
           "\"Harry Potter and the Philosopher's Stone\" \n" +
           "\"Harry Potter and the Chamber of Secrets\" \n" +
           "\"Harry Potter and the Prisoner of Azkaban\" \n" +
           "\"Harry Potter and the Goblet of Fire\" \n" +
           "\"Harry Potter and the Order of the Phoenix\" \n" +
           "\"Harry Potter and the Half-Blood Prince\" \n" +
           "\"Harry Potter and the Deathly Hallows\" \n");
           break;
           case "2": System.out.println("You walk away from the bookcase.");
           break;
           case "inventory": System.out.println("Items in Inventory: " + inventory.getInventory());
           break;
         }

         if(choice3.equals("1")) {
           System.out.println("What will you do now?");
           System.out.println("1) Grab the Narnia books \n" +
           "2) Grab the Harry Potter books \n" +
           "3) Exit \n");
           String choice31 = scan.nextLine();

           switch (choice31) {
             case "1": System.out.println("You pull the Narnia books from the bookshelf. Nothing seems peculiar with them, but you take them with you anyways \n");
             hasBook = true;
             inventory.addItem("Narnia Book Series");
             points += 100;
             break;
             case "2": System.out.println("You grab the Harry Potter books from the bookshelf, but they dont slide off. Instead, they move in a lever-like fashion, and a shifting noise can be heard behind the bookshelf. \n" +
             "Suddenly, you hear the incredibly loud sound of stone sliding across stone. you turn to see the massive stone fireplace moving, revealing an exit behind it! \n");
             bookFin = true;
             fireOpen = true;
             break;
             case "3": System.out.println("You walk away from the bookshelf");
             break;
             case "inventory": System.out.println("Items in Inventory: " + inventory.getInventory());
             break;
           }

           if(choice31.equals("1") || hasBook == true) {
             System.out.println("What will you do now?");
             System.out.println("1) Grab the Harry Potter books \n" +
             "2) Exit \n");
             String choice311 = scan.nextLine();

             switch (choice311) {
               case "1": System.out.println("You grab the Harry Potter books from the bookshelf, but they dont slide off. Instead, they move in a lever-like fashion, and a shifting noise can be heard behind the bookshelf. \n" +
               "Suddenly, you hear the incredibly loud sound of stone sliding across stone. you turn to see the massive stone fireplace moving, revealing an exit behind it! \n");
               bookFin = true;
               fireOpen = true;
               break;
               case "2": System.out.println("You walk away from the bookshelf");
               break;
               case "inventory": System.out.println("Items in Inventory: " + inventory.getInventory());
               break;
             }
           }
         }
       }
       if(choice1.equals("4") && wardFin == false) {
         System.out.println("What will you do now?");
         System.out.println("1) Open the Wardrobe \n" +
         "2) Exit \n");
         String choice4 = scan.nextLine();

         switch (choice4) {
           case "1": System.out.println("You open the wardrobe. From left to right, there are 5 clothing items total. A vampire's suit, and four robes, colored red, green, blue, and yellow respectively. \n");
           break;
           case "2": System.out.println("You walk away from the wardrobe. \n");
           break;
           case "inventory": System.out.println("Items in Inventory: " + inventory.getInventory());
           break;
         }

         if(choice4.equals("1")) {
           System.out.println("What will you do now?");
           System.out.println("1) Investigate the robes \n" +
           "2) Exit \n");
           String choice41 = scan.nextLine();

           switch (choice41) {
             case "1": System.out.println("You take a closer look at the robes, and realize that they are representative of the four houses of the Harry Potter universe: Gryffindor, Slytherin, Ravenclaw and Hufflepuff. The Vampire must be a fan! \n");
             break;
             case "2": System.out.println("You walk away from the open wardrobe, believing there is nothing left to see in there. \n");
             break;
             case "inventory": System.out.println("Items in Inventory: " + inventory.getInventory());
             break;
           }

           if(choice41.equals("1")) {
             System.out.println("What will you do now?");
             System.out.println("1) Grab the Vampire's Suit \n" +
             "2) Grab the Gryffindor Robe \n" +
             "3) Grab the Slytherin Robe \n" +
             "4) Grab the Ravenclaw Robe \n" +
             "5) Grab the Hufflepuff Robe \n");

             String choice411 = scan.nextLine();

             switch (choice411) {
               case "1": System.out.println("You grab the Vampire's Suit, and admire it's beauty. As you do, something rises up right behind you. Teeth sink into your neck, as you fall to your knees. \n" +
               "You Have Died. \n" +
               "REST IN PIECE \n" +
               "YOU HAVE PERISHED IN THE VAMPIRE ROOM \n");
               lives--;
               break;
               case "2": System.out.println("You grab the Gryffindor robe. The wardrobe's doors swing shut, unable to be opened. \n");
               hasGRobe = true;
               wardFin = true;
               inventory.addItem("Gryffindor Robe");
               points += 100;
               break;
               case "3": System.out.println("You grab the Slytherin robe. The wardrobe's doors swing shut, unable to be opened. \n");
               hasSRobe = true;
               wardFin = true;
               inventory.addItem("Slytherin Robe");
               points += 100;
               break;
               case "4": System.out.println("You grab the Ravenclaw robe. The wardrobe's doors swing shut, unable to be opened. \n");
               hasRRobe = true;
               wardFin = true;
               inventory.addItem("Ravenclaw Robe");
               points += 100;
               break;
               case "5": System.out.println("You grab the Hufflepuff robe. The wardrobe's doors swing shut, unable to be opened. \n");
               hasHRobe = true;
               wardFin = true;
               inventory.addItem("Hufflepuff Robe");
               points += 100;
               break;
               case "inventory": System.out.println("Items in Inventory: " + inventory.getInventory());
               break;
             }
           }
         }
       }
       if(choice1.equals("5")) {
         if(fireOpen == false) {
           System.out.println("It is a large, unlit fireplace, logs stacked both inside and to the side of the pit as if it is ready to be lit at any moment. \n");
           System.out.println("What will you do now? \n" +
           "1) Crawl into the fireplace \n" +
           "2) Exit");
           String choice5 = scan.nextLine();

           switch(choice5) {
             case "1": System.out.println("You crawl into the fireplace. \n" +
             "You think you hear the tiniest flick of a lighter, as if it is struggling to be lit. \n" +
             "Suddenly, the whole fireplace lights up, and you are consumed by the flames. \n" +
             "You Have Died. \n" +
             "REST IN PIECE \n" +
             "YOU HAVE PERISHED IN THE VAMPIRE ROOM \n");
             lives--;
             break;
             case "2": System.out.println("You realize it would be stupid to crawl into a fireplace, and walk away.");
             break;
             case "inventory": System.out.println("Items in Inventory: " + inventory.getInventory());
             break;
           }
         } else {
           System.out.println("The Exit is open! Would you like to leave the Vampire's Lair?");
           System.out.println("1) Yes \n" +
           "2) No");
           String escapeChoice = scan.nextLine();

           switch(escapeChoice) {
             case "1": System.out.println("You walk into the newly uncovered exit.");
             escaped = true;
             break;
             case "2": System.out.println("You walk away from the exit.");
             break;
             case "inventory": System.out.println("Items in Inventory: " + inventory.getInventory());
             break;
           }
         }
       }
     }
     if(lives < 0) {
       System.out.println("You have run out of Lives. \n" +
       "Final Score: " + points);
     } else {
       System.out.println("You have escaped the Vampire's Lair! \n" +
       "There are still challenges that lie ahead... \n");
       System.out.println("\nScore Earned in First Level: " + points);
       System.out.println("\nLives Remaining: " + lives);
       player.increaseScore(points);
       player.getScore();
       //player.setLives();
       System.out.println("Items in Inventory: " + inventory.getInventory());
     }
   }
 }