/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.interfaces;

import ohtu.verkkokauppa.Tuote;
import ohtu.verkkokauppa.Tuote;

/**
 *
 * @author ville
 */
public interface VarastoInterface {

    Tuote haeTuote(int id);

    void otaVarastosta(Tuote t);

    void palautaVarastoon(Tuote t);

    int saldo(int id);
    
}
