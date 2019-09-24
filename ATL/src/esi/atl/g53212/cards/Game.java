package esi.atl.g53212.cards;

/**
 *
 * @author leopoldmols
 */
public class Game {
    
    public static void main(String[] args) {
        
        int n = 0;
        if (args.length == 1) {
            try {
                n = Integer.parseInt(args[0]);
                
            } catch (Exception e) {
                System.out.println("Usage : " );
                System.exit(0);
            }
            Deck cardList = new Deck();
            cardList.shuffle();
            for (int i = 0; i < n; i++) {
                System.out.println(cardList.hit());
            }
            
            System.out.println(cardList);
        } else {
            System.out.println("Usage : Not enough arguments");
        }
    }
}
