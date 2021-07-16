package com.techdecode.test;

public class PersonUtils {
    private String EMPNAME;
    private String REASON;
    private String NO_OF_DAYS;



    private String LEAVE_FROM;
    private String LEAVE_TO;
    private String   ID_CARD_NO;
    private String Leave_id;


    public String getLeave_id() {
        return Leave_id;
    }

    public void setLeave_id(String leave_id) {
        Leave_id = leave_id;
    }

    public String getNO_OF_DAYS() {
        return NO_OF_DAYS;
    }

    public void setNO_OF_DAYS(String NO_OF_DAYS) {
        this.NO_OF_DAYS = NO_OF_DAYS;
    }

    public String getLEAVE_FROM() {
        return LEAVE_FROM;
    }

    public void setLEAVE_FROM(String LEAVE_FROM) {
        this.LEAVE_FROM = LEAVE_FROM;
    }

    public String getLEAVE_TO() {
        return LEAVE_TO;
    }

    public void setLEAVE_TO(String LEAVE_TO) {
        this.LEAVE_TO = LEAVE_TO;
    }

    public String getID_CARD_NO() {
        return ID_CARD_NO;
    }

    public void setID_CARD_NO(String ID_CARD_NO) {
        this.ID_CARD_NO = ID_CARD_NO;
    }

    public String getEMPNAME() {
        return EMPNAME;
    }

    public void setEMPNAME(String EMPNAME) {
        this.EMPNAME = EMPNAME;
    }

    public String getREASON() {
        return REASON;
    }

    public void setREASON(String REASON) {
        this.REASON = REASON;
    }
}
