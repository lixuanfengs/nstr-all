package com.nstr.common.core.entity.system;

import com.nstr.common.core.entity.Tree;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author: cactusli
 * @date: 2021.08.16
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DeptTree extends Tree<Dept> {
    private Integer orderNum;
}
