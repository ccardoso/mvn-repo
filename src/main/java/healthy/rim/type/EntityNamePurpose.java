package healthy.rim.type;import javax.xml.bind.annotation.XmlAccessType;import javax.xml.bind.annotation.XmlAccessorType;import javax.xml.bind.annotation.XmlEnum;import javax.xml.bind.annotation.XmlRootElement;import javax.xml.bind.annotation.XmlType;/** * The purpose for the Entity Name * * @author Yosvany Llerena Rodríguez <yosvanyllr@gmail.com> * @since 30-May-2013 */@XmlRootElement(name = "EntityNamePurpose")@XmlAccessorType(XmlAccessType.FIELD)@XmlType(name = "EntityNamePurpose")@XmlEnum(String.class)public enum EntityNamePurpose {    /**     * For mailing letters     */    MAILING,    /**     * On Writing Cheques     */    CHEQUES,    /**     * Other correspondence documents     */    CORRESPONDENCE;}