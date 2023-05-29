package MCexamples.VenndingMachine;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Item {

    COKE(25,"Coke"),
    SODA(35,"Soda"),
    PEPSI(45, "Pepsi");

    private Integer price;
    private String description;
}