
package com.unpri.charactermanager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.view.MainWindow;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        // Membuat CharacterManager
        CharacterManager manager = new CharacterManager();

        // Membuat lima karakter
        Character arthur = new Character(
                "Arthur",
                CharacterType.WARRIOR,
                5
        );

        Character merlin = new Character(
                "Merlin",
                CharacterType.MAGE,
                3
        );

        Character robin = new Character(
                "Robin",
                CharacterType.ARCHER,
                4
        );

        Character morgana = new Character(
                "Morgana",
                CharacterType.MAGE,
                6
        );

        Character athena = new Character(
                "Athena",
                CharacterType.ASSASSIN,
                7
        );

        // Menambahkan karakter ke manager
        manager.addCharacter(arthur);
        manager.addCharacter(merlin);
        manager.addCharacter(robin);
        manager.addCharacter(morgana);
        manager.addCharacter(athena);

        // Menjalankan GUI melalui Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {

            MainWindow window = new MainWindow(manager);

            window.setVisible(true);

        });
    }
}
