package com.example.RentCarSpb;

public class Test2 {
    private String MemberId;
    private String MemberName;
    private String MemberEmail;
    private String MemberPhone;

    // 强制要求传入参数的构造函数
    public Test2(String MemberId, String MemberName, String MemberEmail, String MemberPhone) {
        this.MemberId = MemberId;
        this.MemberName = MemberName;
        this.MemberEmail = MemberEmail;
        this.MemberPhone = MemberPhone;
    }
    
    // 可选的无参构造函数，设置默认值
    public Test2() {
        this.MemberId = "DefaultId";
        this.MemberName = "DefaultName";
        this.MemberEmail = "default@example.com";
        this.MemberPhone = "000-000-0000";
    }

    public String getMemberId() {
        return MemberId;
    }

    public void setMemberId(String MemberId) {
        this.MemberId = MemberId;
    }

    public String getMemberName() {
        return MemberName;
    }

    public void setMemberName(String MemberName) {
        this.MemberName = MemberName;
    }

    public String getMemberEmail() {
        return MemberEmail;
    }

    public void setMemberEmail(String MemberEmail) {
        this.MemberEmail = MemberEmail;
    }

    public String getMemberPhone() {
        return MemberPhone;
    }

    public void setMemberPhone(String MemberPhone) {
        this.MemberPhone = MemberPhone;
    }

    @Override
    public String toString() {
        return "Test2 [MemberId=" + MemberId + ", MemberName=" + MemberName + ", MemberEmail=" + MemberEmail + ", MemberPhone=" + MemberPhone + "]";
    }
}
