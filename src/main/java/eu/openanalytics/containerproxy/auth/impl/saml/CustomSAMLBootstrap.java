package eu.openanalytics.containerproxy.auth.impl.saml;

import org.springframework.security.saml.SAMLBootstrap;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.BeansException;
import org.opensaml.xml.security.BasicSecurityConfiguration;
import org.opensaml.xml.Configuration;
import org.opensaml.xml.signature.SignatureConstants;

public final class CustomSAMLBootstrap extends SAMLBootstrap {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        super.postProcessBeanFactory(beanFactory);
        BasicSecurityConfiguration config = (BasicSecurityConfiguration) Configuration.getGlobalSecurityConfiguration();
        config.registerSignatureAlgorithmURI("RSA", SignatureConstants.ALGO_ID_SIGNATURE_RSA_SHA256);
        config.setSignatureReferenceDigestMethod(SignatureConstants.ALGO_ID_DIGEST_SHA256);
    }
}
