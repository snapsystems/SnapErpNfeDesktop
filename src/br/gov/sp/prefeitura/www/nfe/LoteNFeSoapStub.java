/**
 * LoteNFeSoapStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.gov.sp.prefeitura.www.nfe;

public class LoteNFeSoapStub extends org.apache.axis.client.Stub implements br.gov.sp.prefeitura.www.nfe.LoteNFeSoap {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[10];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("EnvioRPS");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.prefeitura.sp.gov.br/nfe", "EnvioRPSRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.prefeitura.sp.gov.br/nfe", ">EnvioRPSRequest"), br.gov.sp.prefeitura.www.nfe.EnvioRPSRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.prefeitura.sp.gov.br/nfe", ">EnvioRPSResponse"));
        oper.setReturnClass(br.gov.sp.prefeitura.www.nfe.EnvioRPSResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.prefeitura.sp.gov.br/nfe", "EnvioRPSResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("EnvioLoteRPS");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.prefeitura.sp.gov.br/nfe", "EnvioLoteRPSRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.prefeitura.sp.gov.br/nfe", ">EnvioLoteRPSRequest"), br.gov.sp.prefeitura.www.nfe.EnvioLoteRPSRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.prefeitura.sp.gov.br/nfe", ">EnvioLoteRPSResponse"));
        oper.setReturnClass(br.gov.sp.prefeitura.www.nfe.EnvioLoteRPSResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.prefeitura.sp.gov.br/nfe", "EnvioLoteRPSResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("TesteEnvioLoteRPS");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.prefeitura.sp.gov.br/nfe", "TesteEnvioLoteRPSRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.prefeitura.sp.gov.br/nfe", ">TesteEnvioLoteRPSRequest"), br.gov.sp.prefeitura.www.nfe.TesteEnvioLoteRPSRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.prefeitura.sp.gov.br/nfe", ">TesteEnvioLoteRPSResponse"));
        oper.setReturnClass(br.gov.sp.prefeitura.www.nfe.TesteEnvioLoteRPSResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.prefeitura.sp.gov.br/nfe", "TesteEnvioLoteRPSResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CancelamentoNFe");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.prefeitura.sp.gov.br/nfe", "CancelamentoNFeRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.prefeitura.sp.gov.br/nfe", ">CancelamentoNFeRequest"), br.gov.sp.prefeitura.www.nfe.CancelamentoNFeRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.prefeitura.sp.gov.br/nfe", ">CancelamentoNFeResponse"));
        oper.setReturnClass(br.gov.sp.prefeitura.www.nfe.CancelamentoNFeResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.prefeitura.sp.gov.br/nfe", "CancelamentoNFeResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ConsultaNFe");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.prefeitura.sp.gov.br/nfe", "ConsultaNFeRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.prefeitura.sp.gov.br/nfe", ">ConsultaNFeRequest"), br.gov.sp.prefeitura.www.nfe.ConsultaNFeRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.prefeitura.sp.gov.br/nfe", ">ConsultaNFeResponse"));
        oper.setReturnClass(br.gov.sp.prefeitura.www.nfe.ConsultaNFeResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.prefeitura.sp.gov.br/nfe", "ConsultaNFeResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ConsultaNFeRecebidas");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.prefeitura.sp.gov.br/nfe", "ConsultaNFeRecebidasRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.prefeitura.sp.gov.br/nfe", ">ConsultaNFeRecebidasRequest"), br.gov.sp.prefeitura.www.nfe.ConsultaNFeRecebidasRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.prefeitura.sp.gov.br/nfe", ">ConsultaNFeRecebidasResponse"));
        oper.setReturnClass(br.gov.sp.prefeitura.www.nfe.ConsultaNFeRecebidasResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.prefeitura.sp.gov.br/nfe", "ConsultaNFeRecebidasResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ConsultaNFeEmitidas");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.prefeitura.sp.gov.br/nfe", "ConsultaNFeEmitidasRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.prefeitura.sp.gov.br/nfe", ">ConsultaNFeEmitidasRequest"), br.gov.sp.prefeitura.www.nfe.ConsultaNFeEmitidasRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.prefeitura.sp.gov.br/nfe", ">ConsultaNFeEmitidasResponse"));
        oper.setReturnClass(br.gov.sp.prefeitura.www.nfe.ConsultaNFeEmitidasResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.prefeitura.sp.gov.br/nfe", "ConsultaNFeEmitidasResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ConsultaLote");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.prefeitura.sp.gov.br/nfe", "ConsultaLoteRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.prefeitura.sp.gov.br/nfe", ">ConsultaLoteRequest"), br.gov.sp.prefeitura.www.nfe.ConsultaLoteRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.prefeitura.sp.gov.br/nfe", ">ConsultaLoteResponse"));
        oper.setReturnClass(br.gov.sp.prefeitura.www.nfe.ConsultaLoteResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.prefeitura.sp.gov.br/nfe", "ConsultaLoteResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ConsultaInformacoesLote");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.prefeitura.sp.gov.br/nfe", "ConsultaInformacoesLoteRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.prefeitura.sp.gov.br/nfe", ">ConsultaInformacoesLoteRequest"), br.gov.sp.prefeitura.www.nfe.ConsultaInformacoesLoteRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.prefeitura.sp.gov.br/nfe", ">ConsultaInformacoesLoteResponse"));
        oper.setReturnClass(br.gov.sp.prefeitura.www.nfe.ConsultaInformacoesLoteResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.prefeitura.sp.gov.br/nfe", "ConsultaInformacoesLoteResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ConsultaCNPJ");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.prefeitura.sp.gov.br/nfe", "ConsultaCNPJRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.prefeitura.sp.gov.br/nfe", ">ConsultaCNPJRequest"), br.gov.sp.prefeitura.www.nfe.ConsultaCNPJRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.prefeitura.sp.gov.br/nfe", ">ConsultaCNPJResponse"));
        oper.setReturnClass(br.gov.sp.prefeitura.www.nfe.ConsultaCNPJResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.prefeitura.sp.gov.br/nfe", "ConsultaCNPJResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[9] = oper;

    }

    public LoteNFeSoapStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public LoteNFeSoapStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public LoteNFeSoapStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://www.prefeitura.sp.gov.br/nfe", ">CancelamentoNFeRequest");
            cachedSerQNames.add(qName);
            cls = br.gov.sp.prefeitura.www.nfe.CancelamentoNFeRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.prefeitura.sp.gov.br/nfe", ">CancelamentoNFeResponse");
            cachedSerQNames.add(qName);
            cls = br.gov.sp.prefeitura.www.nfe.CancelamentoNFeResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.prefeitura.sp.gov.br/nfe", ">ConsultaCNPJRequest");
            cachedSerQNames.add(qName);
            cls = br.gov.sp.prefeitura.www.nfe.ConsultaCNPJRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.prefeitura.sp.gov.br/nfe", ">ConsultaCNPJResponse");
            cachedSerQNames.add(qName);
            cls = br.gov.sp.prefeitura.www.nfe.ConsultaCNPJResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.prefeitura.sp.gov.br/nfe", ">ConsultaInformacoesLoteRequest");
            cachedSerQNames.add(qName);
            cls = br.gov.sp.prefeitura.www.nfe.ConsultaInformacoesLoteRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.prefeitura.sp.gov.br/nfe", ">ConsultaInformacoesLoteResponse");
            cachedSerQNames.add(qName);
            cls = br.gov.sp.prefeitura.www.nfe.ConsultaInformacoesLoteResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.prefeitura.sp.gov.br/nfe", ">ConsultaLoteRequest");
            cachedSerQNames.add(qName);
            cls = br.gov.sp.prefeitura.www.nfe.ConsultaLoteRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.prefeitura.sp.gov.br/nfe", ">ConsultaLoteResponse");
            cachedSerQNames.add(qName);
            cls = br.gov.sp.prefeitura.www.nfe.ConsultaLoteResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.prefeitura.sp.gov.br/nfe", ">ConsultaNFeEmitidasRequest");
            cachedSerQNames.add(qName);
            cls = br.gov.sp.prefeitura.www.nfe.ConsultaNFeEmitidasRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.prefeitura.sp.gov.br/nfe", ">ConsultaNFeEmitidasResponse");
            cachedSerQNames.add(qName);
            cls = br.gov.sp.prefeitura.www.nfe.ConsultaNFeEmitidasResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.prefeitura.sp.gov.br/nfe", ">ConsultaNFeRecebidasRequest");
            cachedSerQNames.add(qName);
            cls = br.gov.sp.prefeitura.www.nfe.ConsultaNFeRecebidasRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.prefeitura.sp.gov.br/nfe", ">ConsultaNFeRecebidasResponse");
            cachedSerQNames.add(qName);
            cls = br.gov.sp.prefeitura.www.nfe.ConsultaNFeRecebidasResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.prefeitura.sp.gov.br/nfe", ">ConsultaNFeRequest");
            cachedSerQNames.add(qName);
            cls = br.gov.sp.prefeitura.www.nfe.ConsultaNFeRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.prefeitura.sp.gov.br/nfe", ">ConsultaNFeResponse");
            cachedSerQNames.add(qName);
            cls = br.gov.sp.prefeitura.www.nfe.ConsultaNFeResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.prefeitura.sp.gov.br/nfe", ">EnvioLoteRPSRequest");
            cachedSerQNames.add(qName);
            cls = br.gov.sp.prefeitura.www.nfe.EnvioLoteRPSRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.prefeitura.sp.gov.br/nfe", ">EnvioLoteRPSResponse");
            cachedSerQNames.add(qName);
            cls = br.gov.sp.prefeitura.www.nfe.EnvioLoteRPSResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.prefeitura.sp.gov.br/nfe", ">EnvioRPSRequest");
            cachedSerQNames.add(qName);
            cls = br.gov.sp.prefeitura.www.nfe.EnvioRPSRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.prefeitura.sp.gov.br/nfe", ">EnvioRPSResponse");
            cachedSerQNames.add(qName);
            cls = br.gov.sp.prefeitura.www.nfe.EnvioRPSResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.prefeitura.sp.gov.br/nfe", ">TesteEnvioLoteRPSRequest");
            cachedSerQNames.add(qName);
            cls = br.gov.sp.prefeitura.www.nfe.TesteEnvioLoteRPSRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.prefeitura.sp.gov.br/nfe", ">TesteEnvioLoteRPSResponse");
            cachedSerQNames.add(qName);
            cls = br.gov.sp.prefeitura.www.nfe.TesteEnvioLoteRPSResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public br.gov.sp.prefeitura.www.nfe.EnvioRPSResponse envioRPS(br.gov.sp.prefeitura.www.nfe.EnvioRPSRequest parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.prefeitura.sp.gov.br/nfe/ws/envioRPS");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "EnvioRPS"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (br.gov.sp.prefeitura.www.nfe.EnvioRPSResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (br.gov.sp.prefeitura.www.nfe.EnvioRPSResponse) org.apache.axis.utils.JavaUtils.convert(_resp, br.gov.sp.prefeitura.www.nfe.EnvioRPSResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public br.gov.sp.prefeitura.www.nfe.EnvioLoteRPSResponse envioLoteRPS(br.gov.sp.prefeitura.www.nfe.EnvioLoteRPSRequest parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.prefeitura.sp.gov.br/nfe/ws/envioLoteRPS");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "EnvioLoteRPS"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (br.gov.sp.prefeitura.www.nfe.EnvioLoteRPSResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (br.gov.sp.prefeitura.www.nfe.EnvioLoteRPSResponse) org.apache.axis.utils.JavaUtils.convert(_resp, br.gov.sp.prefeitura.www.nfe.EnvioLoteRPSResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public br.gov.sp.prefeitura.www.nfe.TesteEnvioLoteRPSResponse testeEnvioLoteRPS(br.gov.sp.prefeitura.www.nfe.TesteEnvioLoteRPSRequest parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.prefeitura.sp.gov.br/nfe/ws/testeenvio");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "TesteEnvioLoteRPS"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (br.gov.sp.prefeitura.www.nfe.TesteEnvioLoteRPSResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (br.gov.sp.prefeitura.www.nfe.TesteEnvioLoteRPSResponse) org.apache.axis.utils.JavaUtils.convert(_resp, br.gov.sp.prefeitura.www.nfe.TesteEnvioLoteRPSResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public br.gov.sp.prefeitura.www.nfe.CancelamentoNFeResponse cancelamentoNFe(br.gov.sp.prefeitura.www.nfe.CancelamentoNFeRequest parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.prefeitura.sp.gov.br/nfe/ws/cancelamentoNFe");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "CancelamentoNFe"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (br.gov.sp.prefeitura.www.nfe.CancelamentoNFeResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (br.gov.sp.prefeitura.www.nfe.CancelamentoNFeResponse) org.apache.axis.utils.JavaUtils.convert(_resp, br.gov.sp.prefeitura.www.nfe.CancelamentoNFeResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public br.gov.sp.prefeitura.www.nfe.ConsultaNFeResponse consultaNFe(br.gov.sp.prefeitura.www.nfe.ConsultaNFeRequest parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.prefeitura.sp.gov.br/nfe/ws/consultaNFe");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "ConsultaNFe"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (br.gov.sp.prefeitura.www.nfe.ConsultaNFeResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (br.gov.sp.prefeitura.www.nfe.ConsultaNFeResponse) org.apache.axis.utils.JavaUtils.convert(_resp, br.gov.sp.prefeitura.www.nfe.ConsultaNFeResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public br.gov.sp.prefeitura.www.nfe.ConsultaNFeRecebidasResponse consultaNFeRecebidas(br.gov.sp.prefeitura.www.nfe.ConsultaNFeRecebidasRequest parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.prefeitura.sp.gov.br/nfe/ws/consultaNFeRecebidas");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "ConsultaNFeRecebidas"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (br.gov.sp.prefeitura.www.nfe.ConsultaNFeRecebidasResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (br.gov.sp.prefeitura.www.nfe.ConsultaNFeRecebidasResponse) org.apache.axis.utils.JavaUtils.convert(_resp, br.gov.sp.prefeitura.www.nfe.ConsultaNFeRecebidasResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public br.gov.sp.prefeitura.www.nfe.ConsultaNFeEmitidasResponse consultaNFeEmitidas(br.gov.sp.prefeitura.www.nfe.ConsultaNFeEmitidasRequest parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.prefeitura.sp.gov.br/nfe/ws/consultaNFeEmitidas");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "ConsultaNFeEmitidas"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (br.gov.sp.prefeitura.www.nfe.ConsultaNFeEmitidasResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (br.gov.sp.prefeitura.www.nfe.ConsultaNFeEmitidasResponse) org.apache.axis.utils.JavaUtils.convert(_resp, br.gov.sp.prefeitura.www.nfe.ConsultaNFeEmitidasResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public br.gov.sp.prefeitura.www.nfe.ConsultaLoteResponse consultaLote(br.gov.sp.prefeitura.www.nfe.ConsultaLoteRequest parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.prefeitura.sp.gov.br/nfe/ws/consultaLote");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "ConsultaLote"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (br.gov.sp.prefeitura.www.nfe.ConsultaLoteResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (br.gov.sp.prefeitura.www.nfe.ConsultaLoteResponse) org.apache.axis.utils.JavaUtils.convert(_resp, br.gov.sp.prefeitura.www.nfe.ConsultaLoteResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public br.gov.sp.prefeitura.www.nfe.ConsultaInformacoesLoteResponse consultaInformacoesLote(br.gov.sp.prefeitura.www.nfe.ConsultaInformacoesLoteRequest parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.prefeitura.sp.gov.br/nfe/ws/consultaInformacoesLote");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "ConsultaInformacoesLote"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (br.gov.sp.prefeitura.www.nfe.ConsultaInformacoesLoteResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (br.gov.sp.prefeitura.www.nfe.ConsultaInformacoesLoteResponse) org.apache.axis.utils.JavaUtils.convert(_resp, br.gov.sp.prefeitura.www.nfe.ConsultaInformacoesLoteResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public br.gov.sp.prefeitura.www.nfe.ConsultaCNPJResponse consultaCNPJ(br.gov.sp.prefeitura.www.nfe.ConsultaCNPJRequest parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.prefeitura.sp.gov.br/nfe/ws/consultaCNPJ");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "ConsultaCNPJ"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (br.gov.sp.prefeitura.www.nfe.ConsultaCNPJResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (br.gov.sp.prefeitura.www.nfe.ConsultaCNPJResponse) org.apache.axis.utils.JavaUtils.convert(_resp, br.gov.sp.prefeitura.www.nfe.ConsultaCNPJResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
