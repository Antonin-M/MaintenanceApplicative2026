package trivia;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;

// REFACTOR ME
public class Game implements IGame {
   private final ArrayList<Player> players = new ArrayList<>();

   LinkedList popQuestions = new LinkedList();
   LinkedList scienceQuestions = new LinkedList();
   LinkedList sportsQuestions = new LinkedList();
   LinkedList rockQuestions = new LinkedList();

   Map<String, int[]> categories = Map.of(
   "Pop", new int[]{0, 4, 8},
   "Science", new int[]{1, 5, 9},
   "Sports", new int[]{2, 6, 10}
   );

   int currentPlayer = 0;
   boolean isGettingOutOfPenaltyBox;

   public Game() {
      for (int i = 0; i < 50; i++) {
         popQuestions.addLast("Pop Question " + i);
         scienceQuestions.addLast(("Science Question " + i));
         sportsQuestions.addLast(("Sports Question " + i));
         rockQuestions.addLast(createRockQuestion(i));
      }
   }

   public String createRockQuestion(int index) {
      return "Rock Question " + index;
   }

   public boolean isPlayable() {
      return (players.size() >= 2);
   }

   public boolean add(String playerName) {
      Player player = new Player(playerName);
      players.add(player);

      System.out.println(playerName + " was added");
      System.out.println("They are player number " + players.size());
      return true;
   }

   public int howManyPlayers() {
      return players.size();
   }

   public void roll(int roll) {
      Player curPlayer = players.get(currentPlayer);
      System.out.println(curPlayer.getName() + " is the current player");
      System.out.println("They have rolled a " + roll);

      if (curPlayer.isInPenaltyBox()) {
         if (roll % 2 != 0) {
            isGettingOutOfPenaltyBox = true;

            System.out.println(curPlayer.getName() + " is getting out of the penalty box");
            int newPlace = curPlayer.getPlace() + roll;
            if (newPlace > 12) newPlace = newPlace-12;
            curPlayer.setPlace(newPlace);

            System.out.println(curPlayer.getName()
                               + "'s new location is "
                               + curPlayer.getPlace());
            System.out.println("The category is " + currentCategory());
            askQuestion();
         } else {
            System.out.println(curPlayer.getName() + " is not getting out of the penalty box");
            isGettingOutOfPenaltyBox = false;
         }

      } else {

         int newPlace = curPlayer.getPlace() + roll;
         if (newPlace > 12) newPlace = newPlace-12;
         curPlayer.setPlace(newPlace);

         System.out.println(curPlayer.getName()
                            + "'s new location is "
                            + curPlayer.getPlace());
         System.out.println("The category is " + currentCategory());
         askQuestion();
      }

   }

   private void askQuestion() {
      switch (currentCategory()) {
         case "Pop" -> System.out.println(popQuestions.removeFirst());
         case "Science" -> System.out.println(scienceQuestions.removeFirst());
         case "Sports" -> System.out.println(sportsQuestions.removeFirst());
         case "Rock" -> System.out.println(rockQuestions.removeFirst());
       }
   }


   private String currentCategory() {
      for (Map.Entry<String, int[]> t : categories.entrySet()) {
         for (int value : t.getValue()) {
            if (value == players.get(currentPlayer).getPlace()-1) {
               return t.getKey();
            }
         }
      }
      return "Rock";
   }

   public boolean handleCorrectAnswer() {
      Player curPlayer = players.get(currentPlayer);
      if (curPlayer.isInPenaltyBox()) {
         if (isGettingOutOfPenaltyBox) {
            System.out.println("Answer was corrent!!!!");
            curPlayer.addCoins();
            System.out.println(curPlayer.getName()
                               + " now has "
                               + curPlayer.getCoins()
                               + " Gold Coins.");

            boolean winner = didPlayerWin();
            changeCurrentPlayer();
            if (currentPlayer == players.size()) currentPlayer = 0;

            return winner;
         } else {
            changeCurrentPlayer();
            if (currentPlayer == players.size()) currentPlayer = 0;
            return true;
         }


      } else {

         System.out.println("Answer was corrent!!!!");
         curPlayer.addCoins();
         System.out.println(curPlayer.getName()
                            + " now has "
                            + curPlayer.getCoins()
                            + " Gold Coins.");

         boolean winner = didPlayerWin();
         changeCurrentPlayer();
         if (currentPlayer == players.size()) currentPlayer = 0;

         return winner;
      }
   }

   public boolean wrongAnswer() {
      System.out.println("Question was incorrectly answered");
      System.out.println(players.get(currentPlayer).getName() + " was sent to the penalty box");
      players.get(currentPlayer).setInPenaltyBox(true);

      currentPlayer++;
      if (currentPlayer == players.size()) currentPlayer = 0;
      return true;
   }


   private boolean didPlayerWin() {
      return !(players.get(currentPlayer).getCoins() == 6);
   }

   private void changeCurrentPlayer() {
      currentPlayer = (currentPlayer+1) % players.size();
   }
}
