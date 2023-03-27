package com.quinsic.servicename.config;

import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.KeyUse;
import com.nimbusds.jose.jwk.RSAKey;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import java.lang.reflect.Array;
import java.security.KeyPair;
import java.security.interfaces.RSAPublicKey;
import java.util.Arrays;

/**
 * This class is to centralize all the
 * JWK (a JSON object that represents a cryptographic key)
 * configuration bean here.
 * ref: <a href="https://www.baeldung.com/spring-security-oauth2-jws-jwk#5-creating-a-keystore-file">...</a>
 */
@Configuration
public class JwksConfig {
    private static final String KEY_STORE_FILE = "jwk/bael-jwt.jks";
    private static final String KEY_STORE_PASSWORD = "bael-pass";
    private static final String KEY_ALIAS = "bael-oauth-jwt";
    private static final String JWK_KID = "bael-key-id";

    private static final String KEY_STORE_FILE_2 = "jwk/rd-jwt.jks";
    private static final String KEY_STORE_PASSWORD_2 = "rd-pass";
    private static final String KEY_ALIAS_2 = "rd-oauth-jwt";
    private static final String JWK_KID_2 = "rd-key-id";

    @Bean
    public JWKSet jwkSet() {
        RSAKey.Builder builder = new RSAKey.Builder((RSAPublicKey) keyPair().getPublic())
                .keyUse(KeyUse.SIGNATURE)
                .algorithm(JWSAlgorithm.RS256)
                .keyID(JWK_KID);
        RSAKey.Builder builder2 = new RSAKey.Builder((RSAPublicKey) keyPair2().getPublic())
                .keyUse(KeyUse.SIGNATURE)
                .algorithm(JWSAlgorithm.RS256)
                .keyID(JWK_KID_2);
        return new JWKSet(Arrays.asList(builder.build(), builder2.build()));
    }

    @Bean
    public KeyPair keyPair() {
        ClassPathResource ksFile = new ClassPathResource(KEY_STORE_FILE);
        KeyStoreKeyFactory ksFactory = new KeyStoreKeyFactory(ksFile, KEY_STORE_PASSWORD.toCharArray());
        return ksFactory.getKeyPair(KEY_ALIAS);
    }

    @Bean
    public KeyPair keyPair2() {
        ClassPathResource ksFile = new ClassPathResource(KEY_STORE_FILE_2);
        KeyStoreKeyFactory ksFactory = new KeyStoreKeyFactory(ksFile, KEY_STORE_PASSWORD_2.toCharArray());
        return ksFactory.getKeyPair(KEY_ALIAS_2);
    }
}
