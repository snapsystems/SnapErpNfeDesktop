/**
 * ConsultaNFeRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.gov.sp.prefeitura.www.nfe;

public class ConsultaNFeRequest  implements java.io.Serializable {
    private int versaoSchema;

    private java.lang.String mensagemXML;

    public ConsultaNFeRequest() {
    }

    public ConsultaNFeRequest(
           int versaoSchema,
           java.lang.String mensagemXML) {
           this.versaoSchema = versaoSchema;
           this.mensagemXML = mensagemXML;
    }


    /**
     * Gets the versaoSchema value for this ConsultaNFeRequest.
     * 
     * @return versaoSchema
     */
    public int getVersaoSchema() {
        return versaoSchema;
    }


    /**
     * Sets the versaoSchema value for this ConsultaNFeRequest.
     * 
     * @param versaoSchema
     */
    public void setVersaoSchema(int versaoSchema) {
        this.versaoSchema = versaoSchema;
    }


    /**
     * Gets the mensagemXML value for this ConsultaNFeRequest.
     * 
     * @return mensagemXML
     */
    public java.lang.String getMensagemXML() {
        return mensagemXML;
    }


    /**
     * Sets the mensagemXML value for this ConsultaNFeRequest.
     * 
     * @param mensagemXML
     */
    public void setMensagemXML(java.lang.String mensagemXML) {
        this.mensagemXML = mensagemXML;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsultaNFeRequest)) return false;
        ConsultaNFeRequest other = (ConsultaNFeRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.versaoSchema == other.getVersaoSchema() &&
            ((this.mensagemXML==null && other.getMensagemXML()==null) || 
             (this.mensagemXML!=null &&
              this.mensagemXML.equals(other.getMensagemXML())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += getVersaoSchema();
        if (getMensagemXML() != null) {
            _hashCode += getMensagemXML().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConsultaNFeRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.prefeitura.sp.gov.br/nfe", ">ConsultaNFeRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("versaoSchema");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.prefeitura.sp.gov.br/nfe", "VersaoSchema"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mensagemXML");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.prefeitura.sp.gov.br/nfe", "MensagemXML"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
