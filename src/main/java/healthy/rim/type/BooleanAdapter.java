/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package healthy.rim.type;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author Yosvany Llerena Rodríguez <yosvanyllr@gmail.com>
 */
public class BooleanAdapter extends XmlAdapter<String, Boolean> {

    @Override
    public String marshal(Boolean v) throws Exception {
        return v ? "True" : "False";
    }

    @Override
    public Boolean unmarshal(String v) throws Exception {
        return Boolean.getBoolean(v);
    }
}
