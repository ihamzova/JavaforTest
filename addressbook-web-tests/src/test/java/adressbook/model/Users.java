package adressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

public class Users extends ForwardingSet<UserData> {

  private Set<UserData> delegate;

  public Users(Users users) {
    this.delegate = new HashSet<UserData>(users.delegate);
  }

  public Users() {
    this.delegate = new HashSet<UserData>();;
  }

  public Users withadded(UserData userData) {
    Users users = new Users(this);
    users.add(userData);
    return users;
  }

  public Users without(UserData userData) {
    Users users = new Users(this);
    users.remove(userData);
    return users;
  }

  @Override
  protected Set<UserData> delegate() {
    return delegate;
  }
}
