package com.pdi.tests.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;

public class TokenManipulation {
    private static final String SECRET = Manipulation.getProp().getProperty("JWT_SECRET");

    public static DecodedJWT decodeToken(String token) {
        return JWT.decode(token);
    }

    // TODO: futuramente adaptar para estar com o mesmo algoritmo usado pelo time de dev
    public static Boolean validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            JWT.require(algorithm).build().verify(token);
            return true;
        } catch (JWTVerificationException exception){
            return false;
        }
    }

    public static Boolean isTheExpectedRole(String token, String expectedRole) {
        DecodedJWT jwt = decodeToken(token);
        String role = jwt.getClaim("cargos").asList(String.class).get(0);

        System.out.println("Role: " + role);

        return expectedRole.equals(role);
    }
}