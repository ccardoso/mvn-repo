/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package healthy.rim.type;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author Carlos Cardoso <carlos.cardoso@maisis.pt>
 */
public class IntegerAdapter extends XmlAdapter<String, Integer> {

    @Override
    public String marshal(Integer v) throws Exception {
        return Integer.toString(v);
    }

    @Override
    public Integer unmarshal(String v) throws Exception {
        return Integer.parseInt(v);
    }
}
