import java.util.List;
import java.util.ArrayList;


public class ElevensBoard extends Board
{


    private static final int BOARD_SIZE = 9;


    private static final String[] RANKS =
            {"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};


    private static final String[] SUITS =
            {"spades", "hearts", "diamonds", "clubs"};


    private static final int[] POINT_VALUES =
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};


    private static final boolean I_AM_DEBUGGING = false;



    public ElevensBoard() {
        super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
    }


    public ElevensBoard(int size, String[] ranks, String[] suits, int[] pointValues)
    {
        super(size, ranks, suits, pointValues);
    }


    @Override
    public boolean isLegal(List<Integer> selectedCards)
    {
        if(selectedCards.size() == 2 && containsPairSum11(selectedCards))
            return true;
        if(selectedCards.size() == 1 && containsJQK(selectedCards))
            return true;
        return false;
    }



    @Override
    public boolean anotherPlayIsPossible()
    {
        boolean a = false;
        boolean b = false;
        boolean c = false;
        for(int i = 0; i < BOARD_SIZE; i++)
        {
            if(cardAt(i).rank().equals("jack"))
                a = true;
            if(cardAt(i).rank().equals("queen"))
                b = true;
            if(cardAt(i).rank().equals("king"))
                c = true;
        }
        if(a && b && c)
            return true;
        for(int i = 0; i < BOARD_SIZE; i++)
        {
            for(int j = 0; i < BOARD_SIZE; i++)
            {
                if(j != i)
                    if(cardAt(i).pointValue() + cardAt(j).pointValue() == 11)
                        return true;
            }
        }
        return false;
    }


    private boolean containsPairSum11(List<Integer> selectedCards)
    {
        if(cardAt(selectedCards.get(0)).pointValue() + cardAt(selectedCards.get(1)).pointValue() == 11)
            return true;
        return false;
    }


    private boolean containsJQK(List<Integer> selectedCards)
    {
        boolean a = false;
        boolean b = false;
        boolean c = false;
        for(int i = 0; i < selectedCards.size(); i++)
        {
            if(cardAt(i).rank().equals("jack"))
                a = true;
            if(cardAt(i).rank().equals("queen"))
                b = true;
            if(cardAt(i).rank().equals("king"))
                c = true;
        }
        if(a && b && c)
            return true;
        return false;
    }
}

