package adressbook.model;

import java.util.Objects;

public class UserData {
  private int id = Integer.MAX_VALUE;
  private String name;
  private String surname;

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
