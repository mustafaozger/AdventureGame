import java.util.Scanner;
public class Location
{
    public static int numEnemy;


    public static void selectedLoc(int selectLoc,Character player, Character enemy )
    {

        if(selectLoc==1)
            safeHouse(player);
        else if (selectLoc==2)
            ToolStore(player);
        else if(selectLoc==3)
            Forest(player,enemy);
        else if(selectLoc==4)
            Cave(player,enemy);
        else if (selectLoc==5)
            River(player,enemy);
        else
            System.out.println("entered wrong number");

    }

    public static void safeHouse(Character player )
    {
        player.setHealth(player.getTotalHealth());
        System.out.println("Your health is restored");
        System.out.println("Your new health is " + player.getHealth());

    }
    public static void ToolStore(Character player)
    {
        Scanner input = new Scanner(System.in);
        int[] priceGun = {0,25,35,45};
        int[] damageEffect = {0,2,3,7};
        int[] priceArmor = {0,15,25,40};
        int[] effectArmor = {0,1,3,5};
        System.out.println("1)Guns \n2)Armor");
        switch (input.nextInt())
        {
            case 1:
            {
                System.out.println("1)Gun  :  +2 Damage" + priceGun[1] +"$");
                System.out.println("2)Sword  :  +3 Damage" + priceGun[2] +"$");
                System.out.println("3)Rifle  :  +7 Damage " + priceGun[3] +"$");
                int selectGun = input.nextInt();
                if(player.getMoney()> priceGun[selectGun])
                {
                    player.setMoney(player.getMoney()- priceGun[selectGun]);
                    player.setDamage(player.getDamage()+ damageEffect[selectGun]);
                }
                else
                {
                    System.out.println("You don't have enough money");
                }break;
            }
            case 2:
            {
                System.out.println("1)Light :  +1 extra health   " + priceArmor[1] +"$");
                System.out.println("2)Medium :  +3 extra health   " + priceArmor[2] +"$");
                System.out.println("1)Heavy :  +5 extra health   " + priceArmor[3] +"$");
                int selectArmor = input.nextInt();
                if (player.getMoney()>priceArmor[selectArmor])
                {
                    player.setTotalHealth(player.getTotalHealth()+effectArmor[selectArmor]);
                    player.setMoney(player.getMoney()-priceArmor[selectArmor]);
                }
                else
                {
                    System.out.println("You don't have enough money");
                }break;
            }
            default:
                System.out.println("You write wrong value");

        }



    }
    public static void Forest(Character player, Character enemy )
    {
        boolean isCollect =false;
        fight(player,enemy,isCollect);
        if(isCollect)
            Game.food=true;

    }
    public static void Cave(Character player, Character enemy )
    {
        boolean isCollect =false;
        fight(player,enemy,isCollect);
        if(isCollect)
            Game.firewood=true;
    }


    public static void River(Character player, Character enemy )
    {
        boolean isCollect =false;
        fight(player,enemy,isCollect);
        if(isCollect)
            Game.water=true;
    }
    public static void fight(Character player, Character enemy , Boolean isCollect)
    {
        isCollect=false;
        Scanner input = new Scanner(System.in);
        System.out.print("Your health is " + player.getHealth() + " . Do you want to fight? Yes or No:");
        String slct = input.next().toLowerCase();
        if(slct.equals("yes"))
        {

            numEnemy=0;
            numEnemy = (int) (Math.random() * 3) +1;
            while (numEnemy>0)
            {
                enemy.setHealth(enemy.getTotalHealth());
                while (enemy.getHealth()>0||player.getHealth()<0)
                {
                    enemy.setHealth(enemy.getHealth()- player.getDamage());
                    if (enemy.getHealth()<0 || player.getHealth()<0)
                    {
                        continue;
                    }
                    player.setHealth(player.getHealth() - enemy.getDamage());
                    System.out.println(enemy.getCharName() + "'s remaining health  " + enemy.getHealth());
                    if(player.getHealth()<0){
                        System.out.println("You are died");
                        System.exit(0);
                    }
                    System.out.println("Your remaining health is "+ player.getHealth());
                }
                if(player.getHealth()<0){
                    System.out.println("You are died");
                    System.exit(0);
                }
                System.out.println(enemy.getCharName() + " is died ");
                numEnemy--;
            }
            isCollect=true;
        }


    }

}
