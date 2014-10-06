/**
 * ConsultaInformacoesLoteResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.gov.sp.prefeitura.www.nfe;

public class ConsultaInformacoesLoteResponse  implements java.io.Serializable {
    private java.lang.String retornoXML;

    public ConsultaInformacoesLoteResponse() {
    }

    public ConsultaInformacoesLoteResponse(
           java.lang.String retornoXML) {
           this.retornoXML = retornoXML;
    }


    /**
     * Gets the retornoXML value for this ConsultaInformacoesLoteResponse.
     * 
     * @return retornoXML
     */
    public java.lang.String getRetornoXML() {
        return retornoXML;
    }


    /**
     * Sets the retornoXML value for this ConsultaInformacoesLoteResponse.
     * 
     * @param retornoXML
     */
    public void setRetornoXML(java.lang.String retornoXML) {
        this.retornoXML = retornoXML;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsultaInformacoesLoteResponse)) return false;
        ConsultaInformacoesLoteResponse other = (ConsultaInformacoesLoteResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.retornoXML==null && other.getRetornoXML()==null) || 
             (this.retornoXML!=null &&
              this.retornoXML.equals(other.getRetornoXML())));
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
        if (getRetornoXML() != null) {
            _hashCode += getRetornoXML().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConsultaInformacoesLoteResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.prefeitura.sp.gov.br/nfe", ">ConsultaInformacoesLoteResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("retornoXML");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.prefeitura.sp.gov.br/nfe", "RetornoXML"));
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
