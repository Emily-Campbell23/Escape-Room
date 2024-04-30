import java.util.Scanner;



// Zombies room
class Zombies extends Room{
   private boolean hasEscaped;
   private boolean isChased;

   public Zombies(){
       super("You've entered the Zombies room. You must be stealthy to avoid alerting the zombies.", 100, 3);
       this.hasEscaped = false;
       this.isChased = false;
   }

   @Override
   public void interact(Player player){
       Scanner scanner = new Scanner(System.in);
       System.out.println(description);
       while(!hasEscaped && !isChased){
           System.out.println("What will you do?");
           String action = scanner.nextLine().toLowerCase();
           switch(action){
               case "investigate":
                   System.out.println("You see graves with tombstones, and a white with behind two switches.");
                   break;
               case "open":
                   System.out.println("You can't open anything here.");
                   break;
               case "exit":
                   System.out.println("There's nothing to pick up here.");
                   break;
               case "pull switch":
                   System.out.println("You pull a switch...");
                   // Logic to determine if a player pulled the correct switch
                   boolean correctSwitch = pullSwitch();
                   if(correctSwitch){
                       System.out.println("You hear a distant click. You have escaped the Zombies room!");
                       hasEscaped = true;
                       player.increaseScore(points);
                   }else{
                       System.out.println("The white with starts chasing you!");
                       //Logic to handle player being chased
                       isChased = true;
                   }
                   break;
               default:
                   System.out.println("Invalid command. Try again.");
           }
       }
       if (isChased) {
           // Implement logic for player to evade or handle being chased
           System.out.println("The white witch is chasing you!");

           // For simplicity, let's assume the player's only option is to exit the game
           System.out.println("The white witch caught you." + "You have died.");
           System.exit(0);
       }
   }

   private boolean pullSwitch(){
       //Return true if correct, false otherwise
       return false;
   }
}