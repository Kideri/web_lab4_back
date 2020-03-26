package kideri.web.orm;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "actual_result")
public class ResultActual
{
    @Id
    @GeneratedValue(generator="GENERATOR_COMMON")
    @GenericGenerator(name="GENERATOR_COMMON",strategy="increment")
    @Column(name = "ActualPoint_id",table ="actual_result" )
    private int ActualPoint_id;

   // @Column(name = "history_point")
    //@JoinColumn(name="id")
    @OneToOne(orphanRemoval = false)
    private ResultRs history_point;


    public ResultActual(ResultRs history_point) {
        this.history_point = history_point;
    }

    public ResultActual() {
    }

    public int getActualPoint_id() {
        return ActualPoint_id;
    }

    public void setActualPoint_id(int actualPoint_id) {
        ActualPoint_id = actualPoint_id;
    }

}
