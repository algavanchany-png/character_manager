package com.unpri.charactermanager.model;

public class Character {

    // Atribut
    private String name;
    private CharacterType type;
    private int level;
    private int hitPoints;
    private int attackPower;
    private int mana;

    // Constructor pertama
    // Menghitung HP dan attack berdasarkan level dan jenis karakter
    public Character(String name, CharacterType type, int level) {
        this.name = name;
        this.type = type;
        setLevel(level);
        this.mana = 0;
    }

    // Constructor kedua
    // Mengisi seluruh atribut secara langsung
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
    }

    // Getter dan setter name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter dan setter type
    public CharacterType getType() {
        return type;
    }

    public void setType(CharacterType type) {
        this.type = type;
    }

    // Getter dan setter level
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {

        if (level < 1) {
            throw new IllegalArgumentException(
                    "Level harus minimal 1.");
        }

        this.level = level;

        // Perhitungan otomatis berdasarkan jenis karakter
        switch (type) {
            case WARRIOR:
                this.hitPoints = 150 + (level * 20);
                this.attackPower = 15 + (level * 5);
                break;

            case MAGE:
                this.hitPoints = 90 + (level * 10);
                this.attackPower = 30 + (level * 8);
                break;

            case ARCHER:
                this.hitPoints = 110 + (level * 15);
                this.attackPower = 25 + (level * 6);
                break;

            case ASSASSIN:
                this.hitPoints = 100 + (level * 12);
                this.attackPower = 35 + (level * 7);
                break;
        }
    }

    // Getter HP
    public int getHitPoints() {
        return hitPoints;
    }

    // Setter HP
    public void setHitPoints(int hitPoints) {
        if (hitPoints < 0) {
            throw new IllegalArgumentException(
                    "Hit Points tidak boleh negatif.");
        }

        this.hitPoints = hitPoints;
    }

    // Getter Attack Power
    public int getAttackPower() {
        return attackPower;
    }

    // Setter Attack Power
    public void setAttackPower(int attackPower) {
        if (attackPower < 0) {
            throw new IllegalArgumentException(
                    "Attack Power tidak boleh negatif.");
        }

        this.attackPower = attackPower;
    }

    // Getter Mana
    public int getMana() {
        return mana;
    }

    // Setter Mana dengan validasi
    public void setMana(int mana) {
        if (mana < 0) {
            throw new IllegalArgumentException(
                    "Mana tidak boleh negatif.");
        }

        this.mana = mana;
    }

    // Mengecek apakah karakter masih hidup
    public boolean isAlive() {
        return hitPoints > 0;
    }

    // Menaikkan level karakter
    public void levelUp() {
        setLevel(this.level + 1);
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