package com.amsidh.mvc.springbootschedulerexample.entities;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "shedlock")
public class ShedLock {
    @Id
    private String name;

    @NotNull
    private Date lock_until;
    @NotNull
    private Date locked_at;
    private String locked_by;

}
