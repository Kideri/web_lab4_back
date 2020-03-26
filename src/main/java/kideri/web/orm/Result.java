package kideri.web.orm;

import javax.persistence.*;
import java.io.Serializable;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "result")
public class Result implements Serializable {
    @Column(name = "x")
    private float x;
    @Column(name = "y")
    private float y;


    @ManyToOne
    private User user;
    @Id
    @GeneratedValue(generator="GENERATOR_COMMON")
    @GenericGenerator(name="GENERATOR_COMMON",strategy="increment")
    @Column(name = "point_id")
    private int point_id;


    public int getPoint_id() {
        return point_id;
    }

    public void setPoint_id(int point_id) {
        this.point_id = point_id;
    }

    public Result(float x, float y, User user) {
        this.x = x;
        this.y = y;
        this.user=user;

    }


    public Result() {
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }




    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }



}
