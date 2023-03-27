package com.quinsic.servicename.config;

import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.KeyUse;
import com.nimbusds.jose.jwk.RSAKey;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

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
    private static final String KEY_STORE_FILE_1 = "jwk/bael-jwt.jks";
    private static final String KEY_STORE_PASSWORD_1 = "bael-pass";
    private static final String KEY_ALIAS_1 = "bael-oauth-jwt";
    private static final String JWK_KID = "bael-key-id";

    private static final String KEY_STORE_FILE_2 = "jwk/rd-jwt.jks";
    private static final String KEY_STORE_PASSWORD_2 = "rd-pass";
    private static final String KEY_ALIAS_2 = "rd-oauth-jwt";
    private static final String JWK_KID_2 = "rd-key-id";

    @Bean
    public JWKSet jwkSet() {
        RSAKey.Builder key1 = new RSAKey.Builder((RSAPublicKey) keyPair1().getPublic())
                .keyUse(KeyUse.SIGNATURE)
                .algorithm(JWSAlgorithm.RS256)
                .keyID(JWK_KID);
        RSAKey.Builder key2 = new RSAKey.Builder((RSAPublicKey) keyPair2().getPublic())
                .keyUse(KeyUse.SIGNATURE)
                .algorithm(JWSAlgorithm.RS256)
                .keyID(JWK_KID_2);
        return new JWKSet(Arrays.asList(key1.build(), key2.build()));
    }

    @Bean
    public KeyPair keyPair1() {
        ClassPathResource ksFile = new ClassPathResource(KEY_STORE_FILE_1);
        KeyStoreKeyFactory ksFactory = new KeyStoreKeyFactory(ksFile, KEY_STORE_PASSWORD_1.toCharArray());
        return ksFactory.getKeyPair(KEY_ALIAS_1);
    }

    @Bean
    public KeyPair keyPair2() {
        ClassPathResource ksFile = new ClassPathResource(KEY_STORE_FILE_2);
        KeyStoreKeyFactory ksFactory = new KeyStoreKeyFactory(ksFile, KEY_STORE_PASSWORD_2.toCharArray());
        return ksFactory.getKeyPair(KEY_ALIAS_2);
    }
}
