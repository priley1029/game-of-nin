import java.util.Scanner;
public class gameOfNin
{
//this section of the code gets thew number that the computer chooses by using .random//
    public int getComputerMove(int left)
    {
        int compTurn = (int)(Math.random()*2)+1;
        return compTurn;
    }
//this creates a new game//
    public static void main(String args[])
    {
        gameOfNin gon = new gameOfNin();
        gon.play();
    }

    public void play()
    {
        //this shows the begining of a new game with a prompt, it also lets the user set the ammount of elements they want with a scanner//
        try (Scanner scan = new Scanner(System.in)) 
        {
            System.out.println("you are playing the game on nin, enter your number of elements.");
            int leftOver = scan.nextInt();
            //the computer move is subtracted from the total ammount of game elements//
            while (leftOver>0)
            {
                int computerMove = getComputerMove(leftOver);
                System.out.println("Computer chooses" + computerMove);
                leftOver = leftOver - computerMove;
                System.out.println("There are only" + leftOver + " left");
                //If the computer gets the last element, it wins the game//
                if(leftOver <= 0)
                {
                    System.out.println("Computer wins!");
                    return;
                }
                //this is the start of the user input//
                System.out.println("It is your turn: Pick 1 or 2");
                int userMove = scan.nextInt();
                //this section is used to make sutre they use avalif input//
                while (userMove != 1 && userMove != 2)
                {
                    System.out.println("Pick only 1 or 2");
                    userMove = scan.nextInt();
                }
                leftOver = leftOver - userMove;
                System.out.println("after your move there are only" + leftOver + " left");
                //the user wins if they get the last element off the board//
                if (leftOver <= 0)
                {
                    System.out.println("You Win!");
                }

            }
        }
    }

}