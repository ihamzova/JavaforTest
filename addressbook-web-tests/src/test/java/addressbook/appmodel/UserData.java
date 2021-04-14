package addressbook.appmodel;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity

@Table(name = "addressbook")
public class UserData {

  @Id
  @Column(name = "id")
  private int id = Integer.MAX_VALUE;

  @Column(name = "firstname")
  private String name;


  @Column(name = "lastname")
  private String surname;


  @Column(name = "home")
  @Type(type = "text")
  private String homephones;


  @Column(name = "mobile")
  @Type(type = "text")
  private String mobilephones;


  @Column(name = "work")
  @Type(type = "text")
  private String workphones;

  @Transient
  private String allphones;
  @Transient
  private String allemails;


  @Column(name = "address")
  @Type(type = "text")
  private String address;

  @Column(name = "email")
  @Type(type = "text")
  private String email;


  @Column(name = "email2")
  @Type(type = "text")
  private String email2;


  @Column(name = "email3")
  @Type(type = "text")
  private String email3;

  @Column(name = "photo")
  @Type(type = "text")
  private String photo;


  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "address_in_groups",
          joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name="group_id"))
  private Set<GroupData> groups = new HashSet<GroupData>();

  public Groups getGroups() {
    return new Groups(groups);
  }

  public File getPhoto() {
    if (photo == null) {
      return null;
    } else {
      return new File(photo);
    }
  }

  public UserData withPhoto(File photo) {
    this.photo = photo.getPath();
    return this;
  }

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
