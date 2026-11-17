
package com.unpri.charactermanager.model;

import java.util.ArrayList;

public class CharacterManager {

    // Menyimpan daftar karakter
    private ArrayList<Character> characters;

    // Constructor
    public CharacterManager() {
        characters = new ArrayList<>();
    }

    // Menambahkan karakter dan menolak nama duplikat
    public boolean addCharacter(Character character) {

        if (character == null) {
            throw new IllegalArgumentException(
                    "Karakter tidak boleh null."
            );
        }

        if (characters.contains(character)) {
            System.out.println(
                    "[DITOLAK] Karakter dengan nama " +
                    character.getName() + " sudah terdaftar."
            );

            return false;
        }

        characters.add(character);

        System.out.println(
                "[BERHASIL] " + character.getName() +
                " berhasil ditambahkan."
        );

        return true;
    }

    // Mencari karakter berdasarkan nama
    public Character findByName(String name) {

        for (Character character : characters) {

            if (character.getName().equalsIgnoreCase(name)) {
                return new Character(character);
            }
        }

        return null;
    }

    // Menghapus karakter berdasarkan nama
    public boolean removeCharacter(String name) {

        for (int i = 0; i < characters.size(); i++) {

            if (characters.get(i).getName()
                    .equalsIgnoreCase(name)) {

                characters.remove(i);

                System.out.println(
                        "[BERHASIL] " + name +
                        " berhasil dihapus."
                );

                return true;
            }
        }

        System.out.println(
                "[GAGAL] Karakter " + name +
                " tidak ditemukan."
        );

        return false;
    }

    // Mengambil jumlah karakter
    public int getTotalCharacters() {
        return characters.size();
    }

    // Mengembalikan salinan daftar karakter
    public ArrayList<Character> getAllCharacters() {

        ArrayList<Character> copy = new ArrayList<>();

        for (Character character : characters) {
            copy.add(new Character(character));
        }

        return copy;
    }

    // MINI CHALLENGE 1
    // Menghitung rata-rata level karakter
    public double getAverageLevel() {

        if (characters.isEmpty()) {
            return 0.0;
        }

        int totalLevel = 0;

        for (Character character : characters) {
            totalLevel += character.getLevel();
        }

        return (double) totalLevel / characters.size();
    }

    // MINI CHALLENGE 2
    // Mencari semua karakter berdasarkan jenis
    public ArrayList<Character> findByType(CharacterType type) {

        ArrayList<Character> result = new ArrayList<>();

        for (Character character : characters) {

            if (character.getType() == type) {
                result.add(new Character(character));
            }
        }

        return result;
    }

    /**
     * Mencari karakter dengan attack power tertinggi.
     * Mengembalikan salinan karakter agar data internal
     * tidak dapat diubah secara langsung.
     *
     * @return karakter dengan attack tertinggi,
     *         atau null jika daftar kosong.
     */
    public Character findStrongest() {

        if (characters.isEmpty()) {
            return null;
        }

        Character strongest = characters.get(0);

        for (Character character : characters) {

            if (character.getAttackPower()
                    > strongest.getAttackPower()) {

                strongest = character;
            }
        }

        return new Character(strongest);
    }
}
