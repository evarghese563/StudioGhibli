package com.Movie.Ghibli.GhibObject;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public
class Ghibli {
    
  private String title;
  private String director;
  private String release_date;
  private String running_time;
    
  @Id 
  @GeneratedValue(strategy = GenerationType.AUTO) 
  private long id;
  
  Ghibli(){}

  //Ghibli Constructor
  public Ghibli(String title,String director,String release_date,String running_time){
      this.title = title;
      this.director = director;
      this.release_date = release_date;
      this.running_time = running_time;
  }

  // Getters and Setters
  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDirector() {
    return this.director;
  }

  public void setDirector(String director) {
    this.director = director;
  }

  public String getRelease_date() {
    return this.release_date;
  }

  public void setRelease_date(String release_date) {
    this.release_date = release_date;
  }

  public String getRunning_time() {
    return this.running_time;
  }

  public void setRunning_time(String running_time) {
    this.running_time = running_time;
  }
  
  public long getId() {
      return this.id;
    }

  public void setId(long id){
    this.id = id;
  }


  @Override
  public boolean equals(Object o) {
      if (this == o)
          return true;
      if (!(o instanceof Ghibli))
          return false;
      
          Ghibli movie = (Ghibli) o;
      return Objects.equals(this.id, movie.id) && Objects.equals(this.title,movie.title) && Objects.equals(this.director,movie.director) && Objects.equals(this.release_date,movie.release_date) && Objects.equals(this.running_time, movie.running_time);
}

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.title, this.director, this.release_date, this.running_time);
  }

  @Override
  public String toString() {
    return "Movie{"+"id="+this.id+", title="+this.title+", director="+this.director+", release_date="+this.release_date+", running_time="+this.running_time+'\''+'}';
  }

}
