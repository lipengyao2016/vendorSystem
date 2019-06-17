package com.vendor.entity;

import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 部门。
 * </p>
 *
 * @author lpy
 * @since 2019-06-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Departments implements Serializable {

    private static final long serialVersionUID = 1L;

    private String uuid;

    /**
     * 名称。
     */
    private String name;

    /**
     * 描述。
     */
    private String description;

    /**
     * 上级部门UUID.
     */
    @TableField("upLevelDepartmentUUID")
    private String upLevelDepartmentUUID;

    /**
     * 所属的用户组织UUID.
     */
    @TableField("userOrganizationUUID")
    private String userOrganizationUUID;

    private String status;

    @TableField("createdAt")
    private LocalDateTime createdAt;

    @TableField("modifiedAt")
    private LocalDateTime modifiedAt;


}
