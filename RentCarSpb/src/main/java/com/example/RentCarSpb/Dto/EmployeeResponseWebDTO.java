package com.example.RentCarSpb.Dto;

/**
 * 定義一個 Data Transfer Object (DTO) 類，用來封裝從 Web 端返回的員工資料。
 */
public class EmployeeResponseWebDTO {

    // 員工的唯一識別碼
    private int employeeid;
    // 員工的姓名
    private String employeename;
    // 員工的電子郵件地址
    private String email;

    /**
     * 帶參數的構造函數，用於初始化 EmployeeResponseWebDTO 物件。
     *
     * @param employeeid 員工的唯一識別碼
     * @param employeename 員工的姓名
     * @param email 員工的電子郵件地址
     */
    public EmployeeResponseWebDTO(int employeeid, String employeename, String email) {
        this.employeeid = employeeid;
        this.employeename = employeename;
        this.email = email;
    }

    /**
     * 無參數的構造函數，供 Spring 或其他框架使用。
     */
    public EmployeeResponseWebDTO() {
    }

    /**
     * 獲取員工 ID。
     *
     * @return 員工的唯一識別碼
     */
    public int getEmployeeid() {
        return employeeid;
    }

    /**
     * 設置員工 ID。
     *
     * @param employeeid 員工的唯一識別碼
     */
    public void setEmployeeid(int employeeid) {
        this.employeeid = employeeid;
    }

    /**
     * 獲取員工姓名。
     *
     * @return 員工的姓名
     */
    public String getEmployeename() {
        return employeename;
    }

    /**
     * 設置員工姓名。
     *
     * @param employeename 員工的姓名
     */
    public void setEmployeename(String employeename) {
        this.employeename = employeename;
    }

    /**
     * 獲取員工電子郵件。
     *
     * @return 員工的電子郵件地址
     */
    public String getEmail() {
        return email;
    }

    /**
     * 設置員工電子郵件。
     *
     * @param email 員工的電子郵件地址
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 覆寫 toString 方法，用於輸出 EmployeeResponseWebDTO 物件的字串表示。
     *
     * @return EmployeeResponseWebDTO 物件的字串表示
     */
    @Override
    public String toString() {
        return "EmployeeResponseWebDTO [employeeid=" + employeeid + ", employeename=" + employeename + ", email="
                + email + "]";
    }
}
