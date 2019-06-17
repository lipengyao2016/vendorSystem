package com.vendor.entity;

import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author lpy
 * @since 2019-06-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Roles implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键。
     */
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
     * 类型。admin:管理员角色，system:系统默认角色，user:用户定义角色。
     */
    private String type;

    /**
     * 权限。
     */
    private String permission;

    /**
     * 拥有者UUID.
     */
    @TableField("ownerUUID")
    private String ownerUUID;

    /**
     * 拥有者类型，merchant:商户，
     */
    @TableField("ownerType")
    private String ownerType;

    /**
     * 状态，enabled:启用，disabled:禁用。
     */
    private String status;

    /**
     * 创建时间。
     */
    @TableField("createdAt")
    private LocalDateTime createdAt;

    /**
     * 修改时间。
     */
    @TableField("modifiedAt")
    private LocalDateTime modifiedAt;


}
