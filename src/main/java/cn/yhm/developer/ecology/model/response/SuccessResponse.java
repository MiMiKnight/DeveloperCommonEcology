package cn.yhm.developer.ecology.model.response;

import cn.yhm.developer.ecology.common.constant.EcologyExceptionCode;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 成功响应参数类
 * <p>
 * 本响应只有在原本业务的响应没有任何出参时才建议使用
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-09-04 22:33:44
 */
@Getter
@Setter
public class SuccessResponse implements EcologyResponse {

    /**
     * 成功响应码
     */
    @JsonProperty(value = "success_code", index = 1, access = JsonProperty.Access.READ_ONLY)
    private String successCode = EcologyExceptionCode.SUCCESS;

    /**
     * 成功提示消息
     */
    @JsonProperty(value = "success_msg", index = 2, access = JsonProperty.Access.READ_ONLY)
    private String successMsg = "success";
}
