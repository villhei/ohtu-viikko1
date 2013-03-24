/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.interfaces;

import java.util.ArrayList;

/**
 *
 * @author ville
 */
public interface KirjanpitoInterface {

    ArrayList<String> getTapahtumat();

    void lisaaTapahtuma(String tapahtuma);
    
}
