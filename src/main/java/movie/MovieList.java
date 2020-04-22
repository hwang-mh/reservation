package movie;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="MovieList_table")
public class MovieList {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

}
