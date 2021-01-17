package adressbook.model;

import java.io.File;
import java.util.Objects;

public class UserData {
  private int id = Integer.MAX_VALUE;
  private String name;
  private String surname;
  private String homephones;
  private String mobilephones;
  private String workphones;
  private String allphones;
  private String allemails;
  private String address;
  private String email;
  private String email2;
  private String email3;

  public File getPhoto() {
    return photo;
  }

  public UserData withPhoto(File photo) {
    this.photo = photo;
    return this;
  }

  private File photo;

  public String getEmail3() {
    return email3;
  }
  public UserData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }
  public String getEmail2() {
    return email2;
  }
  public UserData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }
  public String getEmail() {
    return email;
  }
  public UserData withEmail(String email) {
    this.email = email;
    return this;
  }
  public String getaddress() {
    return address;
  }
  public UserData withaddress(String address) {
    this.address = address;
    return this;
  }
  public String getAllemails() {
    return allemails;
  }
  public UserData withAllemails(String allemails) {
    this.allemails = allemails;
    return this;
  }
  public String getAllphones() {
    return allphones;
  }
  public UserData withAllphones(String allphones) {
    this.allphones = allphones;
    return this;
  }
  public String getHomephones() {
    return homephones;
  }
  public UserData withHomenumber(String homenumber) {
    this.homephones = homenumber;
    return this;
  }
  public String getMobilephones() {
    return mobilephones;
  }
  public UserData withMobilenumber(String mobilenumber) {
    this.mobilephones = mobilenumber;
    return this;
  }
  public String getWorkphones() {
    return workphones;
  }
  public UserData withWorknumber(String worknumber) {
    this.workphones = worknumber;
    return this;
  }
  public UserData withName(String name) {
    this.name = name;
    return this;
  }
  public UserData withSurname(String surname) {
    this.surname = surname;
    return this;
  }
  public UserData withtId(int id) {
    this.id = id;
    return this;
  }
  public int getId() {
    return id;
  }
  public String getName() {
    return name;
  }
  public String getSurname() {
    return surname;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    UserData userData = (UserData) o;
    return id == userData.id &&
            Objects.equals(name, userData.name) &&
            Objects.equals(surname, userData.surname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, surname);
  }

  @Override
  public String toString() {
    return "UserData{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", surname='" + surname + '\'' +
            '}';
  }

}
