package healthy.rim.type;

import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * A dimensioned quantity expressing the result of a measurement act and formed
 * by a Value and his measure unit.
 *
 * @author Yosvany Llerena Rodríguez <yosvanyllr@gmail.com>
 * @since 23-Jan-2013
 */
@XmlRootElement(name = "PQ")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PQ", propOrder = {
    "value",
    "unit"
})
public class PQ extends RimDataType {

    @XmlElement(type = java.lang.Double.class, required = true)
    private double value;
    @XmlElement(type = java.lang.String.class, required = true)
    private String unit;

    public PQ() {
    }

    public PQ(double value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return (Double.toString(this.value) + " " + unit);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.value) ^ (Double.doubleToLongBits(this.value) >>> 32));
        hash = 17 * hash + Objects.hashCode(this.unit);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PQ other = (PQ) obj;
        if (Double.doubleToLongBits(this.value) != Double.doubleToLongBits(other.value)) {
            return false;
        }
        if (!Objects.equals(this.unit, other.unit)) {
            return false;
        }
        return true;
    }
}
