package com.Jeetcode;

public class Main {

    public static void main(String[] args) {
        // player to smo mi,
        // Monster to je comp,
        // Radnje je combat,
        //Igrica traje dok netko nije porazen.

        //Player

        String playerName;
        int playerHealth;
        int playerMana;
        int playerDefense;
        int playerDamage;
        int playerSpeed;
        int playerStamina;
        boolean playerIsAlive;

        // Monster
        String monsterName;
        int monsterHealth;
        int monsterDefense;
        int monsterDamage;
        int monsterSpeed;
        int monsterStamina;
        boolean monsterIsAlive;

        // Light-attack, heavy-attack, defense, counter-attack, dodge, run-away, stamina-potion, wait...

        // STATS FOR PLAYER
        playerName = "Tvrtko";
        playerHealth = 10;
        playerMana = 5;
        playerDefense = 2;
        playerDamage = 2;
        playerSpeed = 3;
        playerStamina = 10;
        playerIsAlive = true;

        // STATS FOR MONSTER
        monsterName = "Jozha";
        monsterHealth = 10;
        monsterDamage = 2; // Light attack
        monsterSpeed = 4;
        monsterStamina = 12;
        monsterIsAlive = true;


        // STATS FOR GAME FUNCTIONS
        int turn = 0;

        System.out.println("FIGHT");

        // Svaki novi turn, turn se mora povecati za 1
        while (playerIsAlive == true && monsterIsAlive == true) {

            // Event 1

            turn += 1;
            System.out.println("Turn:" + turn);


            monsterHealth = lightAttack(playerName, monsterName, playerStamina, monsterHealth, playerDamage);


            System.out.println("=======================================");

            // Event 2

            turn += 1;
            System.out.println("Turn" + turn);


            playerHealth = heavyAttack(monsterName, playerName, monsterStamina, playerHealth, monsterDamage);


            System.out.println("=======================================");

            // Event 3

            turn += 1;
            System.out.println("Turn:" + turn);

            System.out.println(playerName + " your turn! ");
            System.out.println(playerName + " tries to defend! ");


            System.out.println("=======================================");


            if (playerHealth <= 0) {
                playerIsAlive = false;
                System.out.println(playerName + " is dead! ");
            } else if (monsterHealth <= 0) {
                monsterIsAlive = false;
                System.out.println(monsterName + " is dead ");
                System.out.println(monsterName + " will be back! ");

            }


        }
    }


    //========================= G A M E   F U N C T I O N S =========================================

    public static int lightAttack(String attackerName, String defenderName, int attackerStamina, int defenderHealth, int attackerDamage) {
        System.out.println(attackerName + " Your turn! ");
        System.out.println(attackerName + " Tries to light attack " + defenderName);
        int result;


        result = defenderHealth - attackerDamage;


        System.out.println(defenderName + " lost " + attackerDamage + " Health points! ");
        System.out.println(defenderName + " now has " + result + " Health points! ");

        return result;


    }

    public static int heavyAttack(String attackerName, String defenderName, int attackerStamina, int defenderHealth, int attackerDamage) {
        System.out.println(attackerName + " your turn! ");
        System.out.println(attackerName + " tries to heavy attack " + defenderName);


        int result;
        result = defenderHealth - (attackerDamage * 2);

        System.out.println(defenderName + " lost " + attackerDamage * 2 + " health points! ");
        System.out.println(defenderName + " now has " + result + " health points!");

        return result;

    }

}


