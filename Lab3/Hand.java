import java.util.*;

/**
 * A poker hand is a list of cards, which can be of some "kind" (pair, straight, etc.)
 * 
 */
public class Hand implements Comparable<Hand> {

    public enum Kind {HIGH_CARD, PAIR, TWO_PAIR, THREE_OF_A_KIND, STRAIGHT, 
        FLUSH, FULL_HOUSE, FOUR_OF_A_KIND, STRAIGHT_FLUSH}

    private final List<Card> cards;

    /**
     * Create a hand from a string containing all cards (e,g, "5C TD AH QS 2D")
     */
    public Hand(String s) {

        cards = new ArrayList<>();
        String[] cardList = s.split(" ");
        for (String string : cardList) {
            cards.add(new Card(string));
        }


    }
    private List<Integer> transformIntoSortedRank () {
        List<Integer> rankList = new ArrayList<>();
        for(Card card: cards) {
            rankList.add(card.getRank().ordinal());

        }

        rankList.sort(Comparator.naturalOrder());
       return rankList;
    }
    /**
     * @returns true if the hand has n cards of the same rank
	 * e.g., "TD TC TH 7C 7D" returns True for n=2 and n=3, and False for n=1 and n=4
     */
    protected boolean hasNKind(int n) {

        List<Integer> rankList = this.transformIntoSortedRank ();


        if (n == 3) {
            for (int i=0; i < rankList.size() - 1; i++) {
                if (Objects.equals(rankList.get(i), rankList.get(i + 1))    && Objects.equals(rankList.get(i+1), rankList.get(i + 2))   ) {
                    return true;
                } else if (i == 3) {
                    return false;
                }
                i++;

            }
        } else if (n == 4) {
            for (int i=0; i < rankList.size() - 1; i++) {
                if (Objects.equals(rankList.get(i), rankList.get(i + 1))    && Objects.equals(rankList.get(i+1), rankList.get(i + 2))  && Objects.equals(rankList.get(i+2), rankList.get(i + 3))  ) {
                    return true;
                } else if (i == 1) {
                    return false;
                }


            }
        } else if (n == 2) {

            for (int i=0; i < rankList.size() - 1; i++) {
                if (Objects.equals(rankList.get(i), rankList.get(i + 1))) {
                    return true;
                }

            }
        }

        return false;
    }
    
    /**
	 * Optional: you may skip this one. If so, just make it return False
     * @returns true if the hand has two pairs
     */
    public boolean isTwoPair() {
        List<Integer> rankList = this.transformIntoSortedRank ();

        int j = 1;
        int numberOfPairs = 0;
        for (int i=0; i < rankList.size() - 1; i++) {
            if (Objects.equals(rankList.get(i), rankList.get(j))) {
                numberOfPairs += 1;
                if (j < 3) {
                    j+= 2;
                }
            }
            i++;
            if (numberOfPairs == 2) {return true;}



        }
        return false;

    }   
    
    /**
     * @returns true if the hand is a straight 
     */
    public boolean isStraight() {
        List<Integer> rankList = new ArrayList<>();
        for(Card card: cards) {
            rankList.add(card.getRank().ordinal());

        }
        rankList.sort(Comparator.naturalOrder());
        if (rankList.getLast() == 12 && rankList.getFirst()==0) {
            rankList.set(rankList.size() - 1, rankList.get(rankList.size() - 2) + 1);
        }
        for (int i=0; i < rankList.size() - 1; i++) {
            if (rankList.get(i) + 1 != rankList.get(i + 1)) {
                return false;
            }

        }

        return true;
    }
    
    /**
     * @returns true if the hand is a flush
     */
    public boolean isFlush() {
        List<Integer> suitList = new ArrayList<>();
        for(Card card: cards) {
            suitList.add(card.getSuit().ordinal());

        }

        for (int i=0; i < suitList.size() - 1; i++) {
            if (Objects.equals(suitList.get(i), suitList.get(i + 1))) {

            } else {
                return false;
            }

        }
        return true;
    }
    
    @Override
    public int compareTo(Hand h) {
        //hint: delegate!
		//and don't worry about breaking ties
        return this.kind().compareTo(h.kind());
    }
    
    /**
	 * This method is already implemented and could be useful! 
     * @returns the "kind" of the hand: flush, full house, etc.
     */
    public Kind kind() {
        if (isStraight() && isFlush()) return Kind.STRAIGHT_FLUSH;
        else if (hasNKind(4)) return Kind.FOUR_OF_A_KIND; 
        else if (hasNKind(3) && hasNKind(2)) return Kind.FULL_HOUSE;
        else if (isFlush()) return Kind.FLUSH;
        else if (isStraight()) return Kind.STRAIGHT;
        else if (hasNKind(3)) return Kind.THREE_OF_A_KIND;
        else if (isTwoPair()) return Kind.TWO_PAIR;
        else if (hasNKind(2)) return Kind.PAIR; 
        else return Kind.HIGH_CARD;
    }

}
