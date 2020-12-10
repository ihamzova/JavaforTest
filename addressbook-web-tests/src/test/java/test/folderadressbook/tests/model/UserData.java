package test.folderadressbook.tests.model;

public class UserData {
  private final String name;
  private final String surname;
  private final String nickname;
  private final String company;
  private final String phone;
  private final String email;
  private final String bday;
  private final String bmonth;
  private final String byear;

  public UserData(String name, String surname, String nickname, String company, String phone, String email, String bday, String bmonth, String byear) {
    this.name = name;
    this.surname = surname;
    this.nickname = nickname;
    this.company = company;
    this.phone = phone;
    this.email = email;
    this.bday = bday;
    this.bmonth = bmonth;
    this.byear = byear;
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

  public String getBday() {
    return bday;
  }

  public String getBmonth() {
    return bmonth;
  }

  public String getByear() {
    return byear;
  }
}
