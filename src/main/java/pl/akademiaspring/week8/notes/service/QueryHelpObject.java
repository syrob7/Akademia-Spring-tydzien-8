package pl.akademiaspring.week8.notes.service;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class QueryHelpObject {
    @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm")
    private Date dateFrom;
    @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm")
    private Date dateTo;

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }
}
