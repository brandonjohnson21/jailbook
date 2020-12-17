package galvanize.jailbook.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "Criminal")
public class Criminal implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "Alias", nullable = false)
    private String alias;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Criminal_ID", nullable = false)
    private Integer criminalId;

    @Column(name = "Num_Years_Served")
    private Integer numYearsServed;

    @Column(name = "Pass_Word", nullable = false)
    private String passWord;

    @Column(name = "Prison_Release_Date")
    private LocalDate prisonReleaseDate;

    @Column(name = "Rating", nullable = false)
    private Float rating;

    public Criminal setAlias(String alias) {
        this.alias = alias;
        return this;
    }

    public String getAlias() {
        return alias;
    }

    public Criminal setCriminalId(Integer criminalId) {
        this.criminalId = criminalId;
        return this;
    }

    public Integer getCriminalId() {
        return criminalId;
    }

    public Criminal setNumYearsServed(Integer numYearsServed) {
        this.numYearsServed = numYearsServed;
        return this;
    }

    public Integer getNumYearsServed() {
        return numYearsServed;
    }

    public Criminal setPassWord(String passWord) {
        this.passWord = passWord;
        return this;
    }

    public String getPassWord() {
        return passWord;
    }

    public Criminal setPrisonReleaseDate(LocalDate prisonReleaseDate) {
        this.prisonReleaseDate = prisonReleaseDate;
        return this;
    }

    public LocalDate getPrisonReleaseDate() {
        return prisonReleaseDate;
    }

    public Criminal setRating(Float rating) {
        this.rating = rating;
        return this;
    }

    public Float getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Criminal{" +
               "alias=" + alias + '\'' +
               "criminalId=" + criminalId + '\'' +
               "numYearsServed=" + numYearsServed + '\'' +
               "passWord=" + passWord + '\'' +
               "prisonReleaseDate=" + prisonReleaseDate + '\'' +
               "rating=" + rating + '\'' +
               '}';
    }
}
