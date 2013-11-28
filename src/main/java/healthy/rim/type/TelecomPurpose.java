package healthy.rim.type;import javax.xml.bind.annotation.XmlAccessType;import javax.xml.bind.annotation.XmlAccessorType;import javax.xml.bind.annotation.XmlEnum;import javax.xml.bind.annotation.XmlRootElement;import javax.xml.bind.annotation.XmlType;/** * Purpose of the communication equipment * * @author Yosvany Llerena Rodríguez <yosvanyllr@gmail.com> * @since 30-May-2013 */@XmlRootElement(name = "TelecomPurpose")@XmlAccessorType(XmlAccessType.FIELD)@XmlType(name = "TelecomPurpose")@XmlEnum(String.class)public enum TelecomPurpose {    /**     * Residential contact     */    RESIDENTIAL,    /**     * Business contact     */    BUSINESS,    /**     * Personal contact     */    PERSONAL;}