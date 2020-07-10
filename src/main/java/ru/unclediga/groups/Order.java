package ru.unclediga.groups;

import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;
import java.util.Date;

public class Order {
    @NotNull
    Integer id;
    @NotNull(groups = Default.class)
    String number;
    @NotNull
    Date datePrepare;
    @NotNull(groups = {SignedGroup.class, OperationGroup.class})
    Date dateSigned;
    @NotNull(groups = OperationGroup.class)
    Date dateOperation;

    public Order(Integer id, String number, Date datePrepare, Date dateSigned, Date dateOperation) {
        this.id = id;
        this.number = number;
        this.datePrepare = datePrepare;
        this.dateSigned = dateSigned;
        this.dateOperation = dateOperation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getDatePrepare() {
        return datePrepare;
    }

    public void setDatePrepare(Date datePrepare) {
        this.datePrepare = datePrepare;
    }

    public Date getDateSigned() {
        return dateSigned;
    }

    public void setDateSigned(Date dateSigned) {
        this.dateSigned = dateSigned;
    }

    public Date getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(Date dateOperation) {
        this.dateOperation = dateOperation;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", datePrepare=" + datePrepare +
                ", dateSigned=" + dateSigned +
                ", dateOperation=" + dateOperation +
                '}';
    }
}
