package adressbook.model;

import java.util.Objects;

public class UserData {


  public void setId(int id) {
    this.id = id;
  }

  private int id;
  private final String name;
  private final String surname;
  private final String nickname;
  private final String company;
  private final String phone;
  private final String email;


  public UserData(int id, String name, String surname, String nickname, String company, String phone, String email) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.nickname = nickname;
    this.company = company;
    this.phone = phone;
    this.email = email;

  }

  public UserData(String name, String surname, String nickname, String company, String phone, String email) {
    this.id = Integer.MAX_VALUE;
    this.name = name;
    this.surname = surname;
    this.nickname = nickname;
    this.company = company;
    this.phone = phone;
    this.email = email;

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

  public String getNickname() {
    return nickname;
  }

  public String getCompany() {
    return company;
  }

  public String getPhone() {
    return phone;
  }

  public String getEmail() {
    return email;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    UserData userData = (UserData) o;
    return Objects.equals(name, userData.name) &&
            Objects.equals(surname, userData.surname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, surname);
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
