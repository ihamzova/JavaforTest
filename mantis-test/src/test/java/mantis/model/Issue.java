package mantis.model;

public class Issue {

  private int id;
  private String summary;
  private String description;
  private Project project;
  private String status;

  public int getId() {
    return id;
  }

  public String getSummary() {
    return summary;
  }

  public String getDescription() {
    return description;
  }

  public Project getProject() {
    return project;
  }

  public Issue withId(int id) {
    this.id = id;
    return this;
  }

  public Issue withSummary(String summary) {
    this.summary = summary;
    return this;
  }

  public Issue withDescription(String description) {
    this.description = description;
    return this;
  }

  public Issue withProject(Project project) {
    this.project = project;
    return this;
  }
  public String getStatus() {
    return status;
  }

  public Issue withStatus(String status) {
    this.status = status;
    return this;
  }

}