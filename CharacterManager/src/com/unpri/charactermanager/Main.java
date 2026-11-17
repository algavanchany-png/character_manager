package com.unpri.charactermanager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;

public class Main {

    public static void main(String[] args) {

        System.out.println("==================================");
        System.out.println("      CHARACTER MANAGER TP3");
        System.out.println("==================================");

        // Membuat tiga karakter menggunakan constructor pertama
        Character warrior = new Character(
                "Arthur", CharacterType.WARRIOR, 5);

        Character mage = new Character(
                "Merlin", CharacterType.MAGE, 3);

        Character archer = new Character(
                "Robin", CharacterType.ARCHER, 4);

        // Menampilkan karakter awal
        System.out.println("\n--- DAFTAR KARAKTER ---");

        System.out.println(warrior);
        System.out.println(mage);
        System.out.println(archer);

        // Demonstrasi level up
        System.out.println("\n--- DEMO LEVEL UP ---");

        System.out.println("Sebelum level up:");
        System.out.println(warrior);

        warrior.levelUp();

        System.out.println("\nSesudah level up:");
        System.out.println(warrior);

        // Demonstrasi constructor kedua
        System.out.println("\n--- CONSTRUCTOR KEDUA ---");

        Character knight = new Character(
                "Leon",
                CharacterType.WARRIOR,
                3,
                250,
                40,
                50
        );

        System.out.println(knight);

        // Mini Challenge: Mana dan isAlive()
        System.out.println("\n--- MINI CHALLENGE ---");

        Character necro = new Character(
                "Morgana",
                CharacterType.MAGE,
                5
        );

        necro.setMana(100);

        System.out.println("Nama: " + necro.getName());
        System.out.println("Mana: " + necro.getMana());
        System.out.println("Apakah karakter hidup? "
                + necro.isAlive());

        System.out.println("\n--- SELESAI ---");
    }
}