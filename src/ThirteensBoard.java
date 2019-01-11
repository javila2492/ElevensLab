import java.util.List;
import java.util.ArrayList;


public class ThirteensBoard extends Board
{


    private static final int BOARD_SIZE = 10;


    private static final String[] RANKS =
            {"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};


    private static final String[] SUITS =
            {"spades", "hearts", "diamonds", "clubs"};


    private static final int[] POINT_VALUES =
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};


    private static final boolean I_AM_DEBUGGING = false;



    public ThirteensBoard() {
        super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
    }


    public ThirteensBoard(int size, String[] ranks, String[] suits, int[] pointValues)
    {
        super(size, ranks, suits, pointValues);
    }


    @Override
    public boolean isLegal(List<Integer> selectedCards)
    {
        if(selectedCards.size() == 2 && containsPairSum13(selectedCards))
            return true;
        if(selectedCards.size() == 1 && containsK(selectedCards))
            return true;
        return false;
    }



    @Override
    public boolean anotherPlayIsPossible()
    {
        boolean a = false;
        for(int i = 0; i < 10; i++)
        {
            if(cardAt(i).rank().equals("king"))
                a = true;
        }
        if(a)
            return true;
        for(int i = 0; i < 10; i++)
        {
            for(int j = 0; i < 10; i++)
            {
                if(j != i)
                    if(cardAt(i).pointValue() + cardAt(j).pointValue() == 13)
                        return true;
            }
        }
        return false;
    }


    private boolean containsPairSum13(List<Integer> selectedCards)
    {
        if(cardAt(selectedCards.get(0)).pointValue() + cardAt(selectedCards.get(1)).pointValue() == 13)
            return true;
        return false;
    }


    private boolean containsK(List<Integer> selectedCards)
    {
        if(selectedCards.size() != 1)
            return false;
        boolean a = false;
        for(Integer i : selectedCards)
        {
            if(cardAt(i).rank().equals("king"))
                a = true;
        }
        if(a)
            return true;
        return false;
    }
}

