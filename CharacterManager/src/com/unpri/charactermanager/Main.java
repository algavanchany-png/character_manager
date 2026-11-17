
package com.unpri.charactermanager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.view.MainWindow;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        CharacterManager manager = new CharacterManager();

        // Warrior
        manager.addCharacter(
            new Character("Arthur", CharacterType.WARRIOR, 5)
        );

        manager.addCharacter(
            new Character("Gatotkaca", CharacterType.WARRIOR, 8)
        );

        manager.addCharacter(
            new Character("Leonidas", CharacterType.WARRIOR, 6)
        );

        // Mage
        manager.addCharacter(
            new Character("Merlin", CharacterType.MAGE, 3)
        );

        manager.addCharacter(
            new Character("Morgana", CharacterType.MAGE, 7)
        );

        manager.addCharacter(
            new Character("Albus", CharacterType.MAGE, 4)
        );

        // Archer
        manager.addCharacter(
            new Character("Athena", CharacterType.ARCHER, 9)
        );

        manager.addCharacter(
            new Character("Robin", CharacterType.ARCHER, 2)
        );

        // Launch application
        SwingUtilities.invokeLater(() -> {

            MainWindow window = new MainWindow(manager);

            window.setVisible(true);

        });
    }
}
