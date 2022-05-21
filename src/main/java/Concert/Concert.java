package Concert;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
public class Concert {

    private int concertIdx;
    private String name;
    private String location;
    private String url;
    private String img;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private LocalDate startDate;
    private LocalDate endDate;

    public Concert(String name, String location, String img, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.location = location;
        //this.url = url;
        this.img = img;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
