package com.pinyougou.pojo;

import java.io.Serializable;
import java.util.Date;

public class TbUser implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user.id
     *
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user.username
     *
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user.password
     *
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user.phone
     *
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    private String phone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user.email
     *
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    private String email;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user.created
     *
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    private Date created;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user.updated
     *
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    private Date updated;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user.source_type
     *
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    private String sourceType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user.nick_name
     *
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    private String nickName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user.name
     *
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user.status
     *
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    private String status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user.head_pic
     *
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    private String headPic;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user.qq
     *
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    private String qq;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user.account_balance
     *
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    private Long accountBalance;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user.is_mobile_check
     *
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    private String isMobileCheck;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user.is_email_check
     *
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    private String isEmailCheck;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user.sex
     *
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    private String sex;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user.user_level
     *
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    private Integer userLevel;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user.points
     *
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    private Integer points;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user.experience_value
     *
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    private Integer experienceValue;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user.birthday
     *
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    private Date birthday;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user.last_login_time
     *
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    private Date lastLoginTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.id
     *
     * @return the value of tb_user.id
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.id
     *
     * @param id the value for tb_user.id
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.username
     *
     * @return the value of tb_user.username
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.username
     *
     * @param username the value for tb_user.username
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.password
     *
     * @return the value of tb_user.password
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.password
     *
     * @param password the value for tb_user.password
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.phone
     *
     * @return the value of tb_user.phone
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.phone
     *
     * @param phone the value for tb_user.phone
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.email
     *
     * @return the value of tb_user.email
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.email
     *
     * @param email the value for tb_user.email
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.created
     *
     * @return the value of tb_user.created
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    public Date getCreated() {
        return created;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.created
     *
     * @param created the value for tb_user.created
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.updated
     *
     * @return the value of tb_user.updated
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.updated
     *
     * @param updated the value for tb_user.updated
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.source_type
     *
     * @return the value of tb_user.source_type
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    public String getSourceType() {
        return sourceType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.source_type
     *
     * @param sourceType the value for tb_user.source_type
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    public void setSourceType(String sourceType) {
        this.sourceType = sourceType == null ? null : sourceType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.nick_name
     *
     * @return the value of tb_user.nick_name
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.nick_name
     *
     * @param nickName the value for tb_user.nick_name
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.name
     *
     * @return the value of tb_user.name
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.name
     *
     * @param name the value for tb_user.name
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.status
     *
     * @return the value of tb_user.status
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.status
     *
     * @param status the value for tb_user.status
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.head_pic
     *
     * @return the value of tb_user.head_pic
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    public String getHeadPic() {
        return headPic;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.head_pic
     *
     * @param headPic the value for tb_user.head_pic
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    public void setHeadPic(String headPic) {
        this.headPic = headPic == null ? null : headPic.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.qq
     *
     * @return the value of tb_user.qq
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    public String getQq() {
        return qq;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.qq
     *
     * @param qq the value for tb_user.qq
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.account_balance
     *
     * @return the value of tb_user.account_balance
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    public Long getAccountBalance() {
        return accountBalance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.account_balance
     *
     * @param accountBalance the value for tb_user.account_balance
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    public void setAccountBalance(Long accountBalance) {
        this.accountBalance = accountBalance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.is_mobile_check
     *
     * @return the value of tb_user.is_mobile_check
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    public String getIsMobileCheck() {
        return isMobileCheck;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.is_mobile_check
     *
     * @param isMobileCheck the value for tb_user.is_mobile_check
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    public void setIsMobileCheck(String isMobileCheck) {
        this.isMobileCheck = isMobileCheck == null ? null : isMobileCheck.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.is_email_check
     *
     * @return the value of tb_user.is_email_check
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    public String getIsEmailCheck() {
        return isEmailCheck;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.is_email_check
     *
     * @param isEmailCheck the value for tb_user.is_email_check
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    public void setIsEmailCheck(String isEmailCheck) {
        this.isEmailCheck = isEmailCheck == null ? null : isEmailCheck.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.sex
     *
     * @return the value of tb_user.sex
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    public String getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.sex
     *
     * @param sex the value for tb_user.sex
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.user_level
     *
     * @return the value of tb_user.user_level
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    public Integer getUserLevel() {
        return userLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.user_level
     *
     * @param userLevel the value for tb_user.user_level
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.points
     *
     * @return the value of tb_user.points
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    public Integer getPoints() {
        return points;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.points
     *
     * @param points the value for tb_user.points
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    public void setPoints(Integer points) {
        this.points = points;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.experience_value
     *
     * @return the value of tb_user.experience_value
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    public Integer getExperienceValue() {
        return experienceValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.experience_value
     *
     * @param experienceValue the value for tb_user.experience_value
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    public void setExperienceValue(Integer experienceValue) {
        this.experienceValue = experienceValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.birthday
     *
     * @return the value of tb_user.birthday
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.birthday
     *
     * @param birthday the value for tb_user.birthday
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.last_login_time
     *
     * @return the value of tb_user.last_login_time
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.last_login_time
     *
     * @param lastLoginTime the value for tb_user.last_login_time
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
}