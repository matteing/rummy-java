package proj2;

import java.util.ArrayList;
import java.util.Scanner;

public class Proj2 {
    /**
     * This function prints the current state of the game.
     * @return void
     */
    public static void printState(Hand hand, Engine engine) {
        System.out.printf("Hand: %s%n", hand.toString());
        for (int i = 0; i < hand.findSets().size(); i++) {
            // findSets returns a multidimensional list of lists of Card objects.
            ArrayList<Card> set = (ArrayList<Card>) hand.findSets().get(i);
            System.out.printf("Set %s: %s%n", i + 1, set.toString());
        }
        System.out.printf("Stack: %s%n", engine.getStack().toString());
        System.out.printf("Table: %s%n", engine.getTable().toString());
    }

    public static void main(String[] args) {
        int player = 1;
	    Engine engine = new Engine();

	    Hand player1 = new Hand();
        Hand player2 = new Hand();

        engine.initializeHand(player1);
        engine.initializeHand(player2);
        engine.initializeStack();

        System.out.printf("Initial Player 1: %s%n", player1);
        System.out.printf("Initial Player 2: %s%n", player2);

        while (true) {
            Scanner console = new Scanner(System.in);
            System.out.printf("--------------Player %s--------------%n", player);
            Hand hand = player == 1 ? player1 : player2;
            printState(hand, engine);
            System.out.println("DRAW: deck or stack? ");
            System.out.print("deck/stack?> ");
            String command = console.next();
            if (command.equals("deck")) {
                System.out.println("Drew from deck.");
                engine.takeAndRender(new DrawFromDeckOperation(hand));
            } else {
                System.out.println("Drew from stack.");
                engine.takeAndRender(new DrawFromStackOperation(hand));
            }
            printState(hand, engine);
            if (hand.findSets().size() > 0) {
                System.out.println("LAY: Lay a set? (n/set #...)");
                System.out.print("n/set #> ");
                command = console.next();
                if (!command.equals("n")) {
                    System.out.printf("Laying set %s.%n", command);
                    engine.takeAndRender(new LaySetOperation(hand, Integer.parseInt(command) - 1));
                }
                printState(hand, engine);
            }
            System.out.printf("DISCARD: Which card to discard? 1...%s%n", hand.getNumberOfCards());
            System.out.printf("1...%s> ", hand.getNumberOfCards());
            command = console.next();
            System.out.printf("Discarding card %s.%n", command);
            engine.takeAndRender(new DiscardOperation(hand, Integer.parseInt(command) - 1));
            player = player == 1 ? 2 : 1;
            if (engine.getDeck().getSizeOfDeck() == 0 || hand.isEmpty()) {
                break;
            }
        }

        int score1 = player1.evaluateHand();
        int score2 = player2.evaluateHand();
        System.out.printf("Player 1: %s%n", score1);
        System.out.printf("Player 2: %s%n", score2);
        if (score1 > score2) {
            System.out.println("Player 1 wins!");
        } else if (score2 > score1) {
            System.out.println("Player 2 wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }
}
