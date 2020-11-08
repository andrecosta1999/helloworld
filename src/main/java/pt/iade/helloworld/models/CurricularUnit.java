package pt.iade.helloworld.models;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CurricularUnit {
    private String name;
    private double grade;
    private int semester;
    private int ects;

    public CurricularUnit(String name, double grade, int semester, int ects) {
        this.name = name;
        this.grade = grade;
        this.semester = semester;
        this.ects = ects;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public int getSemester() {
        return semester;
    }

    public int getEcts() {
        return ects;
    }

    public boolean isApproved() {
        if (this.grade > 9.5) {
            return true;
        } else {
            return false;
        }
    }
    
    private Logger logger = LoggerFactory.getLogger(CurricularUnit.class);
    private ArrayList<CurricularUnit> units = new ArrayList<CurricularUnit>();
    @PostMapping(path ="/units/")
    public CurricularUnit saveUnit(@RequestBody CurricularUnit unit) {
    logger.info("Added unit "+unit.getName());
    units.add(unit);
    return unit;
    }
}