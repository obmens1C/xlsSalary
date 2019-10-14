package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Map;

@Entity
@Table(name = "mc_payroll")
public class PayRoll {
    @Id
    private LocalDateTime dateTime;
    @Column
    private Map payRollMap;

}
