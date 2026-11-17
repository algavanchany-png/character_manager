
package com.unpri.charactermanager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.model.CharacterManager;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("     CHARACTER MANAGER SPRINT #2");
        System.out.println("======================================");

        // =================================
        // 1. MEMBUAT CHARACTER MANAGER
        // =================================

        CharacterManager manager = new CharacterManager();

        Character arthur = new Character(
                "Arthur", CharacterType.WARRIOR, 5);

        Character merlin = new Character(
                "Merlin", CharacterType.MAGE, 3);

        Character robin = new Character(
                "Robin", CharacterType.ARCHER, 4);

        Character morgana = new Character(
                "Morgana", CharacterType.MAGE, 6);

        // =================================
        // 2. ADD CHARACTER
        // =================================

        System.out.println("\n--- ADD CHARACTER ---");

        manager.addCharacter(arthur);
        manager.addCharacter(merlin);
        manager.addCharacter(robin);
        manager.addCharacter(morgana);

        // Menguji nama duplikat
        Character duplicate = new Character(
                "arthur", CharacterType.MAGE, 2);

        manager.addCharacter(duplicate);

        // =================================
        // 3. MENAMPILKAN SEMUA CHARACTER
        // =================================

        System.out.println("\n--- ALL CHARACTERS ---");

        for (Character character : manager.getAllCharacters()) {
            System.out.println(character);
        }

        System.out.println(
                "Total Character: " +
                manager.getTotalCharacters()
        );

        // =================================
        // 4. FIND BY NAME
        // =================================

        System.out.println("\n--- FIND BY NAME ---");

        Character result = manager.findByName("Merlin");

        if (result != null) {
            System.out.println("Ditemukan: " + result);
        } else {
            System.out.println("Karakter tidak ditemukan.");
        }

        // =================================
        // 5. REMOVE CHARACTER
        // =================================

        System.out.println("\n--- REMOVE CHARACTER ---");

        manager.removeCharacter("Robin");

        System.out.println(
                "Total setelah penghapusan: " +
                manager.getTotalCharacters()
        );

        // =================================
        // 6. MINI CHALLENGE
        // AVERAGE LEVEL
        // =================================

        System.out.println("\n--- AVERAGE LEVEL ---");

        System.out.println(
                "Rata-rata level: " +
                manager.getAverageLevel()
        );

        // Menguji kondisi list kosong
        CharacterManager emptyManager = new CharacterManager();

        System.out.println(
                "Rata-rata list kosong: " +
                emptyManager.getAverageLevel()
        );

        // =================================
        // 7. FIND BY TYPE
        // =================================

        System.out.println("\n--- FIND BY TYPE: MAGE ---");

        ArrayList<Character> mages =
                manager.findByType(CharacterType.MAGE);

        for (Character mage : mages) {
            System.out.println(mage);
        }

        // =================================
        // 8. FITUR MANDIRI
        // FIND STRONGEST
        // =================================

        System.out.println("\n--- STRONGEST CHARACTER ---");

        Character strongest = manager.findStrongest();

        if (strongest != null) {
            System.out.println(
                    "Karakter terkuat: " + strongest
            );
        }

        // =================================
        // 9. OBJECT REFERENCE EXPERIMENT
        // =================================

        System.out.println("\n--- REFERENCE EXPERIMENT ---");

        Character a = new Character(
                "ReferenceHero",
                CharacterType.WARRIOR,
                3
        );

        Character b = a;

        b.setLevel(8);

        System.out.println("Level a: " + a.getLevel());
        System.out.println("Level b: " + b.getLevel());
        System.out.println("a == b: " + (a == b));

        // Membuat objek independen
        Character independent = new Character(a);

        independent.setLevel(2);

        System.out.println(
                "\nSetelah membuat copy:"
        );

        System.out.println(
                "Level a: " + a.getLevel()
        );

        System.out.println(
                "Level independent: " +
                independent.getLevel()
        );

        System.out.println(
                "a == independent: " +
                (a == independent)
        );

        // =================================
        // 10. DEFENSIVE COPY EXPERIMENT
        // =================================

        System.out.println("\n--- DEFENSIVE COPY ---");

        ArrayList<Character> copy =
                manager.getAllCharacters();

        System.out.println(
                "Jumlah karakter asli: " +
                manager.getTotalCharacters()
        );

        // Menghapus isi salinan
        copy.clear();

        System.out.println(
                "Jumlah karakter salinan: " +
                copy.size()
        );

        System.out.println(
                "Jumlah karakter asli setelah copy dihapus: " +
                manager.getTotalCharacters()
        );

        // =================================
        // 11. STATIC COUNTER
        // =================================

        System.out.println("\n--- STATIC COUNTER ---");

        System.out.println(
                "Total objek Character dibuat: " +
                Character.getTotalCharacterCreated()
        );

        System.out.println("\n======================================");
        System.out.println("       PROGRAM SELESAI");
        System.out.println("======================================");
    }
}
