package test.folderadressbook.tests.model;

public class UserData {
  private final String name;
  private final String surname;
  private final String nickname;
  private final String company;
  private final String phone;
  private final String email;


  public UserData(String name, String surname, String nickname, String company, String phone, String email) {
    this.name = name;
    this.surname = surname;
    this.nickname = nickname;
    this.company = company;
    this.phone = phone;
    this.email = email;

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

}
