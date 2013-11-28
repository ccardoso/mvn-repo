/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package healthy.rim.type;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Adapater for a Timestamp and Date like data types.
 *
 * @author Yosvany Llerena Rodríguez <yosvanyllr@gmail.com>
 */
public class TimestampAdapter extends XmlAdapter<String, Date> {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss.SSS");

    @Override
    public String marshal(Date v) throws Exception {
        return dateFormat.format(v);
    }

    @Override
    public Date unmarshal(String v) throws Exception {
        return new Timestamp(dateFormat.parse(v).getTime());
    }
}
