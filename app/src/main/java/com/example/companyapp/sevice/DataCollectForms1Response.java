package com.example.companyapp.sevice;

import com.google.gson.annotations.SerializedName;

public class DataCollectForms1Response {
  @SerializedName("residencesector")
  String residencesector;
  @SerializedName("placeofresidence")
  String placeofresidence;
  String countryofresidence;
  String profession;
  String idpassportno;
  String issuedate;
  String issueauthority;


  public String getResidencesector() {
   return residencesector;
  }

  public void setResidencesector(String residencesector) {
   this.residencesector = residencesector;
  }

  public String getPlaceofresidence() {
   return placeofresidence;
  }

  public void setPlaceofresidence(String placeofresidence) {
   this.placeofresidence = placeofresidence;
  }

  public String getCountryofresidence() {
   return countryofresidence;
  }

  public void setCountryofresidence(String countryofresidence) {
   this.countryofresidence = countryofresidence;
  }

  public String getProfession() {
   return profession;
  }

  public void setProfession(String profession) {
   this.profession = profession;
  }

  public String getIdpassportno() {
   return idpassportno;
  }

  public void setIdpassportno(String idpassportno) {
   this.idpassportno = idpassportno;
  }

  public String getIssuedate() {
   return issuedate;
  }

  public void setIssuedate(String issuedate) {
   this.issuedate = issuedate;
  }

  public String getIssueauthority() {
   return issueauthority;
  }

  public void setIssueauthority(String issueauthority) {
   this.issueauthority = issueauthority;
  }
 }
