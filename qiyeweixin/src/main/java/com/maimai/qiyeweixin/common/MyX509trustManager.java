package com.maimai.qiyeweixin.common;

import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * @program: springbootmaimai
 * @description:
 * @author: zxb
 * @create: 2020-03-05 12:01
 **/
public class MyX509trustManager implements X509TrustManager {
    @Override
    public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException { }

    @Override
    public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException { }

    @Override
    public X509Certificate[] getAcceptedIssuers() {  return null;  }
}

