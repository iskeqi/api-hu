package com.keqi.apihu.manage.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.keqi.apihu.core.common.AjaxEntity;
import com.keqi.apihu.core.common.AjaxEntityBuilder;
import com.keqi.apihu.core.common.AjaxPageEntity;
import com.keqi.apihu.manage.DictItemService;
import com.keqi.apihu.manage.domain.param.CreateDictItemParam;
import com.keqi.apihu.manage.domain.param.UpdateDictItemParam;
import com.keqi.apihu.manage.domain.vo.DictItemVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Api(tags = "4. 字典管理")
@ApiSupport(author = "keqi", order = 4)
@AllArgsConstructor
@RestController
@RequestMapping("/sys/dict")
public class DictController {

    private final DictItemService dictItemService;

    /**
     * 增加字典项
     * @param createDictItemParam createDictItemParam
     * @return r
     */
    @ApiOperation(value = "4.1 增加字典项")
    @ApiOperationSupport(order = 1)
    @PostMapping("/create")
    public AjaxEntity create(@Validated @RequestBody CreateDictItemParam createDictItemParam) {
        this.dictItemService.createItem(createDictItemParam);
        return AjaxEntityBuilder.success();
    }

    /**
     * 删除字典项
     * @param id id
     * @return r
     */
    @ApiOperation(value = "4.2 删除字典项")
    @ApiOperationSupport(order = 2)
    @ApiImplicitParam(name = "id", value = "字典项ID", example = "1", required = true)
    @PostMapping("/delete")
    public AjaxEntity delete(@Validated @RequestParam Long id) {
        this.dictItemService.deleteByPrimaryKey(id);
        return AjaxEntityBuilder.success();
    }

    /**
     * 修改字典项
     * @param updateDictItemParam updateDictItemParam
     * @return r
     */
    @ApiOperation(value = "4.3 修改字典项")
    @ApiOperationSupport(order = 3)
    @PostMapping("/update")
    public AjaxEntity update(@Validated @RequestBody UpdateDictItemParam updateDictItemParam) {
        this.dictItemService.updateByPrimaryKey(updateDictItemParam);
        return AjaxEntityBuilder.success();
    }

    /**
     * 查询指定字典类型下的全部列表
     * @param typeCode typeCode
     * @return r
     */
    @ApiOperation(value = "4.4 查询字典项列表")
    @ApiOperationSupport(order = 4)
    @ApiImplicitParam(name = "typeCode", value = "字典类型code", example = "gender", required = true)
    @PostMapping("/page")
    public AjaxEntity<AjaxPageEntity<DictItemVO>> page(@Validated @RequestParam String typeCode) {
        return AjaxEntityBuilder.successList(this.dictItemService.pageDictItem(typeCode));
    }
}
