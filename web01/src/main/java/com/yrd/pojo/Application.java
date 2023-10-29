package com.yrd.pojo;

public class Application {
    private int id;
    private String courseName;
    private String stuName;
    private String lecturerName;
    private String masterName;
    private String reason;
    private int status;

    public Application(int id, String courseName, String stuName, String lecturerName, String masterName, String reason, int status) {
        this.id = id;
        this.courseName = courseName;
        this.stuName = stuName;
        this.lecturerName = lecturerName;
        this.masterName = masterName;
        this.reason = reason;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getLecturerName() {
        return lecturerName;
    }

    public void setLecturerName(String lecturerName) {
        this.lecturerName = lecturerName;
    }

    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getstatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    //逻辑视图
    public String getStatusStr(){
        if(this.status==1){
            return "申请已提交";
        }else if(this.status==2){
            return "课程主讲教师审批中";
        }else if(this.status==3){
            return "课程主管教师审批中";
        }else if(this.status==4){
            return "审批成功";
        }else if(this.status==0){
            return "申请驳回";
        }
        return "";
    }

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", stuName='" + stuName + '\'' +
                ", lecturerName='" + lecturerName + '\'' +
                ", masterName='" + masterName + '\'' +
                ", reason='" + reason + '\'' +
                ", status=" + status +
                '}';
    }
}
