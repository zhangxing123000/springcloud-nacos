package com.zx.user.bo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.zx.common.RegexpContants;
import org.hibernate.validator.constraints.Length;
import lombok.Data;

@Data
public class SaveUserBO {

    @NotBlank(message = "用户名称不能为空")
    @Length(max = 10,message = "长度不能超过10个字符")
    private String name;

    @NotBlank(message = "性别不能为空")
    @Pattern(regexp = RegexpContants.ZERO_OR_ONE_EREGEXP,message = "性别格式不正确")
    private String sex;

    @NotBlank(message = "出生日期不能为空")
    @Pattern(regexp = RegexpContants.SIMPLE_DATE_PATTERN,message = "出生日期格式不正确")
    private String birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}