import java.util.Scanner;
public class Game
{
    public static Boolean  food=false;
    public static Boolean firewood=false;
    public static Boolean water=false;


    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
//        Boolean food= false;
//        Boolean firewood=false;
//        Boolean water= false;

        Character zombie = new Character("Zombie", 1, 3, 10, 4);
        Character vampire = new Character("Vampire", 2, 4, 14, 7);
        Character bear = new Character("Bear", 3, 7, 20, 12);
        Character samurai = new Character("Samurai", 1, 5, 21, 15);
        Character archer = new Character("Archer", 2, 7, 18, 20);
        Character knight = new Character("Knight", 3, 8, 24, 5);
        Character[] player = {samurai, archer, knight};
        Character[] obstacle = { zombie, vampire, bear,zombie, vampire, bear};



        while (true)
        {
            System.out.println("Please select the character");
            System.out.println("1)Samurai \n2)Archer \n3)Knight");
            Character character = player[input.nextInt() - 1];
            System.out.println(character.getCharName());
            System.out.println(character.getCharName() + " is has " + character.getHealth() + " health.");
            System.out.println("Which location you prefer to go ");
            System.out.println("1)Safe house \n2)Tool store \n3)Forest \n4)Cave \n5)River");
            int selectLocation = input.nextInt();
            Location.selectedLoc(selectLocation, character, obstacle[selectLocation]);
            if(food && firewood && water )
            {
                System.out.println("You are win");
                System.exit(0);
            }

        }
    }





}
