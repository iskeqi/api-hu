package com.keqi.apihu.core.common;

import com.keqi.apihu.core.pojo.UserTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 登录用户信息实体类
 *
 * @author keqi
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class LoginUserBO {

	/**
	 * 用户ID
	 */
	private Long id;

	/**
	 * 登录用户账号名
	 */
	private String account;

	/**
	 * 登录用户姓名
	 */
	private String nickName;

	/**
	 * 岗位
	 */
	private String post;

	/**
	 * 用户类型
	 */
	private UserTypeEnum userType;

	/**
	 * 当前操作项目ID
	 */
	private Long projectId;
}
