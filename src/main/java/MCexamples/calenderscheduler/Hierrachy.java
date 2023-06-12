package MCexamples.calenderscheduler;

public enum Hierrachy {

    MANAGER(3),
    DIRECTOR(2),
    CEO(1),
    COO(0);

    int pri;

    Hierrachy(int pri){
        this.pri = pri;
    }

}
