package esi.atl.g53212.cards;

/**
 *
 * @author leopoldmols
 */
public class Game {
    
    public static void main(String[] args) {
        
        Deck cardList = new Deck();
        cardList.shuffle();
        
        try {
            int n = Integer.parseInt(args[0]);
            for (int i = 0; i < n; i++) {
                System.out.println(cardList.hit());
            }
            System.exit(0); 
        } catch (Exception e) {
            System.out.println("Usage : " + e.getMessage());
        }
        
        System.out.println(cardList);
    }
}
