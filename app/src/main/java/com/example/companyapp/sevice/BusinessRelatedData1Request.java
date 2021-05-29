package com.example.companyapp.sevice;

import com.google.gson.annotations.SerializedName;
import com.squareup.moshi.Json;

public class BusinessRelatedData1Request {


 @SerializedName("token")
 String tokenType;
 @SerializedName( "expires_in")
 int expiresIn;
 @SerializedName("access_token")
 String accessToken;
 @SerializedName( "refresh_token")
 String refreshToken;

 @SerializedName("companyname")
  String companyname;
  @SerializedName("commercialname")
  String commercialname;
  @SerializedName("acronym")
  String acronym ;
  @SerializedName("businessactivity")
  String businessactivity;
  @SerializedName("businessactivity2")
  String businessactivity2;
  @SerializedName("businessactivity3")
  String businessactivity3;
  @SerializedName("businessactivity4")
  String businessactivity4;
  @SerializedName("authtoken")
  String authtoken;


 public String getTokenType() {
  return tokenType;
 }

 public void setTokenType(String tokenType) {
  this.tokenType = tokenType;
 }

 public int getExpiresIn() {
  return expiresIn;
 }

 public void setExpiresIn(int expiresIn) {
  this.expiresIn = expiresIn;
 }

 public String getAccessToken() {
  return accessToken;
 }

 public void setAccessToken(String accessToken) {
  this.accessToken = accessToken;
 }

 public String getRefreshToken() {
  return refreshToken;
 }

 public void setRefreshToken(String refreshToken) {
  this.refreshToken = refreshToken;
 }

 public String getCompanyname() {
  return companyname;
 }

 public void setCompanyname(String companyname) {
  this.companyname = companyname;
 }

 public String getCommercialname() {
  return commercialname;
 }

 public void setCommercialname(String commercialname) {
  this.commercialname = commercialname;
 }

 public String getAcronym() {
  return acronym;
 }

 public void setAcronym(String acronym) {
  this.acronym = acronym;
 }

 public String getBusinessactivity() {
  return businessactivity;
 }

 public void setBusinessactivity(String businessactivity) {
  this.businessactivity = businessactivity;
 }

 public String getBusinessactivity2() {
  return businessactivity2;
 }

 public void setBusinessactivity2(String businessactivity2) {
  this.businessactivity2 = businessactivity2;
 }

 public String getBusinessactivity3() {
  return businessactivity3;
 }

 public void setBusinessactivity3(String businessactivity3) {
  this.businessactivity3 = businessactivity3;
 }

 public String getBusinessactivity4() {
  return businessactivity4;
 }

 public void setBusinessactivity4(String businessactivity4) {
  this.businessactivity4 = businessactivity4;
 }

 public String getAuthtoken() {
  return authtoken;
 }

 public void setAuthtoken(String authtoken) {
  this.authtoken = authtoken;
 }
}
