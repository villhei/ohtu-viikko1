/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ville
 */
public class StatisticsTest {

    Statistics stats;
    Reader readerStub = new Reader() {
        @Override
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri", "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    @Before
    public void setUp() {
        stats = new Statistics(readerStub);
    }

    @Test
    public void testSearchSemenko() {
        String name = "Semenko";
        Player result = stats.search(name);

        assertEquals(name, result.getName());
    }

    @Test
    public void testSearchGretzky() {
        String name = "Gretzky";
        Player result = stats.search(name);

        assertEquals(name, result.getName());
    }

    @Test
    public void testSearchReturnsPlayer() {
        String name = "Gretzky";
        Player result = stats.search(name);
        assertEquals(true, result.getClass().equals(Player.class));
    }

    @Test
    public void testSearchNonExistant() {
        String name = "Kakka";
        Player result = stats.search(name);

        assertEquals(null, result);
    }

    @Test
    public void testTeamEdmonton() {
        List<Player> players = stats.team("EDM");
        assertEquals(true, listContains(players, "Semenko"));
        assertEquals(true, listContains(players, "Kurri"));
        assertEquals(true, listContains(players, "Gretzky"));

    }

    @Test
    public void testTeamEdmontonNoExtraPlayers() {
        List<Player> players = stats.team("EDM");
        assertEquals(false, listContains(players, "Lemieux"));
        assertEquals(false, listContains(players, "Yzerman"));

    }

    @Test
    public void testTeamReturnsArrayList() {
        List<Player> players = stats.team("EDM");
        assertEquals(true, players.getClass().equals(ArrayList.class));
    }

    private boolean listContains(List<Player> playerList, String name) {
        for (Player player : playerList) {
            if (player.getName().equals(name)) {
                return true;
            }

        }
        return false;
    }

    @Test
    public void testTopScorersBest() {
        List<Player> players = stats.topScorers(1);
        assertEquals("Gretzky", players.get(0).getName());
    }

    @Test
    public void testTopScorersAll() {
        List<Player> players = stats.topScorers(4);
        assertEquals("Gretzky", players.get(0).getName());
        assertEquals("Lemieux", players.get(1).getName());
        assertEquals("Yzerman", players.get(2).getName());
        assertEquals("Kurri", players.get(3).getName());
        assertEquals("Semenko", players.get(4).getName());
    }


    @Test
    public void testTopScorers() {
        System.out.println("topScorers");
        int howMany = 3;
        String expResult = "Gretzky";
        List<Player> result = this.stats.topScorers(howMany);
        assertEquals(expResult, result.get(0).getName());
    }
}