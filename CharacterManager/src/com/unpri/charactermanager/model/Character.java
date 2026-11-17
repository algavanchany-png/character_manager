
package com.unpri.charactermanager.model;

import java.util.Objects;

public class Character {

    // Atribut
    private String name;
    private CharacterType type;
    private int level;
    private int hitPoints;
    private int attackPower;
    private int mana;

    // Menghitung jumlah objek Character yang dibuat
    private static int totalCharacterCreated = 0;

    // Constructor pertama
    public Character(String name, CharacterType type, int level) {
        this.name = name;
        this.type = type;
        setLevel(level);
        this.mana = 0;

        totalCharacterCreated++;
    }

    // Constructor kedua
    public Character(
            String name,
            CharacterType type,
            int level,
            int hitPoints,
            int attackPower,
            int mana) {

        this.name = name;
        this.type = type;
        this.level = level;
        this.hitPoints = hitPoints;
        this.attackPower = attackPower;
        setMana(mana);

        totalCharacterCreated++;
    }

    // Copy constructor
    public Character(Character other) {
        this(
                other.name,
                other.type,
                other.level,
                other.hitPoints,
                other.attackPower,
                other.mana
        );
    }

    // Getter dan setter Name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter dan setter Type
    public CharacterType getType() {
        return type;
    }

    public void setType(CharacterType type) {
        this.type = type;
    }

    // Getter dan setter Level
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {

        if (level < 1) {
            throw new IllegalArgumentException(
                    "Level minimal adalah 1."
            );
        }

        this.level = level;

        switch (type) {

            case WARRIOR:
                hitPoints = 150 + (level * 20);
                attackPower = 15 + (level * 5);
                break;

            case MAGE:
                hitPoints = 90 + (level * 10);
                attackPower = 30 + (level * 8);
                break;

            case ARCHER:
                hitPoints = 110 + (level * 15);
                attackPower = 25 + (level * 6);
                break;

            case ASSASSIN:
                hitPoints = 100 + (level * 12);
                attackPower = 35 + (level * 7);
                break;
        }
    }

    // Getter dan setter HP
    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {

        if (hitPoints < 0) {
            throw new IllegalArgumentException(
                    "HP tidak boleh negatif."
            );
        }

        this.hitPoints = hitPoints;
    }

    // Getter dan setter Attack Power
    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {

        if (attackPower < 0) {
            throw new IllegalArgumentException(
                    "Attack Power tidak boleh negatif."
            );
        }

        this.attackPower = attackPower;
    }

    // Getter dan setter Mana
    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {

        if (mana < 0) {
            throw new IllegalArgumentException(
                    "Mana tidak boleh negatif."
            );
        }

        this.mana = mana;
    }

    // Mengecek status hidup
    public boolean isAlive() {
        return hitPoints > 0;
    }

    // Level up
    public void levelUp() {
        setLevel(level + 1);
    }

    // Mengambil jumlah seluruh objek yang dibuat
    public static int getTotalCharacterCreated() {
        return totalCharacterCreated;
    }

    // Membandingkan karakter berdasarkan nama
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Character)) {
            return false;
        }

        Character other = (Character) obj;

        return Objects.equals(
                name == null ? null : name.toLowerCase(),
                other.name == null ? null : other.name.toLowerCase()
        );
    }

    // hashCode harus konsisten dengan equals
    @Override
    public int hashCode() {
        return Objects.hash(
                name == null ? null : name.toLowerCase()
        );
    }

    // Menampilkan informasi karakter
    @Override
    public String toString() {

        return "Character {" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", level=" + level +
                ", hitPoints=" + hitPoints +
                ", attackPower=" + attackPower +
                ", mana=" + mana +
                ", isAlive=" + isAlive() +
                '}';
    }
}
