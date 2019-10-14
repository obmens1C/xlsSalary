package entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "mc_workshift")
public class Workshift {
    @ManyToOne
    @JoinColumn(name = "subdivision")
    private Subdivision subdivision;
    @Id
    @Column
    private LocalDateTime oppenningdate;
    @Column
    private LocalDateTime closingdate;
    @ManyToOne
    @JoinColumn(name = "administrator")
    private Administrator administrator;
    @Column
    private String status;

    public Workshift() {
    }

    public Workshift(Subdivision subdivision, LocalDateTime oppenningdate, Administrator administrator, String status) {
        this.subdivision = subdivision;
        this.oppenningdate = oppenningdate;
        this.administrator = administrator;
        this.status = status;
    }

    public Workshift(Subdivision subdivision, LocalDateTime oppenningdate, LocalDateTime closingdate, Administrator administrator, String status) {
        this.subdivision = subdivision;
        this.oppenningdate = oppenningdate;
        this.closingdate = closingdate;
        this.administrator = administrator;
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Workshift)) return false;

        Workshift workshift = (Workshift) o;

        if (subdivision != null ? !subdivision.equals(workshift.subdivision) : workshift.subdivision != null)
            return false;
        if (oppenningdate != null ? !oppenningdate.equals(workshift.oppenningdate) : workshift.oppenningdate != null)
            return false;
        if (closingdate != null ? !closingdate.equals(workshift.closingdate) : workshift.closingdate != null)
            return false;
        if (administrator != null ? !administrator.equals(workshift.administrator) : workshift.administrator != null)
            return false;
        return status != null ? status.equals(workshift.status) : workshift.status == null;

    }

    @Override
    public int hashCode() {
        int result = (subdivision != null ? subdivision.hashCode() : 0);
        result = 31 * result + (oppenningdate != null ? oppenningdate.hashCode() : 0);
        result = 31 * result + (closingdate != null ? closingdate.hashCode() : 0);
        result = 31 * result + (administrator != null ? administrator.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Workshift{" +
                "subdivision=" + subdivision +
                ", oppen date=" + oppenningdate +
                ", clouse date=" + closingdate +
                ", administrator=" + administrator +
                ", status='" + status + '\'' +
                '}';
    }

    public Subdivision getSubdivision() {
        return subdivision;
    }

    public void setSubdivision(Subdivision subdivision) {
        this.subdivision = subdivision;
    }

    public LocalDateTime getOppenningdate() {
        return oppenningdate;
    }

    public void setOppenningdate(LocalDateTime oppenningdate) {
        this.oppenningdate = oppenningdate;
    }

    public LocalDateTime getClousingdate() {
        return closingdate;
    }

    public void setClosingdate(LocalDateTime closingdate) {
        this.closingdate = closingdate;
    }

    public Administrator getEmployee() {
        return administrator;
    }

    public void setEmployee(Administrator employee) {
        this.administrator = employee;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
