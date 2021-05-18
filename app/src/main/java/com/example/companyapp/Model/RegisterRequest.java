package com.example.companyapp.Model;

 public class RegisterRequest {
     private String firstname;
     private String lastname;

     private String email;

     private String password;

     private String phone;

     private String dob;

     private String placeofbirth;

     private String citizenship;
     private String address;

     public String getFirstname() {
         return firstname;
     }

     public void setFirstname(String firstname) {
         this.firstname = firstname;
     }

     public String getLastname() {
         return lastname;
     }

     public void setLastname(String lastname) {
         this.lastname = lastname;
     }

     public String getEmail() {
         return email;
     }

     public void setEmail(String email) {
         this.email = email;
     }

     public String getPassword() {
         return password;
     }

     public void setPassword(String password) {
         this.password = password;
     }

     public String getPhone() {
         return phone;
     }

     public void setPhone(String phone) {
         this.phone = phone;
     }

     public String getDob() {
         return dob;
     }

     public void setDob(String dob) {
         this.dob = dob;
     }

     public String getPlaceofbirth() {
         return placeofbirth;
     }

     public void setPlaceofbirth(String placeofbirth) {
         this.placeofbirth = placeofbirth;
     }

     public String getCitizenship() {
         return citizenship;
     }

     public void setCitizenship(String citizenship) {
         this.citizenship = citizenship;
     }

     public String getAddress() {
         return address;
     }

     public void setAddress(String address) {
         this.address = address;
     }
 }
