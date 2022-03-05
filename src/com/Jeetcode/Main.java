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
        int playerShield;
        int playerStamina;
        boolean playerIsAlive;
        boolean playerMagicAbility;
        boolean playerShieldActivation;

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
        playerShield = 10;
        playerIsAlive = true;
        playerMagicAbility = true;
        playerShieldActivation = false;

        // STATS FOR MONSTER
        monsterName = "Jozha";
        monsterHealth = 10;
        monsterDamage = 2; // Light attack
        monsterSpeed = 4;
        monsterStamina = 12;
        monsterIsAlive = true;
        monsterDefense = 1;


        // STATS FOR GAME FUNCTIONS
        int turn = 0;

        System.out.println("FIGHT");

        // Svaki novi turn, turn se mora povecati za 1
        while (playerIsAlive == true && monsterIsAlive == true) {


            // Event 1

            turn = turnCounter(turn);


            monsterHealth = lightAttack(playerName, monsterName, playerStamina, monsterHealth, playerDamage);
            playerIsAlive = checkIfIsAlive(playerName, playerHealth, playerIsAlive);
            if (playerIsAlive == false) {
                break;
            }
            monsterIsAlive = checkIfIsAlive(monsterName, monsterHealth, monsterIsAlive);
            if (monsterIsAlive == false) {
                break;
            }
            System.out.println("=======================================");

            // Event 2

            turn = turnCounter(turn);

            if (playerShieldActivation == false) {
                playerHealth = heavyAttack(monsterName, playerName, monsterStamina, playerHealth, monsterDamage, playerShield, playerShieldActivation);
            } else if (playerShieldActivation == true) {
                playerShield = heavyAttack(monsterName, playerName, monsterStamina, playerHealth, monsterDamage, playerShield, playerShieldActivation);
            }
            playerIsAlive = checkIfIsAlive(playerName, playerHealth, playerIsAlive);
            if (playerIsAlive == false) {
                break;
            }
            monsterIsAlive = checkIfIsAlive(monsterName, monsterHealth, monsterIsAlive);
            if (monsterIsAlive == false) {
                break;
            }


            System.out.println("=======================================");

            // Event 3

            turn = turnCounter(turn);


            playerHealth = healMagic(playerName, playerMana, playerHealth);
            playerMana = healMagicCost(playerName, playerMana, playerHealth);

            playerIsAlive = checkIfIsAlive(playerName, playerHealth, playerIsAlive);
            if (playerIsAlive == false) {
                break;
            }


            System.out.println("=======================================");


            // Event 4

            turn = turnCounter(turn);


            monsterHealth = lightAttack(playerName, monsterName, playerStamina, monsterHealth, playerDamage);
            playerIsAlive = checkIfIsAlive(playerName, playerHealth, playerIsAlive);
            if (playerIsAlive == false) {
                break;
            }
            monsterIsAlive = checkIfIsAlive(monsterName, monsterHealth, monsterIsAlive);
            if (monsterIsAlive == false) {
                break;
            }


            System.out.println("=======================================");


            // Event 5

            turn = turnCounter(turn);


            playerHealth = heavyAttack(monsterName, playerName, monsterStamina, playerHealth, monsterDamage, playerShield, playerShieldActivation);
            playerIsAlive = checkIfIsAlive(playerName, playerHealth, playerIsAlive);
            if (playerIsAlive == false) {
                break;
            }
            monsterIsAlive = checkIfIsAlive(monsterName, monsterHealth, monsterIsAlive);
            if (monsterIsAlive == false) {
                break;
            }


            System.out.println("=======================================");


            // Event 6

            turn = turnCounter(turn);


            playerShieldActivation = blockAttack(playerName, playerShield, playerShieldActivation);
            playerIsAlive = checkIfIsAlive(playerName, playerHealth, playerIsAlive);
            if (playerIsAlive == false) {
                break;
            }
            monsterIsAlive = checkIfIsAlive(monsterName, monsterHealth, monsterIsAlive);
            if (monsterIsAlive == false) {
                break;
            }


            System.out.println("=======================================");


            // Event 7

            turn = turnCounter(turn);


            if (playerShieldActivation == false) {
                playerHealth = heavyAttack(monsterName, playerName, monsterStamina, playerHealth, monsterDamage, playerShield, playerShieldActivation);
            } else if (playerShieldActivation == true) {
                playerShield = heavyAttack(monsterName, playerName, monsterStamina, playerHealth, monsterDamage, playerShield, playerShieldActivation);
            }
            playerIsAlive = checkIfIsAlive(playerName, playerHealth, playerIsAlive);
            if (playerIsAlive == false) {
                break;
            }
            monsterIsAlive = checkIfIsAlive(monsterName, monsterHealth, monsterIsAlive);
            if (monsterIsAlive == false) {
                break;
            }

            playerShieldActivation = false;

            System.out.println("=======================================");


        }
    }


    //========================= G A M E   F U N C T I O N S =========================================

    public static int lightAttack(String attackerName, String defenderName, int attackerStamina, int defenderHealth, int attackerDamage) {
        System.out.println(attackerName + " Your turn! ");
        System.out.println(attackerName + " Tries to light attack " + defenderName);


        defenderHealth -= attackerDamage;


        System.out.println(defenderName + " lost " + attackerDamage + " Health points! ");
        System.out.println(defenderName + " now has " + defenderHealth + " Health points! ");

        return defenderHealth;


    }

    public static int heavyAttack(String attackerName, String defenderName, int attackerStamina, int defenderHealth, int attackerDamage, int defenderShield, boolean defenderShieldActivation) {

        if (defenderShieldActivation == true) {
            System.out.println(attackerName + " your turn! ");
            System.out.println(attackerName + " tries to heavy attack " + defenderName);

            System.out.println(defenderName + " Block attack with his shield!");

            defenderShield -= attackerDamage;

            System.out.println(defenderName + " lost " + (attackerDamage * 2) + " shield! ");
            System.out.println(defenderName + " now has " + defenderShield + " shield ");

            return defenderShield;


        } else {
            System.out.println(attackerName + " your turn! ");
            System.out.println(attackerName + " tries to heavy attack " + defenderName);

            defenderHealth -= (attackerDamage * 2);

            System.out.println(defenderName + " lost " + (attackerDamage * 2) + " health points! ");
            System.out.println(defenderName + " now has " + defenderHealth + " health points ");

            return defenderHealth;
        }


    }


    public static int healMagic(String playerName, int playerMana, int playerHealth) {

        System.out.println(playerName + " your turn! ");


        if (playerMana < 1 || playerHealth <= 0) {
            System.out.println(playerName + " Can't cast the spell ");
            return playerMana;
        } else {
            System.out.println(playerName + " Use health magic spell ");


            int healthMagic = playerHealth + 1;


            System.out.println(playerName + " Have healed himself with a magic ");
            System.out.println(playerName + " Has gain +1 HP ");
            System.out.println(playerName + " now has " + healthMagic + " health !");
            return healthMagic;
        }
    }


    public static int healMagicCost(String playerName, int playerMana, int playerHealth) {
        if (playerMana <= 0 || playerHealth <= 0) {
            System.out.println(playerName + " Don't have enough mana ");
            return playerHealth;
        } else {


            playerMana -= 1;

            System.out.println(playerName + " have " + playerMana + " mana ");

            return playerMana;
        }

    }

    public static int turnCounter(int turn) {
        turn += 1;

        System.out.println("Turn:" + turn);
        return turn;

    }


    public static boolean checkIfIsAlive(String subjectName, int subjectHealth, boolean subjectIsAlive) {


        if (subjectHealth <= 0) {
            System.out.println(subjectName + " is dead! ");
            return subjectIsAlive = false;
        } else {
            return subjectIsAlive = true;
        }
    }


    public static boolean blockAttack(String blockerName, int defenderShield, boolean blockerShieldActivaton) {

        if (defenderShield <= 0) {
            System.out.println(blockerName + " Don't have a shield to block attack! ");
            return blockerShieldActivaton = false;
        } else {


            System.out.println(blockerName + " is your turn ! ");

            System.out.println(blockerName + " Put his shield up for the next Attack! ");


            return blockerShieldActivaton = true;
        }


    }

}









