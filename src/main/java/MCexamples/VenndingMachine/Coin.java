package MCexamples.VenndingMachine;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Coin {

    C1(1,"C1"),
    C2(5,"C2"),
    C3(10,"C3"),
    C4(25, "C4");

    private Integer value;
    private String description;
}