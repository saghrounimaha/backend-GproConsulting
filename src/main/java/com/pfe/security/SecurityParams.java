package com.pfe.security;

public interface SecurityParams {
     String JWT_HEADER_NAME="Authorization";
  String SECRET="mahasaghrouni";
   long EXPIRATION=1000*24*3600;
   //duré de vie de tocken
   String HEADER_PREFIX="Bearer ";
}
