package com.example.companyapp.Model;

import com.google.gson.annotations.SerializedName;

public class  usermodel {
     String firstname,lastname,email,password,phone,dob,placeofbirth,citizenship,address,
            image;
     @SerializedName("token")
     private String status;
     @SerializedName("result_code")
     private int resultCode;
     @SerializedName("name")
     private String name;

     public usermodel(String firstname, String lastname, String email, String password, String phone, String dob, String placeofbirth, String citizenship, String address, String image) {
         this.firstname = firstname;
         this.lastname = lastname;
         this.email = email;
         this.password = password;
         this.phone = phone;
         this.dob = dob;
         this.placeofbirth = placeofbirth;
         this.citizenship = citizenship;
         this.address = address;
         this.image = image;
     }

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

     public String getImage() {
         return image;
     }

     public void setImage(String image) {
         this.image = image;
     }

    public String getStatus() {
        return status;
    }

    public int getResultCode() {
        return resultCode;
    }

    public String getName() {
        return name;
    }
}
