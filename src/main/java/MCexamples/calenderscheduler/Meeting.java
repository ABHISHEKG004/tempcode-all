package MCexamples.calenderscheduler;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Meeting {

    //id
    String name;
    String start;
    String end;
    String organizer;
    int attendees;

    int startTime; //created from start
    int endTime; //created from end

    public Meeting(String name, String start, String end, int attendees, String organizer){
        this.name = name;
        this.start = start;
        this.end = end;
        this.attendees = attendees;
        this.organizer = organizer;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "name='" + name + '\'' +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", organizer='" + organizer + '\'' +
                ", attendees=" + attendees +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}' + "\n";
    }
}
