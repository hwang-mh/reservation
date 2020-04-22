package movie;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="ReservationProcess_table")
public class ReservationProcess {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String moviename;
    private Date moviedate;
    private Integer movieid;
    private String theater;
    private String subscriber;

    @PostPersist
    public void onPostPersist(){
        MovieReserved movieReserved = new MovieReserved();
        BeanUtils.copyProperties(this, movieReserved);
        movieReserved.publish();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        movie.external.PayProcess payProcess = new movie.external.PayProcess();
        // mappings goes here
        Application.applicationContext.getBean(movie.external.PayProcessService.class)
            .pay(payProcess);


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getMoviename() {
        return moviename;
    }

    public void setMoviename(String moviename) {
        this.moviename = moviename;
    }
    public Date getMoviedate() {
        return moviedate;
    }

    public void setMoviedate(Date moviedate) {
        this.moviedate = moviedate;
    }
    public Integer getMovieid() {
        return movieid;
    }

    public void setMovieid(Integer movieid) {
        this.movieid = movieid;
    }
    public String getTheater() {
        return theater;
    }

    public void setTheater(String theater) {
        this.theater = theater;
    }
    public String getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(String subscriber) {
        this.subscriber = subscriber;
    }




}
